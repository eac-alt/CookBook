package com.bae.rest;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
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
	
		public RecipeController() {
		super();
	}

		private RecipeService recipeService;
		
		@Autowired
		public RecipeController(RecipeService recipeService){
			super();
			this.recipeService = recipeService;
		}

		@GetMapping("/getAllRecipes")
		public List<Recipe> getAllRecipe() {
			return recipeService.getAllRecipe();
		}
		@GetMapping("/get{id}")
		public Recipe getRecipe(@PathVariable Long id) {
			return this.recipeService.findRecipebyId(id);
		}

		@PostMapping("/createRecipe")
		public Recipe createRecipe(@RequestBody Recipe recipe) {
			return recipeService.createRecipe(recipe);
		}

		@PutMapping("/updateRecipe")
		public Recipe updateRecipe(@PathParam("id") Long id, @RequestBody Recipe recipe) {
			return this.recipeService.updateRecipe(recipe);
		}

		@DeleteMapping("/deleteRecipe/{id}")
		public void deleteRecipe(@PathVariable(value = "id") Long id) {
			 this.recipeService.deleteRecipe(id);
			
		}

	}
