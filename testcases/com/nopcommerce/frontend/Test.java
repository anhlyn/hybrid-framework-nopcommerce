package com.nopcommerce.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver chrome = new ChromeDriver();
		
		chrome.get("https://demo.nopcommerce.com/");
		
		Actions action = new Actions(chrome);
		action.moveToElement(chrome.findElement(By.xpath("//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[text()='Computers ']"))).perform();
		action.click(chrome.findElement(By.xpath("//ul[contains(@class,'sublist')]//a[text()='Notebooks ']"))).perform();
		
		WebDriverWait wait = new WebDriverWait(chrome, 10);
		//wait.until(ExpectedConditions.(chrome.findElement(By.xpath("//div[@class='ajax-products-busy']"))));
		
		System.out.println(chrome.findElement(By.xpath("//div[@class='breadcrumb']")).getText());

	}

}
