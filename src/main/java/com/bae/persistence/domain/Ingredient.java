package com.bae.persistence.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Ingredient  {

	public Ingredient(String ingredientName) {
		super();
		this.ingredientName = ingredientName;
	}
	public Ingredient() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ingredientId;
	private String ingredientName;

	@ManyToMany
    @JoinTable(
    		  name = "recipeIngredients ",
    		  joinColumns = @JoinColumn(name = "ingredientId"),
    		  inverseJoinColumns = @JoinColumn(name = "recipeId"))
	
	private Set<Ingredient> recipeHasIngredients;

	public Long getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(Long ingredientId) {
		this.ingredientId = ingredientId;
	}
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public Set<Ingredient> getRecipeHasIngredients() {
		return recipeHasIngredients;
	}
	public void setRecipeHasIngredients(Set<Ingredient> recipeHasIngredients) {
		this.recipeHasIngredients = recipeHasIngredients;
	}
	@Override
	public String toString() {
		return "Ingredient [ingredientId=" + ingredientId + ", ingredientName=" + ingredientName
				+ ", recipeHasIngredients=" + recipeHasIngredients + "]";
	}
	
	 
	
}
