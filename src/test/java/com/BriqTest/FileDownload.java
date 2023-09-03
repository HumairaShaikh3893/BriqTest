package com.BriqTest;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;
import org.testng.annotations.Test;



public class FileDownload  extends Base{
	
	
	@Test
	public static void download() throws InterruptedException
	{
		
		ChromeOptions options = new ChromeOptions();
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		//String downloadFilepath = System.getProperty("user.dir");
		String downloadFilepath = "C:\\Users\\habib\\eclipse-workspace\\BriqTest\\DownloadedFile";
		chromePrefs.put("download.default_directory", downloadFilepath);
		options.setExperimentalOption("prefs", chromePrefs);
		
		driver = new ChromeDriver(options);
		
		driver.get("https://the-internet.herokuapp.com/download");
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String title=driver.findElement(By.xpath("//h3[contains(text(),'File Downloader')]")).getText();
		System.out.println(title);
		
		String ExpTitle="File Downloader";
		
		Assert.assertEquals(title, ExpTitle);
		
		
		WebElement image=driver.findElement(By.xpath("//a[contains(text(),'Image.PNG')]"));
		
		image.click();
		
		Thread.sleep(5000);
		
		System.out.println("File downloaded successfully..!");
		
		
	}
	
	

}
