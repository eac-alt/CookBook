package com.bae.cookbook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import com.bae.service.RecipeService;

 @RunWith(SpringRunner.class)
public class RecipeServiceUnitTest {


	@InjectMocks
	private RecipeService service;
	
	@Mock
	private RecipeRepository repository;
	
	private List<Recipe> recipeList;
	
	private Recipe testRecipe;
	
	private Recipe testRecipeWithID;
	
	final long id = 1L;
	
	@Before(value = "") 
	public void init() {
		this.recipeList = new ArrayList<>();
		this.recipeList.add(testRecipe);
		this.testRecipe = new Recipe ("Victoria Sponge", "1.Combine ingredients 2. Mix well 3.Bake at 180 " , 1.0 , 0.30, 0.50 );
	    this.testRecipeWithID.setRecipeId(id);;
		

	}

	@Test
	public void createRecipeTest() {
		when (this.repository.save(testRecipe)).thenReturn(testRecipeWithID);
		
		assertEquals(this.testRecipeWithID,this.service.createRecipe(testRecipe));
		
		verify(this.repository, times(1)).save (this.testRecipe);
		
	}
	
	@Test
	public void deleteRecipeTest() {
		when(this.repository.existsById(id)).thenReturn(true,false);
		
		this.service.deleteRecipe(id);
		verify(this.repository,times(1)).deleteById(id);
		verify(this.repository,times(2)).existsById(id);
		
		
	}
	
	@Test
	public void findRecipeByIdTest() {
		when(this.repository.findById(id)).thenReturn(Optional.of(this.testRecipeWithID));
		
		assertEquals(this.testRecipeWithID, this.service.findRecipebyId(this.id));
		
		verify(this.repository,times(1)).findById(this.id);
			
			
	}
	
	@Test
	
	public void readRecipeTest( ) {
		when(repository.findAll()).thenReturn(this.recipeList);
		
		assertFalse("No Recipes found by Controller")this.service.getAllRecipe().isEmpty());
		
		verify(repository,times(1).findAll();
		
	}
	
	@Test
	
	public void updateRecipeTest() {
		
		Recipe newRecipe = new Recipe ("Chocolate Cake", "1.Mix ingredients, 2.Transfer mixture into baking tin 3. Bake at 170", 1.05, 0.45, 0.75);
		Recipe updatedRecipe = new Recipe(newRecipe.getRecipeTitle(), newRecipe.getRecipeMethod(), newRecipe.getCookTime(), newRecipe.getPrepTime(), newRecipe.getCookTime(), newRecipe.getCostPerUnit());
		updatedRecipe.setRecipeId(this.id);
		
		when(this.repository.findById(this.id)).thenReturn(Optional.of(this.testRecipeWithID));
		
		when(this.repository.save(updatedRecipe)).thenReturn(updatedRecipe);
		
		assertEquals(updatedRecipe, this.service.updateRecipe(newRecipe,this.id));
		
		verify(this.repository, times(1).findRecipeById(1L));
		verify(this.repository,times(1).save(updatedRecipe));
		
	}

	
	

}
