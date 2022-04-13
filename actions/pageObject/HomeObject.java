package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalContants;
import pageUI.HomeUI;

public class HomeObject extends BasePage{
	
	private WebDriver driver;
	
	public HomeObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		pageLoadTimeout(driver, 30000);
	}
	
	public void openHomepage() {
		openPageUrl(driver, GlobalContants.URL);
	}
	
	public boolean isSliderExists() {
		return isWebElementDisplayed(driver, HomeUI.NIVO_SLIDER);
	}
	
}
