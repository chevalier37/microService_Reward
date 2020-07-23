package com.tourguide;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tourguide.model.User;
import com.tourguide.service.RewardsService;

import tripPricer.Provider;

@SpringBootTest

public class RewardTest {

	@Test
	public void getTripDeals() {
		RewardsService rewardsService = new RewardsService();

		User user = new User(UUID.randomUUID(), "jon", "000", "jon@tourGuide.com");

		List<Provider> providers = rewardsService.getTripDeals(user);

		assertEquals(10, providers.size());
	}

}
