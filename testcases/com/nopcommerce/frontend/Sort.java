package com.nopcommerce.frontend;

//import org.apache.commons.logging.LogFactory;
//import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.Helper;
import commons.PageGenerator;
import pageObject.HomeObject;


public class Sort extends BaseTest{
	
	WebDriver d;
	private Helper helper;
	
	@Parameters("browser")
	@BeforeClass
	public void Pre_Condition(@Optional("chrome") String b) {		
		d = getBrowserDriver(b);	
		helper = Helper.getHelper();

		
		homePage = PageGenerator.getHomePage(d);
	}
	
	 @AfterClass(enabled=true, alwaysRun=true)
	 public void afterClass() {
		log.info("close browser");
		quitBrowser(d);
	}
	 
	private HomeObject homePage;
	
}
