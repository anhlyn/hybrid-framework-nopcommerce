package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import frontend.AddressesUI;

public class AddressObject extends BasePage{
	
	WebDriver driver;
	
	public AddressObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public String getFullNameText() {
		return getTextElement(driver, AddressesUI.NAME_LI);
	}
	
	public String getEmailText() {
		return getTextElement(driver, AddressesUI.EMAIL_LI);
	}
	
	public String getPhoneText() {
		return getTextElement(driver, AddressesUI.PHONE_LI);
	}
	
	public String getFaxText() {
		return getTextElement(driver, AddressesUI.FAX_LI);
	}
	
	public String getCompanyText() {
		return getTextElement(driver, AddressesUI.COMPANY_LI);
	}
	
	public String getAddress1Text() {
		return getTextElement(driver, AddressesUI.ADDRESS1_LI);
	}
	
	public String getAddress2Text() {
		return getTextElement(driver, AddressesUI.ADDRESS2_LI);
	}
	
	public String getCityAndZipText() {
		return getTextElement(driver, AddressesUI.CITY_ZIP_LI);
	}
	
	public String getCountryText() {
		return getTextElement(driver, AddressesUI.COUNTRY_LI);
	}
	
}
