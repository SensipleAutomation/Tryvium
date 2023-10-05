package com.Hooks;

import org.BaseClass.BaseClass;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {

	@After
	public void tearDown(Scenario scenario) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		takeScreenshotAndAttach(scenario, takesScreenshot);

	}
}
