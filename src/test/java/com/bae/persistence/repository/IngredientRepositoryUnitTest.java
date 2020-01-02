package com.bae.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.bae.persistence.domain.Ingredient;

	@RunWith(MockitoJUnitRunner.class)
	public class IngredientRepositoryUnitTest {

	
	@Autowired
	private IngredientRepository repository;

	private final String TEST_NAME = "Chocolate";

	private final Ingredient TEST_INGREDIENT = new Ingredient("Chocolate", "500g");

	private Ingredient testSavedIngredient;

	@Before
	public void init() {
		this.repository.deleteAll();
		this.testSavedIngredient = this.repository.save(this.TEST_INGREDIENT);
	}

	@Test
	public void testFindByName() {
		assertThat(this.repository.findByIngredientName(this.TEST_NAME)).containsExactly(this.testSavedIngredient);
	}

}