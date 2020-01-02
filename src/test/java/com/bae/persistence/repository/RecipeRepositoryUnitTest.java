package com.bae.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.bae.persistence.domain.Recipe;


	@RunWith(MockitoJUnitRunner.class)
	public class RecipeRepositoryUnitTest {



		@Autowired
		private RecipeRepository repository;

		private final String TEST_TITLE = "Victoria Sponge";

		private final Recipe TEST_RECIPE = new Recipe("Victoria Sponge", "1.Combine ingredients 2. Mix well 3.Bake at 180 " , 1.0 , 0.30, 0.50 );

		private Recipe testSavedRecipe;

		@Before
		public void init() {
			this.repository.deleteAll();
			this.testSavedRecipe = this.repository.save(this.TEST_RECIPE);
		}

		@Test
		public void testFindByName() {
			assertThat(this.repository.findByRecipeTitle(this.TEST_TITLE)).containsExactly(this.testSavedRecipe);
		} 
	}

