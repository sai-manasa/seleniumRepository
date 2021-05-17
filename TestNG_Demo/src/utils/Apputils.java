package utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Apputils 
{

	
	@Parameters({"appurl"})
	@BeforeTest
	public void launchApp(String url)
	{
		System.out.println("Launch application: "+url);
	}
	
	
	
	
	
	
	
	
	
}
