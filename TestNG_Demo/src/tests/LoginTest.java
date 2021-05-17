package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.Apputils;

public class LoginTest extends Apputils
{

		
	@Parameters({"uname","pword"})
	@Test(priority=1)
	public void checkLogin(String uid,String pwd)	
	{
		
		System.out.println("Login Tested with username: "+uid+" and password: "+pwd);
	}
	
	
	
}
