package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import frontend.WishlistUI;

public class WishlistObject extends BasePage{
	
	WebDriver driver;
	
	public WishlistObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void clickShareInfo() {
		clickToElement(this.driver, WishlistUI.SHARE_INFO);
	}
	
	public void clickShareInfoLink() {
		clickToElement(this.driver, WishlistUI.SHARE_INFO);
		waitUntilPageLoaded(this.driver);
	}
}
