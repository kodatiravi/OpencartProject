package testCasesOne;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectsOne.HomePageOne;
import pageObjectsOne.LoginPageOne;
import testBaseOne.BaseClassOne;
import utilities.DataProviders;
import pageObjectsOne.MyAccountPageOne;

public class TC_003_LoginDataDrivenTest extends BaseClassOne {
	
	
	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class)
	public void test_loginDDT(String email, String pwd, String exp) {
		
		logger.info(" Starting TC_003_LoginDataDrivenTest ");
		
		try
		{
             HomePageOne hp=new HomePageOne(driver);  //Home page pageObject class
	                     hp.clickMyAccount();
	                     hp.clickLogin();
		            
		LoginPageOne lp=new LoginPageOne(driver);  //login page pageObject class
		           lp.setEmail(email);
		           lp.setPassword(pwd);
		           lp.clickLogin();
		
		           MyAccountPageOne macc=new MyAccountPageOne(driver);
		            boolean  targetpage=macc.isMyAccountPageOneExists();
		            
		            if (exp.equals("Valid")) {
						if (targetpage == true) {
							macc.clickLogout();
							Assert.assertTrue(true);
						} else {
							Assert.assertTrue(false);
						}
					}
		            
		            if (exp.equals("Invalid")) {
						if (targetpage == true) {
							macc.clickLogout();
							Assert.assertTrue(false);
						} else {
							Assert.assertTrue(true);
						}
					}
		            
	} catch (Exception e) {
		Assert.fail();
	}

	logger.info(" Finished TC_003_LoginDataDrivenTest");

}

		            
		            
	}


