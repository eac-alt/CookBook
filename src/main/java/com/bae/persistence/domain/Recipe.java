package com.bae.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	@Column(length = 40000)
	private String recipeMethod;
	private String prepTime;
	private String cookTime;
	private String pricePerUnit;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Ingredient> ingredients = new ArrayList<>();

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

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
				+ ", prepTime=" + prepTime + ", cookTime=" + cookTime + ", pricePerUnit=" + pricePerUnit + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Recipe other = (Recipe) obj;
		if (recipeMethod == null) {
			if (other.recipeMethod != null) {
				return false;
			}
		} else if (!recipeMethod.equals(other.recipeMethod)) {
			return false;
		}
		if (recipeTitle == null) {
			if (other.recipeTitle != null) {
				return false;
			}
		} else if (!recipeTitle.equals(other.recipeTitle)) {
			return false;
		}
		return true;
	}

}
