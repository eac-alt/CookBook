package com.bae.rest;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistence.domain.Category;
import com.bae.service.CategoryService;

@RestController 
@RequestMapping("/categoryapp")
public class CategoryController {
	
		private CategoryService categoryService;
		
		@Autowired
		public CategoryController(CategoryService categoryService){
			super();
			this.categoryService = categoryService;
		}

		@GetMapping("/getAllCategories")
		public List<Category> getAllCategory() {
			return categoryService.getAllCategory();
		}
		@GetMapping("/get{id}")
		public Category getCategory(@PathVariable Long id) {
			return this.categoryService.findCategorybyId(id);
		}

		@PostMapping("/createCategory")
		public Category createCategory(@RequestBody Category category) {
			return categoryService.createCategory(category);
		}

		@PutMapping("/updateCategory")
		public Category updateCategory(@PathParam("id") Long id, @RequestBody Category category) {
			return this.categoryService.updateCategory(category);
		}

		@DeleteMapping("/deleteCategory/{id}")
		public void deleteCategory(@PathVariable(value = "id") Long id) {
			 this.categoryService.deleteCategory(id);
			
		}

	}
