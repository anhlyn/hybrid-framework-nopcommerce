package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.BlogObject;
import pageObject.HomeObject;
import pageObject.MyAccountObject;
import pageObject.RegisterObject;
import pageObject.SitemapObject;

public class Apply_Dynamic_Locators extends BaseTest{
	
	private HomeObject homePage;
	private RegisterObject registerPage;
	private MyAccountObject myAccountPage;
	private SitemapObject sitemapPage;
	private BlogObject blogPage;
	
	private String invalidEmail = "linh@abc@123";
	private String invalidPassword = "1";
	
	private String fname = "first name";
	private String lname = "last name";
	private String email = "";
	private String password = "123456";
	private String cpassword = "654321";
	
	private WebDriver d;
	
	
	@Parameters("browser")
	@BeforeClass
	public void preCondition(String b) {
		
		d = getBrowserDriver(b);
		
		//registerPage = new RegisterObject(d);
		//homePage = new HomeObject(d);		
		//registerPage = PageFactory.initElements(d, RegisterObject.class);
		//homePage = PageFactory.initElements(d, HomeObject.class);
		
		//Apply PageGeneratorManager
		registerPage = PageGeneratorManager.getRegisterPage(d);
		homePage = PageGeneratorManager.getHomePage(d);
		email = generateRandomNumber();
		System.out.println("NEW EMAIL: " + email);		
		homePage.loadHomePage();
	}
	
	@Test(enabled = true)
	public void Switch_pages() {
		//Home -> My Account
		myAccountPage = homePage.clickMyAccountLinkOnFooter(d);
		
		//My Account -> Sitemap
		sitemapPage = myAccountPage.clickSitemapLinkOnFooter(d);
		
		//Sitemap -> blog
		blogPage = sitemapPage.clickBlogLinkOnFooter(d);
	}
	
	
	@Test(enabled=false)
	public void Register_01_EmptyData() {
		System.out.println("Step 1: click register navigation.");
		homePage.clickRegisterNav();
		Assert.assertEquals(homePage.getH1Title(), "Register");
		
		System.out.println("Step 2: click register button.");
		registerPage.clickRegisterBtn();
		Assert.assertEquals(registerPage.getFirstNameErrorMsg(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMsg(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMsg(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMsg(), "Password is required.");
		Assert.assertEquals(registerPage.getCPasswordErrorMsg(), "Password is required.");
	}
	
	@Test(enabled=false)
	public void Register_02_InvalidEmail() {
		homePage.clickRegisterNav();
		Assert.assertEquals(homePage.getH1Title(), "Register");
		
		registerPage.typeFirstnameTxt(fname);
		registerPage.typeLastnameTxt(lname);
		registerPage.typeEmailTxt(invalidEmail);
		registerPage.typePasswordTxt(password);
		registerPage.typeCPasswordTxt(password);
		registerPage.clickRegisterBtn();
		
		Assert.assertEquals(registerPage.getEmailErrorMsg(), "Wrong email");
	}
	
	@Test(enabled=false)
	public void Register_03_Success() {
		homePage.clickRegisterNav();
		Assert.assertEquals(homePage.getH1Title(), "Register");
		
		registerPage.typeFirstnameTxt(fname);
		registerPage.typeLastnameTxt(lname);
		registerPage.typeEmailTxt(email);
		registerPage.typePasswordTxt(password);
		registerPage.typeCPasswordTxt(password);
		registerPage.clickRegisterBtn();
		
		Assert.assertEquals(registerPage.getSuccessMsg(), "Your registration completed");
		homePage.clickLogOutNav();
	}
	
	@Test(enabled=false, dependsOnMethods = "Register_03_Success")
	public void Register_04_ExistedEmail() {
		homePage.clickRegisterNav();
		Assert.assertEquals(homePage.getH1Title(), "Register");
		
		registerPage.typeFirstnameTxt(fname);
		registerPage.typeLastnameTxt(lname);
		registerPage.typeEmailTxt(email);
		registerPage.typePasswordTxt(password);
		registerPage.typeCPasswordTxt(password);
		registerPage.clickRegisterBtn();
		
		Assert.assertEquals(registerPage.getSummaryErrorMsg(), "The specified email already exists");
	}
	
	@Test(enabled=false)
	public void Register_05_Less_6_Letters_Password() {
		homePage.clickRegisterNav();
		Assert.assertEquals(homePage.getH1Title(), "Register");
		
		registerPage.typeFirstnameTxt(fname);
		registerPage.typeLastnameTxt(lname);
		registerPage.typeEmailTxt(email);
		registerPage.typePasswordTxt(invalidPassword);
		registerPage.typeCPasswordTxt(password);
		registerPage.clickRegisterBtn();
		
		String expectedMsg = "Password must meet the following rules:\nmust have at least 6 characters";
		Assert.assertEquals(registerPage.getPasswordErrorMsg(), expectedMsg);
		
	}
	
	@Test(enabled=false)
	public void Register_06_Pass_CPass_Not_Match() {
		homePage.clickRegisterNav();
		Assert.assertEquals(homePage.getH1Title(), "Register");
		
		registerPage.typeFirstnameTxt(fname);
		registerPage.typeLastnameTxt(lname);
		registerPage.typeEmailTxt(email);
		registerPage.typePasswordTxt(password);
		registerPage.typeCPasswordTxt(cpassword);
		registerPage.clickRegisterBtn();
		
		Assert.assertEquals(registerPage.getCPasswordErrorMsg(), "The password and confirmation password do not match.");
	}
	
	@AfterClass
	public void afterClass() {
		registerPage.closeFocusBrowser(d);
	}
	
}
