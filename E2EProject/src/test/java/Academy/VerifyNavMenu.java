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


import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;
import org.apache.logging.log4j.*;
public class VerifyNavMenu extends Base {
WebDriver driver;
private static Logger log=LogManager.getLogger(VerifyNavMenu.class.getName());
LandingPage lp;
@BeforeTest
public void initialise() throws IOException
{
driver=browserInitialise();
}

@Test
public void navMenuVerify() throws IOException, InterruptedException
{
	
	driver.get(prop.getProperty("url"));
	log.info("Navigated to URL");
	lp=new LandingPage(driver);
	log.info("No Thanks link clicked");
	Assert.assertTrue(lp.navHeader().isDisplayed());
	log.info("Verified Nav header is displayed");
}
@Test
public void verifyHeaderSec() throws IOException, InterruptedException
{
	
	driver.get(prop.getProperty("url"));
	Assert.assertEquals(lp.verifyHeader().getText(),"An Academy to learn Everything about Testing".toUpperCase());

}
@AfterTest
public void browser_close()
{
	driver.close();	
}

}
