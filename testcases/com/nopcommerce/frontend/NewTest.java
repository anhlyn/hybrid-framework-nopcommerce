package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest {
	
	protected Log log;
	
  @Test
  public void TC_01() {
	  log = LogFactory.getLog(this.getClass());
	  System.out.println("TC 01...");
	  log.info("log info here ...");
	  WebDriverManager.chromedriver().setup();
	  WebDriver d = new ChromeDriver();
	  d.get("https://www.google.com/");
  }
  
}
