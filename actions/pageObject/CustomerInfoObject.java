package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class CustomerInfoObject extends BasePage{
	
	WebDriver driver;
	
	public CustomerInfoObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	/*public String getSelectedValueOfBirthday() {
		return getSelectedOptionTextInDropdown(driver, CustomerInfoUI.BIRTH_DAY_SELECT);
	}
	
	public String getSelectedValueOfBirthMonth() {
		return getSelectedOptionTextInDropdown(driver, CustomerInfoUI.BIRTH_MONTH_SELECT);
	}
	
	public String getSelectedValueOfBirthYear() {
		return getSelectedOptionTextInDropdown(driver, CustomerInfoUI.BIRTH_YEAR_SELECT);
	}*/
	
}
