package com.tourguide;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.tourguide.controller.RewardController;
import com.tourguide.proxies.MicroServiceUserProxy;
import com.tourguide.service.RewardsService;

@WebMvcTest(RewardController.class)
@ExtendWith(SpringExtension.class)
public class RewardsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	RewardsService rewardsService;

	@MockBean
	MicroServiceUserProxy userProxy;

	@Test
	public void get5NearbyAttractionsTest() throws Exception {
		this.mockMvc.perform(
				MockMvcRequestBuilders.get("/calculateRewards/internalUser1").param("userName", "internalUser1"))
				.andDo(print()).andExpect(status().isOk());
	}

}
