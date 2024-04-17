package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search {
	
	WebDriver driver;
	private HomePage homePage;
	private SearchResultsPage searchResultsPage;
	
	@Given("User opens the Application")
	public void user_opens_the_application() {
		
		driver = DriverFactory.getDriver();
	    
	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validProductText) {
		
		homePage = new HomePage(driver);
		homePage.enterProductInSearchBox(validProductText);
		
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		
		homePage.clickOnSearchButton();
	    
	}

	@Then("User should get valid product dispalyed in search results")
	public void user_should_get_valid_product_duspalyed_in_search_results() {
		
		searchResultsPage = new SearchResultsPage(driver);
		Assert.assertTrue(searchResultsPage.displayStatusOfValidProduct());
		
		//Assert.fail();
		//int a = 10/0;
	    
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductText) {
		
		homePage = new HomePage(driver);
		homePage.enterProductInSearchBox(invalidProductText);
	    
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching1() {
		
		searchResultsPage = new SearchResultsPage(driver);
		Assert.assertEquals("There is no product that matches the search criteria.", searchResultsPage.getMessageText());
	    
	}

	@When("User dont enter any product name into Search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		
		//Intentionally kept blank
		homePage = new HomePage(driver);
	    
	}

}
