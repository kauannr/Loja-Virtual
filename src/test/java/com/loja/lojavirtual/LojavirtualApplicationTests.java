package com.loja.lojavirtual;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loja.lojavirtual.controllers.AcessoController;
import com.loja.lojavirtual.entities.Acesso;
import com.loja.lojavirtual.repositories.AcessoRepository;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class LojavirtualApplicationTests {

	@Autowired
	AcessoController acessoController;

	@Autowired
	AcessoRepository acessoRepository;

	@Autowired
	private MockMvc mockMvc;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void testRestApiCadastroAcesso() throws JsonProcessingException, Exception {

		Acesso acesso = new Acesso(null, "descricao teste json");

		ResultActions retornoApi = mockMvc
				.perform(MockMvcRequestBuilders.post("/acessos").content(objectMapper.writeValueAsString(acesso))
						.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON));

		System.out.println(retornoApi.andReturn().getResponse().getContentAsString());

		Acesso objetoRetornado = objectMapper.readValue(retornoApi.andReturn().getResponse().getContentAsString(),
				Acesso.class);

		assertEquals(acesso.getDescricao(), objetoRetornado.getDescricao(), "Falhou: descricoes nao sao iguais");

	}

}
