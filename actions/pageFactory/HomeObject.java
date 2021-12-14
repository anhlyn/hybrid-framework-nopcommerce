package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class HomeObject extends BasePage{
	
	private WebDriver driver;
	private String url;
	
	public HomeObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		url = "https://demo.nopcommerce.com/";
		pageLoadTimeout(driver, 5000);
		//PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(xpath = "//div[@class='page-title']//h1")
	WebElement pageTitle;
	
	@CacheLookup
	@FindBy(xpath = "//div[@class='header-links']//a[@class='ico-logout']")
	WebElement logoutTopNav;
	
	@CacheLookup
	@FindBy(xpath = "//div[@class='header-links']//a[@class='ico-register']")
	WebElement registerTopNav;
	
	public void loadHomePage() {
		openPageUrl(driver, url);
	}
	
	public String getH1Title() {
		return getTextElement(pageTitle);
	}
	
	public void clickLogOutNav() {
		clickToElement(logoutTopNav);
	}
	
	public void clickRegisterNav() {
		clickToElement(registerTopNav);
	}
	
}
