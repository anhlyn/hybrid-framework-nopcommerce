package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalContants;
import pageUI.HomeUI;

public class HomeObject extends BasePage{
	
	private WebDriver driver;
	
	public HomeObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		pageLoadTimeout(driver, 5000);
	}
	
	public void loadHomePage() {
		openPageUrl(driver, GlobalContants.URL);
	}
	
	public String getH1Title() {
		return getTextElement(driver, HomeUI.PAGE_TITLE);
	}
	
	public void clickLogOutNav() {
		clickToElement(driver, HomeUI.LOGOUT_TOP_NAV);
	}
	
	public void clickRegisterNav() {
		clickToElement(driver, HomeUI.REGISTER_TOP_NAV);
	}
	
}
