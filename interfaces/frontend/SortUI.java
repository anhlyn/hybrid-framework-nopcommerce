package frontend;

public class SortUI {

	public static final String SEL_SORT = "//div[@class='product-sorting']//select";
	public static final String SEL_DISPLAY = "//div[@class='product-page-size']//select";
	public static final String PAGER = "//div[@class='pager']";
	public static final String NEXT_PAGE = "//div[@class='pager']//li[@class='next-page']";
	public static final String PREV_PAGE = "//div[@class='pager']//li[@class='previous-page']";
	public static final String PAGE_BY_NUMBER = "//div[@class='pager']//a[text()='%s']";
	
	public static final String PRODUCT_NAMES = "//div[@class='item-grid']//h2[@class='product-title']/a";
	public static final String PRODUCT_PRICES = "//div[@class='item-grid']//span[contains(@class, 'actual-price')]";
	
}
