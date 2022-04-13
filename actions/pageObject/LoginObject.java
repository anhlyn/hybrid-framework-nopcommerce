package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.PatternUI;
import pageUI.LoginUI;

public class LoginObject extends BasePage{
	
	WebDriver driver;
	
	public LoginObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void typeEmailTxt(String em) {
		sendKeyToElement(driver, LoginUI.EMAIL_INPUT, em);
	}
	
	public void typePasswordTxt(String p) {
		sendKeyToElement(driver, LoginUI.PASSWORD_INPUT, p);
	}
	
	public void clickLoginBtn() {
		clickToElement(driver, LoginUI.LOGIN_BUTTON);
	}
	
	public String getEmailErrMsg() {
		return getTextElement(driver, LoginUI.EMAIL_ERR_MSG);
	}
	
	public String getSummaryErrMsg() {
		return getTextElement(driver, LoginUI.SUMMARY_ERR_MSG);
	}
	
	public boolean isLoginSuccess() {
		return isWebElementDisplayed(driver, PatternUI.HEADER_LINKS_PATTERN, "logout");
	}
	
}
