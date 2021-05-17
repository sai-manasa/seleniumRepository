package calci_tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import calci_pages.calculator_page;
import utils.AppUtils;

public class AddTest extends AppUtils {

	
	@Test
	public void checkAdd() throws InterruptedException
	{
		calculator_page cp=PageFactory.initElements(driver, calculator_page.class);
	    boolean result=cp.add(110, 200);
	    Assert.assertTrue(result);
		System.out.println("res "+result);
		
	}
}
