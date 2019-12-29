package com.bae.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.exceptions.CategoryNotFoundException;
import com.bae.persistence.domain.Category;
import com.bae.persistence.repository.CategoryRepository;
@Service
public class CategoryService {

	private CategoryRepository repository;
	
	@Autowired
	public CategoryService(CategoryRepository repository) {
		this.repository = repository;
	}

	public List<Category> getAllCategory() {
		return repository.findAll();
	}

	public Category createCategory(Category category) {
		return this.repository.save(category);
	}

	public Category updateCategory(Category category) {
		return repository.save(category);
	}

	public boolean deleteCategory(Long id) {
		if (!this.repository.existsById(id)) {
				throw new CategoryNotFoundException();
		}
		this.repository.deleteById(id);
		return this.repository.existsById(id);
	}

	public Category findCategorybyId(Long id) {
		return this.repository.findById(id).orElseThrow(CategoryNotFoundException::new);
	
	}
}
	
