package com.bae.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.bae.persistence.domain.Ingredient;
import com.bae.persistence.repository.IngredientRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IngredientControllerIntegrationTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private IngredientRepository repository;

	private ObjectMapper mapper = new ObjectMapper();

	private long id;

	private Ingredient testIngredient ;

	private Ingredient testIngredientWithID;

	@Before
	public void init() {
		this.repository.deleteAll();

		this.testIngredient  = new Ingredient ("Chocolate 400g ");
		this.testIngredientWithID = this.repository.save(this.testIngredient);
		this.id = this.testIngredientWithID.getIngredientId();
	}

	@Test
	public void testCreateIngredient() throws Exception {
		String result = this.mock
				.perform(request(HttpMethod.POST, "/ingredient/createIngredient").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(testIngredient)).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		assertEquals(this.mapper.writeValueAsString(testIngredientWithID), result);
	}

	@Test
	public void testDeleteIngredient() throws Exception {
		this.mock.perform(request(HttpMethod.DELETE, "/ingredient/deleteIngredient/" + this.id)).andExpect(status().isOk());
	}

	@Test
	public void testGetAllIngredients() throws Exception {
		List<Ingredient> IngredientList = new ArrayList<>();
		IngredientList.add(this.testIngredientWithID);

		String content = this.mock.perform(request(HttpMethod.GET, "/ingredient/getAllIngredient").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		assertEquals(this.mapper.writeValueAsString(IngredientList), content);
	}

	@Test
	public void testUpdateIngredient() throws Exception {
		Ingredient newIngredient = new Ingredient("Lemon juice");
		Ingredient updatedIngredient = new Ingredient(newIngredient.getIngredientName());
		updatedIngredient.setIngredientId(this.id);

		String result = this.mock
				.perform(request(HttpMethod.PUT, "/ingredient/updateIngredient/?id=" + this.id).accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newIngredient)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		assertEquals(this.mapper.writeValueAsString(updatedIngredient), result);
	}

}