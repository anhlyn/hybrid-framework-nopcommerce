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

import commons.BaseTest;
import commons.EnContanst;
import commons.Helper;
import commons.PageGenerator;
import pageObject.frontend.HomeObject;
import pageObject.frontend.LoginObject;
import pageObject.frontend.RegisterObject;
import pageObject.frontend.SearchObject;


public class Search extends BaseTest{
	
	WebDriver d;
	private Helper helper;
	private Faker dataFaker;
	
	private String email, password, keyword, category, manufacturer;
	
	@Parameters("browser")
	@BeforeClass
	public void Pre_Condition(@Optional("chrome") String b) {		
		d = getBrowserDriver(b);	
		helper = Helper.getHelper();
		dataFaker = new Faker();
		
		email = dataFaker.bothify("?????###@gmail.com");
		password = dataFaker.bothify("???###");
		keyword = "Macbook Pro 2050";
		
		homePage = PageGenerator.getHomePage(d);
		loginPage = PageGenerator.getLoginPage(d);
		registerPage = PageGenerator.getRegisterPage(d);
		searchPage = PageGenerator.getSearchPage(d);
	}
	
	@Test(priority=1)
	public void Register_New_Account() {
		
		log.info("TC: Register_03_Success");
		
		log.info("open homepage");
		homePage.openHomepage();
		log.info("verify open homepage");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click register link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Register");		
		registerPage.FillInformationOnRegisterForm(dataFaker.name().firstName(), dataFaker.name().lastName(), email, password, password);
		
		log.info("- verify register is successful.");
		Assert.assertEquals(helper.getResultMsg(d), EnContanst.MSG_REG_SUCCESS);
		
		log.info("click logout link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Log out");
		log.info("verify after logout successfully and then redirect to homepage");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
	}
	
	@Test(priority=2)
	public void Login_06_Success() {
		log.info("Login_01_Empty_Data");
		log.info("- Step 1: open homepage");
		homePage.openHomepage();
		log.info("Verify open homepage successfully.");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click login link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Log in");	
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.LOGINPAGE_TITLE);
		
		loginPage.FillInfoAndClickLoginBtn(email, password);
		System.out.println("email: " + email + " | pass: " + password);
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		Assert.assertTrue(helper.isLoginSuccessful(this.d));
		
	}
	
	@Test(enabled=true,priority=3)
	public void Search_01_Empty_Data() {
		helper.clickAnchorByClassAndText(this.d, "footer-upper", "Search");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("/search"));
		
		helper.clickButtonByClassAndText(this.d, "buttons", "Search");
		Assert.assertEquals(searchPage.getWarning(), EnContanst.MSG_SEARCH_EMPTY_KEYWORD);
	}
	
	@Test(enabled=true,priority=4)
	public void Search_02_Keyword_Not_Exists() {
		helper.clickAnchorByClassAndText(this.d, "footer-upper", "Search");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("/search"));
		
		searchPage.TypeKeyword(keyword);
		helper.clickButtonByClassAndText(this.d, "buttons", "Search");
		Assert.assertEquals(searchPage.getNoResult(), EnContanst.MSG_SEARCH_NOT_EXISTS);
	}
	
	@Test(enabled=true,priority=5)
	public void Search_03_By_Product_Name() {
		helper.clickAnchorByClassAndText(this.d, "footer-upper", "Search");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("/search"));
		
		keyword = "Lenovo";
		searchPage.TypeKeyword(keyword);
		helper.clickButtonByClassAndText(this.d, "buttons", "Search");
		
		Assert.assertTrue(searchPage.isProductTitleListContainByKeyword(keyword, false));
	}
	
	@Test(enabled=true,priority=6)
	public void Search_04_By_Product_Name() {
		helper.clickAnchorByClassAndText(this.d, "footer-upper", "Search");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("/search"));
		
		keyword = "Lenovo Thinkpad X1 Carbon Laptop";
		searchPage.TypeKeyword(keyword);
		helper.clickButtonByClassAndText(this.d, "buttons", "Search");
		
		Assert.assertTrue(searchPage.isProductTitleListContainByKeyword(keyword, true));
	}
	
	@Test(enabled=true,priority=7)
	public void Search_05_With_No_Category() {
		helper.clickAnchorByClassAndText(this.d, "footer-upper", "Search");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("/search"));
		
		this.keyword = "Apple Macbook Pro";
		this.category = "Computers";
		
		searchPage.TypeKeyword(keyword);
		
		searchPage.checkAdvancedSearch();
		Assert.assertTrue(searchPage.isAdvanceSearchBoxDisplayed());
		
		searchPage.selectCategory(this.category);
		searchPage.uncheckSearchInSubCate();
		
		helper.clickButtonByClassAndText(this.d, "buttons", "Search");
		
		Assert.assertEquals(searchPage.getNoResult(), EnContanst.MSG_SEARCH_NOT_EXISTS);
	}
	
	@Test(enabled=true,priority=8)
	public void Search_06_With_Category() {
		helper.clickAnchorByClassAndText(this.d, "footer-upper", "Search");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("/search"));
		
		this.keyword = "Apple Macbook Pro";
		this.category = "Computers";
		
		searchPage.TypeKeyword(keyword);
		
		searchPage.checkAdvancedSearch();
		Assert.assertTrue(searchPage.isAdvanceSearchBoxDisplayed());
		
		searchPage.selectCategory(this.category);
		searchPage.checkSearchInSubCate();
		
		helper.clickButtonByClassAndText(this.d, "buttons", "Search");
		
		Assert.assertTrue(searchPage.isProductTitleListContainByKeyword(this.keyword, false));
	}
	
	@Test(enabled=true,priority=8)
	public void Search_07_With_InCorrect_Manufacturer() {
		helper.clickAnchorByClassAndText(this.d, "footer-upper", "Search");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("/search"));
		
		this.keyword = "Apple Macbook Pro";
		this.category = "Computers";
		this.manufacturer = "HP";
		
		searchPage.TypeKeyword(keyword);
		
		searchPage.checkAdvancedSearch();
		Assert.assertTrue(searchPage.isAdvanceSearchBoxDisplayed());
		
		searchPage.selectCategory(this.category);
		searchPage.checkSearchInSubCate();
		
		searchPage.selectManufacturer(this.manufacturer);
		
		helper.clickButtonByClassAndText(this.d, "buttons", "Search");
		
		Assert.assertEquals(searchPage.getNoResult(), EnContanst.MSG_SEARCH_NOT_EXISTS);
	}
	
	@Test(enabled=true,priority=9)
	public void Search_08_With_Correct_Manufacturer() {
		helper.clickAnchorByClassAndText(this.d, "footer-upper", "Search");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("/search"));
		
		this.keyword = "Apple Macbook Pro";
		this.category = "Computers";
		this.manufacturer = "Apple";
		
		searchPage.TypeKeyword(keyword);
		
		searchPage.checkAdvancedSearch();
		Assert.assertTrue(searchPage.isAdvanceSearchBoxDisplayed());
		
		searchPage.selectCategory(this.category);
		searchPage.checkSearchInSubCate();
		
		searchPage.selectManufacturer(this.manufacturer);
		
		helper.clickButtonByClassAndText(this.d, "buttons", "Search");
		
		Assert.assertTrue(searchPage.isProductTitleListContainByKeyword(this.keyword, false));
	}
	
	 @AfterClass(enabled=true, alwaysRun=true)
	 public void afterClass() {
		log.info("close browser");
		quitBrowser(d);
	}
	 
	private HomeObject homePage;
	private LoginObject loginPage;
	private RegisterObject registerPage;
	private SearchObject searchPage;
	
}
