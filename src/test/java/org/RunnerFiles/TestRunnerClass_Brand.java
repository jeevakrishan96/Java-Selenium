package org.RunnerFiles;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/java/org/featurefies/brandPages", glue ={"org.setpdefinition","HooksClass"}, monochrome = true,dryRun = false,
        plugin ={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
,tags = "@ProductListing")


public class TestRunnerClass_Brand {


}


