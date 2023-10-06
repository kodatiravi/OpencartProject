package pageObjectsOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageOne extends BasePageOne {
	
	//constructor 
	
	public LoginPageOne(WebDriver driver) {
		
		super(driver);
	}
	
	//Elements
	
	@FindBy(xpath="//input[@id='input-email']")
	
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	
	WebElement btnLogin;
	
	//Action methods
	
	public void setEmail(String email) {
		
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		
		btnLogin.click();
	}

}
