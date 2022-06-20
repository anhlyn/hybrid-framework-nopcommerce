package pageObject.admin;

import org.openqa.selenium.WebDriver;

import admin.LoginUI;
import commons.BasePage;
import commons.GlobalContants;

public class LoginObject extends BasePage {

	WebDriver driver;
	
	public LoginObject(WebDriver mappingDriver){
		this.driver = mappingDriver;
	}
	
	public Boolean OpenAdminAndLogin(String em, String p) {
		openPageUrl(driver, GlobalContants.URL_ADMIN);
		waitUntilPageLoaded(driver);
		if(em.length() > 0) {
			sendKeyToElement(driver, LoginUI.TXT_EMAIL, em);
		}
		if(p.length() > 0) {
			sendKeyToElement(driver, LoginUI.TXT_PASS, p);
		}
		clickToElement(driver, LoginUI.BTN_LOGIN);
		return waitUntilPageLoaded(driver);
	}
	
}
