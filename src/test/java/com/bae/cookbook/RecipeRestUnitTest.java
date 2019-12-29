package com.bae.cookbook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Recipe;
import com.bae.persistence.repository.RecipeRepository;
import com.bae.rest.RecipeController;
import com.bae.service.RecipeService;

@RunWith(MockitoJUnitRunner.class)
class RecipeControllerUnitTest {

	@InjectMocks
	private RecipeController controller;


	@Mock
	private RecipeService service;
	
	private List<Recipe> recipeList;
	
	private Recipe testRecipe;
	
	private Recipe testRecipeWithId;
	
	final long id = 1L;
	
	@Before
	public void init() {
		this.recipeList = new ArrayList<>();
		this.recipeList.add(testRecipe);
		this.testRecipe = new Recipe ("Victoria Sponge", "1.Combine ingredients 2. Mix well 3.Bake at 180 " , 1.0 , 0.30, 0.50 );
	       this.testRecipeWithId = new Recipe(this.testRecipe.getRecipeTitle(), this.testRecipe.getRecipeMethod(), this.testRecipe.getPrepTime(), this.testRecipe.getCookTime(), this.testRecipe.getPricePerUnit());

	    this.testRecipeWithId.setRecipeId(id);
		

	}

	@Test
	public void createRecipeTest() {
		when (this.service.createRecipe(testRecipe)).thenReturn(testRecipeWithId);
		
		assertEquals(this.testRecipeWithId,this.controller.createRecipe(testRecipe));
		
		verify(this.service, times(1)).createRecipe(this.testRecipe);
		
	}
	
	@Test
	public void deleteRecipeTest() {
		this.controller.deleteRecipe(id);
		
		verify(this.service, times(1)).deleteRecipe(this.id); //verifies that method is called at least once 
		
		
	}
	
	@Test
	public void findRecipeByIdTest() {
		when(this.service.findRecipeById(this.id)).thenReturn(this.testRecipeWithId);
		
		assertEquals(this.testRecipeWithId, this.controller.getRecipe(this.id));
		
		verify(this.service,times(1)).findRecipeById(this.id);
			
			
	}
	
	@Test
	
	public void getAllRecipesTest( ) {
		
		when(service.findAllRecipe()).thenReturn(this.recipeList);
		
		assertFalse("No Recipes found by Controller", this.controller.getAllRecipe().isEmpty());
		
		verify(service, times(1)).findAllRecipe(); 
		
	}
	
	@Test
	
	public void updateRecipeTest() {
		
		Recipe newRecipe = new Recipe ("Chocolate Cake", "1.Mix ingredients, 2.Transfer mixture into baking tin 3. Bake at 170", 1.05, 0.45, 0.75);
		Recipe updatedRecipe = new Recipe(newRecipe.getRecipeTitle(), newRecipe.getRecipeMethod(), newRecipe.getPrepTime(), newRecipe.getCookTime(), newRecipe.getPricePerUnit());
		updatedRecipe.setRecipeId(this.id);
		
		when(this.service.updateRecipe(newRecipe, this.id)).thenReturn(updatedRecipe);
		
		assertEquals(updatedRecipe, this.controller.updateRecipe(this.id, newRecipe));
		
		verify(this.service, times(1)).updateRecipe(newRecipe, this.id);
		
	}

	
	

}
