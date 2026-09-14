package SonikaProject.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRportNG {
	
	public static ExtentReports getReportObject()
	{
		String file=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(file);
		reporter.config().setDocumentTitle("Reports");
		reporter.config().setReportName("E commerce Website");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sonika");
		
		//ExtentTest test=extent.createTest("Submit Order");
		return extent;

		
	}

}
