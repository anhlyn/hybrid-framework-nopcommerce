package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test {

	public static void main(String[] args) {
		
		String browser = "firefox";
		String userdir = System.getProperty("user.dir");
		String driverPath = "";
		WebDriver driver;
		switch(browser) {
			case "chrome":
				driverPath = userdir + "/browserDrivers/chromedriver";
				System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
				break;
			case "firefox":
				driverPath = userdir + "/browserDrivers/geckodriver";
				System.setProperty("webdriver.gecko.driver", driverPath);
				driver = new FirefoxDriver();
				break;
		}
		
	}

}
