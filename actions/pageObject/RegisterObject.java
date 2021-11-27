package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.RegisterUI;

public class RegisterObject extends BasePage {

	private WebDriver driver;
	
	public RegisterObject(WebDriver d) {
		driver = d;
	}
	
	public void selectMaleRdo() {
		clickToElement(driver, RegisterUI.MALE_RDO);
	}
	
	public void selectFemaleRdo() {
		clickToElement(driver, RegisterUI.FEMALE_RDO);
	}
	
	public void typeFirstnameTxt(String fname) {
		sendKeyToElement(driver, RegisterUI.FNAME_INPUT, fname);
	}
	
	public void typeLastnameTxt(String lname) {
		sendKeyToElement(driver, RegisterUI.LNAME_INPUT, lname);
	}
	
	public void selectBirthDay(String d) {
		selectDefaultDropdown(driver, RegisterUI.BIRTH_DAY_SELECT, d);
	}
	
	public void selectBirthMonth(String m) {
		selectDefaultDropdown(driver, RegisterUI.BIRTH_MONTH_SELECT, m);
	}
	
	public void selectBirthYear(String y) {
		selectDefaultDropdown(driver, RegisterUI.BIRTH_YEAR_SELECT, y);
	}
	
	public void typeEmailTxt(String em) {
		sendKeyToElement(driver, RegisterUI.EMAIL_INPUT, em);
	}
	
	public void typePasswordTxt(String p) {
		sendKeyToElement(driver, RegisterUI.PASSWORD_INPUT, p);
	}
	
	public void typeCPasswordTxt(String cp) {
		sendKeyToElement(driver, RegisterUI.CPASSWORD_INPUT, cp);
	}
	
	public void clickRegisterBtn() {
		clickToElement(driver, RegisterUI.REGISTER_BUTTON);
	}
	
	public String getFirstNameErrorMsg() {
		return getTextElement(driver, RegisterUI.FNAME_ERR_MSG);
	}
	
	public String getLastNameErrorMsg() {
		return getTextElement(driver, RegisterUI.LNAME_ERR_MSG);
	}
	
	public String getEmailErrorMsg() {
		return getTextElement(driver, RegisterUI.EMAIL_ERR_MSG);
	}
	
	public String getPasswordErrorMsg() {
		return getTextElement(driver, RegisterUI.PASSWORD_ERR_MSG);
	}
	
	public String getCPasswordErrorMsg() {
		return getTextElement(driver, RegisterUI.CPASSWORD_ERR_MSG);
	}
	
	public String getSummaryErrorMsg() {
		return getTextElement(driver, RegisterUI.SUMMARY_ERR_MSG);
	}
	
	public String getSuccessMsg() {
		return getTextElement(driver, RegisterUI.SUCCESS_MSG);
	}
	
	public void closeBrowser() {
		closeBrowser(driver);
	}
	
}
