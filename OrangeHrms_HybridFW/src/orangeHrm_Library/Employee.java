package orangeHrm_Library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



import Utils.ApplicationUtils;

public class Employee extends ApplicationUtils{
	
	public boolean addEmployee(String fname,String lname) throws InterruptedException 
	{
		
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		
		driver.findElement(By.id("firstName")).sendKeys(fname);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		
		String	 empid=driver.findElement(By.id("employeeId")).getAttribute("value");
		
		
		driver.findElement(By.id("btnSave")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Employee List")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(empid);
		Thread.sleep(3000);
		System.out.println("before search");
		driver.findElement(By.id("searchBtn")).click();
		
		Thread.sleep(3000);
		
		System.out.println("clicked search brn");
		
		WebElement resultstable=driver.findElement(By.id("resultTable"));
		List<WebElement> rows=resultstable.findElements(By.tagName("tr"));
		List<WebElement> cols=rows.get(1).findElements(By.tagName("td"));
		String tableempid=cols.get(1).getText();
		
		if(tableempid.equals(empid))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
