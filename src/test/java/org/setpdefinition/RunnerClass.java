package org.setpdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/RetailerPages/RetailerProfile.feature", glue = "")
public class RunnerClass {

}
