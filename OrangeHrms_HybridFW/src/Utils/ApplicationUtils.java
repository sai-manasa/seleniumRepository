package Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class ApplicationUtils {
	
public static WebDriver driver;

	public static String url="http://orangehrm.qedgetech.com";
	
	@BeforeTest
	public static void launchApp()
	{
		System.out.println("before suite");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@AfterTest
	public static void closeApp()
	{
		System.out.println("after suite");
		driver.close();
	}
	


}
