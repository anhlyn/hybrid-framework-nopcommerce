package pageUI;

public class SearchUI {

	public static final String SEARCH_INPUT = "css=input#small-searchterms"; //"//input[@id='small-searchterms']"
	public static final String SEARCH_BUTTON = "xpath=//form[@id='small-search-box-form']//button";
	
	public static final String RESULT_H2 = "xpath=//h2[@class='product-title']//a";
	public static final String RESULT_BY_HEADER_PATTERN = "xpath=//h2[@class='product-title']//a[text()='%s']";
	
}
