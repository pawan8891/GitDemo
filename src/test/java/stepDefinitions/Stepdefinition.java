package stepDefinitions;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.CoursePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

@RunWith(Cucumber.class)
public class Stepdefinition extends Base {
	WebDriver driver;
	LandingPage lp;
	LoginPage l;
	CoursePage cp;

    @Given("^user initialised browser$")
    public void user_initialised_browser() throws Throwable {
       driver=browserInitialise(); 
    }

    @And("^user navigate to (.+) landing page$")
    public void user_navigate_to_landing_page(String url) throws Throwable {
    	driver.get(url);     
    }

    @And("^user clicks on login link$")
    public void user_clicks_on_login_link() throws Throwable {
    	lp=new LandingPage(driver);
    	if(lp.popUpSize()>0)
    	{
    		lp.popUp().click();
    	}
    	l=lp.getLogin();
    }

    @When("^User Login into home page with (.+) and Password (.+)$")
    public void user_login_into_home_page_with_and_password(String username, String password) throws Throwable {
        l.getUName().sendKeys(username);
        l.getPwd().sendKeys(password);
        cp=l.getloginbtn();
    }

    @Then("^user is sucessfully logged in$")
    public void user_is_sucessfully_logged_in() throws Throwable {
        Assert.assertTrue(cp.course().isDisplayed());
    }

    @And("^browsers are closed$")
    public void browsers_are_closed() throws Throwable {
        driver.quit();
    }

}
