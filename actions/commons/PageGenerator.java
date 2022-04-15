package commons;

import org.openqa.selenium.WebDriver;

import pageObject.BlogObject;
import pageObject.ChangePasswordObject;
import pageObject.DetailProductObject;
import pageObject.HomeObject;
import pageObject.LoginObject;
import pageObject.MyAccountObject;
import pageObject.MyAddressObject;
import pageObject.MyReviewObject;
import pageObject.RegisterObject;
import pageObject.SearchObject;
import pageObject.SitemapObject;

public class PageGenerator {

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
	
	public static LoginObject getLoginPage(WebDriver d) {
		return new LoginObject(d);
	}
	
	public static MyAddressObject getMyAddressPage(WebDriver d) {
		return new MyAddressObject(d);
	}
	
	public static ChangePasswordObject getChangePasswordPage(WebDriver d) {
		return new ChangePasswordObject(d);
	}
	
	public static SearchObject getSearchPage(WebDriver d) {
		return new SearchObject(d);
	}
	
	public static DetailProductObject getDetailPage(WebDriver d) {
		return new DetailProductObject(d);
	}
	
	public static MyReviewObject getMyReviewPage(WebDriver d) {
		return new MyReviewObject(d);
	}
}
