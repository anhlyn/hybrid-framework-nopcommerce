package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalContants;
import pageUI.CommonUI;

public class HomeObject extends BasePage{
	
	private WebDriver driver;
	
	public HomeObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		pageLoadTimeout(driver, 30000);
	}
	
	public void open() {
		openPageUrl(driver, GlobalContants.URL);
	}
	
	public String getH1Title() {
		return getTextElement(driver, CommonUI.PAGE_TITLE);
	}
	
}
