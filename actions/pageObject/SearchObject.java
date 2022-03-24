package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.SearchUI;

public class SearchObject extends BasePage{
	
	WebDriver driver;
	
	public SearchObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public List<String> searchOnHeader(String keyword) {
		sendKeyToElement(driver, SearchUI.SEARCH_INPUT, keyword);
		clickToElement(driver, SearchUI.SEARCH_BUTTON);
		
		return getTextElements(driver, SearchUI.RESULT_H2);
	}
	
	public DetailProductObject clickByHeader(String headerTitle) {
		clickToElement(driver, SearchUI.RESULT_BY_HEADER_PATTERN, headerTitle);
		return PageGeneratorManager.getDetailPage(driver);
	}
	
}
