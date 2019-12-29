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

import com.bae.persistence.domain.Ingredient;
import com.bae.service.IngredientService;

@RestController 
@RequestMapping("/Ingredientapp")

public class IngredientController {
	
	private IngredientService ingredientService;
	
	@Autowired
	public IngredientController(IngredientService ingredientService){
		super();
		this.ingredientService = ingredientService;
	}

	@GetMapping("/getAllIngredients")
	public List<Ingredient> getAllIngredients() {
		return ingredientService.getAllIngredients();
	}
	@GetMapping("/get{id}")
	public Ingredient getIngredient(@PathVariable Long id) {
		return this.ingredientService.findIngredientbyId(id);
	}

	@PostMapping("/createIngredient")
	public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
		return ingredientService.createIngredient(ingredient);
	}

	@PutMapping("/updateIngredient")
	public Ingredient updateIngredient(@PathParam("id") Long id, @RequestBody Ingredient ingredient) {
		return this.ingredientService.updateIngredient(ingredient);
	}

	@DeleteMapping("/deleteIngredient/{id}")
	public void deleteIngredient(@PathVariable(value = "id") Long id) {
		 this.ingredientService.deleteIngredient(id);
		
	}

}
