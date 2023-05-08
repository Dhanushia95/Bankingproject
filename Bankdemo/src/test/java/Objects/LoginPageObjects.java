package Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {
	
	@FindBy(xpath="//input[@name='uid']")
	public static WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	public static WebElement password;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	public static WebElement loginbutton;

}
