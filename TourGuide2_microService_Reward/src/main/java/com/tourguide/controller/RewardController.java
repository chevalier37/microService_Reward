package com.tourguide.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourguide.model.Attraction;
import com.tourguide.model.User;
import com.tourguide.proxies.MicroServiceGpsUtilProxy;
import com.tourguide.proxies.MicroServiceUserProxy;
import com.tourguide.service.RewardsService;

@RestController
@RequestMapping("/rewards")
public class RewardController {

	@Autowired
	RewardsService rewardsService;

	@Autowired
	MicroServiceUserProxy userProxy;

	@Autowired
	MicroServiceGpsUtilProxy gpsProxy;

	private static final Logger logger = LogManager.getRootLogger();

	@GetMapping("/calculateRewards/{userName}")
	public void calculateRewards(@PathVariable("userName") String userName) {
		User user = userProxy.getUser(userName);
		rewardsService.calculateRewards(user);
	}

	@PostMapping("/getRewardPoints/{userName}")
	public int getRewardPoints(@PathVariable("userName") String userName, @RequestBody Attraction attraction) {
		User user = userProxy.getUser(userName);
		return rewardsService.getRewardPoints(attraction, user);
	}
}
