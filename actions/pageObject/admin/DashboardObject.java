package pageObject.admin;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;

import admin.DashboardUI;
import admin.ProductDetailUI;
import admin.SearchUI;
import commons.BasePage;

public class DashboardObject extends BasePage {

	WebDriver driver;
	
	public DashboardObject(WebDriver mappingDriver){
		this.driver = mappingDriver;
	}
	
	public void ClickFirstNav(String nav){
		clickToElement(driver, DashboardUI.FIRST_NAV, nav);
	}
	
	public void ClickSecondNav(String parent, String child){
		clickToElement(driver, DashboardUI.SECOND_NAV, parent, child);
		waitUntilPageLoaded(driver);
	}
	
	public void typeProductNameInSearchArea(String n){
		sendKeyToElement(driver, SearchUI.TXT_SEARCH_PRODUCT_NAME, n);
	}
	
	public void selectProductCateInSearchArea(String c){
		selectDefaultDropdown(driver, c, SearchUI.SELECT_SEARCH_PRODUCT_CATE);
	}
	
	public void selectManufacturerInSearchArea(String m){
		selectDefaultDropdown(driver, m, SearchUI.SELECT_SEARCH_PRODUCT_MANUFACTURER);
	}
	
	public void uncheckSubCate(){
		uncheckTheCheckbox(driver, SearchUI.CHK_SEARCH_PRODUCT_SUB_CATE);
	}
	
	public void checkSubCate(){
		clickToElement(driver, SearchUI.CHK_SEARCH_PRODUCT_SUB_CATE);
	}
	
	public void goDirectSKU(String sku){
		sendKeyToElement(driver, SearchUI.TXT_SEARCH_PRODUCT_SKU, sku);
		clickToElement(driver, SearchUI.BTN_SEARCH_PRODUCT_SKU);
		waitUntilPageLoaded(driver);
		waitUntilElementInvisible(driver, SearchUI.DIV_AJAXBUSY);
		/*if(isWebElementDisplayed(driver, ProductDetailUI.PRODUCT_INFO_FA_PLUS)){
			clickToElement(driver, ProductDetailUI.PRODUCT_INFO_FA_PLUS);
			waitUntilElementInvisible(driver, SearchUI.DIV_AJAXBUSY);
		}*/
	}
	
	public Hashtable<String, String> getProductDetail(){
		Hashtable<String, String> result = new Hashtable<String, String>();
		result.put("url", getCurrentUrl(driver));
		Boolean b1 = isWebElementDisplayed(driver, ProductDetailUI.TXT_PRODUCTNAME);
		Boolean b2 = isWebElementDisplayed(driver, ProductDetailUI.TXT_SKU);
		result.put("h1", getTextElement(driver, ProductDetailUI.H1_PRODUCTNAME));
		result.put("productname", getAttributeValue(driver, ProductDetailUI.TXT_PRODUCTNAME, "value"));
		result.put("sku", getAttributeValue(driver, ProductDetailUI.TXT_SKU, "value"));
		return result;
	}
	
	public void clickSearchInProductPage(){
		clickToElement(driver, SearchUI.BTN_SEARCH_PRODUCT);
		//waitUntilPageLoaded(driver);
		waitUntilElementInvisible(driver, SearchUI.DIV_AJAXBUSY);
	}
	
	public String getTotalResultNumber(){
		String s = getTextElement(driver, SearchUI.DIV_SEARCH_TOTAL);
		String[] arrTemp1 = s.split(" of ");
		String[] arrTemp2 = arrTemp1[1].split(" ");
		return arrTemp2[0].trim();
	}
	
	public String getDataTableEmptyText(){
		return getTextElement(driver, SearchUI.DATATABLE_EMPTY);
	}
	
	public Hashtable<String, String> getFirstRowInResultSearch(){
		Hashtable<String, String> firstRow = new Hashtable<String, String>();
		firstRow.put("productname", getTextElement(driver, SearchUI.RESULT_SEARCH_FIRST_ROW_PRODUCT_NAME));
		firstRow.put("sku", getTextElement(driver, SearchUI.RESULT_SEARCH_FRIST_ROW_SKU));
		firstRow.put("price", getTextElement(driver, SearchUI.RESULT_SEARCH_FIRST_ROW_PRICE));
		firstRow.put("stock", getTextElement(driver, SearchUI.RESULT_SEARCH_FIRST_ROW_STOCK));
		return firstRow;
	}
	
}
