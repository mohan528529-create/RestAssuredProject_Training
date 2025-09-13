package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListeners  implements ITestListener{
	
	public ExtentReports extentreports;
	public ExtentTest extenttest;
	
	public void onStart(ITestContext context)
	{ 
	
	System.out.println("test started");	
   //create a html file
	ExtentSparkReporter reportobj=new ExtentSparkReporter("C:\\Users\\mohaa\\OneDrive\\Documents\\Reports\\extentreport.html");	
	extentreports=new ExtentReports();	
	//provide title to the report 

	reportobj.config().setReportName("UserDataCreationAPI");
	
	}
	public void onTestSuccess(ITestResult result)
	{
		//adding test pass and test fail results 
		extenttest.pass("Test passed");
		System.out.println("test passed");
	}
	public void onTestFailure(ITestResult result)
	{
		//adding test pass and test fail results 
		extenttest.fail("Test failed");
		System.out.println("test failed");
	}
	public void onFinish(ITestContext context)
	{
		//closing our html report
		extentreports.flush();
		System.out.println("test finished");
	}
	public void onTestStart(ITestResult result)
	{
		//creating a table to store test results
		System.out.println("test started");
		extenttest=extentreports.createTest(result.getMethod().getMethodName());
	}
}
