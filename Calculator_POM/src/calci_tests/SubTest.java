package calci_tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import calci_pages.calculator_page;
import utils.AppUtils;

public class SubTest extends AppUtils{

	@Test
	public void checkSub() throws InterruptedException
	{
		calculator_page cp=PageFactory.initElements(driver, calculator_page.class);
	    boolean result=cp.sub(100, 50);
	    Assert.assertTrue(result);
		System.out.println("res "+result);
		
	}
}
