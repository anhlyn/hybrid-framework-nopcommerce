package com.nopcommerce.frontend;

//import org.apache.commons.logging.LogFactory;
//import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.Helper;
import commons.PageGenerator;
import pageObject.frontend.HomeObject;
import pageObject.frontend.SortObject;


public class Sort extends BaseTest{
	
	WebDriver d;
	private Helper helper;
	
	@Parameters("browser")
	@BeforeClass
	public void Pre_Condition(@Optional("chrome") String b) {		
		d = getBrowserDriver(b);	
		helper = Helper.getHelper();
		
		homePage = PageGenerator.getHomePage(d);
		sortPage = PageGenerator.getSortPage(d);
		
		homePage.openHomepage();
		
		helper.HoverParentAndClickSubMenu(d, "Computers ", "Notebooks ");
		
		String txtBreadScrum = helper.getBreadScrumText(d);		
		Assert.assertTrue(txtBreadScrum.contains("Computers ".trim()));
		Assert.assertTrue(txtBreadScrum.contains("Notebooks ".trim()));
	}
	
	@Test(enabled=true)
	public void Sort_01_Name_A_To_Z() {
		
		sortPage.SelectSortBy("Name: A to Z");
		Assert.assertTrue(sortPage.isSortByName(false));
	}
	
	@Test(enabled=true)
	public void Sort_02_Name_Z_To_A() {
		
		sortPage.SelectSortBy("Name: Z to A");
		Assert.assertTrue(sortPage.isSortByName(true));
	}
	
	@Test(enabled=true)
	public void Sort_03_Price_Low_To_High() {
		
		sortPage.SelectSortBy("Price: Low to High");
		Assert.assertTrue(sortPage.isSortByPrice(false));
	}
	
	@Test(enabled=true)
	public void Sort_04_Price_High_To_Low() {
		
		sortPage.SelectSortBy("Price: High to Low");
		Assert.assertTrue(sortPage.isSortByPrice(true));
	}
	
	@Test(enabled=true)
	public void Sort_05_Display_3() {
		
		sortPage.SelectDisplay("3");
		int numOfProduct = sortPage.getProductNamesOnOnePage().size();
		
		Assert.assertTrue(numOfProduct<=3);
		Assert.assertTrue(sortPage.isNextPageDisplayed());
		
		sortPage.clickPageByNumber("2");
		Assert.assertTrue(sortPage.isPrevPageDisplayed());
	}
	
	@Test(enabled=true)
	public void Sort_06_Display_6() {
		
		sortPage.SelectDisplay("6");
		int numOfProduct = sortPage.getProductNamesOnOnePage().size();
		
		Assert.assertTrue(numOfProduct<=6);
		Assert.assertFalse(sortPage.isPagerDisplayed());
	}
	
	@Test(enabled=true)
	public void Sort_06_Display_9() {
		
		sortPage.SelectDisplay("9");
		int numOfProduct = sortPage.getProductNamesOnOnePage().size();
		
		Assert.assertTrue(numOfProduct<=9);
		Assert.assertFalse(sortPage.isPagerDisplayed());
	}
	
	 @AfterClass(enabled=true, alwaysRun=true)
	 public void afterClass() {
		log.info("close browser");
		quitBrowser(d);
	}
	 
	private HomeObject homePage;
	private SortObject sortPage;
	
}
