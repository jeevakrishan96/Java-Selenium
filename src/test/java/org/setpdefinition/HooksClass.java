package org.setpdefinition;

import io.cucumber.java.AfterStep;

import io.cucumber.java.Scenario;
import org.Base.BaseClase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class HooksClass extends BaseClase{

	@Before
    public void setUp() {

    }

	@AfterStep
	public void takeScreenShotAfterStep(Scenario scenario)   {
		if (scenario.isFailed()) {
			final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/jpg", scenario.getName());
		}
	}
	@After
    public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			screenShot(scenario.getName());
		}
		driver.close();
	}



	}


