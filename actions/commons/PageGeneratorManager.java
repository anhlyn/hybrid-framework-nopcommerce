package commons;

import org.openqa.selenium.WebDriver;

import pageObject.BlogObject;
import pageObject.HomeObject;
import pageObject.MyAccountObject;
import pageObject.RegisterObject;
import pageObject.SitemapObject;

public class PageGeneratorManager {

	public static HomeObject getHomePage(WebDriver d) {
		return new HomeObject(d);
	}
	
	public static RegisterObject getRegisterPage(WebDriver d) {
		return new RegisterObject(d);
	}
	
	public static MyAccountObject getMyAccountPage(WebDriver d) {
		return new MyAccountObject(d);
	}
	
	public static SitemapObject getSitemapPage(WebDriver d) {
		return new SitemapObject(d);
	}
	
	public static BlogObject getBlogPage(WebDriver d) {
		return new BlogObject(d);
	}
}
