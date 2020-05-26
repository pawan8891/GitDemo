package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
WebDriver driver;

public LoginPage(WebDriver driver)
{
	this.driver=driver;
}

private By username=By.id("user_email");
private By password=By.id("user_password");
private By loginbtn=By.xpath("//*[@name='commit']");
private By forgotPwd=By.cssSelector("[href*='password/new']");


public WebElement getUName()
{
	return driver.findElement(username);
}
public WebElement getPwd()
{
	return driver.findElement(password);
}
public CoursePage getloginbtn()
{
	driver.findElement(loginbtn).click();
	return new CoursePage(driver);
	
}
public ForgotPassword forgotPwd()
{
	driver.findElement(forgotPwd).click();
	return new ForgotPassword(driver);
}
}
