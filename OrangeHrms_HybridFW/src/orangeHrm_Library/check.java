package orangeHrm_Library;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class check {

	@Test
	public void checking() throws InterruptedException
	{
		boolean res;
		String role="ESS";
		String empName="manikanth Demo";
		String userName="nasa123";
		String upword="Qedge123!@#";
	
		
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://orangehrm.qedgetech.com");
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		   driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
		  driver.findElement((By.name("Submit"))).click();
		
		
		
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("User Management")).click();
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.id("btnAdd")).click();
		
		System.out.println(role+" "+empName+" "+userName+" "+upword);
		//*[@id="systemUser_userType"]
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
		
		Thread.sleep(5000);
		
		//*[@id="btnSave"]
		//*[@id="btnSave"]
		System.out.println(driver.findElement(By.id("btnSave")).isEnabled());
		driver.findElement(By.id("btnSave")).click();
		
		
		Thread.sleep(4000);
		
		
		
		
		
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
		}
		else
		{
			res=false;
		}
		Assert.assertTrue(res);
		
		
		driver.findElement(By.partialLinkText("Welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();;
	}
}
