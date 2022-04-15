package com.nopcommerce.frontend;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGenerator;
import pageObject.ChangePasswordObject;
import pageObject.DetailProductObject;
import pageObject.HomeObject;
import pageObject.LoginObject;
import pageObject.MyAccountObject;
import pageObject.MyAddressObject;
import pageObject.MyReviewObject;
import pageObject.RegisterObject;
import pageObject.SearchObject;

public class MyAccount extends BaseTest{
	
	private WebDriver d;
	
	private HomeObject homePage;
	private LoginObject loginPage;
	private RegisterObject registerPage;
	private MyAccountObject myaccountPage;
	private MyAddressObject addressPage;
	private ChangePasswordObject changepassPage;
	private SearchObject searchPage;
	private DetailProductObject detailPage;
	private MyReviewObject myreviewPage;
	
	private String email = "";
	private String password = "123456";
	
	@Parameters("browser")
	@BeforeClass
	public void preCondition(String b) {	
		d = getBrowserDriver(b);	
		
		//khoi tao pages
		homePage = PageGenerator.getHomePage(d);
		loginPage = PageGenerator.getLoginPage(d);
		registerPage = PageGenerator.getRegisterPage(d);
		myaccountPage = PageGenerator.getMyAccountPage(d);
		addressPage = PageGenerator.getMyAddressPage(d);
		changepassPage = PageGenerator.getChangePasswordPage(d);
		searchPage = PageGenerator.getSearchPage(d);
		detailPage = PageGenerator.getDetailPage(d);
		myreviewPage = PageGenerator.getMyReviewPage(d);

		registerNewAccount();
	}
	
	private void registerNewAccount() {
		//step 1: open homepage
		log.info("Open homepage");
		homePage.open();
		//step 2: click register link on header
		log.info("Click register link on header");
		registerPage = registerPage.clickRegisterLinkOnHeader(d);
		//step 3: fill all correct data
		String em = "human_" + generateRandomNumber() + "@gmail.com";
		System.out.println("-- new email: " + em);
		log.info("Generate new email name : " + em);
		
		log.info("Type first name textbox: first name");
		registerPage.typeFirstnameTxt("first name");
		log.info("Type last name textbox: last name");
		registerPage.typeLastnameTxt("last name");
		log.info("Type email textbox: "+em);
		registerPage.typeEmailTxt(em);
		log.info("Type password textbox: 123456");
		registerPage.typePasswordTxt("123456");
		log.info("Type confirm password textbox: 123456");
		registerPage.typeCPasswordTxt("123456");
		log.info("Click register button");
		registerPage.clickRegisterBtn();
		//Verify
		log.info("Verify your registration...");
		Assert.assertEquals(registerPage.getSuccessMsg(), "Your registration completed");
		this.email = em;
		
		log.info("Click logout link on header.");
		registerPage.clickLogoutOnHeader(d);
	}
	
	@BeforeMethod
	private void login() {
		log.info("@BeforeMethod: login()");
		//step 2: click login link on header
		loginPage.clickLoginOnHeader(d);
		//step 3:
		loginPage.typeEmailTxt(this.email);
		loginPage.typePasswordTxt(this.password);
		//step 4:
		loginPage.clickLoginBtn();
		//Verify
		Assert.assertTrue(loginPage.isLoginSuccess());
	}
	
	@AfterMethod
	private void logout() {
		log.info("@AfterMethod: logout()");
		homePage.clickLogoutOnHeader(d);
	}
	
	@Test
	public void MyAccount_O1_Update_Info() {
		log.info("TC: MyAccount_O1_Update_Info");
		
		//step 1: click My Account
		myaccountPage.clickMyAccountLinkOnHeader(d);
		Assert.assertTrue(myaccountPage.isCustomerInfoLoaded());
		//step 2: update info
		myaccountPage.selectFemaleRdo();
		myaccountPage.typeFirstName("Automation");
		myaccountPage.typeLastName("FC");
		myaccountPage.selectDateOfBirth("1");
		myaccountPage.selectMonthOfBirth("January");
		myaccountPage.selectYearOfBirth("1999");
		String updatedEmail = "human_" + generateRandomNumber() + "@gmail.com";
		System.out.println("updated email: " + updatedEmail);
		myaccountPage.typeEmailInput(updatedEmail);
		myaccountPage.typeCompanyInput("Automation FC");
		//step 3: click save
		myaccountPage.save();
		//step 4: verify
		Assert.assertTrue(myaccountPage.isFemaleRdoSelected());
		Assert.assertEquals(myaccountPage.getFirstNameValue(), "Automation");
		Assert.assertEquals(myaccountPage.getLastNameValue(), "FC");
		Assert.assertEquals(myaccountPage.getSelectedValueOfBirthday(), "1");
		Assert.assertEquals(myaccountPage.getSelectedValueOfBirthMonth(), "January");
		Assert.assertEquals(myaccountPage.getSelectedValueOfBirthYear(), "1999");
		Assert.assertEquals(myaccountPage.getEmailValue(), updatedEmail);
		Assert.assertEquals(myaccountPage.getCompanyValue(), "Automation FC");
		
		this.email = updatedEmail;
	}
	
	@Test
	public void MyAccount_O2_Add_Address() {
		log.info("TC: MyAccount_O2_Add_Address");
		//step 0: click My Account on header
		addressPage.clickMyAccountLinkOnHeader(d);
		//step 1: click Addresses
		addressPage.clickMyAddressesOnSidebar(d);
		//Assert.assertTrue(addressPage.isAddressesLoaded());
		//step 2: add new address
		addressPage.clickAddNew();
		addressPage.typeFirstName("Automation");
		addressPage.typeLastName("FC");
		addressPage.typeEmailInput("automationfc.vn@gmail.com");
		addressPage.typeCompanyInput("Automation FC");
		addressPage.selectCountry("Viet Nam");
		addressPage.typeCityInput("Da Nang");
		addressPage.typeAddress1Input("123/04 Le Lai");
		addressPage.typeAddress2Input("234/05 Hai Phong");
		addressPage.typePostalCodeInput("550000");
		addressPage.typePhoneInput("0123456789");
		addressPage.typeFaxInput("0987654321");
		//step 3: click save
		addressPage.save();
		//step 4: verify
		Assert.assertEquals(addressPage.getFullName(), "Automation FC");
		Assert.assertTrue(addressPage.getEmail().contains("automationfc.vn@gmail.com"));
		Assert.assertTrue(addressPage.getPhone().contains("0123456789"));
		Assert.assertTrue(addressPage.getFax().contains("0987654321"));
		Assert.assertTrue(addressPage.getCompany().contains("Automation FC"));
		Assert.assertTrue(addressPage.getAddress1().contains("123/04 Le Lai"));
		Assert.assertTrue(addressPage.getAddress2().contains("234/05 Hai Phong"));
		Assert.assertTrue(addressPage.getCityPostalCode().contains("Da Nang, 550000"));
		Assert.assertTrue(addressPage.getCountry().contains("Viet Nam"));
	}
	
	@Test
	public void MyAccount_03_Change_Password() {
		log.info("TC: MyAccount_03_Change_Password");
		//step 0: click My account on header
		changepassPage.clickMyAccountLinkOnHeader(d);
		//step 1: click chang password on sidebar
		changepassPage.clickChangePasswordOnSidebar(d);
		Assert.assertTrue(changepassPage.isChangePasswordLoaded());
		//step 2: fill new pass
		changepassPage.typeOldPass("123456");
		changepassPage.typeNewPass("654321");
		changepassPage.typeConfirmPass("654321");
		//step 3: click change password
		changepassPage.clickChangePassword();
		Assert.assertTrue(changepassPage.isSuccess());
		//step 4: close success noti
		changepassPage.closeNoti();
		//step 5: click logout
		changepassPage.clickLogoutOnHeader(d);
		//step 6: login with old password
		changepassPage.clickLoginOnHeader(d);
		loginPage.typeEmailTxt(this.email);
		loginPage.typePasswordTxt("123456");
		loginPage.clickLoginBtn();
		Assert.assertTrue(loginPage.getSummaryErrMsg().contains("The credentials provided are incorrect"));
		
		//step 7: login with new password
		changepassPage.clickLoginOnHeader(d);
		loginPage.typeEmailTxt(this.email);
		loginPage.typePasswordTxt("654321");
		loginPage.clickLoginBtn();
		
		this.password = "654321";
	}
	
	@Parameters("product_add_review")
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
	}
	
	
	@AfterClass
	public void afterClass() {
		log.info("@AfterClass: close browser");
		quitBrowser(d);
	}
	
}
