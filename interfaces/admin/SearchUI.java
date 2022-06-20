package admin;

public class SearchUI {
	
	public static final String TXT_SEARCH_PRODUCT_NAME = "//input[@id='SearchProductName']";
	public static final String SELECT_SEARCH_PRODUCT_CATE = "//select[@id='SearchCategoryId']";
	public static final String CHK_SEARCH_PRODUCT_SUB_CATE = "//input[@id='SearchIncludeSubCategories']";
	public static final String SELECT_SEARCH_PRODUCT_MANUFACTURER = "//select[@id='SearchManufacturerId']";
	public static final String TXT_SEARCH_PRODUCT_SKU = "//input[@id='GoDirectlyToSku']";
	public static final String BTN_SEARCH_PRODUCT_SKU = "//button[@id='go-to-product-by-sku']";
	
	public static final String DIV_AJAXBUSY = "//div[@id='ajaxBusy']";
	
	public static final String DIV_SEARCH_TOTAL = "//div[@id='products-grid_info']";
	public static final String DATATABLE_EMPTY = "//td[@class='dataTables_empty']";
	public static final String RESULT_SEARCH_FIRST_ROW_PRODUCT_NAME = "//table[@id='products-grid']/tbody/tr[1]/td[3]";
	public static final String RESULT_SEARCH_FRIST_ROW_SKU = "//table[@id='products-grid']/tbody/tr[1]/td[4]";
	public static final String RESULT_SEARCH_FIRST_ROW_PRICE = "//table[@id='products-grid']/tbody/tr[1]/td[5]";
	public static final String RESULT_SEARCH_FIRST_ROW_STOCK = "//table[@id='products-grid']/tbody/tr[1]/td[6]";
	
	public static final String BTN_SEARCH_PRODUCT = "//button[@id='search-products']";
}
