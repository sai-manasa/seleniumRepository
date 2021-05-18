package stepdefinations;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Calculator_functions {
	public WebDriver driver;
	int v1,sum=0,actVal;
	@Given("^I want to open url \"([^\"]*)\"$")
	public void i_want_to_open_url(String url) throws Throwable {
	    System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	    driver=new FirefoxDriver();
	    driver.manage().deleteAllCookies();
	    driver.get(url);
	}

	@When("^I click \"([^\"]*)\"$")
	public void i_click(String num)  {
		int len=num.length();
		for(int i=0;i<len;i++)
		{
			char numb=num.charAt(i);
			driver.findElement(By.xpath("//input[@value='"+numb+"']")).click();;
			
		}
		v1=Integer.parseInt(num);
		sum=sum+v1;
	}

	@When("^I click add$")
	public void i_click_add() {
		 driver.findElement(By.xpath("//input[@value='+']")).click();;
	}

	@When("^I click equals$")
	public void i_click_equals()  {
		 driver.findElement(By.xpath("//input[@value='=']")).click();;
	    
	}

	@Then("^it should display apporptiate result$")
	public void it_should_display_apporptiate_result()  {
		
		String sre=driver.findElement(By.xpath("//input[@name='display']")).getAttribute("value");
		 actVal=Integer.parseInt(sre);
		 System.out.println("actual val "+actVal);
		 System.out.println("sum "+sum);
		 driver.findElement(By.xpath("//input[@value='C']")).click();
	
		 if(actVal==sum)
		 {
			 System.out.println("addition test case passed suceessfully");
		 }
		 else
		 {
			 System.out.println("failed");
		 }
	   
	}


}
