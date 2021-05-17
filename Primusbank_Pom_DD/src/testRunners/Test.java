package testRunners;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import stepPages.AdminPage;
import stepPages.LoginPage;
import stepPages.RolesPage;
import utils.AppUtils;
import utils.XLUtils;


public class Test extends AppUtils {

	@org.testng.annotations.Test
	public void test1() throws InterruptedException {
		//int r=XLUtils.getRowCount("C:\\Users\\surya\\workspace\\Primusbank_Pom_DD\\excelfiles\\primusbankdata.xlsx", "login");
		//int r=XLUtils.getRowCount("C:\\Users\\surya\\workspace\\Primusbank_Pom_DD\\excelfiles\\primusbankdata.xlsx", "login");
		//System.out.println("rows "+r);
		
		//String rolename=XLUtils.getStringCellData("C:\\Users\\surya\\workspace\\Primusbank_Pom_DD\\excelfiles\\primusbankdata.xlsx", "insertdata",1 , 0);
		//String roletype=XLUtils.getStringCellData("C:\\Users\\surya\\workspace\\Primusbank_Pom_DD\\excelfiles\\primusbankdata.xlsx", "insertdata",1 , 1);
		//System.out.println(aduname+" "+apwd);
		
		
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.adminLogin("Admin", "Admin",driver);
	
		AdminPage ap=PageFactory.initElements(driver, AdminPage.class);
		ap.clickRole();
	//Assert.assertTrue(res);
	
		RolesPage rp=PageFactory.initElements(driver, RolesPage.class);
		rp.clickRole();
		
		driver.findElement(By.xpath("//tbody/tr/td[3]/a/img")).click();
		
	}

}
