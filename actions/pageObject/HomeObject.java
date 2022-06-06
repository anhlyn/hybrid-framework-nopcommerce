package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalContants;
import frontend.HomeUI;

public class HomeObject extends BasePage{
	
	private WebDriver driver;
	
	public HomeObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		pageLoadTimeout(driver, 30000);
	}
	
	public void openHomepage() {
		openPageUrl(driver, GlobalContants.URL);
		waitUntilPageLoaded(driver);
	}
	
	public boolean isSliderExists() {
		return isWebElementDisplayed(driver, HomeUI.NIVO_SLIDER);
	}
	
	public void addToWishlistByProductName(String productName) {
		clickToElement(this.driver, HomeUI.BTN_ADD_TO_WISHLIST_BY_PRODUCT_TITLE, productName);
		waitUntilPageLoaded(driver);
	}
	
	public void addToComparelistByProductName(String productName) {
		clickToElement(this.driver, HomeUI.BTN_ADD_TO_COMPARELIST_BY_PRODUCT_TITLE, productName);
		waitUntilPageLoaded(driver);
	}
	
	public void addToCartByProductName(String productName) {
		clickToElement(this.driver, HomeUI.BTN_ADD_TO_CART_BY_PRODUCT_TITLE, productName);
		waitUntilPageLoaded(driver);
	}
	
}
