package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.EnContanst;
import pageUI.ChangePasswordUI;
import pageUI.CommonUI;

public class ChangePasswordObject extends BasePage{
	
	WebDriver driver;
	
	public ChangePasswordObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public boolean isChangePassSuccessfull() {
		return getTextElement(driver, CommonUI.BAR_NOTI_SUCCESS_CONTENT).contains(EnContanst.MSG_PASSWORD_CHANGED_SUCCESSFULLY);
	}
	
	public void closeNoti() {
		clickToElement(driver, CommonUI.BAR_NOTI_CLOSE);
	}
	
}
