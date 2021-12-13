package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;

public class RegisterObject extends BasePage {

	private WebDriver driver;
	
	public RegisterObject(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#gender-male")
	WebElement maleRdo;
	
	@FindBy(id = "gender-female")
	WebElement femaleRdo;
	
	@FindBy(id = "FirstName")
	WebElement fnameInput;
	
	@FindBy(id = "LastName")
	WebElement lnameInput;
	
	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	WebElement birthDaySelect;
	
	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	WebElement birthMonthSelect;
	
	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	WebElement birthYearSelect;
	
	@FindBy(id = "Email")
	WebElement emailInput;
	
	@FindBy(id = "Password")
	WebElement passwordInput;
	
	@FindBy(css = "#ConfirmPassword")
	WebElement cpasswordInput;
	
	@FindBy(css = "button#register-button")
	WebElement registerButton;
	
	@FindBy(css = "span#FirstName-error")
	WebElement fnameErrorMsg;
	
	@FindBy(css = "span#LastName-error")
	WebElement lnameErrorMsg;
	
	@FindBy(css = "span#Email-error")
	WebElement emailErrorMsg;
	
	@FindBy(css = "span#Password-error")
	WebElement passwordErrorMsg;
	
	@FindBy(css = "span#ConfirmPassword-error")
	WebElement cpasswordErrorMsg;
	
	@FindBy(xpath = "//div[@class='page-body']//div[contains(@class,'validation-summary-errors')]/ul/li")
	WebElement summaryErrorMsg;
	
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
