package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
WebDriver driver;

public ForgotPassword(WebDriver driver)
{
	this.driver=driver;
}

By username=By.id("user_email");
By sendMeInstructions=By.cssSelector("[type='submit']");

public WebElement getUName()
{
	return driver.findElement(username);
}
public WebElement sendMeInstructions()
{
	return driver.findElement(sendMeInstructions);
}

}
