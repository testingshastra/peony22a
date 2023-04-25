package com.peony22a;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", 
glue = "com.testingshastra.stepdefinition",
dryRun = false)
public class TestRunner extends AbstractTestNGCucumberTests{

	
}
