package com.bae.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.exceptions.RecipeNotFoundException;
import com.bae.persistence.domain.Recipe;
import com.bae.persistence.repository.RecipeRepository;

@Service
public class RecipeService {

	private RecipeRepository repository;
	
	@Autowired
	public RecipeService(RecipeRepository repository) {
		this.repository = repository;
	}

	public List<Recipe> findAllRecipe() {
		return repository.findAll();
	}

	public Recipe createRecipe(Recipe recipe) {
		if (!recipe.getRecipeTitle().matches("[a-zA-Z]+{5,30}")) {
			throw new IllegalStateException("Invalid Recipe Name. Please enter a recipe name between 5 and 30 letters from A to Z.");
		}
		return this.repository.save(recipe);
		

		if (!recipe.getRecipeMethod().matches("^\\W*(?:\\w+\\b\\W*){100,600}$")) {
			throw new IllegalStateException();
		}
		return this.repository.save(recipe);
		
		if (!recipe.getCookTime().matches("^(1[0-2]|0?[1-9]):([0-5]?[0-9])$")) {
			throw new IllegalStateException();

		}
		return this.repository.save(recipe);
		
		
		


	public Recipe updateRecipe(Recipe recipe, long id){
		Recipe toUpdate = this.repository.findById(id).orElseThrow(RecipeNotFoundException::new);
		toUpdate.setRecipeTitle(recipe.getRecipeTitle());
		toUpdate.setRecipeMethod(recipe.getRecipeMethod());
		toUpdate.setPrepTime(recipe.getPrepTime());
		toUpdate.setCookTime(recipe.getCookTime());
		toUpdate.setPricePerUnit(recipe.getPricePerUnit());
		return this.repository.save(toUpdate);
		
	}

	public boolean deleteRecipe(Long id) {
		if (!this.repository.existsById(id)) {
				throw new RecipeNotFoundException();
		}
		this.repository.deleteById(id);
		return this.repository.existsById(id);
	}
	
	
	public Recipe findRecipeById(Long id) {
		return this.repository.findById(id).orElseThrow(
				() -> new RecipeNotFoundException());
	}

}