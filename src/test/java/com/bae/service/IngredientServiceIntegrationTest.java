package com.bae.service;import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.bae.persistence.domain.Ingredient;
import com.bae.persistence.repository.IngredientRepository;
import com.bae.service.IngredientService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IngredientServiceIntegrationTest {


    @Autowired
    private IngredientService service;
    @Autowired
    private IngredientRepository repository;
    private Ingredient testIngredient;
    private Ingredient testIngredientWithID;
    @Before
    public void init() {
        this.testIngredient = new Ingredient("500g Chocolate");
        
        this.repository.deleteAll();
        
        this.testIngredientWithID = this.repository.save(this.testIngredient);
    }
    
    @Test
    public void testCreateIngredient() {
        assertEquals(this.testIngredientWithID, this.service.createIngredient(testIngredient));
    }
    @Test
    public void testIngredientDelete() {
        assertThat(this.service.deleteIngredient(this.testIngredientWithID.getIngredientId())).isFalse();
    }
    @Test
    public void testFindIngredientByID() {
        assertThat(this.service.findIngredientById(this.testIngredientWithID.getIngredientId())).isEqualTo(this.testIngredientWithID);
    }
    @Test
    public void testReadIngredient() {
        assertThat(this.service.findAllIngredient()).isEqualTo(Arrays.asList(new Ingredient[] { this.testIngredientWithID }));
    }
    @Test
    public void testUpdateIngredient() {
        Ingredient newIngredient = new Ingredient("50g Butter");
        Ingredient updatedIngredient = new Ingredient(newIngredient.getIngredientName());
        updatedIngredient.setIngredientId(this.testIngredientWithID.getIngredientId());
        assertThat(this.service.updateIngredient(newIngredient, this.testIngredientWithID.getIngredientId())).isEqualTo(updatedIngredient);
    }
}



