package com.bae.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient  {

	public Ingredient() {
		super();
	}

	public Ingredient(String ingredientName , String ingredientAmount) {
		super();
		this.ingredientName = ingredientName;
		this.ingredientAmount = ingredientAmount;
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ingredientId;
	private String ingredientName;
	private String ingredientAmount; 

	
	

	//@ManyToMany(mappedBy = "recipeHasIngredient")
	//private Set<Recipe> ingredientIsInRecipe;

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
	@Override
	public String toString() {
		return "Ingredient [ingredientId=" + ingredientId + ", ingredientName=" + ingredientName
				+ "]";
	}
	public String getIngredientAmount() {
		return ingredientAmount;
	}
	public void setIngredientAmount(String ingredientAmount) {
		this.ingredientAmount = ingredientAmount;
	}
	
	 
	
}
