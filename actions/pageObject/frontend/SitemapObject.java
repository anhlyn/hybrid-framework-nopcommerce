package pageObject.frontend;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class SitemapObject extends BasePage{
	
	WebDriver driver;
	
	public SitemapObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
}
