package com.BriqTest;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import com.opencsv.CSVWriter;

 public class test extends Base {
	
	
              
		List<String[]> strings;
	@Test
	public void testmethod() throws InterruptedException
	{
		
		driver.get("http://the-internet.herokuapp.com/challenging_dom");
		Thread.sleep(5000);
		List<WebElement> headerdata=driver.findElements(By.xpath("//table/thead/tr/th"));
		
		List<String> strings = new ArrayList<String>();
		for(WebElement e : headerdata){
		    strings.add(e.getText());

}System.out.println(strings);
	}
	
	
	public void writedata() throws IOException, InterruptedException
	{
	String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	String filename="WebTable_"+timestamp+".csv";
	
	
	CSVWriter writer=new CSVWriter(new FileWriter(".//CSV file"+filename));
	
Thread.sleep(5000);
	writer.writeAll(strings);
	writer.flush();
	
	
	System.out.println("data enterd");
 }
 }
 
