package com.tourguide.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.tourguide.model.Attraction;
import com.tourguide.model.Location;
import com.tourguide.model.User;
import com.tourguide.model.UserReward;
import com.tourguide.model.VisitedLocation;
import com.tourguide.proxies.MicroServiceGpsUtilProxy;
import com.tourguide.proxies.MicroServiceUserProxy;

import rewardCentral.RewardCentral;

@Service
public class RewardsService {

	private static final double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;

	private int defaultProximityBuffer = 10;
	private int proximityBuffer = defaultProximityBuffer;

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	RewardCentral rewardsCentral;

	@Autowired
	MicroServiceGpsUtilProxy gpsUtilProxy;

	@Autowired
	MicroServiceUserProxy userProxy;

	@Async("asyncExecutor")
	public void calculateRewards(User user) {
		List<VisitedLocation> userLocations = user.getVisitedLocations();

		List<Attraction> attractions = gpsUtilProxy.getAttractions();
		for (VisitedLocation visitedLocation : userLocations) {
			for (Attraction attraction : attractions) {
				if (user.getUserRewards().stream()
						.filter(r -> r.attraction.attractionName.equals(attraction.attractionName)).count() == 0) {
					if (nearAttraction(visitedLocation, attraction)) {
						user.addUserReward(
								new UserReward(visitedLocation, attraction, getRewardPoints(attraction, user)));
					}
				}
			}
		}

		userProxy.addUserReward(user.getUserName());
	}

	public boolean nearAttraction(VisitedLocation visitedLocation, Attraction attraction) {
		return getDistance(attraction, visitedLocation.location) > proximityBuffer ? false : true;
	}

	public int getRewardPoints(Attraction attraction, User user) {
		return rewardsCentral.getAttractionRewardPoints(attraction.attractionId, user.getUserId());
	}

	public double getDistance(Location loc1, Location loc2) {
		double lat1 = Math.toRadians(loc1.latitude);
		double lon1 = Math.toRadians(loc1.longitude);
		double lat2 = Math.toRadians(loc2.latitude);
		double lon2 = Math.toRadians(loc2.longitude);

		double angle = Math
				.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

		double nauticalMiles = 60 * Math.toDegrees(angle);
		double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
		return statuteMiles;
	}

}
