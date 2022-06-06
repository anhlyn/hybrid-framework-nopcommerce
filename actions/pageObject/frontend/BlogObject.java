package pageObject.frontend;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class BlogObject extends BasePage{
	
	WebDriver driver;
	
	public BlogObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
}
