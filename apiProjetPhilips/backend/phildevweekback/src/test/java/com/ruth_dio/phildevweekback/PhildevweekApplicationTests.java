package com.ruth_dio.phildevweekback;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruth_dio.phildevweekback.controller.*;
import com.ruth_dio.phildevweekback.entity.*;

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
	private final String URLR="/api/regioes";
	private final String URLF="/api/faixaetaria";
	private final String URLO="/api/ocorrencias";

	@Autowired
	MockMvc mockMvc;
/*
 *   @Autowired
 *   private ObjectMapper objectMapper;
 *   @Autowired
 *   private ControllerRegiao controllerRegiao;
 *   @Autowired
 *   private ControllerFaixaEtaria controllerFaixa;
 *   @Autowired
 *   private ControllerOcorrencias controllerOcorrencias;
 * 
 */

// ****** Testes com o controller regiao ******
	
	@Test // Testa se a URL /api/regioes esta funcionando corretamente.
	public void getControllerRegiaoTest() throws Exception {
		mockMvc.perform(get(URLR)).andExpect(status().isOk());
	}

	@Test // Testa se a URL /api/regioes/{id} esta funcionando corretamente.
	public void getByIdControllerRegiaoTest() throws Exception {
		mockMvc.perform(get(URLR+"/1")).andExpect(status().isOk());
	}

/*
 *   @Test // Testa se o metodo adicona uma nova Regiao ao banco de dados.
 *   public void addNewRegiaoTest() throws Exception {
 *     Regiao newRegiao = new Regiao("Teste-Regiao",7);
 *     mockMvc.perform(post(URLR+"/add").contentType(MediaType.APPLICATION_JSON).content(asJasonString(newRegiao))).andExpect(status().isOk());
 *   }
 * 
 *   @Test //Testa se o metodo deleta uma região no banco de dados pelo id.
 *   public void deleteByIdRegiaoTest() throws Exception {
 *     mockMvc.perform(delete(URLR+"/delete/{id}","3006").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
 *   }
 */

// ****** Testes com o controller faixaetaria ******
//
		@Test // Testa se a URL /api/faixaetaria esta funcionando corretamente.
	public void getControllerFaixaEtariaTest() throws Exception {
		mockMvc.perform(get(URLF)).andExpect(status().isOk());
	}

	@Test // Testa se a URL /api/faixaetaria/{id} esta funcionando corretamente.
	public void getByIdControllerFaixaEtariaTest() throws Exception {
		mockMvc.perform(get(URLF+"/1")).andExpect(status().isOk());
	}

/*
 *   @Test // Testa se o metodo adicona uma nova faixetaria no banco de dados.
 *   public void addNewFaixaEtariaTest() throws Exception {
 *     FaixaEtaria newFaixaEtaria = new FaixaEtaria(151, 160, "Acima de 150");
 *     mockMvc.perform(post(URLF+"/add").contentType(MediaType.APPLICATION_JSON).content(asJasonString(newFaixaEtaria))).andExpect(status().isOk());
 *   }
 * 
 *   @Test //Testa se o metodo deleta uma faixa etaria no banco de dados pelo id.
 *   public void deleteByIdFaixaEtariaTest() throws Exception {
 *     mockMvc.perform(delete(URLF+"/delete/{id}","3007").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
 *   }
 */

// ****** Testes com o controller ocorrencias ******
//
		@Test // Testa se a URL /api/ocorrencias esta funcionando corretamente.
	public void getControllerOcorrenciasTest() throws Exception {
		mockMvc.perform(get(URLO)).andExpect(status().isOk());
	}

	@Test // Testa se a URL /api/ocorrencias/{id} esta funcionando corretamente.
	public void getByIdControllerOcorrenciasTest() throws Exception {
		mockMvc.perform(get(URLO+"/2")).andExpect(status().isOk());
	}

/*
 *   @Test // Testa se o metodo adicona uma nova ocorrencia no banco de dados.
 *   public void addNewOcorrenciasTest() throws Exception {
 *     IncidenciaExame newIncidenciaExame = new IncidenciaExame(2, 3, 6L, 20);
 *     mockMvc.perform(post(URLO+"/add").contentType(MediaType.APPLICATION_JSON).content(asJasonString(newIncidenciaExame))).andExpect(status().isOk());
 *   }
 * 
 *   @Test //Testa se o metodo deleta uma ocorrencia no banco de dados pelo id.
 *   public void deleteByIdOcorrenciasTest() throws Exception {
 *     mockMvc.perform(delete(URLO+"/delete/{id}","3008").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
 *   }
 */

	public static String asJasonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}		
}
