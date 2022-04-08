package com.nopcommerce.frontend;

//import org.apache.commons.logging.LogFactory;
//import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.HomeObject;
import pageObject.LoginObject;
import pageObject.RegisterObject;


public class Login extends BaseTest{
	
	WebDriver d;
	
	private HomeObject homePage;
	private LoginObject loginPage;
	private RegisterObject registerPage;
	
	private String newEmail = "";
	
	@Parameters("browser")
	@BeforeClass
	public void preCondition(@Optional("chrome") String b) {		
		d = getBrowserDriver(b);	
		
		//khoi tao pages
		homePage = new HomeObject(d);
		loginPage = new LoginObject(d);
		registerPage = new RegisterObject(d);
	}

	@Test
	public void Login_01_Empty_Data() {
		Reporter.log("Login_01_Empty_Data", true);
		Reporter.log("- Step 01: Open homepage", true);
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<h1>Report.log here ... </h1>");
		//step 1: open homepage
		homePage.open();
		Reporter.log("- Step 02: Click Login link on header", true);
		//step 2: click Login link on header
		loginPage.clickLoginOnHeader(d);
		Reporter.log("- Step 03: Click button Login", true);
		//step 3: click btn login
		loginPage.clickLoginBtn();
		//Verify
		Assert.assertEquals(loginPage.getEmailErrMsg(), "Please enter your email 1");	
	}
	
	@Test(enabled=false)
	public void Login_02_Invalid_Email() {
		//Reporter.log("Login_02_Invalid_Email");
		//Reporter.log("- Step 01: Open homepage");
		//step 1: open homepage
		homePage.open();
		//Reporter.log("- Step 02: Click login link on header");
		//step 2: click login link on header
		loginPage.clickLoginOnHeader(d);
		
		//Reporter.log("- Step 03: fill invalid email");
		//step 3: fill invalid email
		loginPage.typeEmailTxt("test@123@456");
		//Reporter.log("- Step 04: type password textbox");
		loginPage.typePasswordTxt("123456");
		
		//Reporter.log("- Step 05: click login button");
		//step 4: click login button
		loginPage.clickLoginBtn();
		//Verify
		Assert.assertEquals(loginPage.getEmailErrMsg(), "Wrong email");
	}
	
	@Test(enabled=false)
	public void Login_03_Not_Registered_Email() {
		Reporter.log("Login_03_Not_Registered_Email");
		Reporter.log("- Step 01: open homepage");
		homePage.open();

		Reporter.log("- Step 02: click login link on header");
		loginPage.clickLoginOnHeader(d);
	
		Reporter.log("- Step 03: fill unregistered email");
		loginPage.typeEmailTxt("test" + generateRandomNumber() + "@gmail.com");
		
		Reporter.log("- Step 04: type password");
		loginPage.typePasswordTxt("123456");
	
		Reporter.log("- Step 05: click Login button");
		loginPage.clickLoginBtn();
		//Verify
		Assert.assertTrue(loginPage.getSummaryErrMsg().contains("No customer account found"));
	}
	
	@Test(enabled=false)
	public void Pre_Condition_Register() {
		
		Reporter.log("Pre_Condition_Register");
	
		Reporter.log("- Step 01: open homepage");
		homePage.open();
	
		Reporter.log("- Step 02: click register link on header");
		registerPage = registerPage.clickRegisterLinkOnHeader(d);
	
		String em = "human_" + generateRandomNumber() + "@gmail.com";
		Reporter.log("- Step 03: Generate new email " + em);
		
		Reporter.log("- Step 04: Type first name textbox");
		registerPage.typeFirstnameTxt("first name");
		
		Reporter.log("- Step 05: Type last name textbox");
		registerPage.typeLastnameTxt("last name");
		
		Reporter.log("- Step 06: Type email");
		registerPage.typeEmailTxt(em);
		
		Reporter.log("- Step 07: Type password");
		registerPage.typePasswordTxt("123456");
		
		Reporter.log("- Step 08: Type confirmed password");
		registerPage.typeCPasswordTxt("123456");
		
		Reporter.log("Click register button");
		registerPage.clickRegisterBtn();
		//Verify
		Assert.assertEquals(registerPage.getSuccessMsg(), "Your registration completed");
		this.newEmail = em;
		
		Reporter.log("- Step 09: logout after register successfully");
		registerPage.clickLogoutOnHeader(d);
	}
	
	@Test(enabled=false, dependsOnMethods = "Pre_Condition_Register")
	public void Login_04_Empty_Password() {
		Reporter.log("Login_04_Empty_Password");
		
		Reporter.log("- Step 01: open homepage");
		homePage.open();
		
		Reporter.log("- Step 02: click login on header");
		loginPage.clickLoginOnHeader(d);

		Reporter.log("- Step 03: fill new registered email");
		loginPage.typeEmailTxt(this.newEmail);
	
		Reporter.log("- Step 04: click login button");
		loginPage.clickLoginBtn();
		//Verify
		Assert.assertTrue(loginPage.getSummaryErrMsg().contains("The credentials provided are incorrect"));
	}
	
	@Test(enabled = false, dependsOnMethods = "Pre_Condition_Register")
	public void Login_05_Wrong_Password() {
		Reporter.log("Login_05_Wrong_Password");
		
		Reporter.log("- Step 01: open homepage");
		homePage.open();
		
		Reporter.log("- Step 02: click login link on header");
		loginPage.clickLoginOnHeader(d);
		
		Reporter.log("- Step 03: type email");
		loginPage.typeEmailTxt(newEmail);
		
		Reporter.log("- Step 04: type password");
		loginPage.typePasswordTxt("12345678");
		
		Reporter.log("- Step 05: click login button");
		loginPage.clickLoginBtn();
		//Verify
		Assert.assertTrue(loginPage.getSummaryErrMsg().contains("The credentials provided are incorrect"));
	}
	
	@Test(enabled = false, dependsOnMethods = "Pre_Condition_Register")
	public void Login_06_Success() {
		Reporter.log("Login_06_Success");
		Reporter.log("- Step 01: open homepage");
		homePage.open();
		
		Reporter.log("- Step 02: click login link on header");
		loginPage.clickLoginOnHeader(d);
		
		Reporter.log("- Step 03: type email");
		loginPage.typeEmailTxt(newEmail);
		
		Reporter.log("- Step 04: type pass");
		loginPage.typePasswordTxt("123456");
		
		Reporter.log("- Step 05: click login button");
		loginPage.clickLoginBtn();
		//Verify
		Assert.assertTrue(loginPage.isLoginSuccess());
	}
	
	 @AfterClass
	  public void quitCurrentOpenedBrowser() {
		  this.quitBrowser(d);
	  }
	
}
