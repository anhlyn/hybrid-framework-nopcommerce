package pageUI;

public class CheckoutUI {

	//BILLING ADDRESS
	public static final String CHK_SHIP_TO_SAME_ADDRESS = "//input[@id='ShipToSameAddress']";
	public static final String TXT_BILLING_FNAME = "//input[@id='BillingNewAddress_FirstName']";
	public static final String TXT_BILLING_LNAME = "//input[@id='BillingNewAddress_LastName']";
	public static final String TXT_BILLING_EMAIL = "//input[@id='BillingNewAddress_Email']";
	public static final String SEL_BILLING_COUNTRY = "//select[@id='BillingNewAddress_CountryId']";
	public static final String TXT_BILLING_CITY = "//input[@id='BillingNewAddress_City']";
	public static final String TXT_BILLING_ADDRESS_1 = "//input[@id='BillingNewAddress_Address1']";
	public static final String TXT_BILLING_ZIP = "//input[@id='BillingNewAddress_ZipPostalCode']";
	public static final String TXT_BILLING_PHONE = "//input[@id='BillingNewAddress_PhoneNumber']";
	public static final String BTN_BILLING_CONTINUE = "//div[@id='billing-buttons-container']/button[text()='Continue']";
	
	//SHIPPING ADDRESS
	public static final String SEL_SHIPPING = "//select[@id='shipping-address-select']";
	public static final String TXT_SHIPPING_FNAME = "//input[@id='ShippingNewAddress_FirstName']";
	public static final String TXT_SHIPPING_LNAME = "//input[@id='ShippingNewAddress_LastName']";
	public static final String TXT_SHIPPING_EMAIL = "//input[@id='ShippingNewAddress_Email']";
	public static final String SEL_SHIPPING_COUNTRY = "//select[@id='ShippingNewAddress_CountryId']";
	public static final String TXT_SHIPPING_CITY = "//input[@id='ShippingNewAddress_City']";
	public static final String TXT_SHIPPING_ADDRESS_1 = "//input[@id='ShippingNewAddress_Address1']";
	public static final String TXT_SHIPPING_ZIP = "//input[@id='ShippingNewAddress_ZipPostalCode']";
	public static final String TXT_SHIPPING_PHONE = "//input[@id='ShippingNewAddress_PhoneNumber']";
	public static final String BTN_SHIPPING_CONTINUE = "//div[@id='shipping-buttons-container']//button[text()='Continue']";
	
	//SHIPPING METHOD
	public static final String RDO_SHIPPING_METHOD_BY_LBL_TEXT = "//label[text()='%s']/preceding-sibling::input[@type='radio']";
	public static final String BTN_SHIPPING_METHOD_CONTINUE = "//div[@id='shipping-method-buttons-container']/button[text()='Continue']";
	
	//PAYMENT METHOD
	public static final String RDO_PAYMENT_METHOD_BY_LBL_TEXT = "//label[text()='%s']/preceding-sibling::input[@type='radio']";
	public static final String BTN_PAYMENT_METHOD_CONTINUE = "//div[@id='payment-method-buttons-container']/button[text()='Continue']";
	
	//CONFIRM ORDER
	public static final String CONFIRM_ORDER_BILLING_INFO = "//div[@class='billing-info']//ul[@class='info-list']";
	public static final String CONFIRM_ORDER_SHIPPING_INFO = "//div[@class='shipping-info']//ul[@class='info-list']";
	public static final String CONFIRM_ORDER_SHIPPING_METHOD = "//li[@class='shipping-method']/span[@class='value']"; //Next Day Air
	public static final String CONFIRM_ORDER_PAYMENT_METHOD = "//li[@class='payment-method']/span[@class='value']"; //Check / Money Order
	
	
}
