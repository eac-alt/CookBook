package com.bae.cookbook;

import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Recipe;
import com.bae.persistence.repository.RecipeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
class RecipeRepoUnitTest {


	private static final Object TEST_RECIPE = null;

	@Autowired
	private RecipeRepository repository;

	private final String TEST_TITLE = "Victoria Sponge";

	private final Recipe TEST_RECIPE = new Recipe("Victoria Sponge", "1.Combine ingredients 2. Mix well 3.Bake at 180 " , 1.0 , 0.30, 0.50 );

	private Recipe testSavedRecipe;

	@Before
	public void init() {
		this.repository.deleteAll();
		this.testSavedRecipe = this.repository.save(this.TEST_RECIPE);
	}

	@Test
	public void testFindByName() {
		assertThat(this.repository.findById(this.TEST_TITLE)).containsExactly(this.testSavedRecipe);
	}

}