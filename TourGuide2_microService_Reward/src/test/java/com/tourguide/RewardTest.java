package com.tourguide;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tourguide.model.Attraction;
import com.tourguide.model.Location;
import com.tourguide.model.User;
import com.tourguide.model.VisitedLocation;
import com.tourguide.service.RewardsService;

@SpringBootTest

public class RewardTest {

	@Autowired
	RewardsService rewardsService;

	@Test
	public void calculateRewardsTest() {
		User user = new User(UUID.randomUUID(), "jon", "000", "jon@tourGuide.com");
		rewardsService.calculateRewards(user);

		assertEquals(0, user.getUserRewards().size());
	}

	@Test
	public void nearAttractionTest() {
		User user = new User(UUID.randomUUID(), "jon", "000", "jon@tourGuide.com");
		Attraction attraction = new Attraction("name", "city", "state", 20.00, 20.00);
		VisitedLocation visitedLocation = new VisitedLocation(user.getUserId(), new Location(20.00, 20.00), new Date());
		assertEquals(true, rewardsService.nearAttraction(visitedLocation, attraction));
	}

	@Test
	public void getDistanceTest() {
		Location loc1 = new Location(20.00, 20.00);
		Location loc2 = new Location(20.00, 20.00);
		Double distance = rewardsService.getDistance(loc1, loc2);
		assertEquals(0.0, distance);
	}

	@Test
	public void getRewardPointsTest() {
		User user = new User(UUID.randomUUID(), "jon", "000", "jon@tourGuide.com");
		Attraction attraction = new Attraction("name", "city", "state", 20.00, 20.00);
		assertTrue(rewardsService.getRewardPoints(attraction, user) > 0, "fail");

	}

}
