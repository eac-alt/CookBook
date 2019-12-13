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

import com.bae.persistence.domain.Ingredient;
import com.bae.service.IngredientService;

@RestController 
@RequestMapping("/Ingredientapp")

public class IngredientController {
	
		private IngredientService ingredientService;

		public IngredientController(IngredientService ingredientService) {
			this.ingredientService = ingredientService;
		}

		@GetMapping("/ingredient")
		public List<Ingredient> getAllIngredient() {
			return IngredientService.getAllIngredient();
		}

		@PostMapping("/ingredient")
		public Ingredient addNewIngredient(@RequestBody Ingredient ingredient) {
			return ingredientService.addNewIngredient(ingredient);
		}

		@PutMapping("/ingredient")
		public Ingredient updateIngredient(@RequestBody Ingredient ingredient) {
			return ingredientService.updateIngredient(ingredient);
		}

		@DeleteMapping("/ingredient/{id}")
		public String deleteIngredient(@PathVariable(value = "id") Long id) {
			return ingredientService.deleteIngredient(id);
		}

	}