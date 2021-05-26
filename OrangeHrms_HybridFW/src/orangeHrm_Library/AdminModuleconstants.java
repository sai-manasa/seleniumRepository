package orangeHrm_Library;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Utils.AppUtils;

public class AdminModuleconstants extends AppUtils {

	@BeforeTest
	@Parameters({"auname","apword"})
	public void adminLogin(String uname,String pwd)
	{
		System.out.println("before test");
		   driver.findElement(By.name("txtUsername")).sendKeys(uname);
		   driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		  driver.findElement((By.name("Submit"))).click();
	}
	
	@AfterTest
	public void adminLogout() throws InterruptedException
	{
		System.out.println("after test");
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();;
	}
}
