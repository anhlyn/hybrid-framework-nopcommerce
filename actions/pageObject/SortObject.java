package pageObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import frontend.CommonUI;
import frontend.SortUI;

public class SortObject extends BasePage{
	
	WebDriver driver;
	
	public SortObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void SelectSortBy(String item) {
		selectDefaultDropdown(this.driver, item, SortUI.SEL_SORT);
		waitUntilElementInvisible(this.driver, CommonUI.AJAX_PRODUCTS_BUSY);
	}
	
	public void SelectDisplay(String item) {
		selectDefaultDropdown(this.driver, item, SortUI.SEL_DISPLAY);
		waitUntilElementInvisible(this.driver, CommonUI.AJAX_PRODUCTS_BUSY);
	}
	
	public List<String> getProductNamesOnOnePage(){
		return getTextElements(this.driver, SortUI.PRODUCT_NAMES);
	}
	
	public List<String> getProductPricesOnOnePage(){
		return getTextElements(this.driver, SortUI.PRODUCT_PRICES);
	}
	
	public Boolean isPagerDisplayed() {
		return !isWebElementNotExistsInHTML(this.driver, SortUI.PAGER);
	}
	
	public Boolean isNextPageDisplayed() {
		return !isWebElementNotExistsInHTML(this.driver, SortUI.NEXT_PAGE);
	}
	
	public Boolean isPrevPageDisplayed() {
		return !isWebElementNotExistsInHTML(this.driver, SortUI.PREV_PAGE);
	}
	
	public void clickPageByNumber(String page) {
		clickToElement(this.driver, SortUI.PAGE_BY_NUMBER, page);
		waitUntilElementInvisible(this.driver, CommonUI.AJAX_PRODUCTS_BUSY);
	}
	
	public Boolean isSortByName(Boolean isDESC) {
		List<String> lst = this.getProductNamesOnOnePage();
		List<String> copy = new ArrayList<String>(lst);
		Collections.sort(copy);
		if(isDESC) {
			Collections.sort(copy, Collections.reverseOrder());
		}
	
		return lst.equals(copy);
	}
	
	public Boolean isSortByPrice(Boolean isDESC) {
		List<String> lst = this.getProductPricesOnOnePage();
		List<String> copy = new ArrayList<String>(lst);
		Collections.sort(copy);
		if(isDESC) {
			Collections.sort(copy, Collections.reverseOrder());
		}
	
		return lst.equals(copy);
	}
	
}
