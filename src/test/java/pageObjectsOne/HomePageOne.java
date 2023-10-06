package pageObjectsOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*  create page Object class for HomePage and RegistrationPage under PageObjects package(these classes
extends from BasePage) because BasePage class contains constructor, which we require in every page object 
class*/

public class HomePageOne extends BasePageOne {
	
	
	public HomePageOne(WebDriver driver){
		
		super(driver);
	}
	
	
	//Elements 
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	
	WebElement lnkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")  // login link added in step: 6
	
	WebElement lnkLogin;
	
	
	//action methods
	
	public void clickMyAccount() {
		
		lnkMyaccount.click();
	}
	
	public void clickRegister() {
		
		lnkRegister.click();
	}
	
	public void clickLogin() {  // login link added in step: 6
		
		lnkLogin.click();
	}

}
