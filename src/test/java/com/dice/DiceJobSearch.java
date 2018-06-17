package com.dice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
	public static void main(String [] args) {
		//Set up chrome driver path
		WebDriverManager.chromedriver().setup();
		// invoke selenium webdriver
		WebDriver driver = new ChromeDriver();
		//fullscreen
		driver.manage().window().fullscreen();
		
		//set universal wait time in case web page is slow
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Step 1. launch browser and navigate to https://dice.com
		//Expected: dice home page should be displayed
		// we are navigating like this: 
		
		String url = "https://dice.com";
		driver.get(url);
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Job Search for Technology Professionals | Dice.com";
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Step PASS: Dice homepage successfully loaded");
		}else {
			System.out.println("Step fail. Dice homepage did not load successfully");
			throw new RuntimeException("Step fail. Dice homepage did not load successfully");// if the homepage is not loaded so there is 
			// not point to continue te test. it will throw exception
			
		}
		String keyword = "java developer";
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
		//       where do you wanna do some action -- // what do you wanna do ( sendKeys== type something)
		// in selenium actions there is always two parts like above
		
		
		String location = "22102";
		// which locator you use here?
		
		driver.findElement(By.id("search-field-location")).clear();// it is clearing if there typed something before
		
		
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		
		
		driver.findElement(By.id("findTechJobs")).click();
		
		String count = driver.findElement(By.id("posiCountId")).getText();// we read value between tex by getText();
		System.out.println(count);
		// ensure count is more than 0 // we use replace method in order to get rid of comma bewteen number of job 
		int countResult = Integer.parseInt(count.replace(",", ""));
		if(countResult >0) {
			System.out.println("Step PASS keyword: " + keyword + " search returned " + countResult + "results in " + location);
			
		}else {
			System.out.println("Step FAIL keyword: " + keyword + " search returned " + countResult + "results in " + location);
		}

		driver.close();
		
		System.out.println("Test Completed -" + LocalDateTime.now());
		
		
		
		
		
	}

}
