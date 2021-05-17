package stepPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(id="txtuId")
	WebElement uname;
	
	@FindBy(id="txtPword")
	WebElement pwd;
	
	@FindBy(id="login")
	WebElement login;
	
	public boolean adminLogin(String auname,String apwd,WebDriver driver) throws InterruptedException
	{
		uname.sendKeys(auname);
		pwd.sendKeys(apwd);
		login.click();
		
		Thread.sleep(4000);
		String acturl=driver.getCurrentUrl();
		String expurl="adminflow";
		
		if(acturl.toLowerCase().contains(expurl))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
}
