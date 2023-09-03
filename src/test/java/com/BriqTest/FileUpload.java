package com.BriqTest;




import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUpload extends Base{
	
	@Test(priority=2)

	
	public static void upload() throws InterruptedException, AWTException
	
	{
		driver.get("https://the-internet.herokuapp.com/upload");
		//driver.findElement(By.xpath("(//input[@type='file'])[1]")).sendKeys("C:\\Users\\habib\\eclipse-workspace\\BriqTest\\DownloadedFile\\Image.PNG");
	
		WebElement button=driver.findElement(By.xpath("//input[@name='file']"));
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//js.executeScript("arguments[0].click();", button);
		button.click();
		
		Thread.sleep(10000);
		
		Robot r=new Robot();
		
		r.delay(2000);
		
		StringSelection ss=new StringSelection("C:\\Users\\habib\\eclipse-workspace\\BriqTest\\DownloadedFile\\Image.PNG");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		r.keyRelease(KeyEvent.VK_V);
		
		r.keyPress(KeyEvent.VK_ENTER);
		
		r.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(4000);
		
		
		driver.findElement(By.xpath("//input[@id=file-submit]")).click();

		
		
		
		
	}

}
