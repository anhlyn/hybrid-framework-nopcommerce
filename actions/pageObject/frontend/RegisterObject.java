package pageObject.frontend;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.Helper;
import frontend.RegisterUI;

public class RegisterObject extends BasePage {

	private WebDriver driver;
	
	public RegisterObject(WebDriver d) {
		driver = d;
	}
	
	public void TypeFirstName(String fn) {
		sendKeyToElement(driver, RegisterUI.TXT_FIRSTNAME, fn);
	}
	
	public void TypeLastName(String ln) {
		sendKeyToElement(driver, RegisterUI.TXT_LASTNAME, ln);
	}
	
	public void TypeEmail(String em) {
		sendKeyToElement(driver, RegisterUI.TXT_EMAIL, em);
	}
	
	public void TypePassword(String p) {
		sendKeyToElement(driver, RegisterUI.TXT_PASSWORD, p);
	}
	
	public void TypeConfirmPassword(String cp) {
		sendKeyToElement(driver, RegisterUI.TXT_CONFIRM_PASSWORD, cp);
	}
	
	public void FillInformationOnRegisterForm(String fn, String ln, String em, String p, String cp) {
		Helper.getHelper().clickAnchorByClassAndText(this.driver, "header-links", "Register");
		
		this.TypeFirstName(fn);
		this.TypeLastName(ln);
		this.TypeEmail(em);
		this.TypePassword(p);
		this.TypeConfirmPassword(cp);
	
		Helper.getHelper().clickButtonByClassAndText(this.driver, "buttons", "Register");
	}
	
}
