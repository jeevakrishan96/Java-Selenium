package org.pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sample {
	
 public static void main(String[] args) {
	
	 WebDriverManager.edgedriver().setup();
	 
	 WebDriver driver = new EdgeDriver();
	
	 driver.get("https://lh.inmakesedu.com/home/lesson/software-testing-master/39/2496");

		
}
 
		
	}
		


