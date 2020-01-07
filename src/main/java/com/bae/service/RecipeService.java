package com.bae.service;

import java.util.List;
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
		if (matches(recipe.getRecipeTitle(), "^[A-Za-z]{5,30}$")) {
			throw new IllegalStateException(
					"Invalid Recipe Name. Please enter a recipe name between 5 and 30 letters from A to Z.");
		} else if (matches(recipe.getRecipeMethod(),"^\\W*(?:\\w+\\b\\W*){10,400}$")) {
			throw new IllegalStateException(
					"Invalid Recipe Method. Please enter a recipe method between 10 and 600 words.");
		} else if (matches(recipe.getCookTime(),"^(0[0-9]|1[0-9]|2[0-3]|[0-9]):[0-5][0-9]$")) {
			throw new IllegalStateException("Invalid CookTime. Please enter a valid CookTime in the HH.MM format.");
		} else if (matches(recipe.getPrepTime(),"^(0[0-9]|1[0-9]|2[0-3]|[0-9]):[0-5][0-9]$")) {
			throw new IllegalStateException("Invalid PrepTime. Please enter a valid PrepTime in the HH.MM format.");
		} else if (matches(recipe.getPricePerUnit(), "^£?(([1-9]{1,3}(,\\d{3})*(\\.\\d{2})?)|(0\\.[1-9]\\d)|(0\\.0[1-9]))$")) {
			throw new IllegalStateException(
					"Invalid Price per unit. Please enter a valid Price per unit in the ££.pp format. ");
		}

		return this.repository.save(recipe);
	}

	private boolean matches(String value, String pattern) {
		return value == null || !value.matches(pattern);
	}

	public Recipe updateRecipe(Recipe recipe, long id) {
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
		return this.repository.findById(id).orElseThrow(() -> new RecipeNotFoundException());
	}

}
