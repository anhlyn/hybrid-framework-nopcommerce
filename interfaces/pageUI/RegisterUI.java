package pageUI;

public class RegisterUI {

	public static final String MALE_RDO = "id=gender-male"; //"//input[@id='gender-male']"
	public static final String FEMALE_RDO = "id=gender-female"; //"//input[@id='gender-female']"
	public static final String FNAME_INPUT = "id=FirstName"; //"//input[@id='FirstName']"
	public static final String LNAME_INPUT = "id=LastName"; //"//input[@id='LastName']"
	public static final String BIRTH_DAY_SELECT = "name=DateOfBirthDay"; //"//select[@name='DateOfBirthDay']"
	public static final String BIRTH_MONTH_SELECT = "name=DateOfBirthMonth"; //"//select[@name='DateOfBirthMonth']"
	public static final String BIRTH_YEAR_SELECT = "name=DateOfBirthYear"; //"//select[@name='DateOfBirthYear']"
	public static final String EMAIL_INPUT = "id=Email"; //"//input[@id='Email']"
	public static final String PASSWORD_INPUT = "id=Password"; //"//input[@id='Password']"
	public static final String CPASSWORD_INPUT = "id=ConfirmPassword";
	public static final String REGISTER_BUTTON = "id=register-button";
	
	public static final String FNAME_ERR_MSG = "css=span#FirstName-error";
	public static final String LNAME_ERR_MSG = "css=span#LastName-error";
	public static final String EMAIL_ERR_MSG = "css=span#Email-error";
	public static final String PASSWORD_ERR_MSG = "css=span#Password-error";
	public static final String CPASSWORD_ERR_MSG = "css=span#ConfirmPassword-error";
	public static final String SUMMARY_ERR_MSG = "xpath=//div[@class='page-body']//div[contains(@class,'validation-summary-errors')]/ul/li";
	
	public static final String SUCCESS_MSG = "xpath=//div[@class='page-body']/div[@class='result']";
	
}
