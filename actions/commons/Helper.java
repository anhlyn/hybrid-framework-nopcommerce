package commons;

import org.openqa.selenium.WebDriver;

import pageUI.CommonUI;
import pageUI.PatternUI;

public class Helper extends BasePage{

	public static String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public static String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public static String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public static Helper getHelper() {
		return new Helper();
	}
	
	public void typeInputById(WebDriver driver, String id, String text) {
		sendKeyToElement(driver, PatternUI.INPUT_BY_ID, text, id);
	}
	
	public void typeInputByName(WebDriver driver, String name, String text) {
		sendKeyToElement(driver, PatternUI.INPUT_BY_NAME, text, name);
	}
	
	public String getInputValueById(WebDriver driver, String id) {
		return getAttributeValue(driver, PatternUI.INPUT_BY_ID, "value", id);
	}
	
	public void clickInputById(WebDriver driver, String id) {
		clickToElement(driver, PatternUI.INPUT_BY_ID, id);
	}
	
	public void selectItemFromDropdownByName(WebDriver driver, String name, String item) {
		selectDefaultDropdown(driver, item, PatternUI.SEL_BY_NAME, name);
	}
	
	public String getFieldValidationError(WebDriver driver, String containedID) {
		return getTextElement(driver, PatternUI.SPAN_ERROR_BY_ID, containedID);
	}
	
	public void clickButtonByClassAndText(WebDriver driver, String attrClass, String attrText) {
		clickToElement(driver, PatternUI.BUTTON_BY_CLASS_AND_TEXT, attrClass, attrText);
	}
	
	public boolean isRdoSelectedById(WebDriver driver, String id) {
		return isWebElementSelected(driver, PatternUI.INPUT_BY_ID, id);
	}
	
	public String getResultMsg(WebDriver driver) {
		return getTextElement(driver, CommonUI.RESULT_MSG);
	}
	
	public String getSummaryErrMsg(WebDriver driver) {
		return getTextElement(driver, CommonUI.SUMMARY_ERR_MSG);
	}
	
	//click menu
	public void clickAnchorByClassAndText(WebDriver driver, String attrClass, String attrText) {
		clickToElement(driver, PatternUI.ANCHOR_BY_CLASS_AND_TEXT, attrClass, attrText);
	}
	
	public boolean isLoginSuccessful(WebDriver driver) {
		return isWebElementDisplayed(driver, CommonUI.LOGOUT_LINK_ON_HEADER);
	}
	
	public void HoverParentAndClickSubMenu(WebDriver driver, String parentMenu, String childMenu) {
		hoverMouseToElement(driver, PatternUI.ANCHOR_BY_CLASS_AND_TEXT, "header-menu", parentMenu);
		clickToElement(driver, PatternUI.SUBMENU_BY_TEXT, childMenu);
	}
	
	public String getBreadScrumText(WebDriver driver) {
		return getTextElement(driver, CommonUI.BREADSCRUM);
	}
	
}
