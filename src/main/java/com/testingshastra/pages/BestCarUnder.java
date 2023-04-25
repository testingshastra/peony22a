package com.testingshastra.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testingshastra.keywords.UIKeyword;

public class BestCarUnder {

	private static final Logger LOG = LogManager.getLogger(BestCarUnder.class);
	@CacheLookup //Marker Annotation
	@FindBy(css = "span.o-Hyyko.o-cyHybq.o-eZTujG.o-eqqVmt")
	public List<WebElement> priceElements;
	
	public BestCarUnder(){
		PageFactory.initElements(UIKeyword.driver,this);
	}
	public List<Float> getPrices() {
		List<String> prices = UIKeyword.getTexts(priceElements);
		List<Float> pricesFloat = new ArrayList<>();
		for (String price : prices) {
			float priceInFloat = UIKeyword.getFloatFromString(price);
			pricesFloat.add(priceInFloat);
		}
		LOG.info("Got all prices: "+pricesFloat);
		return pricesFloat;
	}
	
	public void assertThatPricesAreUnder(float price) {
		for (float priceInFloat: getPrices()) {
			Assert.assertTrue(priceInFloat<=price,"Price is not under "+price+" lakh: "+priceInFloat);
		}
	}
}
