package stepPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage {
	
	@FindBy(xpath="//tbody/tr[2]/td/table/tbody/tr[4]/td/a")
	WebElement roles;
	////img[@scr='images/Roles_but.jpg']
	
	
	public void clickRole() throws InterruptedException
	{
		roles.click();
		Thread.sleep(3000);
	}
}
