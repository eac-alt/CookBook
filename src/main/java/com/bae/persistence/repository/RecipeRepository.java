package com.bae.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.persistence.domain.Recipe;

@Repository
	public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	
	List<Recipe> findByRecipeTitle(String title);
}