package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.MyAccountUI;

public class MyAccountObject extends BasePage{
	
	WebDriver driver;
	
	public MyAccountObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void selectMaleRdo() {
		clickToElement(driver, MyAccountUI.MALE_RDO);
	}
	
	public void selectFemaleRdo() {
		clickToElement(driver, MyAccountUI.FEMALE_RDO);
	}
	
	public void typeFirstName(String fname) {
		sendKeyToElement(driver, MyAccountUI.FNAME_INPUT, fname);
	}
	
	public void typeLastName(String lname) {
		sendKeyToElement(driver, MyAccountUI.LNAME_INPUT, lname);
	}
	
	public void selectDateOfBirth(String d) {
		selectDefaultDropdown(driver, MyAccountUI.BIRTH_DAY_SELECT, d);
	}
	
	public void selectMonthOfBirth(String m) {
		selectDefaultDropdown(driver, MyAccountUI.BIRTH_MONTH_SELECT, m);
	}
	
	public void selectYearOfBirth(String y) {
		selectDefaultDropdown(driver, MyAccountUI.BIRTH_YEAR_SELECT, y);
	}
	
	public void typeEmailInput(String em) {
		sendKeyToElement(driver, MyAccountUI.EMAIL_INPUT, em);
	}
	
	public void typeCompanyInput(String com) {
		sendKeyToElement(driver, MyAccountUI.COMPANY_INPUT, com);
	}
	
	public void save() {
		clickToElement(driver, MyAccountUI.SAVE_BTN);
	}
	
	public boolean isMaleRdoSelected() {
		return isWebElementSelected(driver, MyAccountUI.MALE_RDO);
	}
	
	public boolean isFemaleRdoSelected() {
		return isWebElementSelected(driver, MyAccountUI.FEMALE_RDO);
	}
	
	public String getFirstNameValue() {
		return getAttributeValue(driver, MyAccountUI.FNAME_INPUT, "value");
	}
	
	public String getLastNameValue() {
		return getAttributeValue(driver, MyAccountUI.LNAME_INPUT, "value");
	}
	
	public String getEmailValue() {
		return getAttributeValue(driver, MyAccountUI.EMAIL_INPUT, "value");
	}
	
	public String getCompanyValue() {
		return getAttributeValue(driver, MyAccountUI.COMPANY_INPUT, "value");
	}
	
	public String getSelectedValueOfBirthday() {
		return getSelectedOptionTextInDropdown(driver, MyAccountUI.BIRTH_DAY_SELECT);
	}
	
	public String getSelectedValueOfBirthMonth() {
		return getSelectedOptionTextInDropdown(driver, MyAccountUI.BIRTH_MONTH_SELECT);
	}
	
	public String getSelectedValueOfBirthYear() {
		return getSelectedOptionTextInDropdown(driver, MyAccountUI.BIRTH_YEAR_SELECT);
	}
	
	public boolean isCustomerInfoLoaded() {
		return getCurrentPageUrl(driver).contains("customer/info");
	}
	
}
