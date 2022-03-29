package com.nopcommerce.frontend;

//import org.apache.commons.logging.LogFactory;
//import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.HomeObject;
import pageObject.LoginObject;
import pageObject.RegisterObject;

public class Login extends BaseTest{
	
	private WebDriver d;
	
	private HomeObject homePage;
	private LoginObject loginPage;
	private RegisterObject registerPage;
	
	private String newEmail = "";
	
	@Parameters("browser")
	@BeforeClass
	public void preCondition(String b) {		
		d = getBrowserDriver(b);	
		
		//khoi tao pages
		homePage = new HomeObject(d);
		loginPage = new LoginObject(d);
		registerPage = new RegisterObject(d);
	}

	@Test
	public void Login_01_Empty_Data() {
		log.info("Login_01_Empty_Data");
		log.info("- Step 01: Open homepage");
		log.info("");
		//step 1: open homepage
		homePage.open();
		log.info("- Step 02: Click Login link on header");
		//step 2: click Login link on header
		loginPage.clickLoginOnHeader(d);
		log.info("- Step 03: Click button Login");
		//step 3: click btn login
		loginPage.clickLoginBtn();
		//Verify
		Assert.assertEquals(loginPage.getEmailErrMsg(), "Please enter your email");	
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		log.info("Login_02_Invalid_Email");
		log.info("- Step 01: Open homepage");
		//step 1: open homepage
		homePage.open();
		log.info("- Step 02: Click login link on header");
		//step 2: click login link on header
		loginPage.clickLoginOnHeader(d);
		
		log.info("- Step 03: fill invalid email");
		//step 3: fill invalid email
		loginPage.typeEmailTxt("test@123@456");
		log.info("- Step 04: type password textbox");
		loginPage.typePasswordTxt("123456");
		
		log.info("- Step 05: click login button");
		//step 4: click login button
		loginPage.clickLoginBtn();
		//Verify
		Assert.assertEquals(loginPage.getEmailErrMsg(), "Wrong email");
	}
	
	@Test
	public void Login_03_Not_Registered_Email() {
		log.info("Login_03_Not_Registered_Email");
		log.info("- Step 01: open homepage");
		homePage.open();

		log.info("- Step 02: click login link on header");
		loginPage.clickLoginOnHeader(d);
	
		log.info("- Step 03: fill unregistered email");
		loginPage.typeEmailTxt("test" + generateRandomNumber() + "@gmail.com");
		
		log.info("- Step 04: type password");
		loginPage.typePasswordTxt("123456");
	
		log.info("- Step 05: click Login button");
		loginPage.clickLoginBtn();
		//Verify
		Assert.assertTrue(loginPage.getSummaryErrMsg().contains("No customer account found"));
	}
	
	@Test
	public void Pre_Condition_Register() {
		
		log.info("Pre_Condition_Register");
	
		log.info("- Step 01: open homepage");
		homePage.open();
	
		log.info("- Step 02: click register link on header");
		registerPage = registerPage.clickRegisterLinkOnHeader(d);
	
		String em = "human_" + generateRandomNumber() + "@gmail.com";
		log.info("- Step 03: Generate new email " + em);
		
		log.info("- Step 04: Type first name textbox");
		registerPage.typeFirstnameTxt("first name");
		
		log.info("- Step 05: Type last name textbox");
		registerPage.typeLastnameTxt("last name");
		
		log.info("- Step 06: Type email");
		registerPage.typeEmailTxt(em);
		
		log.info("- Step 07: Type password");
		registerPage.typePasswordTxt("123456");
		
		log.info("- Step 08: Type confirmed password");
		registerPage.typeCPasswordTxt("123456");
		
		log.info("Click register button");
		registerPage.clickRegisterBtn();
		//Verify
		Assert.assertEquals(registerPage.getSuccessMsg(), "Your registration completed");
		this.newEmail = em;
		
		log.info("- Step 09: logout after register successfully");
		registerPage.clickLogoutOnHeader(d);
	}
	
	@Test(enabled=true, dependsOnMethods = "Pre_Condition_Register")
	public void Login_04_Empty_Password() {
		log.info("Login_04_Empty_Password");
		
		log.info("- Step 01: open homepage");
		homePage.open();
		
		log.info("- Step 02: click login on header");
		loginPage.clickLoginOnHeader(d);

		log.info("- Step 03: fill new registered email");
		loginPage.typeEmailTxt(this.newEmail);
	
		log.info("- Step 04: click login button");
		loginPage.clickLoginBtn();
		//Verify
		Assert.assertTrue(loginPage.getSummaryErrMsg().contains("The credentials provided are incorrect"));
	}
	
	@Test(enabled = true, dependsOnMethods = "Pre_Condition_Register")
	public void Login_05_Wrong_Password() {
		log.info("Login_05_Wrong_Password");
		
		log.info("- Step 01: open homepage");
		homePage.open();
		
		log.info("- Step 02: click login link on header");
		loginPage.clickLoginOnHeader(d);
		
		log.info("- Step 03: type email");
		loginPage.typeEmailTxt(newEmail);
		
		log.info("- Step 04: type password");
		loginPage.typePasswordTxt("12345678");
		
		log.info("- Step 05: click login button");
		loginPage.clickLoginBtn();
		//Verify
		Assert.assertTrue(loginPage.getSummaryErrMsg().contains("The credentials provided are incorrect"));
	}
	
	@Test(enabled = true, dependsOnMethods = "Pre_Condition_Register")
	public void Login_06_Success() {
		log.info("Login_06_Success");
		log.info("- Step 01: open homepage");
		homePage.open();
		
		log.info("- Step 02: click login link on header");
		loginPage.clickLoginOnHeader(d);
		
		log.info("- Step 03: type email");
		loginPage.typeEmailTxt(newEmail);
		
		log.info("- Step 04: type pass");
		loginPage.typePasswordTxt("123456");
		
		log.info("- Step 05: click login button");
		loginPage.clickLoginBtn();
		//Verify
		Assert.assertTrue(loginPage.isLoginSuccess());
	}
	
	@AfterClass
	public void afterClass() {
		log.info("AfterClass: close browser");
		closeBrowser(d);
	}
	
}
