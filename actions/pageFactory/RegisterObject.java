package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class RegisterObject extends BasePage {

	WebDriver driver;
	
	public RegisterObject(WebDriver d) {
		driver = d;
		//PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(css = "#gender-male")
	WebElement maleRdo;
	
	@CacheLookup
	@FindBy(id = "gender-female")
	WebElement femaleRdo;
	
	@CacheLookup
	@FindBy(id = "FirstName")
	WebElement fnameInput;
	
	@CacheLookup
	@FindBy(id = "LastName")
	WebElement lnameInput;
	
	@CacheLookup
	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	WebElement birthDaySelect;
	
	@CacheLookup
	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	WebElement birthMonthSelect;
	
	@CacheLookup
	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	WebElement birthYearSelect;
	
	@CacheLookup
	@FindBy(id = "Email")
	WebElement emailInput;
	
	@CacheLookup
	@FindBy(id = "Password")
	WebElement passwordInput;
	
	@CacheLookup
	@FindBy(css = "#ConfirmPassword")
	WebElement cpasswordInput;
	
	@CacheLookup
	@FindBy(css = "button#register-button")
	WebElement registerButton;
	
	@CacheLookup
	@FindBy(css = "span#FirstName-error")
	WebElement fnameErrorMsg;
	
	@CacheLookup
	@FindBy(css = "span#LastName-error")
	WebElement lnameErrorMsg;
	
	@CacheLookup
	@FindBy(css = "span#Email-error")
	WebElement emailErrorMsg;
	
	@CacheLookup
	@FindBy(css = "span#Password-error")
	WebElement passwordErrorMsg;
	
	@CacheLookup
	@FindBy(css = "span#ConfirmPassword-error")
	WebElement cpasswordErrorMsg;
	
	@CacheLookup
	@FindBy(xpath = "//div[@class='page-body']//div[contains(@class,'validation-summary-errors')]/ul/li")
	WebElement summaryErrorMsg;
	
	@CacheLookup
	@FindBy(xpath = "//div[@class='page-body']/div[@class='result']")
	WebElement successMsg;
	
	public void selectMaleRdo() {
		clickToElement(maleRdo);
	}
	
	public void selectFemaleRdo() {
		clickToElement(femaleRdo);
	}
	
	public void typeFirstnameTxt(String fname) {
		sendKeyToElement(fnameInput, fname);
	}
	
	public void typeLastnameTxt(String lname) {
		sendKeyToElement(lnameInput, lname);
	}
	
	public void selectBirthDay(String d) {
		selectDefaultDropdown(birthDaySelect, d);
	}
	
	public void selectBirthMonth(String m) {
		selectDefaultDropdown(birthMonthSelect, m);
	}
	
	public void selectBirthYear(String y) {
		selectDefaultDropdown(birthYearSelect, y);
	}
	
	public void typeEmailTxt(String em) {
		sendKeyToElement(emailInput, em);
	}
	
	public void typePasswordTxt(String p) {
		sendKeyToElement(passwordInput, p);
	}
	
	public void typeCPasswordTxt(String cp) {
		sendKeyToElement(cpasswordInput, cp);
	}
	
	public void clickRegisterBtn() {
		clickToElement(registerButton);
	}
	
	public String getFirstNameErrorMsg() {
		return getTextElement(fnameErrorMsg);
	}
	
	public String getLastNameErrorMsg() {
		return getTextElement(lnameErrorMsg);
	}
	
	public String getEmailErrorMsg() {
		return getTextElement(emailErrorMsg);
	}
	
	public String getPasswordErrorMsg() {
		return getTextElement(passwordErrorMsg);
	}
	
	public String getCPasswordErrorMsg() {
		return getTextElement(cpasswordErrorMsg);
	}
	
	public String getSummaryErrorMsg() {
		return getTextElement(summaryErrorMsg);
	}
	
	public String getSuccessMsg() {
		return getTextElement(successMsg);
	}
	
}
