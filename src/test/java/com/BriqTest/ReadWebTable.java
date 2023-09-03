package com.BriqTest;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import com.opencsv.CSVWriter;


public class ReadWebTable extends Base{
	
	
	
	WebElement headerdata;
	WebElement Tablecolumns;
	Iterable<String[]> strings; 
	List<Strings> strings1; 
	
	@Test(priority=1)
	public void readHeader()
	{
		List<WebElement> headerdata=driver.findElements(By.xpath("//table/thead/tr/th"));
		List<String> strings = new ArrayList<String>();
		for(WebElement e : headerdata){
		    strings.add(e.getText());
		}
		System.out.println(strings);
		
		/*for (int k=0;k<headerdata.size();k++)
		{
			System.out.print(headerdata.get(k).getText()+"  ");
			//String header=headerdata.get(k).getText();
			
		}
		
		//System.out.println(headerdata);*/
		
		
	}
	@Test(priority=2)
	public void readDataRows()
	{
		
		driver.get("http://the-internet.herokuapp.com/challenging_dom");
		List<WebElement> TableRows=driver.findElements(By.xpath("//table//tr"));
		
		String colFirst="//table//tr[";
		String colLast="]/td";
		String Column;
		
		List<WebElement> Tablecolumns = null;
		for(int i=1;i<TableRows.size();i++)  ////table//tr[3]/td
		{
			Column=colFirst+i+colLast;
			//System.out.println(Column);
			Tablecolumns=driver.findElements(By.xpath(Column));
			
			//System.out.println("For row: " +i+ "columns count are :"+Tablecolumns.size());
			
			for(int j=0;j<Tablecolumns.size();j++)
			{
				System.out.print(Tablecolumns.get(j).getText()+"  ");
				
			
			
			}
			System.out.println(Tablecolumns);
			}
			
			
		}
		
		
	
	@Test(priority=3)
	public void writedata() throws IOException
	{
	String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	String filename="WebTable_"+timestamp+".csv";
	
	
	CSVWriter writer=new CSVWriter(new FileWriter("/BriqTest/CSV file"+filename));
	
	//writer
	writer.writeAll((Iterable<String[]>) Tablecolumns);
	writer.writeAll(strings);
	
	
	}
	
	

}
