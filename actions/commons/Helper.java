package commons;

import org.openqa.selenium.WebDriver;

import frontend.CartUI;
import frontend.CommonUI;
import frontend.PatternUI;
import frontend.WishlistUI;

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
	
	public String getH1Title(WebDriver driver) {
		return getTextElement(driver, CommonUI.PAGE_TITLE);
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
		waitUntilPageLoaded(driver);
	}
	
	public String getFieldValidationError(WebDriver driver, String containedID) {
		return getTextElement(driver, PatternUI.SPAN_ERROR_BY_ID, containedID);
	}
	
	public void clickButtonByClassAndText(WebDriver driver, String attrClass, String attrText) {
		clickToElement(driver, PatternUI.BUTTON_BY_CLASS_AND_TEXT, attrClass, attrText);
		waitUntilPageLoaded(driver);
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
		waitUntilElementClickable(driver, PatternUI.ANCHOR_BY_CLASS_AND_TEXT, attrClass, attrText);
		clickToElement(driver, PatternUI.ANCHOR_BY_CLASS_AND_TEXT, attrClass, attrText);
		waitUntilPageLoaded(driver);
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
	
	public void closeBarNoti(WebDriver driver) {
		if(isWebElementDisplayed(driver, CommonUI.BAR_NOTI_CLOSE)) {
			clickToElement(driver, CommonUI.BAR_NOTI_CLOSE);
		}
	}
	
	//common functions on table
	public Boolean isTableNotEmpty(WebDriver driver) {
		return isWebElementNotExistsInHTML(driver, CommonUI.NO_DATA);
	}
	
	public String getNoDataMsgBelowTable(WebDriver driver) {
		return getTextElement(driver, CommonUI.NO_DATA);
	}
	
	public String getBarNotiSuccessMsg(WebDriver driver) {
		waitUntilElementVisible(driver, CommonUI.BAR_NOTI_SUCCESS_CONTENT);
		if(isWebElementDisplayed(driver, CommonUI.BAR_NOTI_SUCCESS_CONTENT)) {
			return getTextElement(driver, CommonUI.BAR_NOTI_SUCCESS_CONTENT);
		}
		return "";
	}
	
	public Boolean isProductNameOnProductGrid(WebDriver driver, String productName) {
		if(isWebElementNotExistsInHTML(driver, CommonUI.PRODUCT_NAME_ON_PRODUCT_GRID_BY_TEXT, productName)) {
			return false;
		}
		return isWebElementDisplayed(driver, CommonUI.PRODUCT_NAME_ON_PRODUCT_GRID_BY_TEXT, productName);
	}
	
	public Boolean isProductNameInTable(WebDriver driver, String productName) {
		if(isTableNotEmpty(driver)) {
			return isWebElementDisplayed(driver, CommonUI.PRODUCT_NAME_ON_TABLE_BY_TEXT, productName);
		}
		return false;
	}
	
	public String getAttrInTableByProductName(WebDriver driver, String productName) {
		return getTextElement(driver, CommonUI.ATTR_ON_TABLE_BY_PRODUCT_NAME, productName);
	}
	
	public String getTotalPriceOnTableByProductName(WebDriver driver, String productName) {
		return getTextElement(driver, CommonUI.TOTAL_PRICE_ON_TABLE_BY_PRODUCT_NAME, productName);
	}
	
	public void removeItemByProductName(WebDriver driver, String productName) {
		if(isProductNameInTable(driver, productName)) {
			clickToElement(driver, CommonUI.REMOVE_BUTTON_ON_TABLE_BY_PRODUCT_NAME, productName);
			waitUntilPageLoaded(driver);	
		}	
	}
	
	public void checkItemByProductName(WebDriver driver, String productName) {
		clickToElement(driver, CommonUI.CHK_ON_TABLE_BY_PRODUCT_NAME, productName);
	}
	
	public void EmptyTheList(WebDriver driver) {
		while(!isWebElementNotExistsInHTML(driver, CommonUI.REMOVE_BUTTON_ON_TABLE)) {
			clickToElement(driver, CommonUI.REMOVE_BUTTON_ON_TABLE);
			waitUntilPageLoaded(driver);
		}
	}
	
	public String getTextFromHeaderLink(WebDriver driver, String text) {
		return getTextElement(driver, PatternUI.ANCHOR_BY_CLASS_AND_TEXT, "header-links", text);
	}
	
	public void hoverShoppingCart(WebDriver driver) {
		hoverMouseToElement(driver, PatternUI.ANCHOR_BY_CLASS_AND_TEXT, "header-links", "Shopping cart");
		waitUntilElementVisible(driver, CommonUI.FLYOUT_CART_COUNT);
	}
	
	public String getFlyoutCartCount(WebDriver driver) {
		return getTextElement(driver, CommonUI.FLYOUT_CART_COUNT);
	}
	
	public String getFlyoutProductName(WebDriver driver) {
		return getTextElement(driver, CommonUI.FLYOUT_CART_PRODUCT_NAME);
	}
	
	public String getFlyoutAttribute(WebDriver driver) {
		return getTextElement(driver, CommonUI.FLYOUT_CART_ATTR);
	}
	
	public String getFlyoutPrice(WebDriver driver) {
		return getTextElement(driver, CommonUI.FLYOUT_CART_PRICE);
	}
	
	public void clickEditOnTableByProductName(WebDriver driver, String productName) {
		clickToElement(driver, CommonUI.EDIT_LINK_ON_TABLE_BY_PRODUCT_NAME, productName);
		waitUntilPageLoaded(driver);
	}
	
	public void typeQtyOnTableByProductName(WebDriver driver, String productName, String qty) {
		sendKeyToElement(driver, CommonUI.TXT_QTY_ON_TABLE_BY_PRODUCT_NAME, qty, productName);
	}
	
	public void chkTermsOfServicesOnCart(WebDriver driver) {
		clickToElement(driver, CartUI.CHK_TERM_OF_SERVICE);
	}
		
}
