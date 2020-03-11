package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.PASS, result.getName().toUpperCase()+"PASS");
		test.log(LogStatus.PASS, result.getName().toUpperCase()+"Passed with exception : "+test.addScreenCapture(TestUtil.screenshotName));
		repo.endTest(test);
		repo.flush();
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.setProperty("org.uncommons.reportng.escape-output",  "false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+"Failed with exception : "+result.getThrowable());
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+"Failed with exception : "+test.addScreenCapture(TestUtil.screenshotName));
		
		Reporter.log("Capturing Screenshot");
		Reporter.log("<a target=\"_blank\" href=\"C:\\screenshot\\error.jpg");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"C:\\screenshot\\error.jpg");
		repo.endTest(test);
		repo.flush();
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		test = repo.startTest(context.getName().toUpperCase());
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
