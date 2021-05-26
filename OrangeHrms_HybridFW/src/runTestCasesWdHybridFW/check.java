package runTestCasesWdHybridFW;

import org.testng.annotations.Test;

import Utils.ApplicationUtils;
import orangeHrm_Library.LoginScrip_OrangeHrms;

public class check extends ApplicationUtils{

	@Test
	public void maintest() throws InterruptedException {
		// TODO Auto-generated method stub
		LoginScrip_OrangeHrms lobj=new LoginScrip_OrangeHrms();
		lobj.loginAsAdmin("Admin", "Qedge123!@#");
		lobj.loggout();

	}

}
