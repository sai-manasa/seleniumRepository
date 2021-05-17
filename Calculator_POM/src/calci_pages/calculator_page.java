package calci_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Factory;

public class calculator_page {

	@FindBy(xpath="//input[@value='1']")
	WebElement one;
	
	
	@FindBy(xpath="//input[@value='2']")
	WebElement two;
	
	@FindBy(xpath="//input[@value='3']")
	WebElement three;
	
	@FindBy(xpath="//input[@value='4']")
	WebElement four;
	
	
	@FindBy(xpath="//input[@value='5']")
	WebElement five;
	
	@FindBy(xpath="//input[@value='6']")
	WebElement six;
	
	
	@FindBy(xpath="//input[@value='7']")
	WebElement seven;
	
	@FindBy(xpath="//input[@value='8']")
	WebElement eight;
	
	
	@FindBy(xpath="//input[@value='9']")
	WebElement nine;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement zero;
	
	@FindBy(xpath="//input[@value='+']")
	WebElement add;
	
	@FindBy(xpath="//input[@value='-']")
	WebElement sub;
	
	@FindBy(xpath="//input[@value='x']")
	WebElement mul;
	
	@FindBy(xpath="//input[@value='/']")
	WebElement div;
	
	@FindBy(xpath="//input[@value='=']")
	WebElement equals;
	
	@FindBy(xpath="//input[@name='display']")
	WebElement res;
	
	@FindBy(xpath="//input[@value='C']")
	WebElement clear;
	
	public boolean add(int v1,int v2) throws InterruptedException
	{
		System.out.println(v1+" "+v2);
		clickNum(v1);
		Thread.sleep(4000);
		add.click();
		clickNum(v2);
		equals.click();
		String straddres=res.getAttribute("value");
		int actres=Integer.parseInt(straddres);
		int expres=(v1+v2);
		clear.click();
		if(actres==expres)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean sub(int v1,int v2) throws InterruptedException
	{
		System.out.println(v1+" "+v2);
		clickNum(v1);
		Thread.sleep(4000);
		sub.click();
		clickNum(v2);
		equals.click();
		String straddres=res.getAttribute("value");
		int actres=Integer.parseInt(straddres);
		int expres=(v1-v2);
		clear.click();
		if(actres==expres)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public void clickNum(int num)
	{
		String snum=Integer.toString(num);
		int len=snum.length();
		
		for(int i=0;i<len;i++)
		{
			char inum=snum.charAt(i);
		System.out.println(inum);
		switch (inum) {
		case '1':one.click();
				 break;
		case '2':two.click();
				break;
		case '3':three.click();
				break;
				
		case '4':four.click();
		 break;
		 
		case '5':five.click();
		break;
		
		case '6':six.click();
		break;
		
		case '7':seven.click();
		 break;
		 
		case '8':eight.click();
		break;
		
		case '9':nine.click();
		break;
		
		case '0':zero.click();
			break;
	
		default:
			break;
		}
	}
	}
	
	
	
}
