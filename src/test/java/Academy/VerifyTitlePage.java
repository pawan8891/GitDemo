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

public class VerifyTitlePage extends Base {
public WebDriver driver;
private static Logger log=LogManager.getLogger(VerifyTitlePage.class.getName());
@BeforeTest
public void initialise() throws IOException, InterruptedException
{
	
	driver=browserInitialise();
}

	
@Test
public void verifyTitle() throws IOException, InterruptedException
{
	
	driver.get(prop.getProperty("url"));
	log.info("Navigated to URL");
	LandingPage lp=new LandingPage(driver);
	log.info("No Thanks link clicked");
	Assert.assertEquals(lp.verifyTitle().getText(),"FEATURED COU123RSES");
	log.info("FEATURED COURSES text is verified");
	
}

@AfterTest
public void browser_close()
{
driver.close();	
}

}
