package pageUI;

public class CommonUI {
	public static final String PAGE_TITLE = "//div[@class='page-title']/h1";
	public static final String RESULT_MSG = "//div[@class='page-body']/div[@class='result']";
	public static final String SUMMARY_ERR_MSG = "//div[contains(@class, 'validation-summary-errors')]/ul";
	
	public static final String LOGOUT_LINK_ON_HEADER = "//div[@class='header-links']//a[text()='Log out']";
	
	public static final String BAR_NOTI_SUCCESS_CONTENT = "//div[@class='bar-notification success']/p[@class='content']";
	public static final String BAR_NOTI_CLOSE = "//div[contains(@class, 'bar-notification')]//span[@class='close']";
	
	public static final String BREADSCRUM = "//div[@class='breadcrumb']";
	public static final String AJAX_PRODUCTS_BUSY = "//div[@class='ajax-products-busy']";
	
	public static final String CONTENT = "//div[@class='table-wrapper']";
	public static final String NO_DATA = "//div[@class='no-data']";
	
	public static final String REMOVE_BUTTON_ON_TABLE = "//td[@class='remove-from-cart']/button";
	public static final String REMOVE_BUTTON_ON_TABLE_BY_PRODUCT_NAME = "//div[@class='table-wrapper']//a[@class='product-name' and text()='%s']/ancestor::tr//button";
	public static final String CHK_ON_TABLE_BY_PRODUCT_NAME = "//div[@class='table-wrapper']//a[@class='product-name' and text()='%s']/ancestor::tr//input";
	public static final String ATTR_ON_TABLE_BY_PRODUCT_NAME = "//div[@class='table-wrapper']//a[@class='product-name' and text()='%s']/following-sibling::div[@class='attributes']";
	public static final String TOTAL_PRICE_ON_TABLE_BY_PRODUCT_NAME = "//div[@class='table-wrapper']//a[@class='product-name' and text()='%s']/ancestor::tr//span[@class='product-subtotal']";
	public static final String PRODUCT_NAME_ON_TABLE_BY_TEXT = "//div[@class='table-wrapper']//a[@class='product-name' and text()='%s']";
	public static final String TXT_QTY_ON_TABLE_BY_PRODUCT_NAME = "//div[@class='table-wrapper']//a[@class='product-name' and text()='%s']/ancestor::tr//input[@class='qty-input']";
	
	public static final String PRODUCT_NAME_ON_PRODUCT_GRID_BY_TEXT = "//div[@class='product-grid']//h2[@class='product-title']/a[text()='%s']";
	
	public static final String FLYOUT_CART_ACTIVE = "//div[@id='flyout-cart']";
	public static final String FLYOUT_CART_COUNT = "//div[@id='flyout-cart']//div[@class='count']/a";
	public static final String FLYOUT_CART_PRODUCT_NAME = "//div[@id='flyout-cart']//div[@class='name']/a";
	public static final String FLYOUT_CART_ATTR = "//div[@id='flyout-cart']//div[@class='attributes']";
	public static final String FLYOUT_CART_QTY = "//div[@id='flyout-cart']//div[@class='quantity']/span";
	public static final String FLYOUT_CART_PRICE = "//div[@id='flyout-cart']//div[@class='totals']/strong";
	
	public static final String EDIT_LINK_ON_TABLE_BY_PRODUCT_NAME = "//div[@class='table-wrapper']//td[@class='product']/a[text()='%s']/following-sibling::div[@class='edit-item']/a";
	
}


