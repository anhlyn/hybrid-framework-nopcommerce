package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.SearchUI;

public class SearchObject extends BasePage{
	
	WebDriver driver;
	
	public SearchObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void TypeKeyword(String keyword) {
		sendKeyToElement(this.driver, SearchUI.TXT_KEYWORD, keyword);
	}
	
	public void checkAdvancedSearch() {
		clickToElement(this.driver, SearchUI.CHK_ADV_SEARCH);
	}
	
	public void uncheckAdvancedSearch() {
		uncheckTheCheckbox(this.driver, SearchUI.CHK_ADV_SEARCH);
	}
	
	public void checkSearchInSubCate() {
		clickToElement(this.driver, SearchUI.CHK_SUB_CATEGORY);
	}
	
	public void uncheckSearchInSubCate() {
		uncheckTheCheckbox(this.driver, SearchUI.CHK_SUB_CATEGORY);
	}
	
	public void checkSearchInDescription() {
		clickToElement(this.driver, SearchUI.CHK_DESCRIPTION);
	}
	
	public void uncheckSearchInDescription() {
		uncheckTheCheckbox(this.driver, SearchUI.CHK_DESCRIPTION);
	}
	
	public void selectCategory(String item) {
		selectDefaultDropdown(this.driver, item, SearchUI.SEL_CATEGORY);
	}
	
	public void selectManufacturer(String item) {
		selectDefaultDropdown(this.driver, item, SearchUI.SEL_MANUFACTURER);
	}
	
	public String getWarning() {
		return getTextElement(this.driver, SearchUI.MSG_WARNING);
	}
	
	public String getNoResult() {
		return getTextElement(this.driver, SearchUI.MSG_NO_RESULT);
	}
	
	public Boolean isAdvanceSearchBoxDisplayed() {
		return isWebElementDisplayed(this.driver, SearchUI.DIV_ADV_SEARCH_BOX);
	}
	
	public Boolean isProductTitleListContainByKeyword(String kw, Boolean isEqual){
		List<String> listProductTitles = getTextElements(this.driver, SearchUI.RESULT_LIST_PRODUCT_TITLE);
		kw = kw.toLowerCase();
		if(isEqual == false) {
			for(String text:listProductTitles) {
				if(!text.toLowerCase().contains(kw)) {
					return false;
				}
			}
		}else {
			for(String text:listProductTitles) {
				if(!text.toLowerCase().contentEquals(kw)) {
					return false;
				}
			}
		}
		return true;
	}
	
}
