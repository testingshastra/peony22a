package com.testingshastra.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.testingshastra.utilities.PropUtils;

public class Config {
	private static final Logger LOG = LogManager.getLogger(Config.class);
	public String getAppUrl(String env) { //env = dev
		PropUtils prop = new PropUtils();
		String baseDir = System.getProperty("user.dir");
		if(env==null) {
			LOG.info("Launching default env url: QA");
			env="qa";
		}
		return prop.getProperty(baseDir+"/src/main/resources/application.properties", env+".url");
	}
}
