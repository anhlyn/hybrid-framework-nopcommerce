package com.nopcommerce.frontend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomCloseBrowser extends BaseTest {
	private WebDriver d;
	
  @Test
  public void TC_1() {
  }
  
  @BeforeClass
  public void beforeClass() {
	 System.out.println("--------------- execute @BeforeClass");
	 WebDriverManager.chromedriver().setup();
	 d = new ChromeDriver(); 
	 //d.get("https://demo.nopcommerce.com/");
	 Assert.assertTrue(false);
  }
  
  @AfterClass
  public void quitCurrentOpenedBrowser() {
	  this.quitBrowser(d);
  }

}
