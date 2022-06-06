package pageObject.frontend;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalContants;
import frontend.CompareProductUI;
import frontend.HomeUI;

public class CompareProductObject extends BasePage{
	
	private WebDriver driver;
	
	public CompareProductObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		pageLoadTimeout(driver, 30000);
	}
	
	public String getProductNameByText(String text) {		
		if(!isWebElementNotExistsInHTML(this.driver, CompareProductUI.COMPARE_TABLE)) {
			return getTextElement(this.driver, CompareProductUI.PRODUCT_NAME_ON_TABLE_BY_TEXT, text);
		}
		return "";
	}
	
}
