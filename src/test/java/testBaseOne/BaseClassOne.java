package testBaseOne;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;  // log4j
import org.apache.logging.log4j.Logger;  // log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClassOne {
	
public static WebDriver driver;

public Logger logger;  // log4j 

public ResourceBundle rb;// to read data from config.properties file


	
	@BeforeClass(groups= {"Master","Sanity","Regression"}) //Step8 groups added
	@Parameters("browser")   // getting browser parameter from testng.xml
	public void setup(String br)
	{
		
		rb = ResourceBundle.getBundle("config");	 //  // load config.properties file
		
		logger=LogManager.getLogger(this.getClass());  //for logger
		
		// this.getClass will return test case ID and that id will be stored in test case ID
		//getLogger gets all logs and store into logger variable
		
		if(br.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
		}
		
		else if(br.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();

		}
		
		else
		{
			driver=new FirefoxDriver();

		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(rb.getString("appURL")); // get url from config.properties file
		
		//driver.get("https://tutorialsninja.com/demo/");   // local app URL
		//driver.get("https://demo.opencart.com/index.php");   // remote App URL
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Master","Sanity","Regression"})  //Step8 groups added
	public void tearDown()
	{
		driver.quit();
	}


	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException {
		
	//	Date dt=new Date();
	//	SimpleDateFormat sp=new SimpleDateFormat("yyyymmddhhmmss");
	//	String timeStamp=sp.format(dt);
		

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
	
}


