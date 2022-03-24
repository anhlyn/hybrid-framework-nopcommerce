package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.AddressesUI;

public class MyAddressObject extends BasePage{
	
	WebDriver driver;
	
	public MyAddressObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void clickAddNew() {
		clickToElement(driver, AddressesUI.ADD_NEW_BTN);
	}
	
	public void typeFirstName(String fname) {
		sendKeyToElement(driver, AddressesUI.FNAME_INPUT, fname);
	}
	
	public void typeLastName(String lname) {
		sendKeyToElement(driver, AddressesUI.LNAME_INPUT, lname);
	}
	
	public void typeEmailInput(String em) {
		sendKeyToElement(driver, AddressesUI.EMAIL_INPUT, em);
	}
	
	public void typeCompanyInput(String com) {
		sendKeyToElement(driver, AddressesUI.COMPANY_INPUT, com);
	}
	
	public void selectCountry(String country) {
		selectDefaultDropdown(driver, AddressesUI.COUNTRY_SELECT, country);
	}
	
	public void typeCityInput(String city) {
		sendKeyToElement(driver, AddressesUI.CITY_INPUT, city);
	}
	
	public void typeAddress1Input(String address) {
		sendKeyToElement(driver, AddressesUI.ADDRESS1_INPUT, address);
	}
	
	public void typeAddress2Input(String address) {
		sendKeyToElement(driver, AddressesUI.ADDRESS2_INPUT, address);
	}
	
	public void typePostalCodeInput(String postalcode) {
		sendKeyToElement(driver, AddressesUI.POSTALCODE_INPUT, postalcode);
	}
	
	public void typePhoneInput(String phone) {
		sendKeyToElement(driver, AddressesUI.PHONE_INPUT, phone);
	}
	
	public void typeFaxInput(String fax) {
		sendKeyToElement(driver, AddressesUI.FAX_INPUT, fax);
	}

	public void save() {
		clickToElement(driver, AddressesUI.SAVE_BTN);
	}
	
	public String getFullName() {
		return getTextElement(driver, AddressesUI.NAME_LI);
	}
	
	public String getEmail() {
		return getTextElement(driver, AddressesUI.EMAIL_LI);
	}
	
	public String getPhone() {
		return getTextElement(driver, AddressesUI.PHONE_LI);
	}
	
	public String getFax() {
		return getTextElement(driver, AddressesUI.FAX_LI);
	}
	
	public String getCompany() {
		return getTextElement(driver, AddressesUI.COMPANY_LI);
	}
	
	public String getAddress1() {
		return getTextElement(driver, AddressesUI.ADDRESS1_LI);
	}
	
	public String getAddress2() {
		return getTextElement(driver, AddressesUI.ADDRESS2_LI);
	}
	
	public String getCityPostalCode() {
		return getTextElement(driver, AddressesUI.CITY_ZIP_LI);
	}
	
	public String getCountry() {
		return getTextElement(driver, AddressesUI.COUNTRY_LI);
	}
	
	public boolean isAddressesLoaded() {
		return getCurrentPageUrl(driver).contains("customer/addresses");
	}
	
}
