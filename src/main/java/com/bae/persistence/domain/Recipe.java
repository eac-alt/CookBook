package com.bae.persistence.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class Recipe {

	public Recipe() {
		super();
	}


	public Recipe(String recipeTitle, String recipeMethod, String prepTime, String cookTime, String pricePerUnit) {
		super();
		this.recipeTitle = recipeTitle;
		this.recipeMethod = recipeMethod;
		this.prepTime = prepTime;
		this.cookTime = cookTime;
		this.pricePerUnit = pricePerUnit;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipe_id")
	private Long recipeId;
	private String recipeTitle;
	private String recipeMethod;
	private String prepTime;
	private String cookTime;
	private String pricePerUnit;

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

	public String getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	public String getCookTime() {
		return cookTime;
	}

	public void setCookTime(String cookTime) {
		this.cookTime = cookTime;
	}

	public String getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(String pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", recipeTitle=" + recipeTitle + ", recipeMethod=" + recipeMethod
				+ ", prepTime=" + prepTime + ", cookTime=" + cookTime + ", pricePerUnit=" + pricePerUnit
				+ "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		if (recipeTitle == null) {
			if (other.recipeTitle != null)
				return false;
		} else if (!recipeTitle.equals(other.recipeTitle))
			return false;
		if (recipeMethod == null) {
			if (other.recipeMethod != null)
				return false;
		} else if (!recipeMethod.equals(other.recipeMethod))
			return false;
		if (recipeId != other.recipeId)
			return false;
	
		return true;
	}

}

	
