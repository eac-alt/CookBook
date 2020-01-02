package com.bae.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.bae.persistence.domain.Ingredient;
import com.bae.service.IngredientService;

@RunWith(MockitoJUnitRunner.class)
public class IngredientControllerUnitTest {

	@InjectMocks
	private IngredientController controller;


	@Mock
	private IngredientService service;
	
	private List<Ingredient> ingredientList;
	
	private Ingredient testIngredient;
	
	private Ingredient testIngredientWithId;
	
	final long id = 1L;
	
	@Before
	public void init() {
		this.ingredientList = new ArrayList<>();
		this.ingredientList.add(testIngredient);
		this.testIngredient = new Ingredient ("Chocolate", "500g  " );
	    this.testIngredientWithId = new Ingredient(this.testIngredient.getIngredientName(), this.testIngredient.getIngredientAmount());

	    this.testIngredientWithId.setIngredientId(id);
		

	}

	@Test
	public void createIngredientTest() {
		when (this.service.createIngredient(testIngredient)).thenReturn(testIngredientWithId);
		
		assertEquals(this.testIngredientWithId,this.controller.createIngredient(testIngredient));
		
		verify(this.service, times(1)).createIngredient(this.testIngredient);
		
	}
	
	@Test
	public void deleteIngredientTest() {
		this.controller.deleteIngredient(this.id);
		
		verify(this.service, times(1)).deleteIngredient(this.id); //verifies that method is called at least once 
		
		
	}
	
	@Test
	public void findIngredientByIdTest() {
		when(this.service.findIngredientById(this.id)).thenReturn(this.testIngredientWithId);
		
		assertEquals(this.testIngredientWithId, this.controller.getIngredient(this.id));
		
		verify(this.service,times(1)).findIngredientById(this.id);
			
			
	}
	
	@Test
	
	public void findAllIngredientTest( ) {
		
		when(service.findAllIngredient()).thenReturn(this.ingredientList);
		
		assertFalse("No Recipes found by Controller", this.controller.getAllIngredients().isEmpty());
		
		verify(service, times(1)).findAllIngredient(); 
		
	}
	
	@Test
	
	public void updateIngredientTest() {
		
		Ingredient newIngredient = new Ingredient ("Chocolate ", "500g");
		Ingredient updatedIngredient = new Ingredient(newIngredient.getIngredientName(), newIngredient.getIngredientAmount());
		updatedIngredient.setIngredientId(this.id);
		
		when(this.service.updateIngredient(newIngredient, this.id)).thenReturn(updatedIngredient);
		
		assertEquals(updatedIngredient, this.controller.updateIngredient(this.id, newIngredient));
		
		verify(this.service, times(1)).updateIngredient(newIngredient, this.id);
		
	}

	
	

}
