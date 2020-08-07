package com.tourguide.proxies;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tourguide.model.User;
import com.tourguide.model.UserReward;

@FeignClient(name = "microservice-user")
@RibbonClient(name = "microservice-user")
public interface MicroServiceUserProxy {

	@GetMapping("user/getUser/{userName}")
	User getUser(@PathVariable("userName") String userName);

	@PutMapping("user/addUserReward/{userName}")
	void addUserReward(@PathVariable("userName") String userName, @RequestBody List<UserReward> userRewars);
}
