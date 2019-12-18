


package com.bae.persistence.domain;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity 
public class Category {

	public Category() {
		super();
	}
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long categoryId;
		private String categoryName;
		
		@ManyToMany(mappedBy = "recipeHasCategory")
	    private Set<Recipe> recipeHasCategory;
		
	
		public Long getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(Long categoryId) {
			this.categoryId = categoryId;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		@Override
		public String toString() {
			return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", recipeHasCategory="
					+ recipeHasCategory + "]";
		}
		
		
	}  


	
	

	
	
	
	