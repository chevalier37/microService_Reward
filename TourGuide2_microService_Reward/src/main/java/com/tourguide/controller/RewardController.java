package com.tourguide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tourguide.model.Attraction;
import com.tourguide.model.Location;
import com.tourguide.service.RewardsService;

@RestController
public class RewardController {

	@Autowired
	RewardsService rewardsService;

	@GetMapping("/isWithinAttractionProximity")
	public boolean isWithinAttractionProximity(@RequestBody Attraction attraction, @RequestBody Location location) {
		return rewardsService.isWithinAttractionProximity(attraction, location);
	}

	@GetMapping("/getDistanceMiles")
	public double getDistanceMiles(@RequestBody Attraction attraction, @RequestBody Location location) {
		return rewardsService.getDistanceMiles(attraction, location);
	}

}
