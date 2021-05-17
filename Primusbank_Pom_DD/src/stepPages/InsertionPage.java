package stepPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InsertionPage {

	//txtRname
	@FindBy(id="txtRname")
	WebElement rname;
	
	@FindBy(id="lstRtypeN")
	WebElement rtype;
	
	//btninsert
	@FindBy(id="btninsert")
	WebElement submitBtn;
	
	public void insertData(String rolename,String roletype) throws InterruptedException
	{
		rname.sendKeys(rolename);
		Thread.sleep(4000);
		Select sobj=new Select(rtype);
		sobj.selectByVisibleText(roletype);
		Thread.sleep(4000);
		submitBtn.click();
		

		
		
	}
	
}
