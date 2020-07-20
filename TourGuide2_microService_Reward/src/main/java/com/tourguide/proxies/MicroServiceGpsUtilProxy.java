package com.tourguide.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.tourguide.model.Attraction;

@FeignClient(name = "microservice-gpsUtil", url = "localhost:9001")
public interface MicroServiceGpsUtilProxy {

	@GetMapping("/getAttractions")
	List<Attraction> getAttractions();

}
