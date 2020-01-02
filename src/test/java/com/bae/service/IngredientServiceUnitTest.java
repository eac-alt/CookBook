package com.bae.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.bae.persistence.domain.Ingredient;
import com.bae.persistence.repository.IngredientRepository;
import com.bae.service.IngredientService;

 @RunWith(MockitoJUnitRunner.class)
public class IngredientServiceUnitTest {


	@InjectMocks
	private IngredientService service;
	
	@Mock
	private IngredientRepository repository;
	
	private List<Ingredient> ingredientList;
	
	private Ingredient testIngredient;
	
	private Ingredient testIngredientWithID;
	
	
	
	final long id = 1L;
	
	@Before
	public void init() {
		this.ingredientList = new ArrayList<>();
		this.ingredientList.add(testIngredient);
		this.testIngredient = new Ingredient ("Chocolate", "500g" );
		this.testIngredientWithID = new Ingredient(testIngredient.getIngredientName(),testIngredient.getIngredientAmount()); 
	    this.testIngredientWithID.setIngredientId(id);
	    

	}

	@Test
	public void createIngredientTest() {
		when (this.repository.save(testIngredient)).thenReturn(testIngredientWithID);
		
		assertEquals(this.testIngredientWithID,this.service.createIngredient(testIngredient));
		
		verify(this.repository, times(1)).save (this.testIngredient); 
	}

	
	@Test
	public void deleteIngredientTest() {
		when(this.repository.existsById(id)).thenReturn(true,false);
		
		this.service.deleteIngredient(id);
		verify(this.repository,times(1)).deleteById(id);
		verify(this.repository,times(2)).existsById(id);
		
		
	}
	
	@Test
	public void findIngredientByIdTest() {
		when(this.repository.findById(id)).thenReturn(Optional.of(this.testIngredientWithID));
		
		assertEquals(this.testIngredientWithID, this.service.findIngredientById(this.id));
		
		verify(this.repository,times(1)).findById(this.id);
			
			
	}
	
	@Test
	
	public void readIngredientTest( ) {
		when(repository.findAll()).thenReturn(this.ingredientList);
		
		assertFalse("No Ingredients found by Controller", this.service.findAllIngredient().isEmpty());
		
		verify(repository,times(1)).findAll();
		
	}
	
	@Test
	
	public void updateIngredientTest() {
		
		Ingredient newIngredient = new Ingredient ("Chocolate", "500g");
		Ingredient updatedIngredient = new Ingredient(newIngredient.getIngredientName(), newIngredient.getIngredientAmount());
		updatedIngredient.setIngredientId(this.id);
		
		when(this.repository.findById(this.id)).thenReturn(Optional.of(this.testIngredientWithID));
		
		when(this.repository.save(updatedIngredient)).thenReturn(updatedIngredient);
		
		assertEquals(updatedIngredient, this.service.updateIngredient(newIngredient, this.id));
		
		verify(this.repository, times(1)).findById(1L);
		verify(this.repository,times(1)).save(updatedIngredient);
		
	}

	
	

}