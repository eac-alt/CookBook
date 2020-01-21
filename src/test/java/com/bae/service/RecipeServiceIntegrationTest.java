package com.bae.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Ingredient;
import com.bae.persistence.domain.Recipe;
import com.bae.persistence.repository.RecipeRepository;
import com.bae.service.RecipeService;

import antlr.collections.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceIntegrationTest {


	@Autowired
	private RecipeService service;

	@Autowired
	private RecipeRepository repository;

	private Recipe testRecipe;

	private Recipe testRecipeWithID;
	
	private Ingredient testIngredient;
	
	private Ingredient testIngredientID;
	@Before
	public void init() {
		this.testRecipe = new Recipe("Sponge Cake", "1.Combine wet and dry ingredients. 2.Pour mixture into cake tin. 3 Bake at 180 degrees celsius for 40 minutes", "00:40", "1:00", "£00.34");
		
		this.repository.deleteAll();
		
		this.testRecipeWithID = this.repository.save(this.testRecipe);
	}
	
	@Test
	public void testCreateRecipe() {
		assertEquals(this.testRecipeWithID, this.service.createRecipe(testRecipe));
	}

	@Test
	public void testRecipeDelete() {
		assertThat(this.service.deleteRecipe(this.testRecipeWithID.getRecipeId())).isFalse();
	}

	@Test
	public void testFindRecipeByID() {
		assertThat(this.service.findRecipeById(this.testRecipeWithID.getRecipeId())).isEqualTo(this.testRecipeWithID);
	}

	@Test
	public void testReadRecipes() {
		assertThat(this.service.findAllRecipe()).isEqualTo(Arrays.asList(new Recipe[] { this.testRecipeWithID }));
	}

	@Test
    public void testUpdateRecipe() {
        Recipe newRecipe = new Recipe("Chocolate Cake", "1.Combine dry ingredients. 2.Melt butter, allow to cool and then mix wet and dry ingredients. 3. Bake at 170 degrees for 30 minutes", "00:30", "00:50", "£00.75");
        Recipe updatedRecipe = new Recipe(newRecipe.getRecipeTitle(), newRecipe.getRecipeMethod(), newRecipe.getCookTime(), newRecipe.getPrepTime(), newRecipe.getPricePerUnit());
        updatedRecipe.setRecipeId(this.testRecipeWithID.getRecipeId());
        assertThat(this.service.updateRecipe(newRecipe, this.testRecipeWithID.getRecipeId())).isEqualTo(updatedRecipe);
    }
	
}