package com.Runner;

import org.BaseClass.BaseClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\rajasekar.p\\eclipse-workspace\\TryviumProduct\\src\\test\\java\\com\\Feature\\Tryvium.feature", glue = {
		"com.StepDefinition", "com.Hooks" }, tags = "not @Skip",

		plugin = { "pretty", "html:target/cucumber.html", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class TestRunner {

	public static WebDriver driver;

	@BeforeClass
	public static void setUP() {
		driver = BaseClass.browser("chrome");

	}
}
