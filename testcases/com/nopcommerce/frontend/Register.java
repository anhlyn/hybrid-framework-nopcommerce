package com.nopcommerce.frontend;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.HomeObject;
import pageObject.RegisterObject;

public class Register extends BaseTest{
	
	private WebDriver d;
	
	private HomeObject homePage;
	private RegisterObject registerPage;
	
	private String newEmail = "";
	
	@Parameters("browser")
	@BeforeClass
	public void preCondition(String b) {		
		d = getBrowserDriver(b);	
		
		//khoi tao pages
		homePage = new HomeObject(d);
		registerPage = new RegisterObject(d);
	}
	
	@Test
	public void Register_01_Empty_Data() {
		log.info("Register_01_Empty_Data");
		
		log.info("- Step 1: open homepage");
		homePage.open();
	
		log.info("- Step 2: click register link on header");
		registerPage = registerPage.clickRegisterLinkOnHeader(d);
		
		log.info("- Step 3: click register button");
		registerPage.clickRegisterBtn();
		//Verify
		Assert.assertEquals(registerPage.getFirstNameErrorMsg(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMsg(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMsg(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMsg(), "Password is required.");
		Assert.assertEquals(registerPage.getCPasswordErrorMsg(), "Password is required.");
	}
	
	@Test
	public void Register_02_Invalid_Email() {
		log.info("Register_02_Invalid_Email");
		
		log.info("- Step 1: open homepage");
		homePage.open();
		
		log.info("- Step 2: click register link on header");
		registerPage = registerPage.clickRegisterLinkOnHeader(d);
		
		log.info("- Step 3: type firstname");
		registerPage.typeFirstnameTxt("first name");
		
		log.info("- Step 4: type lastname");
		registerPage.typeLastnameTxt("last name");
		
		log.info("- Step 5: type email");
		registerPage.typeEmailTxt("test@123@456");
		
		log.info("- Step 6: type password");
		registerPage.typePasswordTxt("123456");
		
		log.info("- Step 7: type confirmed pass");
		registerPage.typeCPasswordTxt("123456");
		
		log.info("- Step 8: click register btn");
		registerPage.clickRegisterBtn();
		//Verify
		Assert.assertEquals(registerPage.getEmailErrorMsg(), "Wrong email");
	}
	
	@Test
	public void Register_03_Success() {
		log.info("TC: Register_03_Success");
		
		log.info("open homepage");
		homePage.open();
		
		log.info("click register link on header");
		registerPage = registerPage.clickRegisterLinkOnHeader(d);
		
		String em = "human_" + generateRandomNumber() + "@gmail.com";
		log.info("generate new email: " + em);
		
		log.info("type firstname");
		registerPage.typeFirstnameTxt("first name");
		
		log.info("type lastname");
		registerPage.typeLastnameTxt("last name");
		
		log.info("type email");
		registerPage.typeEmailTxt(em);
		
		log.info("type pass");
		registerPage.typePasswordTxt("123456");
		
		log.info("type confirmed pass");
		registerPage.typeCPasswordTxt("123456");
		
		log.info("click register button");
		registerPage.clickRegisterBtn();
		//Verify
		Assert.assertEquals(registerPage.getSuccessMsg(), "Your registration completed");
		this.newEmail = em;
		
		log.info("click logout link on header");
		registerPage.clickLogoutOnHeader(d);
	}
	
	@Test(dependsOnMethods = "Register_03_Success")
	public void Register_04_Existed_Email() {
		
		log.info("TC: Register_04_Existed_Email");
		
		log.info("open homepage");
		homePage.open();
		
		log.info("click register link on header");
		registerPage = registerPage.clickRegisterLinkOnHeader(d);
		
		log.info("type first name");
		registerPage.typeFirstnameTxt("first name");
		
		log.info("type last name");
		registerPage.typeLastnameTxt("last name");
		
		log.info("type email");
		registerPage.typeEmailTxt(this.newEmail);
		
		log.info("type pass");
		registerPage.typePasswordTxt("123456");
		
		log.info("type confirmed pass");
		registerPage.typeCPasswordTxt("123456");
		
		log.info("click register");
		registerPage.clickRegisterBtn();
		//Verify
		Assert.assertEquals(registerPage.getSummaryErrorMsg(), "The specified email already exists");	
	}
	
	@Test
	public void Register_05_Less_6_Characters() {
		
		log.info("TC: Register_05_Less_6_Characters");
		log.info("open homepage");
		homePage.open();
		
		log.info("click register link on header");
		registerPage = registerPage.clickRegisterLinkOnHeader(d);
		
		log.info("type first name");
		registerPage.typeFirstnameTxt("first name");
		
		log.info("type last name");
		registerPage.typeLastnameTxt("last name");
		
		log.info("type email");
		registerPage.typeEmailTxt("human_" + generateRandomNumber() + "@gmail.com");
		
		log.info("type pass");
		registerPage.typePasswordTxt("123");
		
		log.info("type confirmed pass");
		registerPage.typeCPasswordTxt("123456");
		
		log.info("click register button");
		registerPage.clickRegisterBtn();

		//Assert.assertEquals(registerPage.getPasswordErrorMsg(), "Password must meet the following rules: \nmust have at least 6 characters");
		Assert.assertTrue(registerPage.getPasswordErrorMsg().contains("must have at least 6 characters"));
	}
	
	@Test
	public void Register_06_ConfirmPass_NotMatch() {
		log.info("TC: Register_06_ConfirmPass_NotMatch");
		log.info("open homepage");
		homePage.open();
		
		log.info("click register link on header");
		registerPage = registerPage.clickRegisterLinkOnHeader(d);
		
		log.info("type first name");
		registerPage.typeFirstnameTxt("first name");
		
		log.info("type last name");
		registerPage.typeLastnameTxt("last name");
		
		log.info("type email");
		registerPage.typeEmailTxt("human_" + generateRandomNumber() + "@gmail.com");
		
		log.info("type password");
		registerPage.typePasswordTxt("123456");
		
		log.info("type confirmed pass");
		registerPage.typeCPasswordTxt("654321");
		
		log.info("click register button");
		registerPage.clickRegisterBtn();
		//Verify
		Assert.assertEquals(registerPage.getCPasswordErrorMsg(), "The password and confirmation password do not match.");
	}
	
	@AfterClass
	public void afterClass() {
		log.info("close browser");
		closeBrowser(d);
	}
	
}
