package com.nopcommerce.frontend;

//import org.apache.commons.logging.LogFactory;
//import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.frontend.DataTest.Billing;
import com.nopcommerce.frontend.DataTest.Payment;
import com.nopcommerce.frontend.DataTest.RegisteredAccount;
import com.nopcommerce.frontend.DataTest.Shipping;

import commons.BaseTest;
import commons.EnContanst;
import commons.Helper;
import commons.PageGenerator;
import pageObject.frontend.CheckoutObject;
import pageObject.frontend.DetailObject;
import pageObject.frontend.HomeObject;
import pageObject.frontend.LoginObject;
import pageObject.frontend.RegisterObject;


public class Order extends BaseTest{
	
	WebDriver d;
	private Helper helper;
	private DataTest datatest;
	private RegisteredAccount registeredAcc;
	private Billing billing;
	private Shipping shipping;
	private Payment payment;
	private String productName = "Build your own computer";
	
	private String lblProcessor = "Processor";
	private String processor = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
	
	private String lblRAM = "RAM";
	private String ram = "4GB [+$20.00]";
	
	private String lblHDD = "HDD";
	private String hdd = "320 GB";
	
	private String lblOS = "OS";
	private String os = "Vista Premium [+$60.00]";
	private String priceOnDetail = "$1,345.00";
	private String totalPrice = "$2,920.00";
	
	
	@Parameters("browser")
	@BeforeClass
	public void preCondition(@Optional("chrome") String b) {		
		d = getBrowserDriver(b);	
		helper = Helper.getHelper();
		//init data
		datatest = new DataTest();
		registeredAcc = datatest.new RegisteredAccount();
		billing = datatest.new Billing();
		shipping = datatest.new Shipping();
		payment = datatest.new Payment();
		
		homePage = PageGenerator.getHomePage(d);
		loginPage = PageGenerator.getLoginPage(d);
		registerPage = PageGenerator.getRegisterPage(d);
		detailPage = PageGenerator.getDetailPage(d);
		checkoutPage = PageGenerator.getCheckoutPage(d);
	}
	
	@Test(enabled=true)
	public void Register_New_Account() {
		
		log.info("TC: Register_03_Success");
		
		log.info("open homepage");
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click register link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Register");	
		registerPage.FillInformationOnRegisterForm(registeredAcc.firstName, registeredAcc.lastName, registeredAcc.email, registeredAcc.password, registeredAcc.password);
		
		log.info("- verify register is successful.");
		Assert.assertEquals(helper.getResultMsg(d), EnContanst.MSG_REG_SUCCESS);
		
		log.info("click logout link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Log out");
		log.info("verify after logout successfully and then redirect to homepage");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
	}
	
	@Test(enabled = true, dependsOnMethods = "Register_New_Account")
	public void Login_06_Success() {
		log.info("Login_01_Empty_Data");
		log.info("- Step 1: open homepage");
		homePage.openHomepage();
		log.info("Verify open homepage successfully.");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click login link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Log in");	
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.LOGINPAGE_TITLE);
		
		loginPage.FillInfoAndClickLoginBtn(registeredAcc.email, registeredAcc.password);
		System.out.println("email: " + registeredAcc.email + " | pass: " + registeredAcc.password);
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		Assert.assertTrue(helper.isLoginSuccessful(this.d));	
	}
	
	@Test(enabled=false, dependsOnMethods="Login_06_Success")
	public void Empty_Cart_List() {
		//click Add To Cart
		helper.clickAnchorByClassAndText(this.d, "header-links", "Shopping cart");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("cart"));
		
		helper.EmptyTheList(this.d);
	}
	
	@Test(enabled=false, dependsOnMethods = "Empty_Cart_List")
	public void TC_01_Add_To_Cart_From_Detail_Page() {
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);

		View_Detail_Page("Computers ", "Desktops ", this.productName);
		//select Processor
		detailPage.selectItemFromSelByLabel(" Processor ", this.processor);
		//select RAM
		detailPage.selectItemFromSelByLabel(" RAM ", this.ram);
		//click rdo HDD
		detailPage.clickRdoByLabel(this.hdd);
		//click rdo OS
		detailPage.clickRdoByLabel(this.os);
		//click Add To Cart
		helper.clickButtonByClassAndText(this.d, "add-to-cart-panel", "Add to cart");
		Assert.assertEquals(helper.getBarNotiSuccessMsg(this.d), EnContanst.MSG_ADD_TO_CART_SUCCESS);
		helper.closeBarNoti(this.d);
		
		//hover header-link Shopping cart (1)
		helper.hoverShoppingCart(this.d);
		Assert.assertEquals(helper.getTextFromHeaderLink(this.d, "Shopping cart"), String.format(EnContanst.SHOPPING_CART_TEXT_HEADER_LINK, "1"));
		Assert.assertEquals(helper.getFlyoutCartCount(this.d), String.format(EnContanst.FLYOUT_CART_COUNT, "1"));
		Assert.assertEquals(helper.getFlyoutProductName(this.d), this.productName);
		
		String flyoutAttribute = helper.getFlyoutAttribute(this.d);
		Assert.assertTrue(flyoutAttribute.contains(String.format("%s: %s", this.lblProcessor, this.processor)));
		Assert.assertTrue(flyoutAttribute.contains(String.format("%s: %s", this.lblRAM, this.ram)));
		Assert.assertTrue(flyoutAttribute.contains(String.format("%s: %s", this.lblHDD, this.hdd)));
		Assert.assertTrue(flyoutAttribute.contains(String.format("%s: %s", this.lblOS, this.os)));
		
		Assert.assertEquals(helper.getFlyoutPrice(this.d), this.priceOnDetail);
	}
	
	@Test(enabled=false, dependsOnMethods = "TC_01_Add_To_Cart_From_Detail_Page")
	public void TC_02_Edit_Product_In_Order_Cart() {
		helper.clickAnchorByClassAndText(this.d, "header-links", "Shopping cart");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("cart"));
		
		helper.clickEditOnTableByProductName(this.d, this.productName);
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("?updatecartitemid="));
		
		this.processor = "2.2 GHz Intel Pentium Dual-Core E2200";
		this.ram = "8GB [+$60.00]";
		this.hdd = "400 GB [+$100.00]";
		this.os = "Vista Home [+$50.00]";
		this.priceOnDetail = "$1,460.00";
		
		//select Processor
		detailPage.selectItemFromSelByLabel(" Processor ", this.processor);
		//select RAM
		detailPage.selectItemFromSelByLabel(" RAM ", this.ram);
		//click rdo HDD
		detailPage.clickRdoByLabel(this.hdd);
		//click rdo OS
		detailPage.clickRdoByLabel(this.os);
		//type quantity
		detailPage.typeQty("2");
		
		String actualProductPrice = detailPage.getProductPrice();
		
		//verify updated price on detail page.
		Assert.assertEquals(actualProductPrice, this.priceOnDetail);
		
		//click Add To Cart
		helper.clickButtonByClassAndText(this.d, "add-to-cart-panel", "Update");
		Assert.assertEquals(helper.getBarNotiSuccessMsg(this.d), EnContanst.MSG_ADD_TO_CART_SUCCESS);
		helper.closeBarNoti(this.d);
		
		//click shopping cart on header-links
		helper.clickAnchorByClassAndText(this.d, "header-links", "Shopping cart");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("cart"));
		
		String attr = helper.getAttrInTableByProductName(this.d, this.productName);
		Assert.assertTrue(attr.contains(String.format("%s: %s", this.lblProcessor, this.processor)));
		Assert.assertTrue(attr.contains(String.format("%s: %s", this.lblRAM, this.ram)));
		Assert.assertTrue(attr.contains(String.format("%s: %s", this.lblHDD, this.hdd)));
		Assert.assertTrue(attr.contains(String.format("%s: %s", this.lblOS, this.os)));
		Assert.assertEquals(helper.getTotalPriceOnTableByProductName(this.d, this.productName), this.totalPrice);
	}
	
	@Test(enabled=false, dependsOnMethods = "TC_01_Add_To_Cart_From_Detail_Page")
	public void TC_03_Remove_From_Cart() {
		helper.clickAnchorByClassAndText(this.d, "header-links", "Shopping cart");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("cart"));
		
		helper.removeItemByProductName(this.d, this.productName);
		Assert.assertEquals(helper.getNoDataMsgBelowTable(this.d), EnContanst.MSG_CART_EMPTY);
	}
	
	@Test(enabled=false, dependsOnMethods = "TC_01_Add_To_Cart_From_Detail_Page")
	public void TC_04_Update_Cart() {
		helper.clickAnchorByClassAndText(this.d, "header-links", "Shopping cart");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("cart"));
		
		helper.removeItemByProductName(this.d, this.productName);
		Assert.assertEquals(helper.getNoDataMsgBelowTable(this.d), EnContanst.MSG_CART_EMPTY);
		
		this.productName = "HTC One M8 Android L 5.0 Lollipop";
		this.totalPrice = "$1,225.00";
		homePage.openHomepage();
		homePage.addToCartByProductName(this.productName);
		
		Assert.assertEquals(helper.getBarNotiSuccessMsg(this.d), EnContanst.MSG_ADD_TO_CART_SUCCESS);
		helper.closeBarNoti(this.d);
		
		//hover header-link Shopping cart (1)
		helper.hoverShoppingCart(this.d);
		Assert.assertEquals(helper.getTextFromHeaderLink(this.d, "Shopping cart"), String.format(EnContanst.SHOPPING_CART_TEXT_HEADER_LINK, "1"));
		
		helper.clickAnchorByClassAndText(this.d, "header-links", "Shopping cart");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("cart"));
		
		//Update Quantity upto 5
		helper.typeQtyOnTableByProductName(this.d, this.productName, "5");
		helper.clickButtonByClassAndText(this.d, "common-buttons", "Update shopping cart");
		helper.waitUntilPageLoaded(this.d);
		Assert.assertEquals(helper.getTotalPriceOnTableByProductName(this.d, this.productName), "$1,225.00");
	}
	
	@Test(enabled=false, dependsOnMethods = "Login_06_Success")
	public void TC_05_Checkout_By_Check() {
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		helper.clickAnchorByClassAndText(this.d, "header-links", "Shopping cart");
		helper.EmptyTheList(this.d);
		Assert.assertEquals(helper.getNoDataMsgBelowTable(this.d), EnContanst.MSG_CART_EMPTY);
		
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		this.productName = "HTC One M8 Android L 5.0 Lollipop";
		homePage.addToCartByProductName(productName);
		helper.getBarNotiSuccessMsg(this.d);
		helper.closeBarNoti(this.d);
		Assert.assertEquals(helper.getTextFromHeaderLink(this.d, "Shopping cart"), String.format(EnContanst.SHOPPING_CART_TEXT_HEADER_LINK, "1"));
		
		//main steps
		helper.clickAnchorByClassAndText(this.d, "header-links", "Shopping cart");
		//check agree term of service
		checkoutPage.ChkAgreeTermOfService();
		//click <CHECKOUT>
		helper.clickButtonByClassAndText(this.d, "checkout-buttons", " Checkout ");
		//if session expired and then log out
		if(Helper.getCurrentPageUrl(this.d).contains("checkoutasguest")) {
			loginPage.FillInfoAndClickLoginBtn(this.registeredAcc.email, this.registeredAcc.password);
			Assert.assertTrue(helper.isLoginSuccessful(this.d));
		}
		checkoutPage.UncheckChkShipToSameAddress();
		checkoutPage.FillBillingAddressForm(billing.convertToHashMap());
		checkoutPage.FillNewShippingAddress(shipping.convertToHashMap());
		checkoutPage.ChooseShippingMethodAndClickContinue(shipping.method);
		checkoutPage.ChoosePaymentMethodAndClickContiue(payment.method);
		checkoutPage.clickPaymentInfoContinue();
		//Verify Confirm Order
		String confirmBilling = checkoutPage.getConfirmBilling();
		Assert.assertTrue(confirmBilling.contains(String.format("%s %s", billing.firstName, billing.lastName)));
		Assert.assertTrue(confirmBilling.contains(billing.email));
		Assert.assertTrue(confirmBilling.contains(billing.phone));
		Assert.assertTrue(confirmBilling.contains(billing.address1));
		Assert.assertTrue(confirmBilling.contains(String.format("%s,%s", billing.city, billing.zip)));
		Assert.assertTrue(confirmBilling.contains(billing.country));
		
		String confirmShipping = checkoutPage.getConfirmShipping();
		Assert.assertTrue(confirmShipping.contains(String.format("%s %s", shipping.firstName, shipping.lastName)));
		Assert.assertTrue(confirmShipping.contains(shipping.email));
		Assert.assertTrue(confirmShipping.contains(shipping.phone));
		Assert.assertTrue(confirmShipping.contains(shipping.address1));
		Assert.assertTrue(confirmShipping.contains(String.format("%s,%s", shipping.city, shipping.zip)));
		Assert.assertTrue(confirmShipping.contains(shipping.country));
		
		Assert.assertEquals(checkoutPage.getConfirmPaymentMethod(), payment.method);
		Assert.assertTrue(shipping.method.contains(checkoutPage.getConfirmShippingMethod()));
		Assert.assertTrue(helper.isProductNameInTable(this.d, this.productName));
		
		//click Confirm
		checkoutPage.clickConfirmOrder();
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("checkout/completed"));
	}
	
	@Test(enabled=false, dependsOnMethods = "Login_06_Success")
	public void TC_06_Checkout_Credit_Card(){
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		helper.clickAnchorByClassAndText(this.d, "header-links", "Shopping cart");
		helper.EmptyTheList(this.d);
		Assert.assertEquals(helper.getNoDataMsgBelowTable(this.d), EnContanst.MSG_CART_EMPTY);
		
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		this.productName = "HTC One M8 Android L 5.0 Lollipop";
		homePage.addToCartByProductName(productName);
		helper.getBarNotiSuccessMsg(this.d);
		helper.closeBarNoti(this.d);
		Assert.assertEquals(helper.getTextFromHeaderLink(this.d, "Shopping cart"), String.format(EnContanst.SHOPPING_CART_TEXT_HEADER_LINK, "1"));
		
		//main steps
		helper.clickAnchorByClassAndText(this.d, "header-links", "Shopping cart");
		//check agree term of service
		checkoutPage.ChkAgreeTermOfService();
		//click <CHECKOUT>
		helper.clickButtonByClassAndText(this.d, "checkout-buttons", " Checkout ");
		//if session expired and then log out
		if(Helper.getCurrentPageUrl(this.d).contains("checkoutasguest")) {
			loginPage.FillInfoAndClickLoginBtn(this.registeredAcc.email, this.registeredAcc.password);
			Assert.assertTrue(helper.isLoginSuccessful(this.d));
		}
		checkoutPage.UncheckChkShipToSameAddress();
		checkoutPage.FillBillingAddressForm(billing.convertToHashMap());
		checkoutPage.FillNewShippingAddress(shipping.convertToHashMap());
		checkoutPage.ChooseShippingMethodAndClickContinue(shipping.method);
		
		//Change payment datatest to: Credit Card
		payment.method = "Credit Card";
		checkoutPage.ChoosePaymentMethodAndClickContiue(payment.method);
		
		checkoutPage.FillNewCreditCard(payment.convertToHashMap());
		//Verify Confirm Order
		String confirmBilling = checkoutPage.getConfirmBilling();
		Assert.assertTrue(confirmBilling.contains(String.format("%s %s", billing.firstName, billing.lastName)));
		Assert.assertTrue(confirmBilling.contains(billing.email));
		Assert.assertTrue(confirmBilling.contains(billing.phone));
		Assert.assertTrue(confirmBilling.contains(billing.address1));
		Assert.assertTrue(confirmBilling.contains(String.format("%s,%s", billing.city, billing.zip)));
		Assert.assertTrue(confirmBilling.contains(billing.country));
		
		String confirmShipping = checkoutPage.getConfirmShipping();
		Assert.assertTrue(confirmShipping.contains(String.format("%s %s", shipping.firstName, shipping.lastName)));
		Assert.assertTrue(confirmShipping.contains(shipping.email));
		Assert.assertTrue(confirmShipping.contains(shipping.phone));
		Assert.assertTrue(confirmShipping.contains(shipping.address1));
		Assert.assertTrue(confirmShipping.contains(String.format("%s,%s", shipping.city, shipping.zip)));
		Assert.assertTrue(confirmShipping.contains(shipping.country));
		
		Assert.assertEquals(checkoutPage.getConfirmPaymentMethod(), payment.method);
		Assert.assertTrue(shipping.method.contains(checkoutPage.getConfirmShippingMethod()));
		Assert.assertTrue(helper.isProductNameInTable(this.d, this.productName));
		
		//click Confirm
		checkoutPage.clickConfirmOrder();
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("checkout/completed"));
	}
	
	@Test(enabled=true, dependsOnMethods = "Login_06_Success")
	public void TC_07_Re_Order(){
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		helper.clickAnchorByClassAndText(this.d, "header-links", "Shopping cart");
		helper.EmptyTheList(this.d);
		Assert.assertEquals(helper.getNoDataMsgBelowTable(this.d), EnContanst.MSG_CART_EMPTY);
		
		homePage.openHomepage();
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		this.productName = "HTC One M8 Android L 5.0 Lollipop";
		homePage.addToCartByProductName(productName);
		helper.getBarNotiSuccessMsg(this.d);
		helper.closeBarNoti(this.d);
		Assert.assertEquals(helper.getTextFromHeaderLink(this.d, "Shopping cart"), String.format(EnContanst.SHOPPING_CART_TEXT_HEADER_LINK, "1"));
		
		//main steps
		helper.clickAnchorByClassAndText(this.d, "header-links", "Shopping cart");
		//check agree term of service
		checkoutPage.ChkAgreeTermOfService();
		//click <CHECKOUT>
		helper.clickButtonByClassAndText(this.d, "checkout-buttons", " Checkout ");
		//if session expired and then log out
		if(Helper.getCurrentPageUrl(this.d).contains("checkoutasguest")) {
			loginPage.FillInfoAndClickLoginBtn(this.registeredAcc.email, this.registeredAcc.password);
			Assert.assertTrue(helper.isLoginSuccessful(this.d));
		}
		checkoutPage.UncheckChkShipToSameAddress();
		checkoutPage.FillBillingAddressForm(billing.convertToHashMap());
		checkoutPage.FillNewShippingAddress(shipping.convertToHashMap());
		checkoutPage.ChooseShippingMethodAndClickContinue(shipping.method);
		
		payment.method = "Check / Money Order";
		checkoutPage.ChoosePaymentMethodAndClickContiue(payment.method);
		checkoutPage.clickPaymentInfoContinue();
		//Verify Confirm Order
		String confirmBilling = checkoutPage.getConfirmBilling();
		Assert.assertTrue(confirmBilling.contains(String.format("%s %s", billing.firstName, billing.lastName)));
		Assert.assertTrue(confirmBilling.contains(billing.email));
		Assert.assertTrue(confirmBilling.contains(billing.phone));
		Assert.assertTrue(confirmBilling.contains(billing.address1));
		Assert.assertTrue(confirmBilling.contains(String.format("%s,%s", billing.city, billing.zip)));
		Assert.assertTrue(confirmBilling.contains(billing.country));
		
		String confirmShipping = checkoutPage.getConfirmShipping();
		Assert.assertTrue(confirmShipping.contains(String.format("%s %s", shipping.firstName, shipping.lastName)));
		Assert.assertTrue(confirmShipping.contains(shipping.email));
		Assert.assertTrue(confirmShipping.contains(shipping.phone));
		Assert.assertTrue(confirmShipping.contains(shipping.address1));
		Assert.assertTrue(confirmShipping.contains(String.format("%s,%s", shipping.city, shipping.zip)));
		Assert.assertTrue(confirmShipping.contains(shipping.country));
		
		Assert.assertEquals(checkoutPage.getConfirmPaymentMethod(), payment.method);
		Assert.assertTrue(shipping.method.contains(checkoutPage.getConfirmShippingMethod()));
		Assert.assertTrue(helper.isProductNameInTable(this.d, this.productName));
		
		//click Confirm
		checkoutPage.clickConfirmOrder();
		helper.waitUntilPageLoaded(this.d);
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("checkout/completed"));
		datatest.orderNumber = checkoutPage.getOrderNumber();
		
		//main steps
		//click <My Account>
		helper.clickAnchorByClassAndText(this.d, "header-links", "My account");
		helper.clickAnchorByClassAndText(this.d, "side-2", "Orders");
		checkoutPage.clickDetailOnOrderMenu(datatest.orderNumber);
	}
	
	private void View_Detail_Page(String parentMenu, String childMenu, String pn) {
		helper.HoverParentAndClickSubMenu(d, parentMenu, childMenu);	
		Assert.assertTrue(helper.waitUntilPageLoaded(this.d));
		
		helper.clickAnchorByClassAndText(this.d, "product-item", pn);
		Assert.assertTrue(detailPage.isDetailProductPageLoaded());
	
	}
	
	 @AfterClass(enabled=false, alwaysRun=true)
	 public void afterClass() {
		log.info("close browser");
		quitBrowser(d);
	}
	 
	private HomeObject homePage;
	private LoginObject loginPage;
	private RegisterObject registerPage;
	private DetailObject detailPage;
	private CheckoutObject checkoutPage;
	
}
