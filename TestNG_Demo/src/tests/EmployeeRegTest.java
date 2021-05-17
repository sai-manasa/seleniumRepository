package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.Apputils;

public class EmployeeRegTest extends Apputils
{

	
	@Parameters({"fname","lname"})
	@Test
	public void checkEmpReg(String fname,String lname)
	{
		
		System.out.println("Employee Registration Tested using : "+fname+" "+lname);
	}
	
	
}
