package com.testingshastra.pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.testingshastra.keywords.UIKeyword;

public class HomePage {
	
	private static final Logger LOG = LogManager.getLogger(HomePage.class);

	@FindBy(css = "a[title='under 5 lakh']")
	public WebElement under5LakhBtn;
	
	public HomePage() {
		PageFactory.initElements(UIKeyword.driver, this);
	}
	public void waitForUnder5LakhBtn() {
		UIKeyword.waitForElementToBePresent(under5LakhBtn,"Under 5 Lakh");
	}
	public void clickOnUnder5LakhBtn() {
		UIKeyword.scrollWindow(0, 300);
		waitForUnder5LakhBtn();
		under5LakhBtn.click();
		LOG.info("Clicked on 'Under 5 Lakh' button");
	}
}
