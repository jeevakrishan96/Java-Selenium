package org.RunnerFiles;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/org/featurefies/RetailerPages",glue ={"org.retailerPageStep", "CommonHooks"},
        monochrome = true, dryRun = false,
plugin = {"pretty","html:RetailerReport/Cucumber-html-report/report.html","junit:RetailerReport/Cucumber-junit/junitreport.xml","json:RetailerReport/Cucumber-Jason-report/jsonreport.json"}
,tags = "@Brands")

public class
TestRunnerClass {

}

		
		