package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
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
	
	public void EmptyTheList() {
		while(!isWebElementNotExistsInHTML(this.driver, WishlistUI.REMOVE_BUTTON_ON_TABLE)) {
			clickToElement(this.driver, WishlistUI.REMOVE_BUTTON_ON_TABLE);
			waitUntilPageLoaded(this.driver);
		}
	}
}
