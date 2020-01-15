package com.bae.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.bae.persistence.domain.Recipe;
import com.bae.persistence.repository.RecipeRepository;


 @RunWith(MockitoJUnitRunner.class)
public class RecipeServiceUnitTest {


	@InjectMocks
	private RecipeService service;
	
	@Mock
	private RecipeRepository repository;
	
	private List<Recipe> recipeList;
	
	private Recipe testRecipe;
	
	private Recipe testRecipeWithID;
	
	
	
	final long id = 1L;
	
	@Before 
	public void init() {
		this.recipeList = new ArrayList<>();
		this.recipeList.add(testRecipe);
		this.testRecipe = new Recipe("Cake", "1.Mix ingredients 2.Bake at 180 degrees for 30 minutes 3. Leave to cool", "00:20", "00:40", "£0.70");
		this.testRecipeWithID = new Recipe(testRecipe.getRecipeTitle(),testRecipe.getRecipeMethod(),testRecipe.getCookTime(),testRecipe.getPrepTime(),testRecipe.getPricePerUnit());
	    this.testRecipeWithID.setRecipeId(id);
	    

	}
	
	

	@Test (expected = IllegalStateException.class)
	public void createRecipeTitleTooLongTest() {
		testRecipe.setRecipeTitle("a b c d e f g h i");
		testRecipeWithID.setRecipeTitle("a b c d e f g h i");
		this.service.createRecipe(testRecipe);
		
		
		verify(this.repository, times(0)).save (this.testRecipe); 
	}

	
	@Test 
	public void createRecipeTitleTest() {
		testRecipe.setRecipeTitle("Sponge Cake");
		testRecipeWithID.setRecipeTitle("Sponge Cake");
		when (this.repository.save(this.testRecipe)).thenReturn(this.testRecipeWithID);
		
		assertEquals(this.testRecipeWithID,this.service.createRecipe(testRecipe));
		
		verify(this.repository, times(1)).save (this.testRecipe); 
	}
	
	@Test (expected = IllegalStateException.class)
	public void createRecipeMethodOverWordLimitTest() {
		testRecipe.setRecipeMethod("For the vanilla ice cream, pour the cream and milk into a heavy-based saucepan. Split the vanilla pod lengthways and scrape out the seeds; then add the seeds and pod to the pan. Heat the mixture until just below boiling point. Remove the pan from the heat and set aside to cool for one hour to allow the vanilla flavour to infuse into the mixture. Remove the vanilla pod and discard. Whisk the egg yolks and sugar in a bowl until pale and thickened. Slowly whisk in about one-quarter of the cream mixture. Reheat the remaining cream mixture until just boiling, then slowly whisk it into the egg mixture.Pour the egg mixture into a clean saucepan and cook over a gentle heat, stirring continuously until the custard thickens enough to coat the back of a spoon – it must not boil. Pour the custard into a bowl and set aside to cool, then cover and chill in the fridge overnight.Pour the cooled custard into an ice cream machine and churn according to the manufacturer's instructions, until thick and smooth. Spoon into a freezer container and freeze until needed.For the meringue, whisk the egg whites in a clean, large bowl until stiff peaks form when the whisk is removed. Slowly whisk in the sugar, whisking well between each addition. Continue to whisk until glossy and very stiff peaks form when the whisk is removed.To assemble the Alaska, spread the jam over the circle of sponge cake, then arrange scoops of ice cream in a pyramid shape on top, leaving a 1.5cm/½in border. Spoon the meringue all over the ice cream, ensuring there are no gaps, and use the back of a spoon to make a swirl pattern.The baked Alaska can now be frozen until needed.To cook the baked Alaska, preheat the oven to 200C/400F/Gas 6 and bake for 8-10 minutes, or until golden-brown all over.For the vanilla ice cream, pour the cream and milk into a heavy-based saucepan. Split the vanilla pod lengthways and scrape out the seeds; then add the seeds and pod to the pan. Heat the mixture until just below boiling point.Remove the pan from the heat and set aside to cool for one hour to allow the vanilla flavour to infuse into the mixture. Remove the vanilla pod and discard.Whisk the egg yolks and sugar in a bowl until pale and thickened. Slowly whisk in about one-quarter of the cream mixture. Reheat the remaining cream mixture until just boiling, then slowly whisk it into the egg mixture.Pour the egg mixture into a clean saucepan and cook over a gentle heat, stirring continuously until the custard thickens enough to coat the back of a spoon – it must not boil. Pour the custard into a bowl and set aside to cool, then cover and chill in the fridge overnight");
		testRecipeWithID.setRecipeMethod("For the vanilla ice cream, pour the cream and milk into a heavy-based saucepan. Split the vanilla pod lengthways and scrape out the seeds; then add the seeds and pod to the pan. Heat the mixture until just below boiling point. Remove the pan from the heat and set aside to cool for one hour to allow the vanilla flavour to infuse into the mixture. Remove the vanilla pod and discard. Whisk the egg yolks and sugar in a bowl until pale and thickened. Slowly whisk in about one-quarter of the cream mixture. Reheat the remaining cream mixture until just boiling, then slowly whisk it into the egg mixture.Pour the egg mixture into a clean saucepan and cook over a gentle heat, stirring continuously until the custard thickens enough to coat the back of a spoon – it must not boil. Pour the custard into a bowl and set aside to cool, then cover and chill in the fridge overnight.Pour the cooled custard into an ice cream machine and churn according to the manufacturer's instructions, until thick and smooth. Spoon into a freezer container and freeze until needed.For the meringue, whisk the egg whites in a clean, large bowl until stiff peaks form when the whisk is removed. Slowly whisk in the sugar, whisking well between each addition. Continue to whisk until glossy and very stiff peaks form when the whisk is removed.To assemble the Alaska, spread the jam over the circle of sponge cake, then arrange scoops of ice cream in a pyramid shape on top, leaving a 1.5cm/½in border. Spoon the meringue all over the ice cream, ensuring there are no gaps, and use the back of a spoon to make a swirl pattern.The baked Alaska can now be frozen until needed.To cook the baked Alaska, preheat the oven to 200C/400F/Gas 6 and bake for 8-10 minutes, or until golden-brown all over.For the vanilla ice cream, pour the cream and milk into a heavy-based saucepan. Split the vanilla pod lengthways and scrape out the seeds; then add the seeds and pod to the pan. Heat the mixture until just below boiling point.Remove the pan from the heat and set aside to cool for one hour to allow the vanilla flavour to infuse into the mixture. Remove the vanilla pod and discard.Whisk the egg yolks and sugar in a bowl until pale and thickened. Slowly whisk in about one-quarter of the cream mixture. Reheat the remaining cream mixture until just boiling, then slowly whisk it into the egg mixture.Pour the egg mixture into a clean saucepan and cook over a gentle heat, stirring continuously until the custard thickens enough to coat the back of a spoon – it must not boil. Pour the custard into a bowl and set aside to cool, then cover and chill in the fridge overnight\");\r\n");
		this.service.createRecipe(testRecipe);
		
		
		verify(this.repository, times(0)).save (this.testRecipe); 
	}
	
	@Test(expected = IllegalStateException.class)
	public void createRecipeMethodUnderWordLimitTest() {
		testRecipe.setRecipeMethod("For the vanilla ice cream");
		testRecipeWithID.setRecipeMethod("For the vanilla ice cream");
		
		this.service.createRecipe(testRecipe);
		
		verify(this.repository, times(0)).save(this.testRecipe); 
	}
	
	@Test
	public void createRecipeMethodTest() {
		testRecipe.setRecipeTitle("Sponge");
		testRecipeWithID.setRecipeTitle("Sponge");
		testRecipe.setRecipeMethod("For the vanilla ice cream, pour the cream and milk into a heavy-based saucepan.");
		testRecipeWithID.setRecipeMethod("For the vanilla ice cream, pour the cream and milk into a heavy-based saucepan.");
		when (this.repository.save(this.testRecipe)).thenReturn(this.testRecipeWithID);
		
		assertEquals(this.testRecipeWithID,this.service.createRecipe(testRecipe));
		
		verify(this.repository, times(1)).save (this.testRecipe); 
	}
	
	@Test
	public void createRecipeCookTimeTest() {
		testRecipe.setRecipeTitle("Sponge");
		testRecipeWithID.setRecipeTitle("Sponge");
		testRecipe.setRecipeMethod("For the vanilla ice cream, pour the cream and milk into a heavy-based saucepan.");
		testRecipeWithID.setRecipeMethod("For the vanilla ice cream, pour the cream and milk into a heavy-based saucepan.");
		testRecipe.setCookTime("01:30");
		testRecipeWithID.setCookTime("01:30");
		when (this.repository.save(this.testRecipe)).thenReturn(this.testRecipeWithID);
		
		assertEquals(this.testRecipeWithID,this.service.createRecipe(testRecipe));
		
		verify(this.repository, times(1)).save (this.testRecipe); 
	}
	
	@Test (expected = IllegalStateException.class)
	public void createRecipeCookTimeLettersAndSymbolsTest() {
		testRecipe.setCookTime("akddj%$");
		testRecipeWithID.setCookTime("akddj%$");
		this.service.createRecipe(testRecipe);
		
		verify(this.repository, times(0)).save (this.testRecipe); 
	}
	
	
	@Test
	public void createRecipePrepTimeTest() {
		testRecipe.setRecipeTitle("Sponge");
		testRecipeWithID.setRecipeTitle("Sponge");
		testRecipe.setRecipeMethod("For the vanilla ice cream, pour the cream and milk into a heavy-based saucepan.");
		testRecipeWithID.setRecipeMethod("For the vanilla ice cream, pour the cream and milk into a heavy-based saucepan.");
		testRecipe.setCookTime("01:30");
		testRecipeWithID.setCookTime("01:30");
		testRecipe.setPrepTime("01:30");
		testRecipeWithID.setPrepTime("01:30");
		when (this.repository.save(this.testRecipe)).thenReturn(this.testRecipeWithID);
		
		assertEquals(this.testRecipeWithID,this.service.createRecipe(testRecipe));
		
		verify(this.repository, times(1)).save (this.testRecipe); 
	}
	
	
	@Test(expected = IllegalStateException.class)
	public void createRecipePrepTimeLettersAndSymbolsTest() {
		testRecipe.setPrepTime("akddj%$");
		testRecipeWithID.setPrepTime("akddj%$");
		this.service.createRecipe(testRecipe);
		
		verify(this.repository, times(0)).save (this.testRecipe); 
	}

	@Test
	public void createRecipePricePerUnitTest() {
		testRecipe.setRecipeTitle("Sponge");
		testRecipeWithID.setRecipeTitle("Sponge");
		testRecipe.setRecipeMethod("For the vanilla ice cream, pour the cream and milk into a heavy-based saucepan.");
		testRecipeWithID.setRecipeMethod("For the vanilla ice cream, pour the cream and milk into a heavy-based saucepan.");
		testRecipe.setCookTime("01:30");
		testRecipeWithID.setCookTime("01:30");
		testRecipe.setPrepTime("01:30");
		testRecipeWithID.setPrepTime("01:30");
		testRecipe.setPricePerUnit("£0.01");
		testRecipeWithID.setPricePerUnit("£0.01");
		when (this.repository.save(this.testRecipe)).thenReturn(this.testRecipeWithID);
		
		assertEquals(this.testRecipeWithID,this.service.createRecipe(testRecipe));
		
		verify(this.repository, times(1)).save (this.testRecipe); 
		
	}
		
		@Test (expected = IllegalStateException.class)
		public void createRecipePricePerUnitSymbolsandLettersTest() {
			testRecipe.setPricePerUnit("akddj%$");
			testRecipeWithID.setPricePerUnit("akddj%$");
			this.service.createRecipe(testRecipe);
			
			verify(this.repository, times(0)).save (this.testRecipe); 
	}
		
		

		
	@Test
	public void deleteRecipeTest() {
		when(this.repository.existsById(id)).thenReturn(true,false);
		
		this.service.deleteRecipe(id);
		verify(this.repository,times(1)).deleteById(id);
		verify(this.repository,times(2)).existsById(id);
		
		
	}
	
	@Test
	public void findRecipeByIdTest() {
		when(this.repository.findById(id)).thenReturn(Optional.of(this.testRecipeWithID));
		
		assertEquals(this.testRecipeWithID, this.service.findRecipeById(this.id));
		
		verify(this.repository,times(1)).findById(this.id);
			
			
	}
	
	@Test
	
	public void readRecipeTest( ) {
		when(repository.findAll()).thenReturn(this.recipeList);
		
		assertFalse("No Recipes found by Controller", this.service.findAllRecipe().isEmpty());
		
		verify(repository,times(1)).findAll();
		
	}
	
	@Test
	
	public void updateRecipeTest() {
		
		Recipe newRecipe = new Recipe ("Chocolate Cake", "For the vanilla ice cream, pour the cream and milk into a heavy-based saucepan", "01.00", "02.00", "00.30");
		Recipe updatedRecipe = new Recipe(newRecipe.getRecipeTitle(), newRecipe.getRecipeMethod(), newRecipe.getPrepTime(), newRecipe.getCookTime(), newRecipe.getPricePerUnit());
		updatedRecipe.setRecipeId(this.id);
		
		when(this.repository.findById(this.id)).thenReturn(Optional.of(this.testRecipeWithID));
		
		when(this.repository.save(updatedRecipe)).thenReturn(updatedRecipe);
		
		assertEquals(updatedRecipe, this.service.updateRecipe(newRecipe, this.id));
		
		verify(this.repository, times(1)).findById(1L);
		verify(this.repository,times(1)).save(updatedRecipe);
		
	}

	
	

}
