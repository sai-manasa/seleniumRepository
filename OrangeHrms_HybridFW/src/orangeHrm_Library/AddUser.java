package orangeHrm_Library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utils.AppUtils;
import Utils.ApplicationUtils;

public class AddUser extends ApplicationUtils{

	
	public boolean addingUser(String role,String empName,String userName,String upword) throws InterruptedException
	{
		boolean res=false;;
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("User Management")).click();
		driver.findElement(By.linkText("Users")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnAdd")).click();
		
		System.out.println(role+" "+empName+" "+userName+" "+upword);
		//*[@id="systemUser_userType"]
		Thread.sleep(3000);
		WebElement userrole=driver.findElement(By.id("systemUser_userType"));
		Select sobj=new Select(userrole);
		sobj.selectByVisibleText(role);;
		
		//*[@id="systemUser_employeeName_empName"]
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(empName);
		
		//*[@id="systemUser_userName"]
		
		driver.findElement(By.id("systemUser_userName")).sendKeys(userName);
		
		//*[@id="systemUser_password"]
		driver.findElement(By.id("systemUser_password")).sendKeys(upword);
		
		//*[@id="systemUser_confirmPassword"]
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(upword);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,900)");
		
		Thread.sleep(8000);
		
		//*[@id="btnSave"]
		//*[@id="btnSave"]
		System.out.println(driver.findElement(By.id("btnSave")).isEnabled());
		driver.findElement(By.id("btnSave")).click();
		
		
		Thread.sleep(3000);
		
		
		//*[@id="searchSystemUser_userName"]
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(userName);
		
		//*[@id="searchBtn"]
		driver.findElement(By.id("searchBtn")).click();
		
		//*[@id="resultTable"]
		WebElement table=driver.findElement(By.id("resultTable"));
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		
		List<WebElement> cols=rows.get(1).findElements(By.tagName("td"));
		String tvalue=cols.get(1).getText();
		
		//System.out.println("table value"+tvalue);
		//System.out.println("uname "+userName);
		if(userName.equals(tvalue))
		{
			res=true;
			//return res;
		}
		else
		{
			res=false;
			//return res;
		}
		Assert.assertTrue(res);
		return res;
	}
}
