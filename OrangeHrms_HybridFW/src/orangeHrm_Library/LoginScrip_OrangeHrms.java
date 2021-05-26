package orangeHrm_Library;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import Utils.AppUtils;
import Utils.ApplicationUtils;

public class LoginScrip_OrangeHrms extends ApplicationUtils {
	

public boolean loginAsAdmin(String uname,String pwd) 
{
		
  driver.findElement(By.name("txtUsername")).sendKeys(uname);
   driver.findElement(By.id("txtPassword")).sendKeys(pwd);
  driver.findElement((By.name("Submit"))).click();
   
    boolean res=driver.findElement(By.linkText("Admin")).isDisplayed();
    if(res)
    {
    	return true;
    }
    else
    {
    	return false;
    }
}

public boolean loginAsAdminWdInvalidData(String uname,String pwd)
{
	driver.findElement(By.name("txtUsername")).sendKeys(uname);
	driver.findElement(By.id("txtPassword")).sendKeys(pwd);
	driver.findElement((By.name("Submit"))).click();
	
	//*[@id="spanMessage"]
	String distext=driver.findElement(By.id("spanMessage")).getText();
	if(distext.toLowerCase().contains("invalid") || distext.toLowerCase().contains("empty"))
	{
		return true;
	}
	else
	{
		return false;
	}
	
	 
}
public boolean loggout() throws InterruptedException
{
	
	Thread.sleep(2000);
	driver.findElement(By.partialLinkText("Welcome")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Logout")).click();;
	if(driver.findElement(By.id("btnLogin")).isDisplayed())
	{
		return true;
	}
	else
	{
		return false;
	}

}

public boolean employeeLogin(String euname,String epword)
{
	  driver.findElement(By.name("txtUsername")).sendKeys(euname);
	   driver.findElement(By.id("txtPassword")).sendKeys(epword);
	  driver.findElement((By.name("Submit"))).click();
	  
	  try {
		driver.findElement(By.linkText("Admin"));
		return false;
	} catch (Exception e) {
		// TODO: handle exception
		return true;
	}
	
	
}
}












