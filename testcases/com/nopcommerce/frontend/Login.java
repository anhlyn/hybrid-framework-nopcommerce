package com.nopcommerce.frontend;

//import org.apache.commons.logging.LogFactory;
//import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.nopcommerce.frontend.DataTest.RegisteredAccount;

import commons.BaseTest;
import commons.EnContanst;
import commons.Helper;
import commons.PageGenerator;
import pageObject.frontend.HomeObject;
import pageObject.frontend.LoginObject;
import pageObject.frontend.RegisterObject;


public class Login extends BaseTest{
	
	WebDriver d;
	private Helper helper;
	private Faker dataFaker;
	
	private DataTest dataTest;
	private RegisteredAccount registeredAcc;

	
	@Parameters("browser")
	@BeforeClass
	public void preCondition(@Optional("chrome") String b) {		
		d = getBrowserDriver(b);	
		helper = Helper.getHelper();
		dataFaker = new Faker();
		
		dataTest = new DataTest();
		registeredAcc = dataTest.new RegisteredAccount();
		
		homePage = PageGenerator.getHomePage(this.d);
		loginPage = PageGenerator.getLoginPage(this.d);
		registerPage = PageGenerator.getRegisterPage(this.d);
	}
	
	@Test(enabled=true)
	public void Register_New_Account() {
		
		log.info("TC: Register_03_Success");
		
		log.info("open homepage");
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click register link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Register");	
		registerPage.FillInformationOnRegisterForm(registeredAcc.firstName, registeredAcc.lastName, registeredAcc.email, registeredAcc.password, registeredAcc.password);
		
		log.info("- verify register is successful.");
		Assert.assertEquals(helper.getResultMsg(d), EnContanst.MSG_REG_SUCCESS);
		
		log.info("click logout link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Log out");
		log.info("verify after logout successfully and then redirect to homepage");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
	}

	@Test(enabled=true)
	public void Login_01_Empty_Data() {
		log.info("Login_01_Empty_Data");
		log.info("- Step 1: open homepage");
		homePage.openHomepage();
		log.info("Verify open homepage successfully.");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click login link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Log in");	
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.LOGINPAGE_TITLE);
		
		loginPage.FillInfoAndClickLoginBtn("", "");
		
		log.info("Verify login with empty data.");
		Assert.assertEquals(helper.getFieldValidationError(d, "Email"), EnContanst.ERR_MSG_LOGIN_EMAIL);	
	}
	
	@Test(enabled=true)
	public void Login_02_Invalid_Email() {
		log.info("Login_01_Empty_Data");
		log.info("- Step 1: open homepage");
		homePage.openHomepage();
		log.info("Verify open homepage successfully.");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click login link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Log in");	
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.LOGINPAGE_TITLE);
		
		loginPage.FillInfoAndClickLoginBtn(dataFaker.bothify("????##@???@??##"), this.registeredAcc.password);
		
		log.info("Verify after login with invalid email.");
		Assert.assertEquals(helper.getFieldValidationError(d, "Email"), EnContanst.ERR_MSG_LOGIN_WRONG_EMAIL);
	}
	
	@Test(enabled=true)
	public void Login_03_Not_Registered_Email() {
		log.info("Login_01_Empty_Data");
		log.info("- Step 1: open homepage");
		homePage.openHomepage();
		log.info("Verify open homepage successfully.");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click login link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Log in");	
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.LOGINPAGE_TITLE);

		loginPage.FillInfoAndClickLoginBtn(dataFaker.bothify("????###@????.com"), this.registeredAcc.password);
		
		log.info("Verify login with not registered email.");
		Assert.assertTrue(helper.getSummaryErrMsg(this.d).contains(EnContanst.ERR_MSG_LOGIN_NOT_REGISTERED_EMAIL));
	}
	
	@Test(enabled=true, dependsOnMethods = "Register_New_Account")
	public void Login_04_Empty_Password() {
		log.info("Login_01_Empty_Data");
		log.info("- Step 1: open homepage");
		homePage.openHomepage();
		log.info("Verify open homepage successfully.");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click login link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Log in");	
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.LOGINPAGE_TITLE);
		
		loginPage.FillInfoAndClickLoginBtn(this.registeredAcc.email, "");
		
		Assert.assertTrue(helper.getSummaryErrMsg(this.d).contains(EnContanst.ERR_MSG_LOGIN_WITH_EMPTY_PASSWORD));
	}
	
	@Test(enabled = true, dependsOnMethods = "Register_New_Account")
	public void Login_05_Wrong_Password() {
		log.info("Login_01_Empty_Data");
		log.info("- Step 1: open homepage");
		homePage.openHomepage();
		log.info("Verify open homepage successfully.");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click login link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Log in");	
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.LOGINPAGE_TITLE);
		
		loginPage.FillInfoAndClickLoginBtn(this.registeredAcc.email, dataFaker.bothify("????####"));
		
		Assert.assertTrue(helper.getSummaryErrMsg(this.d).contains(EnContanst.ERR_MSG_LOGIN_WITH_EMPTY_PASSWORD));

	}
	
	@Test(enabled = true, dependsOnMethods = "Register_New_Account")
	public void Login_06_Success() {
		log.info("Login_01_Empty_Data");
		log.info("- Step 1: open homepage");
		homePage.openHomepage();
		log.info("Verify open homepage successfully.");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click login link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Log in");	
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.LOGINPAGE_TITLE);
		
		loginPage.FillInfoAndClickLoginBtn(this.registeredAcc.email, this.registeredAcc.password);
		System.out.println("email: " + this.registeredAcc.email + " | pass: " + this.registeredAcc.password);
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		Assert.assertTrue(helper.isLoginSuccessful(this.d));
		
	}
	
	 @AfterClass(enabled=true, alwaysRun=true)
	 public void afterClass() {
		log.info("close browser");
		quitBrowser(d);
	}
	 
	private HomeObject homePage;
	private LoginObject loginPage;
	private RegisterObject registerPage;
	
}
