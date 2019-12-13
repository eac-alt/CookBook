package com.bae.rest;

import java.util.List;

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
@RequestMapping("/Categoryapp")
public class CategoryController {

	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/category")
	public List<Category> getAllCategory() {
		return CategoryService.getAllCategory();
	}

	@PostMapping("/category")
	public Category addNewCategory(@RequestBody Category category) {
		return categoryService.addNewCategory(category);
	}

	@PutMapping("/category")
	public Category updateCategory(@RequestBody Category category) {
		return categoryService.updateCategory(category);
	}

	@DeleteMapping("/category/{id}")
	public String deleteCategory(@PathVariable(value = "id") Long id) {
		return categoryService.deleteCategory(id);
	}

}

