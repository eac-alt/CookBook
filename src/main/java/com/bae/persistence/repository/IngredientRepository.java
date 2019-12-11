package com.bae.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.persistence.domain.Ingredient;


	@Repository
	public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
