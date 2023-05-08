package CommonFunctionality;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;


public class OpenDriver {
	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties prop;
	
	public Properties inputpropertyfile() throws IOException
	{
	    fis=new FileInputStream("C:\\Users\\dell\\new eclipse\\Guru99Banking\\Bankdemo\\config.properties");
	    prop=new Properties();
		prop.load(fis);
		
		return prop;
	}
	@BeforeTest
	public void openfirefox() throws IOException
	{
		
		inputpropertyfile();
		String driverlocation =prop.getProperty("driverlocation");
		
		
		System.setProperty("WebDriver.gecko.driver", driverlocation);
	    driver =new FirefoxDriver();
	    
	    
	}

}
