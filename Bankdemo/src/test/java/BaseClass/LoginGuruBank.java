package BaseClass;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonFunctionality.OpenDriver;
import Objects.LoginPageObjects;

public class LoginGuruBank extends OpenDriver {
	@Test
	public void login()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String url = prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		
		driver.get(url);
		System.out.println("loginpage title:"+driver.getTitle());
		
		PageFactory.initElements(driver, LoginPageObjects.class);
		
		LoginPageObjects.username.sendKeys(username);
		LoginPageObjects.password.sendKeys(password);
		LoginPageObjects.loginbutton.click();
		
		System.out.println("homepage title:"+driver.getTitle());
		String actualtitle=driver.getTitle();
		String expectedtitle="Guru99 Bank Manager HomePage";
		if(actualtitle.contains(expectedtitle))
		{
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
	  //  Assert.assertEquals(actualtitle, expectedtitle);
	
	}

}
