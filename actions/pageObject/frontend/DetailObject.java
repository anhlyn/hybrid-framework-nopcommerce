package pageObject.frontend;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import frontend.DetailProductUI;
import frontend.DetailUI;

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
	
	public void selectItemFromSelByLabel(String label, String item) {
		selectDefaultDropdown(this.driver, item, DetailUI.PRODUCT_SEL_BY_LABEL, label);
		waitUntilPageLoaded(this.driver);
	}
	
	public void clickRdoByLabel(String label) {
		clickToElement(this.driver, DetailUI.PRODUCT_RDO_BY_LABEL, label);
		waitUntilPageLoaded(this.driver);
	}
	
	public void clickChkByLabel(String label) {
		clickToElement(this.driver, DetailUI.PRODUCT_CHK_BY_LABEL, label);
		waitUntilPageLoaded(this.driver);
	}
	
	public void typeQty(String qty) {
		sendKeyToElement(this.driver, DetailUI.TXT_QTY, qty);
		waitUntilPageLoaded(this.driver);
	}
	
	public String getProductPrice() {
		return getTextElement(this.driver, DetailUI.PRODUCT_PRICE);
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
