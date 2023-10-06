package pageObjectsOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageOne {
	
	/* create BasePage class under "pageObjects" package. The BasePage class contains only constructor, which 
	is invoked by every pageObjects class (re-usability) */

	WebDriver driver;
	
	public BasePageOne(WebDriver driver)
	
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

}
