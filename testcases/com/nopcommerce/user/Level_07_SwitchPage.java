package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.BlogObject;
import pageObject.HomeObject;
import pageObject.MyAccountObject;
import pageObject.RegisterObject;
import pageObject.SitemapObject;

public class Level_07_SwitchPage extends BaseTest{
	
	private WebDriver d;
	
	private HomeObject homePage;
	private MyAccountObject myAccountPage;
	private SitemapObject sitemapPage;
	private BlogObject blogPage;
	
	
	@Parameters("browser")
	@BeforeClass
	public void preCondition(String b) {
		
		d = getBrowserDriver(b);
		homePage = PageGeneratorManager.getHomePage(d);
		homePage.loadHomePage();
	}
	
	@Test
	public void Register_01_EmptyData() {
		//Home -> My Account
		myAccountPage = homePage.clickMyAccountLink(d);
		
		//My Account -> Sitemap
		sitemapPage = myAccountPage.clickSitemapLink(d);
		
		//Sitemap -> blog
		blogPage = sitemapPage.clickBlogLink(d);
	}
	
	@AfterClass
	public void afterClass() {
		
	}
	
}
