package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursePage {
	
WebDriver driver;

public CoursePage(WebDriver driver)
{
	this.driver=driver;
}

private By course=By.cssSelector("[title*='Automation Testers']");

public WebElement course()
{
	return driver.findElement(course);
}
}
