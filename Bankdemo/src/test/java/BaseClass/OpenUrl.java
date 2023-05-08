package BaseClass;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import CommonFunctionality.OpenDriver;

public class OpenUrl extends OpenDriver {
	public static String url;
	@Test
	public void openurl()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		url = prop.getProperty("url");
		
		driver.get(url);
	}

}
