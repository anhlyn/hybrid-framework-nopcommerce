package com.nopcommerce.admin;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.EnContanst;
import commons.PageAdminGenerator;
import commons.GlobalContants;
import pageObject.admin.DashboardObject;
import pageObject.admin.LoginObject;

public class Admin extends BaseTest{
	
	WebDriver d;
	
	LoginObject loginPage;
	DashboardObject dashboardPage;
	
	Hashtable<String, String> product = new Hashtable<String, String>();

	@Parameters("browser")
	@BeforeClass
	public void preCondition(@Optional("chrome") String b) {		
		d = getBrowserDriver(b);
		
		//khoi tao data test
		product.put("name", "Lenovo IdeaCentre 600 All-in-One PC");
		product.put("sku", "LE_IC_600");
		product.put("price", "500");
		product.put("stock", "10000");
		product.put("cate", "Computers");
		product.put("subcate", "unchecked");
		product.put("manufacturer", "Apple");
		
		loginPage = PageAdminGenerator.getLoginPage(d);
		dashboardPage = PageAdminGenerator.getDashboardPage(d);
	}
	
	@Test
	public void TC_Admin_Login(){
		loginPage.OpenAdminAndLogin(GlobalContants.ADMIN_EMAIL, GlobalContants.ADMIN_PASSWORD);
	}
	
	@Test(enabled=false, dependsOnMethods="TC_Admin_Login")
	public void TC_Admin_1(){
		dashboardPage.ClickFirstNav("Catalog");
		dashboardPage.ClickSecondNav("Catalog", "Products");
		
		dashboardPage.typeProductNameInSearchArea(product.get("name"));
		dashboardPage.clickSearchInProductPage();
		
		Assert.assertEquals("1", dashboardPage.getTotalResultNumber());
		Hashtable<String, String> row_1 = dashboardPage.getFirstRowInResultSearch();
		Assert.assertEquals(row_1.get("productname"), product.get("name"));
		Assert.assertEquals(row_1.get("sku"), product.get("sku"));
		Assert.assertEquals(row_1.get("price"), product.get("price"));
		Assert.assertEquals(row_1.get("stock"), product.get("stock"));
	}
	
	@Test(enabled=false, dependsOnMethods="TC_Admin_Login")
	public void TC_Admin_2(){
		dashboardPage.ClickFirstNav("Catalog");
		dashboardPage.ClickSecondNav("Catalog", "Products");
		
		dashboardPage.typeProductNameInSearchArea(product.get("name"));
		dashboardPage.selectProductCateInSearchArea(product.get("cate"));
		dashboardPage.uncheckSubCate();
		
		dashboardPage.clickSearchInProductPage();
		
		Assert.assertEquals(dashboardPage.getDataTableEmptyText(), EnContanst.MSG_ADMIN_SEARCH_DATATABLE_EMPTY);
	}
	
	@Test(enabled=false, dependsOnMethods="TC_Admin_Login")
	public void TC_Admin_3(){
		dashboardPage.ClickFirstNav("Catalog");
		dashboardPage.ClickSecondNav("Catalog", "Products");
		
		dashboardPage.typeProductNameInSearchArea(product.get("name"));
		dashboardPage.selectProductCateInSearchArea(product.get("cate"));
		dashboardPage.checkSubCate();
		
		dashboardPage.clickSearchInProductPage();
		
		Assert.assertEquals("1", dashboardPage.getTotalResultNumber());
		Hashtable<String, String> row_1 = dashboardPage.getFirstRowInResultSearch();
		Assert.assertEquals(row_1.get("productname"), product.get("name"));
		Assert.assertEquals(row_1.get("sku"), product.get("sku"));
		Assert.assertEquals(row_1.get("price"), product.get("price"));
		Assert.assertEquals(row_1.get("stock"), product.get("stock"));
	}
	
	@Test(enabled=false, dependsOnMethods="TC_Admin_Login")
	public void TC_Admin_4(){
		dashboardPage.ClickFirstNav("Catalog");
		dashboardPage.ClickSecondNav("Catalog", "Products");
		
		dashboardPage.typeProductNameInSearchArea(product.get("name"));
		dashboardPage.selectProductCateInSearchArea("Computers >> Desktops");
		dashboardPage.uncheckSubCate();
		
		dashboardPage.clickSearchInProductPage();
		
		Assert.assertEquals("1", dashboardPage.getTotalResultNumber());
		Hashtable<String, String> row_1 = dashboardPage.getFirstRowInResultSearch();
		Assert.assertEquals(row_1.get("productname"), product.get("name"));
		Assert.assertEquals(row_1.get("sku"), product.get("sku"));
		Assert.assertEquals(row_1.get("price"), product.get("price"));
		Assert.assertEquals(row_1.get("stock"), product.get("stock"));
	}
	
	@Test(enabled=false, dependsOnMethods="TC_Admin_Login")
	public void TC_Admin_5(){
		dashboardPage.ClickFirstNav("Catalog");
		dashboardPage.ClickSecondNav("Catalog", "Products");
		
		dashboardPage.typeProductNameInSearchArea(product.get("name"));
		dashboardPage.selectProductCateInSearchArea("All");
		dashboardPage.uncheckSubCate();
		dashboardPage.selectManufacturerInSearchArea(product.get("manufacturer"));
		
		dashboardPage.clickSearchInProductPage();
		
		Assert.assertEquals(dashboardPage.getDataTableEmptyText(), EnContanst.MSG_ADMIN_SEARCH_DATATABLE_EMPTY);
	}
	
	@Test(enabled=true, dependsOnMethods="TC_Admin_Login")
	public void TC_Admin_6(){
		dashboardPage.ClickFirstNav("Catalog");
		dashboardPage.ClickSecondNav("Catalog", "Products");
		
		dashboardPage.goDirectSKU(product.get("sku"));
		
		Hashtable<String, String> detail = dashboardPage.getProductDetail();
		Assert.assertTrue(detail.get("url").contains("Admin/Product/Edit"));
		Assert.assertTrue(detail.get("h1").contains(product.get("name")));
		Assert.assertEquals(detail.get("productname"), product.get("name"));
		Assert.assertEquals(detail.get("sku"), product.get("sku"));
	}
	
	 @AfterClass(enabled=false, alwaysRun=false)
	 public void afterClass() {
		log.info("close browser");
		quitBrowser(d);
	}
	
}
