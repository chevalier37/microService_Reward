package com.tourguide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tourguide.model.AttractionAndLocation;
import com.tourguide.service.RewardsService;

@RestController
public class RewardController {

	@Autowired
	RewardsService rewardsService;

	@GetMapping("/isWithinAttractionProximity")
	public boolean isWithinAttractionProximity(@RequestBody AttractionAndLocation request) {
		return rewardsService.isWithinAttractionProximity(request.getAttraction(), request.getLocation());
	}

	@GetMapping("/getDistanceMiles")
	public double getDistanceMiles(@RequestBody AttractionAndLocation request) {
		return rewardsService.getDistanceMiles(request.getAttraction(), request.getLocation());
	}

}
