package com.bae.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.exceptions.IngredientNotFoundException;
import com.bae.exceptions.RecipeNotFoundException;
import com.bae.persistence.domain.Ingredient;
import com.bae.persistence.repository.IngredientRepository;


@Service
public class IngredientService {
	
	private IngredientRepository ingredientRepository;
	
	
		@Autowired
		public IngredientService(IngredientRepository repository) {
			this.ingredientRepository = repository;
		}

		public List<Ingredient> findAllIngredient() {
			return ingredientRepository.findAll();
		}

		public Ingredient createIngredient(Ingredient ingredient) {
			return this.ingredientRepository.save(ingredient);
		}
		
		

		public Ingredient updateIngredient(Ingredient ingredient, long id){
			Ingredient toUpdate = this.ingredientRepository.findById(id).orElseThrow(RecipeNotFoundException::new);
			toUpdate.setIngredientName(ingredient.getIngredientName());
			return this.ingredientRepository.save(toUpdate);
			
		}

		public boolean deleteIngredient(Long id) {
			if (!this.ingredientRepository.existsById(id)) {
					throw new IngredientNotFoundException();
			}
			this.ingredientRepository.deleteById(id);
			return this.ingredientRepository.existsById(id);
		}

		public Ingredient findIngredientById(Long id) {
			return this.ingredientRepository.findById(id).orElseThrow( IngredientNotFoundException:: new); 
		}
}
		