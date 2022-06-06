package frontend;

public class DetailUI {
	
	public static final String AJAX_LOADING = "//div[@class='ajax-loading-block-window']";
	public static final String BAR_NOTI_SUCCESS = "//div[@class='bar-notification success']";
	public static final String BAR_NOTI_CLOSE = "//div[@class='bar-notification success']/span[@class='close']";
	
	public static final String PRODUCT_NAME = "//div[@class='product-name']/h1";	
	public static final String PRODUCT_PRICE = "//div[@class='product-essential']//div[@class='product-price']/span";
	
	public static final String PRODUCT_SEL_BY_LABEL = "//label[text()='%s']/parent::dt/following-sibling::dd/select";
	public static final String PRODUCT_RDO_BY_LABEL = "//label[text()='%s']/preceding-sibling::input[@type='radio']";
	public static final String PRODUCT_CHK_BY_LABEL = "//label[text()='%s']/preceding-sibling::input[@type='checkbox']";
	
	public static final String BTN_ADD_TO_WISHLIST = "//div[@class='add-to-wishlist']/button";
	
	public static final String TXT_QTY = "//input[@name='addtocart_1.EnteredQuantity']";
}
