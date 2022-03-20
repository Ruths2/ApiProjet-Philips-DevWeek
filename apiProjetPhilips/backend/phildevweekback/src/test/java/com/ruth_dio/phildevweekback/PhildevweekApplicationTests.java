package com.ruth_dio.phildevweekback;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruth_dio.phildevweekback.controller.ControllerRegiao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PhildevweekbackApplicationTests{
	private final String URL="/api/regioes";

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ControllerRegiao controllerRegiao;
	
	@Test
	public void getControllerTest() throws Exception {
		mockMvc.perform(get(URL)).andExpect(status().isOk());

	}

	@Test
	public void getByIdControllerTest() throws Exception {
		mockMvc.perform(get(URL+"/45")).andExpect(status().isOk());

	}

}
