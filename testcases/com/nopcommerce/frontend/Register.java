package com.nopcommerce.frontend;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.EnContanst;
import commons.PageGeneratorManager;
import pageObject.HomeObject;
import pageObject.RegisterObject;
import pageUI.PatternUI;

public class Register extends BaseTest{
	
	private WebDriver d;
	
	private HomeObject homePage;
	private RegisterObject registerPage;
	
	private String newEmail = "";
	
	@Parameters("browser")
	@BeforeClass
	public void preCondition(@Optional("chrome") String b) {		
		d = getBrowserDriver(b);	
		
		homePage = PageGeneratorManager.getHomePage(d);
		registerPage = PageGeneratorManager.getRegisterPage(d);
	}
	
	@Test(enabled=true)
	public void Register_01_Empty_Data() {
		log.info("Register_01_Empty_Data");
		
		log.info("- Step 1: open homepage");
		homePage.openHomepage();
	
		log.info("- Step 2: click register link on header");
		registerPage = (RegisterObject)registerPage.clickAnchorByClassAndText(d, "header-links", "Register");
		
		log.info("- Step 3: click register button");
		registerPage.clickButtonByClassAndText(d, "buttons", "Register");
		//Verify
		Assert.assertEquals(registerPage.getFieldValidationError(d, "FirstName"), EnContanst.ERR_MSG_REG_FNAME);
		Assert.assertEquals(registerPage.getFieldValidationError(d, "LastName"), EnContanst.ERR_MSG_REG_LNAME);
		Assert.assertEquals(registerPage.getFieldValidationError(d, "Email"), EnContanst.ERR_MSG_REG_EMAIL);
		Assert.assertEquals(registerPage.getFieldValidationError(d, "Password"), EnContanst.ERR_MSG_REG_PASSWORD);
		Assert.assertEquals(registerPage.getFieldValidationError(d, "ConfirmPassword"), EnContanst.ERR_MSG_REG_CPASSWORD);
	}
	
	@Test(enabled=true)
	public void Register_02_Invalid_Email() {
		log.info("Register_02_Invalid_Email");
		
		log.info("- Step 1: open homepage");
		homePage.openHomepage();
		
		log.info("- Step 2: click register link on header");
		registerPage = (RegisterObject)registerPage.clickAnchorByClassAndText(d, "header-links", "Register");
		
		log.info("- Step 3: type firstname");
		registerPage.typeInputById(d, "FirstName", "first name");
		
		log.info("- Step 4: type lastname");
		registerPage.typeInputById(d, "LastName", "last name");
		
		log.info("- Step 5: type email");
		registerPage.typeInputById(d, "Email", "test@123@456");
		
		log.info("- Step 6: type password");
		registerPage.typeInputById(d, "Password", "123456");
		
		log.info("- Step 7: type confirmed pass");
		registerPage.typeInputById(d, "ConfirmPassword", "123456");
		
		log.info("- Step 8: click register btn");
		registerPage.clickButtonByClassAndText(d, "buttons", "Register");
		//Verify
		Assert.assertEquals(registerPage.getFieldValidationError(d, "Email"), EnContanst.ERR_MSG_REG_WRONG_EMAIL);
	}
	
	@Test(enabled=true)
	public void Register_03_Success() {
		log.info("TC: Register_03_Success");
		
		log.info("open homepage");
		homePage.openHomepage();;
		
		log.info("click register link on header");
		registerPage = (RegisterObject)registerPage.clickAnchorByClassAndText(d, "header-links", "Register");
		
		String em = "human_" + generateRandomNumber() + "@gmail.com";
		log.info("generate new email: " + em);
		
		log.info("type firstname");
		registerPage.typeInputById(d, "FirstName", "first name");
		
		log.info("type lastname");
		registerPage.typeInputById(d, "LastName", "last name");
		
		log.info("type email");
		registerPage.typeInputById(d, "Email", em);
		
		log.info("type pass");
		registerPage.typeInputById(d, "Password", "123456");
		
		log.info("type confirmed pass");
		registerPage.typeInputById(d, "ConfirmPassword", "123456");
		
		log.info("click register button");
		registerPage.clickButtonByClassAndText(d, "buttons", "Register");
		//Verify
		Assert.assertEquals(registerPage.getResultMsg(d), EnContanst.MSG_REG_SUCCESS);
		this.newEmail = em;
		
		log.info("click logout link on header");
		registerPage.clickAnchorByClassAndText(d, "header-links", "Log out");
	}
	
	@Test(enabled=true, dependsOnMethods = "Register_03_Success")
	public void Register_04_Existed_Email() {
		
		log.info("TC: Register_04_Existed_Email");
		
		log.info("open homepage");
		homePage.openHomepage();
		
		log.info("click register link on header");
		registerPage = (RegisterObject)registerPage.clickAnchorByClassAndText(d, "header-links", "Register");
		
		log.info("type firstname");
		registerPage.typeInputById(d, "FirstName", "first name");
		
		log.info("type lastname");
		registerPage.typeInputById(d, "LastName", "last name");
		
		log.info("type email");
		registerPage.typeInputById(d, "Email", this.newEmail);
		
		log.info("type pass");
		registerPage.typeInputById(d, "Password", "123456");
		
		log.info("type confirmed pass");
		registerPage.typeInputById(d, "ConfirmPassword", "123456");
		
		log.info("click register button");
		registerPage.clickButtonByClassAndText(d, "buttons", "Register");
		
		Assert.assertEquals(registerPage.getSummaryErrMsg(d), EnContanst.ERR_MSG_REG_EMAIL_EXISTS);	
	}
	
	@Test(enabled=true)
	public void Register_05_Less_6_Characters() {
		
		log.info("TC: Register_05_Less_6_Characters");
		log.info("open homepage");
		homePage.openHomepage();
		
		log.info("click register link on header");
		registerPage = (RegisterObject)registerPage.clickAnchorByClassAndText(d, "header-links", "Register");
		
		log.info("type firstname");
		registerPage.typeInputById(d, "FirstName", "first name");
		
		log.info("type lastname");
		registerPage.typeInputById(d, "LastName", "last name");
		
		log.info("type email");
		registerPage.typeInputById(d, "Email", "human_" + generateRandomNumber() + "@gmail.com");
		
		log.info("type pass");
		registerPage.typeInputById(d, "Password", "123");
		
		log.info("type confirmed pass");
		registerPage.typeInputById(d, "ConfirmPassword", "123456");
		
		log.info("click register button");
		registerPage.clickButtonByClassAndText(d, "buttons", "Register");

		//Assert.assertEquals(registerPage.get, "Password must meet the following rules: \nmust have at least 6 characters");
		Assert.assertTrue(registerPage.getFieldValidationError(d, "Password").contains("must have at least 6 characters"));
	}
	
	@Test(enabled=true)
	public void Register_06_ConfirmPass_NotMatch() {
		log.info("TC: Register_06_ConfirmPass_NotMatch");
		log.info("open homepage");
		homePage.openHomepage();
		
		log.info("click register link on header");
		registerPage = (RegisterObject)registerPage.clickAnchorByClassAndText(d, "header-links", "Register");
		
		log.info("type firstname");
		registerPage.typeInputById(d, "FirstName", "first name");
		
		log.info("type lastname");
		registerPage.typeInputById(d, "LastName", "last name");
		
		log.info("type email");
		registerPage.typeInputById(d, "Email", "human_" + generateRandomNumber() + "@gmail.com");
		
		log.info("type pass");
		registerPage.typeInputById(d, "Password", "123456");
		
		log.info("type confirmed pass");
		registerPage.typeInputById(d, "ConfirmPassword", "123444");
		
		log.info("click register button");
		registerPage.clickButtonByClassAndText(d, "buttons", "Register");
		
		Assert.assertEquals(registerPage.getFieldValidationError(d, "ConfirmPassword"), EnContanst.ERR_MSG_REG_CPASSWORD_NOTMATCH);
	}
	
	@AfterClass(enabled=true)
	public void afterClass() {
		log.info("close browser");
		quitBrowser(d);
	}
	
}
