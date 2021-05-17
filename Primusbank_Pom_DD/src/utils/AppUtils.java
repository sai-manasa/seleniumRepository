package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtils {
	
	public static WebDriver driver;
	public static String url="http://primusbank.qedgetech.com/";
	
		@BeforeTest
		public  static  void launchApp()
		{
			//System.out.println("before tesst");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(url);
		}
		
		@AfterTest
		public static void closeApp()
		{
			//System.out.println("after test");
			driver.close();
			
		}
}
