package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.Helper;
import frontend.LoginUI;

public class LoginObject extends BasePage{
	
	WebDriver driver;
	
	public LoginObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void FillInfoAndClickLoginBtn(String em, String p) {
		if(em.length() > 0) {
			sendKeyToElement(driver, LoginUI.TXT_EMAIL, em);
		}
		if(p.length() > 0) {
			sendKeyToElement(driver, LoginUI.TXT_PASSWORD, p);
		}
		Helper.getHelper().clickButtonByClassAndText(this.driver, "buttons", "Log in");
	}
	
	/*public boolean isLoginSuccess() {
		//return isWebElementDisplayed(driver, PatternUI.HEADER_LINKS_PATTERN, "logout");
	}*/
	
}
