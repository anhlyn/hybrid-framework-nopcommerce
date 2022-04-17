package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.DetailProductUI;
import pageUI.DetailUI;

public class DetailObject extends BasePage{
	
	WebDriver driver;
	
	public DetailObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public Boolean isDetailProductPageLoaded() {
		waitUntilElementVisible(this.driver, DetailUI.PRODUCT_NAME);
		return isWebElementDisplayed(this.driver, DetailUI.PRODUCT_NAME);
	}
	
	public String getAddToWishlistSuccessMsg() {
		waitUntilElementVisible(this.driver, DetailUI.BAR_NOTI_SUCCESS);
		return getTextElement(this.driver, DetailUI.BAR_NOTI_SUCCESS);
	}
	
	public void clickAddToWishlist() {
		clickToElement(this.driver, DetailUI.BTN_ADD_TO_WISHLIST);
	}
	
	/*public void addReview(String title, String text, String rate) {
		List<WebElement> elements = getWebElements(driver, DetailProductUI.ADD_REVIEW, "Add your review");
		if(elements.size() == 0) {
			elements = getWebElements(driver, DetailProductUI.ADD_REVIEW, "Be the first to review this product");
		}
		elements.get(0).click();
		
		//fill review info
		sendKeyToElement(driver, DetailProductUI.REVIEW_TITLE_INPUT, title);
		sendKeyToElement(driver, DetailProductUI.REVIEW_TEXT_INPUT, text);
		clickToElement(driver, DetailProductUI.REVIEW_RATING_RDO_PATTERN, rate);
		clickToElement(driver, DetailProductUI.REVIEW_SUBMIT_BTN);
	}*/
	
}
