package testCasesOne;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBaseOne.BaseClassOne;

import pageObjectsOne.HomePageOne;

import pageObjectsOne.AccountRegistrationPageOne;

public class TC_001_Account_Registratin_One extends BaseClassOne {
	
	@Test(groups= {"Regression", "Master"}) //Step8 groups added
	public void test_account_Registration() {
		
		logger.info("********** starting TC_001_Account_Registratin_One **********");
		
		try 
		{
			
		
		HomePageOne hp=new HomePageOne(driver);
		
		logger.info("Clicking on MyAccount link");
		
		            hp.clickMyAccount();
		            
		logger.info("Clicking on Registration link ") ;
		
		            hp.clickRegister();
		
		AccountRegistrationPageOne regpage=new AccountRegistrationPageOne(driver);
		
		logger.info("Providing customer details");
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("clicked on continued button........");
		
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("verifying confirmation message");
		
	if(confmsg.equals("Your Account Has Been Created!")) {
		
		logger.info("test passed.....");
		
		Assert.assertTrue(true);
	}
	
	else 
	{
		logger.warn("Customer registration is not successful");
		
		logger.error("test failed.....");
		
		Assert.assertTrue(false); 
	}
		
		}
		
		catch (Exception e)
		{
			Assert.fail();		
			
		}
		
		logger.info("********** finished TC_001_Account_Registratin_One **********");
	}

}
