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
import pageObject.DetailObject;
import pageObject.HomeObject;
import pageObject.WishlistObject;


public class Wishlist extends BaseTest{
	
	WebDriver d;
	private Helper helper;
	private String productName = "Asus N551JK-XO076H Laptop";
	
	@Parameters("browser")
	@BeforeClass
	public void Pre_Condition(@Optional("chrome") String b) {		
		d = getBrowserDriver(b);	
		helper = Helper.getHelper();
		
		homePage = PageGenerator.getHomePage(d);
		detailPage = PageGenerator.getDetailPage(d);
		wishlistPage = PageGenerator.getWishlistPage(d);
	}
	
	@Test(enabled=true,priority=1)
	public void Empty_Wishlist() {
		homePage.openHomepage();
		helper.clickAnchorByClassAndText(this.d, "header-links", "Wishlist");
		if(wishlistPage.isNotEmpty()) {
			wishlistPage.EmptyTheList();
		}
	}
	
	@Test(enabled=true, priority=2)
	public void Wishlist_01_Add() {
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		//click on any product link on homepage
		helper.HoverParentAndClickSubMenu(d, "Computers ", "Notebooks ");
		helper.clickAnchorByClassAndText(this.d, "product-item", this.productName);
		Assert.assertTrue(detailPage.isDetailProductPageLoaded());
		
		//click <Add to wishlist> on detail page.
		helper.clickButtonByClassAndText(this.d, "add-to-wishlist", "Add to wishlist");
		//Assert.assertEquals(detailPage.getAddToWishlistSuccessMsg(), EnContanst.MSG_WISHLIST_SUCCESS);
		helper.closeBarNoti(this.d);
		//if(wishlistPage.isBarNotiSuccessAutoClosed()) {
			helper.clickAnchorByClassAndText(this.d, "header-links", "Wishlist");
			Assert.assertTrue(wishlistPage.isAddToWishlistSuccess(this.productName));
		//}
		
		
		//click wishlist share info link
		wishlistPage.clickShareInfo();
		Assert.assertEquals(helper.getH1Title(this.d), EnContanst.WISHLIST_H1_TITLE_NO_LOGIN);
	}
	
	private void Add_To_Wishlist_Pre_Condition(String parentMenu, String childMenu, String productName) {
		helper.HoverParentAndClickSubMenu(d, parentMenu, childMenu);	
		Assert.assertTrue(helper.waitUntilPageLoaded(this.d));
		
		String txtBreadScrum = helper.getBreadScrumText(d);		
		Assert.assertTrue(txtBreadScrum.contains(parentMenu.trim()));
		Assert.assertTrue(txtBreadScrum.contains(childMenu.trim()));
		
		homePage.addToWishlistByProductName(productName);
		Assert.assertTrue(helper.waitUntilPageLoaded(this.d));
		
		//detailPage.clickAddToWishlist();
		//Assert.assertTrue(helper.waitUntilPageLoaded(this.d));
		//Assert.assertEquals(detailPage.getAddToWishlistSuccessMsg(), EnContanst.MSG_WISHLIST_SUCCESS);
	}
	
	@Test(enabled=false, priority=1)
	public void TC_Add_Products_On_Homepage_ToWishlist() {
		homePage.openHomepage();
		Assert.assertTrue(helper.waitUntilPageLoaded(this.d));
		
		Add_To_Wishlist_Pre_Condition("Computers ", "Notebooks ", "Asus N551JK-XO076H Laptop");
		Add_To_Wishlist_Pre_Condition("Computers ", "Notebooks ", "HP Envy 6-1180ca 15.6-Inch Sleekbook");
		Add_To_Wishlist_Pre_Condition("Computers ", "Notebooks ", "HP Spectre XT Pro UltraBook");
		Add_To_Wishlist_Pre_Condition("Computers ", "Notebooks ", "Lenovo Thinkpad X1 Carbon Laptop");
		Add_To_Wishlist_Pre_Condition("Computers ", "Notebooks ", "Samsung Series 9 NP900X4C Premium Ultrabook");
		
		helper.clickAnchorByClassAndText(this.d, "header-links", "Wishlist");
		Assert.assertTrue(helper.waitUntilPageLoaded(this.d));
	}
	
	 @AfterClass(enabled=false, alwaysRun=true)
	 public void afterClass() {
		log.info("close browser");
		quitBrowser(d);
	}
	 
	private HomeObject homePage;
	private DetailObject detailPage;
	private WishlistObject wishlistPage;
	
}
