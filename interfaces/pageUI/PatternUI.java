package pageUI;

public class PatternUI {
	
	public static final String ANCHOR_BY_CLASS_AND_TEXT = "//div[contains(@class,'%s')]//a[contains(., '%s')]";
	public static final String SUBMENU_BY_TEXT = "//ul[contains(@class,'sublist')]//a[text()='%s']";
	public static final String BUTTON_BY_CLASS_AND_TEXT = "//div[contains(@class, '%s')]//button[text()='%s']";
	
	public static final String SPAN_ERROR_BY_ID = "//span[@class='field-validation-error']/span[contains(@id,'%s')]";
	
	public static final String INPUT_BY_ID = "//input[@id='%s']";
	public static final String INPUT_BY_NAME = "//input[@name='%s']";
	public static final String SEL_BY_NAME = "//select[@name='%s']";
}
