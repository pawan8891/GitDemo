package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {

static ExtentReports extent;
public static ExtentReports extentRportConfig()
{
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setDocumentTitle("Automation Results");
	reporter.config().setReportName("Web Automation Results");
	
	extent =new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Pawan Goswami");
	return extent;
}
}

