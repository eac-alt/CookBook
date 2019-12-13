package com.bae.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.persistence.domain.Recipe;
import com.bae.persistence.repository.RecipeRepository;

@Service
public class RecipeService {

	private RecipeRepository recipeRepository;

	public RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	public List<Recipe> getAllRecipe() {
		return recipeRepository.findAll();
	}

	public Recipe addNewRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	public Recipe updateRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	public String deleteRecipe(Long id) {
		recipeRepository.deleteById(id);
		return "Recipe succesfully deleted";
	}

}

	
	