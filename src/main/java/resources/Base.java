package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	
	public Properties prop;
	public WebDriver driver;
	public WebDriver browserInitialise() throws IOException
	{
		prop = new Properties();
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		//String browserName=System.getProperty("browser");
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("FireFox"))
		{
			
		}
		else
		{
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	public String takeScreenshot(String TestCaseName,WebDriver driver) throws IOException
	{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String detinationFile=System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
	org.apache.commons.io.FileUtils.copyFile(source, new File(detinationFile));
	return detinationFile;
	}
	
}
