package com.nopcommerce.frontend;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.uncommons.reportng.HTMLReporter;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners({com.nopcommerce.frontend.TestListener.class})
public class TakeScreenShot extends BaseTest {
	
	private WebDriver d;
	
	String folderScreenshot = System.getProperty("user.dir") + "/screenshot/";
	
	String url = "http://live.techpanda.org/";
	
	@BeforeTest
	public void initialize() {
		WebDriverManager.chromedriver().setup();
		this.d = new ChromeDriver();

		this.d.get("http://live.techpanda.org/");
		d.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
	}

	@Test
	public void TC_01_Login_EmptyData() {
		
		d.get(url);
		
		d.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		
		d.findElement(By.xpath("//button[@type='submit' and contains(.,'Login')]")).click();
		
		int sizeErrRequired = d.findElements(By.xpath("//form[@id='login-form']//div[@class='validation-advice' and text()='This is a required field.']")).size();
		Assert.assertEquals(sizeErrRequired, 1);
	}
	
	@Test
	public void TC_02_Login_InvalidEmail() {
		d.get(url);

		d.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		
		//Fill invalid email
		d.findElement(By.xpath("//input[@id='email']")).sendKeys("123456789@123456.123");
		d.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
				
		//Click button 'LOGIN'
		d.findElement(By.xpath("//button[@type='submit' and contains(.,'Login')]")).click();
		
		Assert.assertTrue(d.findElement(By.xpath("//div[@class='validation-advice' and starts-with(text(),'Please enter a valid email')]")).isDisplayed());
		
	}
	
	@AfterTest
	public void closeBrowser() {
		this.d.close();
	}
}
