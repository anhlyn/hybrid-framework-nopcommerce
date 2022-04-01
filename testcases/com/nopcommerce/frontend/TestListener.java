package com.nopcommerce.frontend;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import commons.BaseTest;

public class TestListener implements ITestListener {

	String folderScreenshot = System.getProperty("user.dir") + "/screenshot/";
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getName();
		//WebDriver d = (WebDriver) context.getAttribute("driver");
		WebDriver d = null;
		try {
			d = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("d").get(result.getInstance());
			Object obj = result.getInstance();
			Set<String> attrs = result.getAttributeNames();
			String hostStr = result.getHost();
			String instanceName = result.getInstanceName();
			IClass testcls = result.getTestClass();
			
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.takeSnapShot(d, methodName + ".png");
			String imgsrc = this.folderScreenshot + methodName + ".png";
			Reporter.log("<img src='" + imgsrc + "' />");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	private void takeSnapShot(WebDriver webdriver,String filename) throws Exception{

		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		File DestFile=new File(this.folderScreenshot + filename);

		FileUtils.copyFile(SrcFile, DestFile);
	}

}
