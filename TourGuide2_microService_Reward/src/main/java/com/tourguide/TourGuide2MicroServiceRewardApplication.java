package com.tourguide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import rewardCentral.RewardCentral;

@SpringBootApplication
@EnableFeignClients("com.tourguide")
public class TourGuide2MicroServiceRewardApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourGuide2MicroServiceRewardApplication.class, args);
	}

	@Bean
	public RewardCentral getRewardCentrall() {
		return new RewardCentral();
	}

}
