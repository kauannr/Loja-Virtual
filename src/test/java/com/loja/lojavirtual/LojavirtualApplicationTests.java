package com.loja.lojavirtual;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loja.lojavirtual.controllers.AcessoController;
import com.loja.lojavirtual.entities.Acesso;
import com.loja.lojavirtual.repositories.AcessoRepository;

@SpringBootTest
@Transactional
@ExtendWith(MockitoExtension.class)
class LojavirtualApplicationTests {

	@Autowired
	AcessoController acessoController;

	@Autowired
	AcessoRepository acessoRepository;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void testRestApiCadastroAcesso() throws JsonProcessingException, Exception {

		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.webApplicationContext);
		MockMvc mockMvc = builder.build();

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
