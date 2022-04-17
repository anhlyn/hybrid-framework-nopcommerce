package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.DetailProductUI;

public class DetailProductObject extends BasePage{
	
	WebDriver driver;
	
	public DetailProductObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void addReview(String title, String text, String rate) {
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
	}
	
}
