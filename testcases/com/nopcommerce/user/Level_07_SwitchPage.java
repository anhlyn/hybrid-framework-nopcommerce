package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.BlogObject;
import pageObject.HomeObject;
import pageObject.MyAccountObject;
import pageObject.SitemapObject;

public class Level_07_SwitchPage extends BaseTest{
	
	private WebDriver d;
	
	HomeObject homePage;
	MyAccountObject myAccountPage;
	SitemapObject sitemapPage;
	BlogObject blogPage;
	
	
	@Parameters("browser")
	@BeforeClass
	public void preCondition(String b) {	
		d = getBrowserDriver(b);
		homePage = PageGeneratorManager.getHomePage(d);
		homePage.loadHomePage();
	}
	
	@Test(enabled = true)
	public void Register_01_EmptyData() {
		//Home -> My Account
		myAccountPage = homePage.clickMyAccountLinkOnFooter(d);
		
		//My Account -> Sitemap
		sitemapPage = myAccountPage.clickSitemapLinkOnFooter(d);
		
		//Sitemap -> blog
		blogPage = sitemapPage.clickBlogLinkOnFooter(d);
	}
	
	@AfterClass
	public void afterClass() {
		
	}
	
}
