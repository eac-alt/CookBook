package com.bae.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.exceptions.RecipeNotFoundException;
import com.bae.persistence.domain.Recipe;
import com.bae.persistence.repository.IngredientRepository;
import com.bae.persistence.repository.RecipeRepository;

@Service
public class RecipeService {

	private RecipeRepository repository;
	
	@Autowired
	public RecipeService(RecipeRepository repository) {
		this.repository = repository;
	}

	public List<Recipe> getAllRecipe() {
		return repository.findAll();
	}

	public Recipe createRecipe(Recipe recipe) {
		return this.repository.save(recipe);
	}

	public Recipe updateRecipe(Recipe recipe) {
		return repository.save(recipe);
	}

	public boolean deleteRecipe(Long id) {
		if (!this.repository.existsById(id)) {
				throw new RecipeNotFoundException();
		}
		this.repository.deleteById(id);
		return this.repository.existsById(id);
	}


	public Recipe findRecipebyId(Long id) {
		return this.repository.findById(id).orElseThrow(
				()-> new RecipeNotFoundException()); 
				
	}

}

	
	