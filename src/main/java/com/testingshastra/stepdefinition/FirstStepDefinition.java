package com.testingshastra.stepdefinition;

import java.net.MalformedURLException;

import org.testng.Assert;

import com.testingshastra.keywords.UIKeyword;
import com.testingshastra.pages.BestCarUnder;
import com.testingshastra.pages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstStepDefinition {
	
	@Given("क्रोम ब्राउज़र खुल गया है")
	public void m1() throws MalformedURLException {
		UIKeyword.openBrowser("Chrome");
	}
	
	@And("कार वाले का यूआरएल खोलो")
	public void openCarWaleUrl() {
		UIKeyword.launchUrl("https://www.carwale.com");
	}
	
	@When("जब यूजर अंडर ५ लाख पर क्लिक करेगा")
	public void clickOnUnder5Lakh() {
		HomePage home = new HomePage();
		home.clickOnUnder5LakhBtn();
	}
	
	@Then("तब सारी ५ लाख के  नीचेकी गाड़िया दिखानी चाहिए")
	public void verifyThatCarsListedHavePriceLessThan5Lakh() {
		BestCarUnder carsUnder = new BestCarUnder();
		carsUnder.assertThatPricesAreUnder(5.0f);
	}

	@Then("Verify the title of homepage")
	public void verifyTheTitleOfHomePage() {
		String title = UIKeyword.driver.getTitle();
		Assert.assertEquals(title, "New Cars, Used Cars, Buy a Car, Sell Your Car - CarWale");
	}
}
