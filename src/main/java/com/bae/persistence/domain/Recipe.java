package com.bae.persistence.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Recipe {

	public Recipe() {
		super();
	}

	public Recipe(String recipeTitle, String recipeMethod, double d, double e, double f) {
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
	private double prepTime;
	private double cookTime;
	private double pricePerUnit;

	//@ManyToMany
	//@JoinTable(name = "recipe_category ", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "categoryId"))
	//private Set<Category> recipeHasCategory;
	

	@OneToMany
	//@JoinTable(name = "recipe_ingredient", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "ingredientId"))
	private List<Ingredient> ingredients;

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

	public double getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(float prepTime) {
		this.prepTime = prepTime;
	}

	public double getCookTime() {
		return cookTime;
	}

	public void setCookTime(float cookTime) {
		this.cookTime = cookTime;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", recipeTitle=" + recipeTitle + ", recipeMethod=" + recipeMethod
				+ ", prepTime=" + prepTime + ", cookTime=" + cookTime + ", pricePerUnit=" + pricePerUnit
				+ "]";
	}

	

}