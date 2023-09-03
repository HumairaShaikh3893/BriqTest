package com.BriqTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

public class FetchUELData extends Base{
	
	@Test
	public void fetchData() throws IOException
	{
		
		URL u=new URL("https://data.sfgov.org/resource/p4e4-a5a7.json");
		HttpURLConnection hr=(HttpURLConnection)u.openConnection();
		System.out.println(hr.getResponseCode());
		
		if(hr.getResponseCode()==200)
		{
			InputStream im=hr.getInputStream();
			StringBuffer sb=new StringBuffer();
			BufferedReader br=new BufferedReader(new InputStreamReader(im));
			String line=br.readLine();
			
			while(line!=null)
			{
				System.out.println(line);
				line=br.readLine();
						
			}
			
		}
	}

}
