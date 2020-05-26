package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CoursePage;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePageLogin extends Base {
public WebDriver driver;
private static Logger log=LogManager.getLogger(HomePageLogin.class.getName());
@BeforeTest
public void initialise() throws IOException
{
driver=browserInitialise();
}

@Test(dataProvider = "getData")
public void login(String uName,String pwd) throws IOException, InterruptedException
{
	driver.get(prop.getProperty("url"));
	log.info("Navigated to URL");
	LandingPage lp=new LandingPage(driver);
	LoginPage l=lp.getLogin();
	l.getUName().sendKeys(uName);
	log.info("Username is entered");
	l.getPwd().sendKeys(pwd);
	log.info("Password is entered");
	CoursePage cp=l.getloginbtn();
	log.info("licked on login button");
	ForgotPassword fp=l.forgotPwd();
	fp.getUName().sendKeys("pawan");
	fp.sendMeInstructions().click();
	
	
}
@AfterTest
public void browser_close()
{
driver.close();	
}

@DataProvider
public Object[][] getData()
{
	Object[][] data=new Object[2][2];
	data[0][0]="resticteduser@newmail.com";
	data[0][1]="12345";
	data[1][0]="nonresticteduser@newmail.com";
	data[1][1]="56789";
	return data;
}
}
