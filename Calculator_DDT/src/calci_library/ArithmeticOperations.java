package calci_library;

import org.openqa.selenium.By;

import utils.AppUtils;

public class ArithmeticOperations extends AppUtils {

	String s1,s2;
	int expVal,actVal;
	public boolean addition(int v1,int v2) throws InterruptedException
	{
		expVal=v1+v2;
		 s1=Integer.toString(v1);
		 s2=Integer.toString(v2);
		 
		 clickNumber(s1);
		 driver.findElement(By.xpath("//input[@value='+']")).click();;
		 clickNumber(s2);
		 driver.findElement(By.xpath("//input[@value='=']")).click();;
		 String sre=driver.findElement(By.xpath("//input[@name='display']")).getAttribute("value");
		 actVal=Integer.parseInt(sre);
		 
		 System.out.println("act exp "+actVal+" "+expVal);
		 Thread.sleep(2000);
		 clearCalci();
		 if(actVal==expVal)
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
		 
		 
	}
	
	
	
	public boolean subtraction(int v1,int v2) throws InterruptedException
	{
		expVal=v1-v2;
		 s1=Integer.toString(v1);
		 s2=Integer.toString(v2);
		 
		 clickNumber(s1);
		 driver.findElement(By.xpath("//input[@value='-']")).click();;
		 clickNumber(s2);
		 driver.findElement(By.xpath("//input[@value='=']")).click();;
		 String sre=driver.findElement(By.xpath("//input[@name='display']")).getAttribute("value");
		 actVal=Integer.parseInt(sre);
		 
		 System.out.println("act exp "+actVal+" "+expVal);
		 Thread.sleep(2000);
		 clearCalci();
		 if(actVal==expVal)
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
		 
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	public void clickNumber(String snum)
	{
		int len=snum.length();
		for(int i=0;i<len;i++)
		{
			char num=snum.charAt(i);
			driver.findElement(By.xpath("//input[@value='"+num+"']")).click();;
			
		}
	}
	
	public void clearCalci()
	{
		driver.findElement(By.xpath("//input[@value='C']")).click();
	}
	
}
