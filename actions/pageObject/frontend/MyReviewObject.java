package pageObject.frontend;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import frontend.MyReviewUI;

public class MyReviewObject extends BasePage{
	
	WebDriver driver;
	
	public MyReviewObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public HashMap<String, String> getFirstReview(){
		HashMap<String, String> review = new HashMap<String, String>();
		review.put("title", getTextElement(driver, MyReviewUI.REVIEW_TITLE));
		review.put("text", getTextElement(driver, MyReviewUI.REVIEW_TEXT));
		review.put("product_name", getTextElement(driver, MyReviewUI.REVIEW_PRODUCT_NAME));
		review.put("rate", getCssValue(driver, MyReviewUI.REVIEW_RATE, "width"));
		return review;
	}
	
}
