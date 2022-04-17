package com.nopcommerce.frontend;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import commons.BaseTest;
import commons.EnContanst;
import commons.Helper;
import commons.PageGenerator;
import pageObject.AddressObject;
import pageObject.ChangePasswordObject;
import pageObject.CustomerInfoObject;
import pageObject.DetailObject;
import pageObject.HomeObject;
import pageObject.LoginObject;
import pageObject.MyReviewObject;
import pageObject.RegisterObject;
import pageObject.SearchObject;

public class MyAccount extends BaseTest{
	
	private WebDriver d;
	private Helper helper;
	private DataTest datatest;
	private DataTest.RegisteredAccount registeredAcc;
	private DataTest.CustomerInfo customerInfo;
	private DataTest.Address address;
	private String newPassword;
	
	@BeforeClass
	@Parameters("browser")
	public void preCondition(@Optional("chrome") String b) {	
		d = getBrowserDriver(b);	
		helper = Helper.getHelper();
		
		//init data
		datatest = new DataTest();
		registeredAcc = datatest.new RegisteredAccount();
		customerInfo = datatest.new CustomerInfo();
		address = datatest.new Address();
		newPassword = (new Faker()).bothify("????####");
		
		//init pages object
		homePage = PageGenerator.getHomePage(d);
		loginPage = PageGenerator.getLoginPage(d);
		registerPage = PageGenerator.getRegisterPage(d);
		customerInfoPage = PageGenerator.getCustomerInfoPage(d);
		addressPage = PageGenerator.getAddressPage(d);
		changepassPage = PageGenerator.getChangePasswordPage(d);
		searchPage = PageGenerator.getSearchPage(d);
		detailPage = PageGenerator.getDetailPage(d);
		myreviewPage = PageGenerator.getMyReviewPage(d);
	}
	
	@Test(enabled=true)
	public void RegisterNewAccount() {
		
		log.info("Pre-Condition: RegisterNewAccount");
		
		log.info("open homepage");
		homePage.openHomepage();
		log.info("verify open homepage");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		log.info("click register link on header");
		helper.clickAnchorByClassAndText(d, "header-links", "Register");		
		registerPage.FillInformationOnRegisterForm(this.registeredAcc.firstName, this.registeredAcc.lastName, this.registeredAcc.email, this.registeredAcc.password, this.registeredAcc.confirmPassword);
		
		log.info("- verify register is successful.");
		Assert.assertEquals(helper.getResultMsg(d), EnContanst.MSG_REG_SUCCESS);
	}
	
	@Test(enabled=true,dependsOnMethods = {"RegisterNewAccount"})
	public void MyAccount_01_Update_CustomerInfo() {
		log.info("TC: MyAccount_01_Update_CustomerInfo");
		
		helper.clickAnchorByClassAndText(this.d, "header-links", "My account");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("customer/info"));
		
		if(customerInfo.gender.toLowerCase()=="f") {
			helper.clickInputById(this.d, "gender-female");
		}else {
			helper.clickInputById(this.d, "gender-male");
		}
		
		helper.typeInputById(this.d, "FirstName", customerInfo.firstName);
		helper.typeInputById(this.d, "LastName", customerInfo.lastName);
		helper.selectItemFromDropdownByName(this.d, "DateOfBirthDay", customerInfo.birthDay);
		helper.selectItemFromDropdownByName(this.d, "DateOfBirthMonth", customerInfo.birthMonth);
		helper.selectItemFromDropdownByName(this.d, "DateOfBirthYear", customerInfo.birthYear);
		helper.typeInputById(this.d, "Email", customerInfo.email);
		helper.typeInputById(this.d, "Company", customerInfo.company);
		
		helper.clickButtonByClassAndText(this.d, "buttons", "Save");
		
		//step 4: verify
		String genderId = "gender-male";
		if(customerInfo.gender.toLowerCase()=="f") {
			genderId = "gender-female";
		}
		Assert.assertTrue(helper.isRdoSelectedById(this.d, genderId));
		Assert.assertEquals(helper.getInputValueById(this.d, "FirstName"), customerInfo.firstName);
		Assert.assertEquals(helper.getInputValueById(this.d, "LastName"), customerInfo.lastName);
		Assert.assertEquals(helper.getInputValueById(this.d, "Email"), customerInfo.email);
		Assert.assertEquals(helper.getInputValueById(this.d, "Company"), customerInfo.company);

	}
	
	@Test(enabled=true,dependsOnMethods = {"RegisterNewAccount"})
	public void MyAccount_O2_Add_Address() {
		log.info("TC: MyAccount_O2_Add_Address");
		
		helper.clickAnchorByClassAndText(this.d, "header-links", "My account");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("customer/info"));
		
		helper.clickAnchorByClassAndText(this.d, "side-2", "Addresses");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("customer/addresses"));
		
		helper.clickButtonByClassAndText(this.d, "add-button", "Add new");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("customer/addressadd"));
		
		helper.typeInputById(this.d, "Address_FirstName", address.firstName);
		helper.typeInputById(this.d, "Address_LastName", address.lastName);
		helper.typeInputById(this.d, "Address_Email", address.email);
		helper.typeInputById(this.d, "Address_Company", address.company);
		helper.selectItemFromDropdownByName(this.d, "Address.CountryId", address.country);
		helper.typeInputById(this.d, "Address_City", address.city);
		helper.typeInputById(this.d, "Address_Address1", address.address1);
		helper.typeInputById(this.d, "Address_Address2", address.address2);
		helper.typeInputById(this.d, "Address_ZipPostalCode", address.zip);
		helper.typeInputById(this.d, "Address_PhoneNumber", address.phone);
		helper.typeInputById(this.d, "Address_FaxNumber", address.fax);
		
		helper.clickButtonByClassAndText(this.d, "buttons", "Save");
		
		//Verify
		Assert.assertTrue(addressPage.getFullNameText().contains(address.firstName + " " + address.lastName));
		Assert.assertTrue(addressPage.getEmailText().contains(address.email));
		Assert.assertTrue(addressPage.getPhoneText().contains(address.phone));
		Assert.assertTrue(addressPage.getFaxText().contains(address.fax));
		Assert.assertTrue(addressPage.getCompanyText().contains(address.company));
		Assert.assertTrue(addressPage.getAddress1Text().contains(address.address1));
		Assert.assertTrue(addressPage.getAddress2Text().contains(address.address2));
		Assert.assertTrue(addressPage.getCityAndZipText().contains(address.city + ", " + address.zip));
		Assert.assertTrue(addressPage.getCountryText().contains(address.country));
		
	}
	
	@Test(enabled=true,dependsOnMethods = {"RegisterNewAccount"})
	public void MyAccount_03_Change_Password() {
		log.info("TC: MyAccount_03_Change_Password");
		
		helper.clickAnchorByClassAndText(this.d, "header-links", "My account");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("customer/info"));
		
		helper.clickAnchorByClassAndText(this.d, "side-2", "Change password");
		Assert.assertTrue(Helper.getCurrentPageUrl(this.d).contains("customer/changepassword"));
		
		helper.typeInputById(this.d, "OldPassword", registeredAcc.password);
		helper.typeInputById(this.d, "NewPassword", this.newPassword);
		helper.typeInputById(this.d, "ConfirmNewPassword", this.newPassword);
		
		helper.clickButtonByClassAndText(this.d, "buttons", "Change password");
		
		Assert.assertTrue(changepassPage.isChangePassSuccessfull());
		
		changepassPage.closeNoti();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		helper.clickAnchorByClassAndText(this.d, "header-links", "Log out");
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		
		helper.clickAnchorByClassAndText(d, "header-links", "Log in");	
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.LOGINPAGE_TITLE);
		
		loginPage.FillInfoAndClickLoginBtn(registeredAcc.email, registeredAcc.password);
		System.out.println("email: " + registeredAcc.email + " | pass: " + registeredAcc.password);
		Assert.assertTrue(helper.getSummaryErrMsg(this.d).contains(EnContanst.ERR_MSG_LOGIN_WITH_EMPTY_PASSWORD));
		
		loginPage.FillInfoAndClickLoginBtn(registeredAcc.email, this.newPassword);
		System.out.println("email: " + registeredAcc.email + " | pass: " + this.newPassword);
		Assert.assertEquals(Helper.getPageTitle(this.d), EnContanst.HOMEPAGE_TITLE);
		Assert.assertTrue(helper.isLoginSuccessful(this.d));
		
	}
	
	/*@Parameters("product_add_review")
	@Test(enabled = true)
	public void MyAccount_04_Add_Review(String productName) {
		log.info("TC: MyAccount_04_Add_Review");
		searchPage.searchOnHeader(productName);
		detailPage = searchPage.clickByHeader(productName);
		int randomNum = generateRandomNumber();
		String title = "this is title " + randomNum;
		String text = "this is text " + randomNum;
		
		//add new review
		detailPage.addReview(title, text, "4");
		//click My account on header
		myaccountPage = detailPage.clickMyAccountLinkOnHeader(d);
		//click My product review
		myreviewPage = myaccountPage.clickMyReviewOnSidebar(d);
		// get first review
		HashMap<String, String> firstReview = myreviewPage.getFirstReview();
		//Verify
		Assert.assertEquals(firstReview.get("title"), title);
		Assert.assertEquals(firstReview.get("text"), text);
		Assert.assertEquals(firstReview.get("product_name"), productName);
		String width = firstReview.get("rate");
		System.out.println("-- width:" + width);
		int rating = 1;
		if(width.contains("100")) {
			rating = 5;
		}else if(width.contains("76")) {
			rating = 4;
		}else if(width.contains("60")) {
			rating = 3;
		}else if(width.contains("40")) {
			rating = 2;
		}
		Assert.assertEquals(rating, 4);
	}*/
	
	@AfterClass(enabled=true, alwaysRun=true)
	 public void afterClass() {
		log.info("close browser");
		quitBrowser(d);
	}

	private HomeObject homePage;
	private LoginObject loginPage;
	private RegisterObject registerPage;
	private CustomerInfoObject customerInfoPage;
	private AddressObject addressPage;
	private ChangePasswordObject changepassPage;
	private SearchObject searchPage;
	private DetailObject detailPage;
	private MyReviewObject myreviewPage;
	
}
