package TestScripts;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.OpenUrl;

public class Loginpg1 extends OpenUrl
 {
	String[][] data = {
			
			{"sdjkfk23","sdjkfk23"},
			{"sfv65464","amYsAnA"},
			{"mngr493075","6467cgd"},
			{"mngr493075","amYsAnA"}
			
	};
	
	@DataProvider(name="login")
	public String[][] dataprov()
	{
		/*
		 * String[][] data =new String[4][4];
		 * 
		 * data[0][0]="sdjkfk23"; data[0][1]="fyu76";
		 * 
		 * data[1][0]="sfv65464"; data[1][1]="amYsAnA";
		 * 
		 * data[2][0]="mngr493075"; data[2][1]="6467cgd";
		 * 
		 * data[3][0]="mngr493075"; data[3][1]="amYsAnA";
		 */
		
		return data;
	}
	
	@Test(dataProvider ="login")
	public void login(String username , String password) throws IOException
	{
		
	    WebElement uid=driver.findElement(By.xpath("//input[@name='uid']"));
		uid.sendKeys(username);
		WebElement pass=driver.findElement(By.xpath("//input[@name='password']"));
		pass.sendKeys(password);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		if(driver.getCurrentUrl().matches(url))
		{
		Alert alert = driver.switchTo().alert();
		String alerttext =alert.getText();
		System.out.println("text in alert box:"+alerttext);
		alert.accept();
		}else
		{
		
		WebElement text = driver.findElement(By.xpath("//tbody/tr[3]"));

		String text1= text.getText();
		
		System.out.println(text1);
		
		assertEquals(text1,"Manger Id : mngr493075" );
		
		File textsrc =text.getScreenshotAs(OutputType.FILE);
		File textdst=new File("./snaps/img.png");
		FileHandler.copy(textsrc, textdst);
		}
		
		/*
		 * PageFactory.initElements(driver, LoginPageObjects.class);
		 * 
		 * LoginPageObjects.username.sendKeys(username);
		 * LoginPageObjects.password.sendKeys(password);
		 * LoginPageObjects.loginbutton.click();
		 */
		 
	}

}
