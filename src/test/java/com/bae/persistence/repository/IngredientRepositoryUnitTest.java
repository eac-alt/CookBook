package com.bae.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Ingredient;

	@RunWith(SpringRunner.class)
	@DataJpaTest
	public class IngredientRepositoryUnitTest {

	@Autowired
	private IngredientRepository repository;

	private final String TEST_NAME = "Chocolate Cake";
	private final Ingredient TEST_INGREDIENT = new Ingredient("Chocolate Cake");

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