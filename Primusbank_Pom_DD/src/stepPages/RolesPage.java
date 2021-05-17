package stepPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RolesPage {

	//btnRoles
	@FindBy(id="btnRoles")
	WebElement newRole;
	
	public void clickRole() throws InterruptedException
	{
		newRole.click();
		Thread.sleep(4000);
	}
	
}
