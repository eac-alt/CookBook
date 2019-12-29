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

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Recipe;
import com.bae.persistence.repository.RecipeRepository;
import com.bae.rest.RecipeController;
import com.bae.service.RecipeService;

@RunWith(SpringRunner.class)
class RecipeControllerUnitTest {

	@InjectMocks
	private RecipeController controller;


	@Mock
	private RecipeService service;
	
	private List<Recipe> recipeList;
	
	private Recipe testRecipe;
	
	private Recipe testRecipeWithId;
	
	final long id = 1L;
	
	@Before(value = "") 
	public void init() {
		this.recipeList = new ArrayList<>();
		this.recipeList.add(testRecipe);
		this.testRecipe = new Recipe ("Victoria Sponge", "1.Combine ingredients 2. Mix well 3.Bake at 180 " , 1.0 , 0.30, 0.50 );
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
		when(this.service.findRecipeById)(this.id)).thenReturn(this.testRecipeWithId));
		
		assertEquals(this.testRecipeWithId, this.controller.getRecipe(this.id));
		
		verify(this.service,times(1)).findRecipeById(this.id);
			
			
	}
	
	@Test
	
	public void getAllRecipesTest( ) {
		
		when(service.getAllRecipe()).thenReturn(this.recipeList);
		
		assertFalse("No Recipes found by Controller")this.controller.getAllRecipe().isEmpty());
		
		verify(service,times(1).findAllRecipe(); 
		
	}
	
	@Test
	
	public void updateRecipeTest() {
		
		Recipe newRecipe = new Recipe ("Chocolate Cake", "1.Mix ingredients, 2.Transfer mixture into baking tin 3. Bake at 170", 1.05, 0.45, 0.75);
		Recipe updatedRecipe = new Recipe(newRecipe.getRecipeTitle(), newRecipe.getRecipeMethod(), newRecipe.getCookTime(), newRecipe.getPrepTime(), newRecipe.getCookTime(), newRecipe.getCostPerUnit());
		updatedRecipe.setRecipeId(this.id);
		
		when(this.service.updateRecipe(this.id)).thenReturn(Optional.of(this.testRecipeWithId));
		
		assertEquals(updatedRecipe, this.controller.updateRecipe(newRecipe,this.id));
		
		verify(this.service, times(1).updateRecipe(1L));
		
	}

	
	

}
