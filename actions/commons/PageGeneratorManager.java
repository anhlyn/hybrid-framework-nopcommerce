package commons;

import org.openqa.selenium.WebDriver;

import pageObject.HomeObject;
import pageObject.RegisterObject;

public class PageGeneratorManager {

	public static HomeObject getHomePage(WebDriver d) {
		return new HomeObject(d);
	}
	
	public static RegisterObject getRegisterPage(WebDriver d) {
		return new RegisterObject(d);
	}
	
}
