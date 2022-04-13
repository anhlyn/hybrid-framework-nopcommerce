package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.PatternUI;
import pageUI.RegisterUI;

public class RegisterObject extends BasePage {

	private WebDriver driver;
	
	public RegisterObject(WebDriver d) {
		driver = d;
	}
	
}
