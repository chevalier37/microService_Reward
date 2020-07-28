package com.tourguide;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import rewardCentral.RewardCentral;

@SpringBootApplication
@EnableFeignClients("com.tourguide")
@EnableDiscoveryClient
@EnableAsync
public class TourGuide2MicroServiceRewardApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourGuide2MicroServiceRewardApplication.class, args);
	}

	@Bean
	public RewardCentral getRewardCentrall() {
		return new RewardCentral();
	}

	@Bean(name = "asyncExecutor")
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3);
		executor.setMaxPoolSize(3);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("AsynchThread-");
		executor.initialize();
		return executor;
	}

}
