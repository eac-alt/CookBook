package com.bae.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.exceptions.IngredientNotFoundException;
import com.bae.persistence.domain.Ingredient;
import com.bae.persistence.domain.Recipe;
import com.bae.persistence.repository.IngredientRepository;

@Service
public class IngredientService {
	
	private IngredientRepository repository;
	
		@Autowired
		public IngredientService(IngredientRepository repository) {
			this.repository = repository;
		}

		public List<Ingredient> getAllIngredients() {
			return repository.findAll();
		}

		public Ingredient createIngredient(Ingredient ingredient) {

				if (!ingredient.getIngredientName().matches("[a-zA-Z]+{5,30}")){
					throw new IllegalStateException("Invalid Ingredient Name. Please enter a ingredient name between 5 and 30 letters from A to Z.");
				}			
			return this.repository.save(ingredient);
		}

		public Ingredient updateIngredient(Ingredient ingredient) {
			return repository.save(ingredient);
		}

		public boolean deleteIngredient(Long id) {
			if (!this.repository.existsById(id)) {
					throw new IngredientNotFoundException();
			}
			this.repository.deleteById(id);
			return this.repository.existsById(id);
		}

		public Ingredient findIngredientbyId(Long id) {
			return this.repository.findById(id).orElseThrow( IngredientNotFoundException:: new); 
		}
}
		