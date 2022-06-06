package pageObject.frontend;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.Helper;
import frontend.CartUI;
import frontend.CheckoutUI;

public class CheckoutObject extends BasePage{
	
	WebDriver driver;
	Helper helper;
	
	public CheckoutObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		helper = new Helper();
	}
	
	public void ChkAgreeTermOfService() {
		clickToElement(this.driver, CartUI.CHK_TERM_OF_SERVICE);
	}
	
	public void UncheckChkShipToSameAddress(){
		uncheckTheCheckbox(this.driver, CheckoutUI.CHK_SHIP_TO_SAME_ADDRESS);
	}
	
	public void FillBillingAddressForm(HashMap<String, String> billing){
		if(billing.get("firstname").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.TXT_BILLING_FNAME, billing.get("firstname").toString());
		}
		if(billing.get("lastname").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.TXT_BILLING_LNAME, billing.get("lastname").toString());
		}
		if(billing.get("email").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.TXT_BILLING_EMAIL, billing.get("email").toString());
		}
		if(billing.get("country").toString().length()>0){
			selectDefaultDropdown(this.driver, billing.get("country").toString(), CheckoutUI.SEL_BILLING_COUNTRY);
			helper.waitUntilPageLoaded(this.driver);
		}
		if(billing.get("city").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.TXT_BILLING_CITY, billing.get("city").toString());
		}
		if(billing.get("address1").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.TXT_BILLING_ADDRESS_1, billing.get("address1").toString());
		}
		if(billing.get("zip").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.TXT_BILLING_ZIP, billing.get("zip").toString());
		}
		if(billing.get("phone").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.TXT_BILLING_PHONE, billing.get("phone").toString());
		}
		clickToElement(this.driver, CheckoutUI.BTN_BILLING_CONTINUE);
		helper.waitUntilPageLoaded(this.driver);
	}
	
	public void FillNewShippingAddress(HashMap<String, String> shipping){
		selectDefaultDropdown(this.driver, "New Address", CheckoutUI.SEL_SHIPPING);
		helper.waitUntilPageLoaded(this.driver);
		if(shipping.get("firstname").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.TXT_SHIPPING_FNAME, shipping.get("firstname").toString());
		}
		if(shipping.get("lastname").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.TXT_SHIPPING_LNAME, shipping.get("lastname").toString());
		}
		if(shipping.get("email").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.TXT_SHIPPING_EMAIL, shipping.get("email").toString());
		}
		if(shipping.get("country").toString().length()>0){
			selectDefaultDropdown(this.driver, shipping.get("country").toString(), CheckoutUI.SEL_SHIPPING_COUNTRY);
			helper.waitUntilPageLoaded(this.driver);
		}
		if(shipping.get("city").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.TXT_SHIPPING_CITY, shipping.get("city").toString());
		}
		if(shipping.get("address1").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.TXT_SHIPPING_ADDRESS_1, shipping.get("address1").toString());
		}
		if(shipping.get("zip").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.TXT_SHIPPING_ZIP, shipping.get("zip").toString());
		}
		if(shipping.get("phone").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.TXT_SHIPPING_PHONE, shipping.get("phone").toString());
		}
		clickToElement(this.driver, CheckoutUI.BTN_SHIPPING_CONTINUE);
		helper.waitUntilPageLoaded(this.driver);
	}
	
	public void FillNewCreditCard(HashMap<String, String> credit){
		selectDefaultDropdown(this.driver, credit.get("credittype"), CheckoutUI.SEL_CREDIT_CARD_TYPE);
		helper.waitUntilPageLoaded(this.driver);
		if(credit.get("holdername").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.CARD_HOLDER_NAME, credit.get("holdername").toString());
		}
		if(credit.get("cardnumber").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.CARD_NUMBER, credit.get("cardnumber").toString());
		}
		if(credit.get("expiredmonth").toString().length()>0){
			selectDefaultDropdown(this.driver, credit.get("expiredmonth"), CheckoutUI.CARD_EXPIRED_MONTH);
		}
		if(credit.get("expiredyear").toString().length()>0){
			selectDefaultDropdown(this.driver, credit.get("expiredyear"), CheckoutUI.CARD_EXPIRED_YEAR);
		}
		if(credit.get("cardcode").toString().length()>0){
			sendKeyToElement(this.driver, CheckoutUI.CARD_CODE, credit.get("cardcode").toString());
		}
		clickToElement(this.driver, CheckoutUI.BTN_PAYMENT_INFO_CONTINUE);
		helper.waitUntilPageLoaded(this.driver);
	}
	
	public void clickConfirmOrder(){
		clickToElement(this.driver, CheckoutUI.BTN_CONFIRM_ORDER);
		helper.waitUntilPageLoaded(this.driver);
	}
	
	public String getOrderNumber(){
		String orderNum = getTextElement(this.driver, CheckoutUI.ORDER_NUMBER);
		return orderNum.split(": ")[1];
	}
	
	public void clickDetailOnOrderMenu(String orderNumber){
		clickToElement(this.driver, CheckoutUI.DETAIL_BY_ORDER_NUMBER, orderNumber);
		helper.waitUntilPageLoaded(this.driver);
	}
	
	public void ChooseShippingMethodAndClickContinue(String method){
		clickToElement(this.driver, CheckoutUI.RDO_SHIPPING_METHOD_BY_LBL_TEXT, method);
		clickToElement(this.driver, CheckoutUI.BTN_SHIPPING_METHOD_CONTINUE);
		helper.waitUntilPageLoaded(this.driver);
	}
	
	public void ChoosePaymentMethodAndClickContiue(String method){
		clickToElement(this.driver, CheckoutUI.RDO_PAYMENT_METHOD_BY_LBL_TEXT, method);
		clickToElement(this.driver, CheckoutUI.BTN_PAYMENT_METHOD_CONTINUE);
		helper.waitUntilPageLoaded(this.driver);
	}
	
	public void clickPaymentInfoContinue(){
		clickToElement(this.driver, CheckoutUI.BTN_PAYMENT_INFO_CONTINUE);
		helper.waitUntilPageLoaded(this.driver);
	}
	
	public String getConfirmBilling(){
		return getTextElement(this.driver, CheckoutUI.CONFIRM_ORDER_BILLING_INFO);
	}
	
	public String getConfirmShipping(){
		return getTextElement(this.driver, CheckoutUI.CONFIRM_ORDER_SHIPPING_INFO);
	}
	
	public String getConfirmPaymentMethod(){
		return getTextElement(this.driver, CheckoutUI.CONFIRM_ORDER_PAYMENT_METHOD);
	}
	
	public String getConfirmShippingMethod(){
		return getTextElement(this.driver, CheckoutUI.CONFIRM_ORDER_SHIPPING_METHOD);
	}
}
