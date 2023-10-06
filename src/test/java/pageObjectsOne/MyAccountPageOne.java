package pageObjectsOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPageOne extends BasePageOne {
	
	//constructor
	
	public MyAccountPageOne(WebDriver driver) {
		
		super(driver);
	}

	//Element

	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	
	WebElement msgHeading;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	
	WebElement lnkLogout;
	
	//Action method
	
	public boolean isMyAccountPageOneExists() {
		
		
		try 
		{
			
		
		return(msgHeading.isDisplayed());
		
		}
		
		catch(Exception e) {
			
			return (false) ;
		}
		
	}
	
	public void clickLogout() {
		
		lnkLogout.click();
	}
	
}
