package pageUI;

public class LoginUI {
	
	public static final String EMAIL_INPUT = "css=input#Email";
	public static final String PASSWORD_INPUT = "css=input#Password";
	public static final String LOGIN_BUTTON = "xpath=//button[@type='submit' and contains(.,'Log in')]";
	
	public static final String EMAIL_ERR_MSG = "xpath=//span[@id='Email-error']";
	public static final String SUMMARY_ERR_MSG = "xpath=//div[contains(@class,'validation-summary-errors')]";
	
}
