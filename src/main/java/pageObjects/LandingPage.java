package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
WebDriver driver;

public LandingPage(WebDriver driver)
{
	this.driver=driver;
}

private By newsContainer=By.xpath("//*[@id='homepage']//*[text()='NO THANKS']");
private By login=By.cssSelector("a[href*='sign_in']");
private By title=By.xpath("//*[@class='text-center']/h2");
private By navHeader=By.xpath("//*[@class='nav navbar-nav navbar-right']");
private By header=By.cssSelector("[class*='video-banner'] h3");
private By popup=By.xpath("//button[text()='NO THANKS']");

public WebElement navHeader()
{
	return driver.findElement(navHeader);
}
public WebElement newsLetter()
{
	return driver.findElement(newsContainer);
}

public LoginPage getLogin()
{
 driver.findElement(login).click();
 return new LoginPage(driver);
}
public WebElement verifyTitle()
{
	return driver.findElement(title);
}
public WebElement verifyHeader()
{
	return driver.findElement(header);
}
public int popUpSize()
{
	return driver.findElements(popup).size();
}
public WebElement popUp()
{
	return driver.findElement(popup);
}
}
