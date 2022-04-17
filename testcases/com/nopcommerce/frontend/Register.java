package com.nopcommerce.frontend;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import commons.BaseTest;
import commons.EnContanst;
import commons.Helper;
import commons.PageGenerator;
import pageObject.HomeObject;
import pageObject.RegisterObject;

public class Register extends BaseTest{
	
	private WebDriver d;
	private Faker dataFaker;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	
	@BeforeClass
	@Parameters("browser")
	public void preCondition(@Optional("chrome") String b) {		
		d = getBrowserDriver(b);
		dataFaker = new Faker();
		helper = Helper.getHelper();
		
		firstName = dataFaker.name().firstName();
		lastName = dataFaker.name().lastName();
		email = dataFaker.numerify("tester####@gmail.com");
		password = confirmPassword = dataFaker.bothify("###???");
		
		homePage = PageGenerator.getHomePage(d);
		registerPage = PageGenerator.getRegisterPage(d);
	}
	
	@Test(enabled=true)
	public void Register_01_Empty_Data() {
		log.info("Register_01_Empty_Data");
		
		log.info("- Step 1: open homepage");
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
	
		log.info("- Step 2: click register link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Register");
		
		log.info("- Step 3: click register button");
		helper.clickButtonByClassAndText(d, "buttons", "Register");
		
		log.info("- Verify field validation error.");
		Assert.assertEquals(helper.getFieldValidationError(d, "FirstName"), EnContanst.ERR_MSG_REG_FNAME);
		Assert.assertEquals(helper.getFieldValidationError(d, "LastName"), EnContanst.ERR_MSG_REG_LNAME);
		Assert.assertEquals(helper.getFieldValidationError(d, "Email"), EnContanst.ERR_MSG_REG_EMAIL);
		Assert.assertEquals(helper.getFieldValidationError(d, "Password"), EnContanst.ERR_MSG_REG_PASSWORD);
		Assert.assertEquals(helper.getFieldValidationError(d, "ConfirmPassword"), EnContanst.ERR_MSG_REG_CPASSWORD);
	}
	
	@Test(enabled=true)
	public void Register_02_Invalid_Email() {
		log.info("Register_02_Invalid_Email");
		
		log.info("- Step 1: open homepage");
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("- Step 2: click register link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Register");	
		registerPage.FillInformationOnRegisterForm(firstName, lastName, dataFaker.bothify("???###@???@com"), password, confirmPassword);
	
		log.info("- Verify Wrong email validation error.");
		Assert.assertEquals(helper.getFieldValidationError(d, "Email"), EnContanst.ERR_MSG_REG_WRONG_EMAIL);
	}
	
	@Test(enabled=true)
	public void Register_03_Success() {
		log.info("TC: Register_03_Success");
		
		log.info("open homepage");
		homePage.openHomepage();
		log.info("verify open homepage");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click register link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Register");	
		registerPage.FillInformationOnRegisterForm(firstName, lastName, email, password, confirmPassword);
		
		log.info("- verify register is successful.");
		Assert.assertEquals(helper.getResultMsg(d), EnContanst.MSG_REG_SUCCESS);
		
		log.info("click logout link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Log out");
		log.info("verify after logout successfully and then redirect to homepage");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
	}
	
	@Test(enabled=true, dependsOnMethods = "Register_03_Success")
	public void Register_04_Existed_Email() {
		
		log.info("TC: Register_04_Existed_Email");
		
		log.info("open homepage");
		homePage.openHomepage();
		log.info("verify open homepage");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click register link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Register");
		registerPage.FillInformationOnRegisterForm(firstName, lastName, email, password, confirmPassword);
		
		log.info("Verify validation email exists.");
		Assert.assertEquals(helper.getSummaryErrMsg(d), EnContanst.ERR_MSG_REG_EMAIL_EXISTS);	
	}
	
	@Test(enabled=true)
	public void Register_05_Less_6_Characters() {
		
		log.info("TC: Register_05_Less_6_Characters");
		log.info("open homepage");
		homePage.openHomepage();
		log.info("verify open homepage");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click register link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Register");
		registerPage.FillInformationOnRegisterForm(firstName, lastName, dataFaker.bothify("?????###@gmail.com"), dataFaker.letterify("????"), confirmPassword);

		log.info("Verify password is less than 6 characters.");
		Assert.assertTrue(helper.getFieldValidationError(d, "Password").contains(EnContanst.ERR_PARTIAL_MSG_REG_PASSWORD_LESS_6_CHARACTERS));
	}
	
	@Test(enabled=true)
	public void Register_06_ConfirmPass_NotMatch() {
		log.info("TC: Register_06_ConfirmPass_NotMatch");
		log.info("open homepage");
		homePage.openHomepage();
		log.info("verify open homepage");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click register link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Register");
		registerPage.FillInformationOnRegisterForm(firstName, lastName, dataFaker.bothify("?????###@gmail.com"), dataFaker.letterify("??????"), confirmPassword);
		
		log.info("verify confirm password does not match.");
		Assert.assertEquals(helper.getFieldValidationError(d, "ConfirmPassword"), EnContanst.ERR_MSG_REG_CPASSWORD_NOTMATCH);
	}
	
	
	
	@AfterClass(enabled=true, alwaysRun=true)
	public void afterClass() {
		log.info("close browser");
		quitBrowser(d);
	}
	
	private HomeObject homePage;
	private RegisterObject registerPage;
	private Helper helper;
	
}
