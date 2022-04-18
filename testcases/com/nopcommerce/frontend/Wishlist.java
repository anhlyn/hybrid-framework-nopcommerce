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

import commons.BaseTest;
import commons.EnContanst;
import commons.Helper;
import commons.PageGenerator;
import pageObject.CompareProductObject;
import pageObject.DetailObject;
import pageObject.HomeObject;
import pageObject.LoginObject;
import pageObject.RegisterObject;
import pageObject.WishlistObject;


public class Wishlist extends BaseTest{
	
	WebDriver d;
	private Helper helper;
	private DataTest datatest;
	private DataTest.RegisteredAccount registeredAcc;
	private String productName = "Asus N551JK-XO076H Laptop";
	
	private String comparedProduct1 = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
	private String comparedProduct2 = "Lenovo Thinkpad X1 Carbon Laptop";
	
	private String recentlyViewProduct1 = "Apple MacBook Pro 13-inch";
	private String recentlyViewProduct2 = "Asus N551JK-XO076H Laptop";
	private String recentlyViewProduct3 = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
	private String recentlyViewProduct4 = "HP Spectre XT Pro UltraBook";
	private String recentlyViewProduct5 = "Lenovo Thinkpad X1 Carbon Laptop";
	
	@Parameters("browser")
	@BeforeClass
	public void Pre_Condition(@Optional("chrome") String b) {		
		d = getBrowserDriver(b);	
		helper = Helper.getHelper();
		
		//init data
		datatest = new DataTest();
		registeredAcc = datatest.new RegisteredAccount();
		
		homePage = PageGenerator.getHomePage(d);
		detailPage = PageGenerator.getDetailPage(d);
		wishlistPage = PageGenerator.getWishlistPage(d);
		loginPage = PageGenerator.getLoginPage(d);
		registerPage = PageGenerator.getRegisterPage(d);
		comparePage = PageGenerator.getComparePage(d);
	}
	
	@Test(enabled=true,priority=1)
	public void Register_New_Account() {
		
		log.info("Pre-Condition: Register_New_Account");
		
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
	
	@Test(enabled = true, dependsOnMethods = "Register_New_Account", priority=2)
	public void Login_06_Success() {
		log.info("Login_01_Empty_Data");
		log.info("- Step 1: open homepage");
		homePage.openHomepage();
		log.info("Verify open homepage successfully.");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click login link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Log in");	
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.LOGINPAGE_TITLE);
		
		loginPage.FillInfoAndClickLoginBtn(registeredAcc.email, registeredAcc.password);
		System.out.println("email: " + registeredAcc.email + " | pass: " + registeredAcc.password);
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		Assert.assertTrue(helper.isLoginSuccessful(this.d));
		
	}
	
	@Test(enabled=true,priority=3, dependsOnMethods="Login_06_Success")
	public void Empty_Wishlist() {
		homePage.openHomepage();
		helper.clickAnchorByClassAndText(this.d, "header-links", "Wishlist");
		if(helper.isTableNotEmpty(this.d)) {
			helper.EmptyTheList(this.d);
		}
	}
	
	@Test(enabled=true, priority=4, dependsOnMethods="Login_06_Success")
	public void TC_01_Wishlist_Add() {
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		//click on any product link on homepage
		helper.HoverParentAndClickSubMenu(d, "Computers ", "Notebooks ");
		helper.clickAnchorByClassAndText(this.d, "product-item", this.productName);
		Assert.assertTrue(detailPage.isDetailProductPageLoaded());
		
		//click <Add to wishlist> on detail page.
		helper.clickButtonByClassAndText(this.d, "add-to-wishlist", "Add to wishlist");
		helper.closeBarNoti(this.d);

		helper.clickAnchorByClassAndText(this.d, "header-links", "Wishlist");
		Assert.assertTrue(helper.isProductNameInTable(this.d, this.productName));	
		
		//click wishlist share info link
		wishlistPage.clickShareInfo();
		Assert.assertEquals(helper.getH1Title(this.d), String.format("%s %s %s", EnContanst.WISHLIST_H1_TITLE_NO_LOGIN, registeredAcc.firstName, registeredAcc.lastName));
	}
	
	@Test(enabled=true, priority=5, dependsOnMethods="TC_01_Wishlist_Add")
	public void TC_02_Wishlist_Add_To_Cart_From_Wishlist_Page() {
		//reload homepage
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		//click wishlist on header
		helper.clickAnchorByClassAndText(this.d, "header-links", "Wishlist");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("wishlist"));
		
		//check chk theo product name
		helper.checkItemByProductName(this.d, this.productName);
		//click button <Add to cart>
		helper.clickButtonByClassAndText(this.d, "buttons", "Add to cart");
		//Verify redirect to shopping cart successfully
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("/cart"));
		//Verify if product name is in order table
		Assert.assertTrue(helper.isProductNameInTable(this.d, this.productName));
		
		//click wishlist on header and check if product name is remove from list.
		helper.clickAnchorByClassAndText(this.d, "header-links", "Wishlist");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("wishlist"));
		Assert.assertFalse(helper.isProductNameInTable(this.d, this.productName));
	}
	
	@Test(enabled=true, priority=6, dependsOnMethods="TC_01_Wishlist_Add")
	public void TC_03_Wishlist_Remove() {
		//reload homepage
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		//click wishlist on header
		helper.clickAnchorByClassAndText(this.d, "header-links", "Wishlist");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("wishlist"));
		
		helper.removeItemByProductName(this.d, this.productName);
		//Verify message: The wishlist is empty!
		Assert.assertEquals(helper.getNoDataMsgBelowTable(this.d).trim(), EnContanst.MSG_WISHLIST_EMPTY.trim());
		//Verify product is not exists in wishlist.
		Assert.assertFalse(helper.isProductNameInTable(this.d ,this.productName));
	}
	
	@Test(enabled=true, priority=7, invocationCount=2, dependsOnMethods="Login_06_Success")
	public void Pre_Condition_Add_Product_To_CompareList() {
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		helper.HoverParentAndClickSubMenu(d, "Computers ", "Notebooks ");	
		Assert.assertTrue(helper.waitUntilPageLoaded(this.d));
		
		String txtBreadScrum = helper.getBreadScrumText(d);		
		Assert.assertTrue(txtBreadScrum.contains("Computers ".trim()));
		Assert.assertTrue(txtBreadScrum.contains("Notebooks ".trim()));
		
		//Add first product to comparedlist
		homePage.addToComparelistByProductName(this.comparedProduct1);
		Assert.assertEquals(helper.getBarNotiSuccessMsg(this.d), EnContanst.MSG_COMPARE_SUCCESS);
		
		//Add second product to comparedlist
		homePage.addToComparelistByProductName(this.comparedProduct2);
		Assert.assertEquals(helper.getBarNotiSuccessMsg(this.d), EnContanst.MSG_COMPARE_SUCCESS);
	}
	
	@Test(enabled=true, priority=8, dependsOnMethods="Pre_Condition_Add_Product_To_CompareList")
	public void TC_04_CompareList() {
		//reload homepage
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		//click compare list on footer
		helper.clickAnchorByClassAndText(this.d, "footer-upper", "Compare products list");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("compareproducts"));
		
		//
		Assert.assertEquals(comparePage.getProductNameByText(this.comparedProduct1), this.comparedProduct1);
		Assert.assertEquals(comparePage.getProductNameByText(this.comparedProduct2), this.comparedProduct2);
		
		helper.clickAnchorByClassAndText(this.d, "compare-products-page", "Clear list");
		Assert.assertEquals(helper.getNoDataMsgBelowTable(this.d).trim(), EnContanst.COMPARELIST_EMPTY);
		
		Assert.assertNotEquals(comparePage.getProductNameByText(this.comparedProduct1), this.comparedProduct1);
		Assert.assertNotEquals(comparePage.getProductNameByText(this.comparedProduct1), this.comparedProduct2);
	}
	
	@Test(enabled=true, priority=9, dependsOnMethods="Login_06_Success")
	public void TC_01_Recently_View_Product() {
		//reload homepage
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);

		View_Detail_Page("Computers ", "Notebooks ", this.recentlyViewProduct1);
		View_Detail_Page("Computers ", "Notebooks ", this.recentlyViewProduct2);
		View_Detail_Page("Computers ", "Notebooks ", this.recentlyViewProduct3);
		View_Detail_Page("Computers ", "Notebooks ", this.recentlyViewProduct4);
		View_Detail_Page("Computers ", "Notebooks ", this.recentlyViewProduct5);
		
		helper.clickAnchorByClassAndText(this.d, "footer-upper", "Recently viewed products");
		Assert.assertTrue(helper.isProductNameOnProductGrid(this.d, this.recentlyViewProduct3));
		Assert.assertTrue(helper.isProductNameOnProductGrid(this.d, this.recentlyViewProduct4));
		Assert.assertTrue(helper.isProductNameOnProductGrid(this.d, this.recentlyViewProduct5));
	}
	
	private void View_Detail_Page(String parentMenu, String childMenu, String pn) {
		helper.HoverParentAndClickSubMenu(d, parentMenu, childMenu);	
		Assert.assertTrue(helper.waitUntilPageLoaded(this.d));
		
		helper.clickAnchorByClassAndText(this.d, "product-item", pn);
		Assert.assertTrue(detailPage.isDetailProductPageLoaded());
	}
	
	 @AfterClass(enabled=true, alwaysRun=true)
	 public void afterClass() {
		log.info("close browser");
		quitBrowser(d);
	}
	 
	private HomeObject homePage;
	private DetailObject detailPage;
	private WishlistObject wishlistPage;
	private RegisterObject registerPage;
	private LoginObject loginPage;
	private CompareProductObject comparePage;
	
}
