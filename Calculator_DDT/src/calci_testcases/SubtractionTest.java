package calci_testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import calci_library.ArithmeticOperations;
import utils.AppUtils;
import utils.XLUtils;

public class SubtractionTest extends AppUtils{

	double d1,d2;

	@Test
	public void checkSub() throws IOException, InterruptedException
	{
		int val1,val2;
		ArithmeticOperations aop=new ArithmeticOperations();
		
		int rcount=XLUtils.getRowCount("C:\\Users\\surya\\myseleniumwork\\Calculator_DDT\\XcelFiles\\ArthOpersData.xlsx", "sub");
		System.out.println("rows "+rcount);
		for(int i=1;i<=rcount;i++)
		{
			d1=XLUtils.getNumericCellData("C:\\Users\\surya\\myseleniumwork\\Calculator_DDT\\XcelFiles\\ArthOpersData.xlsx", "sub", i, 0);
			d2=XLUtils.getNumericCellData("C:\\Users\\surya\\myseleniumwork\\Calculator_DDT\\XcelFiles\\ArthOpersData.xlsx", "sub", i, 1);
			val1=(int)d1;
			val2=(int)d2;
			System.out.println("val 1 2-->"+val1+" "+val2);
			boolean res=aop.subtraction(val1, val2);
			if(res)
			{
				XLUtils.setCellData("C:\\Users\\surya\\myseleniumwork\\Calculator_DDT\\XcelFiles\\ArthOpersData.xlsx", "sub", i, 2, "pass");
				XLUtils.fillGreenColor("C:\\Users\\surya\\myseleniumwork\\Calculator_DDT\\XcelFiles\\ArthOpersData.xlsx", "sub", i, 2);
			}
			else
			{
				XLUtils.setCellData("C:\\Users\\surya\\myseleniumwork\\Calculator_DDT\\XcelFiles\\ArthOpersData.xlsx", "sub", i, 2, "fail");
				XLUtils.fillRedColor("C:\\Users\\surya\\myseleniumwork\\Calculator_DDT\\XcelFiles\\ArthOpersData.xlsx", "sub", i, 2);
			}
			Assert.assertTrue(res);
		}
		
		
		
		
	}
}
