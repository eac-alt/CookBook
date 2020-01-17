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

import com.bae.persistence.domain.Recipe;
import com.bae.persistence.repository.RecipeRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RecipeControllerIntegrationTest {
	
		@Autowired
		private MockMvc mock;

		@Autowired
		private RecipeRepository repository;

		private ObjectMapper mapper = new ObjectMapper();

		private long id;

		private Recipe testRecipe;

		private Recipe testRecipeWithID;

		@Before
		public void init() {
			this.repository.deleteAll();

			this.testRecipe  = new Recipe ("Chocolate Cake", "1.Combine wet and dry ingredients. 2.Add to baking tin. 3. Bake for 35 mins at 170 degrees celsius", "00:35", "00:45", "0.36");
			this.testRecipeWithID = this.repository.save(this.testRecipe);
			this.id = this.testRecipeWithID.getRecipeId();
		}
		@Test
		public void testCreateRecipe() throws Exception {
			String result = this.mock
					.perform(request(HttpMethod.POST, "/recipe/createRecipe").contentType(MediaType.APPLICATION_JSON)
							.content(this.mapper.writeValueAsString(testRecipe)).accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
			assertEquals(this.mapper.writeValueAsString(testRecipeWithID), result);
		}

		@Test
		public void testDeleteRecipe() throws Exception {
			this.mock.perform(request(HttpMethod.DELETE, "/recipe/deleteRecipe/" + this.id)).andExpect(status().isOk());
		}

		@Test
		public void testGetAllRecipes() throws Exception {
			List<Recipe> RecipeList = new ArrayList<>();
			RecipeList.add(this.testRecipeWithID);

			String content = this.mock.perform(request(HttpMethod.GET, "/recipe/getAllRecipes").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

			assertEquals(this.mapper.writeValueAsString(RecipeList), content);
		}

		@Test
		public void testUpdateRecipe() throws Exception {
			Recipe newRecipe = new Recipe("Lemon Cake", "1.Combine wet and dry ingredients together. 2.Add to lined baking tin. 3. Bake for 40 mins at 160 degrees celsius", "00:40", "01:00", "0.66");;
			Recipe updatedRecipe = new Recipe(newRecipe.getRecipeTitle(), newRecipe.getRecipeMethod(), newRecipe.getPrepTime(), newRecipe.getCookTime(), newRecipe.getPricePerUnit());
			updatedRecipe.setRecipeId(this.id);

			String result = this.mock
					.perform(request(HttpMethod.PUT, "/recipe/updateRecipe/" + this.id).accept(MediaType.APPLICATION_JSON)
							.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newRecipe)))
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
			
			assertEquals(this.mapper.writeValueAsString(updatedRecipe), result);
		}

	}