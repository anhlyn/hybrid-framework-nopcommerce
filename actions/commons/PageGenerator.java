package commons;

import org.openqa.selenium.WebDriver;

import pageObject.frontend.AddressObject;
import pageObject.frontend.BlogObject;
import pageObject.frontend.ChangePasswordObject;
import pageObject.frontend.CheckoutObject;
import pageObject.frontend.CompareProductObject;
import pageObject.frontend.CustomerInfoObject;
import pageObject.frontend.DetailObject;
import pageObject.frontend.HomeObject;
import pageObject.frontend.LoginObject;
import pageObject.frontend.MyReviewObject;
import pageObject.frontend.RegisterObject;
import pageObject.frontend.SearchObject;
import pageObject.frontend.SitemapObject;
import pageObject.frontend.SortObject;
import pageObject.frontend.WishlistObject;

public class PageGenerator {

	public static HomeObject getHomePage(WebDriver d) {
		return new HomeObject(d);
	}
	
	public static RegisterObject getRegisterPage(WebDriver d) {
		return new RegisterObject(d);
	}
	
	public static CustomerInfoObject getCustomerInfoPage(WebDriver d) {
		return new CustomerInfoObject(d);
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
	
	public static AddressObject getAddressPage(WebDriver d) {
		return new AddressObject(d);
	}
	
	public static ChangePasswordObject getChangePasswordPage(WebDriver d) {
		return new ChangePasswordObject(d);
	}
	
	public static SearchObject getSearchPage(WebDriver d) {
		return new SearchObject(d);
	}
	
	public static SortObject getSortPage(WebDriver d) {
		return new SortObject(d);
	}
	
	public static DetailObject getDetailPage(WebDriver d) {
		return new DetailObject(d);
	}
	
	public static CompareProductObject getComparePage(WebDriver d) {
		return new CompareProductObject(d);
	}
	
	public static MyReviewObject getMyReviewPage(WebDriver d) {
		return new MyReviewObject(d);
	}
	
	public static WishlistObject getWishlistPage(WebDriver d) {
		return new WishlistObject(d);
	}
	
	public static CheckoutObject getCheckoutPage(WebDriver d) {
		return new CheckoutObject(d);
	}
}
