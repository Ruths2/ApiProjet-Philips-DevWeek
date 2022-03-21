package com.ruth_dio.phildevweekback;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruth_dio.phildevweekback.controller.ControllerRegiao;
import com.ruth_dio.phildevweekback.entity.Regiao;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;



@SpringBootTest
@AutoConfigureMockMvc
class PhildevweekbackApplicationTests{
	private final String URL="/api/regioes";


	@Autowired
	MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ControllerRegiao controller;
	

	@Test
	public void getControllerTest() throws Exception {
		mockMvc.perform(get(URL)).andExpect(status().isOk());

	}

	@Test
	public void getByIdControllerTest() throws Exception {
		mockMvc.perform(get(URL+"/1")).andExpect(status().isOk());

	}

	/*
	 * @Test
	 * public void addNewRegiaoTest() throws Exception {
	 *   Regiao newRegiao = new Regiao("Noroeste",65);
	 *   mockMvc.perform(post(URL+"/add").contentType(MediaType.APPLICATION_JSON).content(asJasonString(newRegiao))).andExpect(status().isOk());
	 * }
	 */

	@Test
	public void deleteByIdRegiaoTest() throws Exception {
		mockMvc.perform(delete(URL+"/delete/{id}","1004").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}


	public static String asJasonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
