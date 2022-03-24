package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.ChangePasswordUI;

public class ChangePasswordObject extends BasePage{
	
	WebDriver driver;
	
	public ChangePasswordObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void typeOldPass(String p) {
		sendKeyToElement(driver, ChangePasswordUI.OLD_PASS_INPUT, p);
	}
	
	public void typeNewPass(String p) {
		sendKeyToElement(driver, ChangePasswordUI.NEW_PASS_INPUT, p);
	}
	
	public void typeConfirmPass(String p) {
		sendKeyToElement(driver, ChangePasswordUI.CONFIRM_PASS_INPUT, p);
	}
	
	public void clickChangePassword() {
		clickToElement(driver, ChangePasswordUI.CHANGE_PASS_BTN);
	}
	
	public boolean isChangePasswordLoaded() {
		return getCurrentPageUrl(driver).contains("customer/changepassword");
	}
	
	public boolean isSuccess() {
		return getTextElement(driver, ChangePasswordUI.BAR_NOTI_CONTENT).contains("Password was changed");
	}
	
	public void closeNoti() {
		clickToElement(driver, ChangePasswordUI.BAR_NOTI_CLOSE);
	}
	
}
