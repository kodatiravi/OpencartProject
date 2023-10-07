package testCasesOne;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBaseOne.BaseClassOne;
import pageObjectsOne.HomePageOne;
import pageObjectsOne.LoginPageOne;
import pageObjectsOne.MyAccountPageOne;

// login test...
public class TC_002_LoginTestOne extends BaseClassOne {
	
	@Test(groups= {"Sanity","Master"}) //Step8 groups added
	public void Test_Login() {
		
		logger.info(" started  TC_002_LoginTestOne....");
		
		
		try
		{
			
		
		HomePageOne hp=new HomePageOne(driver);  //Home page pageObject class
		
		logger.info("clicked on MyAccount page");
		            hp.clickMyAccount();
		            
		  logger.info("clicked on Login page");
		            hp.clickLogin();
		            
		LoginPageOne lp=new LoginPageOne(driver);  //login page pageObject class
		
		
		  logger.info("entered email id");
		   lp.setEmail(rb.getString("email"));
		    
			  logger.info("entered password ");
            lp.setPassword(rb.getString("password"));
            
  		  logger.info("clicked on Login button");
  		            lp.clickLogin();
	
		    MyAccountPageOne macc=new  MyAccountPageOne(driver);
		    
		    boolean targetPage=macc.isMyAccountPageOneExists();
		 
		    Assert.assertEquals(targetPage, true);
		    
		    logger.info("displayed My Account successfully after logging into the account ");

		}
		
		catch (Exception e)
		{
			Assert.fail();
		}
		    		    
			logger.info("finished TC_002_LoginTestOne ......");

	}

}
