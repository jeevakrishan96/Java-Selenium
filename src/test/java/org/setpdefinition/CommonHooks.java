//package org.setpdefinition;
//
//
//
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//
//import org.Base.BaseClase;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//
//public class CommonHooks  extends BaseClase {
//    Scenario scenario;
//
//    // Setup method - runs before each scenario
//    @Before
//    public void setUp() {
//
//    }
//
////     Cleanup method - runs after each scenario
//    @After
//    public void tearDown(Scenario scenario) {
//        if (scenario.isFailed()){
//            screenShot(scenario.getName());
//        }
//
//
//    }
//    @AfterStep
//   public void afterStep(Scenario scenario){
//        if (scenario.isFailed()){
//            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenshot, "image/png", scenario.getName());
//
//        }
//
//
//   }
//}
