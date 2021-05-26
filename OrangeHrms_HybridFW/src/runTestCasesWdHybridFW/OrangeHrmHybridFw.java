package runTestCasesWdHybridFW;

import java.io.IOException;

import org.testng.annotations.Test;


import Utils.ApplicationUtils;
import Utils.XLUtils;
import orangeHrm_Library.AddUser;
import orangeHrm_Library.Employee;
import orangeHrm_Library.LoginScrip_OrangeHrms;

public class OrangeHrmHybridFw extends ApplicationUtils{

	@Test
	public void orangehrmTestHybrid() throws InterruptedException, IOException
	{
		String keywordfile="C:\\Users\\surya\\myseleniumwork\\OrangeHrms_HybridFW\\excelfiles\\OrangeHRMKeywords.xlsx";
		String tcsheetname,tssheetname;
		tcsheetname="TestCases";
		tssheetname="TestSteps";
	
		int tcsheetcount,tssheetcount;
		tcsheetcount=XLUtils.getRowCount(keywordfile, tcsheetname);
		tssheetcount=XLUtils.getRowCount(keywordfile, tssheetname);
		System.out.println("test case count"+tcsheetcount);
		System.out.println("test step count"+tssheetcount);
		String tcid,executeFlag;
		String tstcid,keyword;
		String tcresult;
		String auname,apwd;
		boolean res=false;
		LoginScrip_OrangeHrms lobj=new LoginScrip_OrangeHrms();
		
		Employee emp=new Employee();
		String efname,elname;
		
		AddUser userobj=new AddUser();
		String  role,empName,userName,userPword;
		
		String empUname,empPword;
		String stepres="fail";
		for(int i=1;i<=tcsheetcount;i++)
		{
			System.out.println("i val"+i);
			tcid=XLUtils.getStringCellData(keywordfile, tcsheetname, i, 0);
			executeFlag=XLUtils.getStringCellData(keywordfile, tcsheetname, i, 2);
			
			if(executeFlag.equalsIgnoreCase("y"))
			{
				for(int j=1;j<=tssheetcount;j++)
				{
					tstcid=XLUtils.getStringCellData(keywordfile, tssheetname, j, 0);
					if(tstcid.equalsIgnoreCase(tcid))
					{
						keyword=XLUtils.getStringCellData(keywordfile, tssheetname, j, 4);
						
						switch (keyword.toLowerCase()) {
						 
						case "adminlogin":auname=XLUtils.getStringCellData(keywordfile, tssheetname, j, 5);
										  apwd=XLUtils.getStringCellData(keywordfile, tssheetname, j, 6);
										  System.out.println(auname+" "+apwd);
							               res=lobj.loginAsAdmin(auname, apwd);
							               break;
						case "adminlogout":res=lobj.loggout();
							               break;
						case "newempreg":efname=XLUtils.getStringCellData(keywordfile, tssheetname, j, 5);
										 elname=XLUtils.getStringCellData(keywordfile, tssheetname, j, 6);
							             res=emp.addEmployee(efname, elname);
							             break;
						case "newuserreg":role=XLUtils.getStringCellData(keywordfile, tssheetname, j, 5);
										   empName=XLUtils.getStringCellData(keywordfile, tssheetname, j, 6);
										   userName=XLUtils.getStringCellData(keywordfile, tssheetname, j, 7);
										   userPword=XLUtils.getStringCellData(keywordfile, tssheetname, j, 8);
										  res= userobj.addingUser(role, empName, userName, userPword);
										  break;
						case "emplogin":empUname=XLUtils.getStringCellData(keywordfile, tssheetname, j, 5);
										empPword=XLUtils.getStringCellData(keywordfile, tssheetname, j, 6);
										res=lobj.employeeLogin(empUname, empPword);
										break;
						case "emplogout":System.out.println("employee switch j value"+j);
							res=lobj.loggout();
							System.out.println("emp res "+res);
							break;
						}		//end of switch	
						if(res)
						{
							stepres="pass";
							XLUtils.setCellData(keywordfile, tssheetname, j, 3,stepres);
							XLUtils.fillGreenColor(keywordfile, tssheetname, j, 3);
						}
						else
						{
							stepres="fail";
							XLUtils.setCellData(keywordfile, tssheetname, j, 3, stepres);
							XLUtils.fillRedColor(keywordfile, tssheetname, j, 3);
							
						}
						tcresult=XLUtils.getStringCellData(keywordfile, tcsheetname, i, 3);
						if(!tcresult.equalsIgnoreCase("fail"))
						{
							System.out.println("j value res"+j+" "+tcresult+" "+stepres);
							XLUtils.setCellData(keywordfile, tcsheetname, i, 3,stepres);
							if(stepres.equals("pass"))
							{
								XLUtils.fillGreenColor(keywordfile, tcsheetname, i, 3);
							}
							else
							{
								XLUtils.fillRedColor(keywordfile, tcsheetname, i, 3);
							
							}
						}
					}//end of if
					
					
				}//end of j loop
				
				
				
				
				//System.out.println(tcid+" is selected to execute");
				
				
			}
			if(executeFlag.equalsIgnoreCase("n"))
			{
				System.out.println("i val"+i);
				XLUtils.setCellData(keywordfile, tcsheetname, i, 3, "Blocked");
				XLUtils.fillRedColor(keywordfile, tcsheetname, i, 3);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
