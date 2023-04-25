package com.testingshastra.base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.testingshastra.keywords.UIKeyword;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public final class TestBase {
	private static final Logger LOG = LogManager.getLogger(TestBase.class);
	@Before
	public void setUpMethod() throws Exception {
		UIKeyword.openBrowser("Chrome");
		Config conf = new Config();
		String env = System.getProperty("env");
		if(env == null) {
			LOG.error("env variable must be set using java vm arguments");
		}
		LOG.info("Launching "+env+" url");
		UIKeyword.launchUrl(conf.getAppUrl(env));
	}
	
	@After
	public void tearDownMethod() throws Exception {
		UIKeyword.driver.close();
		LOG.info("Browser is closed");
	}
}
