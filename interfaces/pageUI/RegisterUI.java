package pageUI;

public class RegisterUI {

	public static final String MALE_RDO = "//input[@id='gender-male']";
	public static final String FEMALE_RDO = "//input[@id='gender-female']";
	public static final String FNAME_INPUT = "//input[@id='FirstName']";
	public static final String LNAME_INPUT = "//input[@id='LastName']";
	public static final String BIRTH_DAY_SELECT = "//select[@name='DateOfBirthDay']";
	public static final String BIRTH_MONTH_SELECT = "//select[@name='DateOfBirthMonth']";
	public static final String BIRTH_YEAR_SELECT = "//select[@name='DateOfBirthYear']";
	public static final String EMAIL_INPUT = "//input[@id='Email']";
	public static final String PASSWORD_INPUT = "//input[@id='Password']";
	public static final String CPASSWORD_INPUT = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	
	public static final String FNAME_ERR_MSG = "//span[@id='FirstName-error']";
	public static final String LNAME_ERR_MSG = "//span[@id='LastName-error']";
	public static final String EMAIL_ERR_MSG = "//span[@id='Email-error']";
	public static final String PASSWORD_ERR_MSG = "//span[@id='Password-error']";
	public static final String CPASSWORD_ERR_MSG = "//span[@id='ConfirmPassword-error']";
	public static final String SUMMARY_ERR_MSG = "//div[@class='page-body']//div[contains(@class,'validation-summary-errors')]/ul/li";
	
	public static final String SUCCESS_MSG = "//div[@class='page-body']/div[@class='result']";
	
}
