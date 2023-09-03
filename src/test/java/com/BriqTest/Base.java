package com.BriqTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
	
	static WebDriver driver;
	
	@BeforeClass
	public static void setup() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\habib\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		
		Thread.sleep(2000);
		
		//driver.get("http://the-internet.herokuapp.com/challenging_dom");
		
		driver.manage().window().maximize();
		
	}
	
	
	
	
	
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	

}
