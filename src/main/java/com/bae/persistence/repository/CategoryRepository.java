package com.bae.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.persistence.domain.Category;

	
	@Repository
	public interface CategoryRepository extends JpaRepository<Category, Long> {
}
