package com.testingshastra.keywords;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public class UIKeyword {
	// Instance
	private static final Logger LOG = LogManager.getLogger(UIKeyword.class);
	public static RemoteWebDriver driver;
	public static FluentWait<WebDriver> wait;

	public static void openBrowser(String browserName) throws MalformedURLException {
		boolean grid = Boolean.parseBoolean(System.getProperty("grid"));
		if (grid) {
			LOG.info("Executing tests on grid");
			System.setProperty("webdriver.chrome.driver", "/Volumes/extra/JARS/chromedriver_112/chromedriver");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			driver = new RemoteWebDriver(new URL("http://192.168.0.175:4444"),chromeOptions);
		
		} else {

			if (browserName.equalsIgnoreCase("Chrome")) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(option);
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("Safari")) {
				driver = new SafariDriver();
			}

			wait = new FluentWait<WebDriver>(driver);
			wait.withTimeout(Duration.ofSeconds(60));
			wait.pollingEvery(Duration.ofMillis(500));
			wait.ignoring(NoSuchElementException.class);
		}
	}

	public static void waitForElementToBePresent(By by) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static void clickOn(By by) {
		driver.findElement(by).click();
	}

	public static void clickOn(String locator) {
		// a[title='under 5 lakh']
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];

		if (locatorType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("class")) {
			driver.findElement(By.className(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			driver.findElement(By.linkText(locatorValue)).click();
		}

	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	/**
	 * This method will return List of texts
	 * 
	 * @param by
	 * @return
	 */
	public static List<String> getTexts(By by) {
		List<WebElement> elements = driver.findElements(by);
		List<String> texts = new ArrayList<>();
		for (WebElement element : elements) {
			String text = element.getText();
			texts.add(text);
		}

		return texts;
	}

	public static int getNumberFromString(String string) {
		String regex = "([0-9]+[.][0-9]+)";
		String input = string;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		int num = 0;
		while (matcher.find()) {
			num = Integer.parseInt(matcher.group());
		}

		return num;
	}

	public static float getFloatFromString(String string) {
		String regex = "([0-9]+[.][0-9]+)";
		String input = string;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		float num = 0;
		while (matcher.find()) {
			num = Float.parseFloat(matcher.group());
		}

		return num;
	}

	public static void scrollWindow(int x, int y) {
		driver.executeScript("window.scrollBy(arguments[0],arguments[1])", x, y);
	}

	public static void waitForElementToBePresent(String locator) {
		String parts[] = locator.split("##");
		String locatorType = parts[0];
		String locatorValue = parts[1];
		By by = null;
		if (locatorType.equalsIgnoreCase("css")) {
			by = By.cssSelector(locatorValue);
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			by = By.xpath(locatorValue);
		}

		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static void waitForElementToBePresent(WebElement element, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public static List<String> getTexts(List<WebElement> priceElements) {
		List<WebElement> elements = priceElements;
		List<String> texts = new ArrayList<>();
		for (WebElement element : elements) {
			String text = element.getText();
			texts.add(text);
		}

		return texts;
	}

}
