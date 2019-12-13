package com.bae.rest;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistence.domain.Recipe;
import com.bae.service.RecipeService;

@RestController 
@RequestMapping("/recipeapp")
public class RecipeController {
	
		private RecipeService recipeService;

		public RecipeController(RecipeService recipeService) {
			this.recipeService = recipeService;
		}

		@GetMapping("/recipe")
		public List<Recipe> getAllRecipe() {
			return recipeService.getAllRecipe();
		}

		@PostMapping("/recipe")
		public Recipe addNewRecipe(@RequestBody Recipe recipe) {
			return recipeService.addNewRecipe(recipe);
		}

		@PutMapping("/recipe")
		public Recipe updateRecipe(@RequestBody Recipe recipe) {
			return recipeService.updateRecipe(recipe);
		}

		@DeleteMapping("/recipe/{id}")
		public String deleteRecipe(@PathVariable(value = "id") Long id) {
			return recipeService.deleteRecipe(id);
		}

	}
