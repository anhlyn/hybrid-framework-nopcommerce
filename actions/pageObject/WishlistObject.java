package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.CommonUI;
import pageUI.WishlistUI;

public class WishlistObject extends BasePage{
	
	WebDriver driver;
	
	public WishlistObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public Boolean isNotEmpty() {
		return isWebElementNotExistsInHTML(this.driver, WishlistUI.NO_DATA);
	}
	
	public String getEmptyMsg() {
		return getTextElement(this.driver, WishlistUI.NO_DATA);
	}
	
	public void clickShareInfo() {
		clickToElement(this.driver, WishlistUI.SHARE_INFO);
	}
	
	public Boolean isAddToWishlistSuccess(String productName) {
		if(this.isNotEmpty()) {
			return isWebElementDisplayed(this.driver, WishlistUI.PRODUCT_NAME_ON_TABLE_BY_TEXT, productName);
		}
		return false;
	}
	
	/*public Boolean isBarNotiSuccessAutoClosed() {
		waitUntilElementInvisible(this.driver, CommonUI.BAR_NOTI_SUCCESS_CONTENT);
		return isWebElementNotExistsInHTML(this.driver, CommonUI.BAR_NOTI_SUCCESS_CONTENT);
	}*/
	
	public void clickShareInfoLink() {
		clickToElement(this.driver, WishlistUI.SHARE_INFO);
		waitUntilPageLoaded(this.driver);
	}
	
	public void EmptyTheList() {
		while(!isWebElementNotExistsInHTML(this.driver, WishlistUI.REMOVE_BUTTON_ON_TABLE)) {
			clickToElement(this.driver, WishlistUI.REMOVE_BUTTON_ON_TABLE);
			waitUntilPageLoaded(this.driver);
		}
	}
}
