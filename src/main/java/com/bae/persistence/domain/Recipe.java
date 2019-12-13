package com.bae.persistence.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Recipe {

	public Recipe() {
		super();
	}

	public Recipe(String recipeTitle, String recipeMethod) {
		super();
		this.recipeTitle = recipeTitle;
		this.recipeMethod = recipeMethod;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipe_id")
	private Long recipeId;
	private String recipeTitle;
	private String recipeMethod;
	private float prepTime;
	private float cookTime;
	private float pricePerUnit;

	@ManyToMany
	@JoinTable(name = "recipe_category ", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "categoryId"))
	private Set<Category> recipeHasCategory;

	@ManyToMany
	@JoinTable(name = "recipe_ingredient", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "ingredientId"))
	private Set<Ingredient> recipeHasIngredient;

	public Long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeTitle() {
		return recipeTitle;
	}

	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}

	public String getRecipeMethod() {
		return recipeMethod;
	}

	public void setRecipeMethod(String recipeMethod) {
		this.recipeMethod = recipeMethod;
	}

	public float getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(float prepTime) {
		this.prepTime = prepTime;
	}

	public float getCookTime() {
		return cookTime;
	}

	public void setCookTime(float cookTime) {
		this.cookTime = cookTime;
	}

	public float getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", recipeTitle=" + recipeTitle + ", recipeMethod=" + recipeMethod
				+ ", prepTime=" + prepTime + ", cookTime=" + cookTime + ", pricePerUnit=" + pricePerUnit
				+ ", recipeHasCategory=" + recipeHasCategory + ", recipeHasIngredient=" + recipeHasIngredient + "]";
	}

}