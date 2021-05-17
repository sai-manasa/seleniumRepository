package testRunners;


import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import stepPages.AdminPage;
import stepPages.InsertionPage;
import stepPages.LoginPage;
import stepPages.RolesPage;
import utils.AppUtils;
import utils.XLUtils;

public class PrimusBankTest extends AppUtils  {

	@Test
	public void primusbanklogin() throws InterruptedException, IOException
	{
		
		int rowcount=XLUtils.getRowCount("C:\\Users\\surya\\workspace\\Primusbank_Pom_DD\\excelfiles\\primusbankdata.xlsx", "insertdata");
		System.out.println("rows "+rowcount);
		boolean res;
		for(int i=1;i<=rowcount;i++)
		{
			
		
		String aduname=XLUtils.getStringCellData("C:\\Users\\surya\\workspace\\Primusbank_Pom_DD\\excelfiles\\primusbankdata.xlsx", "login",1 , 0);
		String apwd=XLUtils.getStringCellData("C:\\Users\\surya\\workspace\\Primusbank_Pom_DD\\excelfiles\\primusbankdata.xlsx", "login",1 , 1);
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.adminLogin(aduname, apwd,driver);
	
		AdminPage ap=PageFactory.initElements(driver, AdminPage.class);
		ap.clickRole();
	//Assert.assertTrue(res);
	
		RolesPage rp=PageFactory.initElements(driver, RolesPage.class);
		rp.clickRole();
	
	
	String rolename=XLUtils.getStringCellData("C:\\Users\\surya\\workspace\\Primusbank_Pom_DD\\excelfiles\\primusbankdata.xlsx", "insertdata",i , 0);
	String roletype=XLUtils.getStringCellData("C:\\Users\\surya\\workspace\\Primusbank_Pom_DD\\excelfiles\\primusbankdata.xlsx", "insertdata",i , 1);
	InsertionPage ip=PageFactory.initElements(driver, InsertionPage.class);
	ip.insertData(rolename, roletype);
	
	System.out.println("alert msg "+driver.switchTo().alert().getText());
	String alertmsg=driver.switchTo().alert().getText();
	if(alertmsg.toLowerCase().contains("created sucessfully"))
	{
		res=true;
		XLUtils.setCellData("C:\\Users\\surya\\workspace\\Primusbank_Pom_DD\\excelfiles\\primusbankdata.xlsx", "insertdata",i , 2,"pass");
		XLUtils.fillGreenColor("C:\\Users\\surya\\workspace\\Primusbank_Pom_DD\\excelfiles\\primusbankdata.xlsx", "insertdata",i , 2);
	}
	else
	{
		res=false;
		XLUtils.setCellData("C:\\Users\\surya\\workspace\\Primusbank_Pom_DD\\excelfiles\\primusbankdata.xlsx", "insertdata",i , 2,"fail");
		XLUtils.fillRedColor("C:\\Users\\surya\\workspace\\Primusbank_Pom_DD\\excelfiles\\primusbankdata.xlsx", "insertdata",i , 2);
	}
	driver.switchTo().alert().accept();
	Assert.assertTrue(res);
	//*[@id="Table_01"]/tbody/tr/td[3]/a/img
	driver.findElement(By.xpath("//tbody/tr/td[3]/a/img")).click();
	}//end of for
	}//end of method
}//end of main
