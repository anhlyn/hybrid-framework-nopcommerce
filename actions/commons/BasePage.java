package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import pageObject.BlogObject;
import pageObject.MyAccountObject;
import pageObject.SitemapObject;
import pageUI.CommonUI;

public class BasePage {
	
	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public void closeFocusBrowser(WebDriver driver) {
		driver.close();
	}
	
	public void quitBrowsers(WebDriver driver) {
		driver.quit();
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void back(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void pageLoadTimeout(WebDriver driver, int x) {
		driver.manage().timeouts().pageLoadTimeout(x, TimeUnit.MILLISECONDS);
	}
	
	private WebElement getWebElement(WebDriver driver, String locatorPattern, String... params) {
		
		System.out.println(locatorPattern);
		String replacedLocator = String.format(locatorPattern, (Object[])params);
		System.out.println(replacedLocator);
		String lowerCaseLocatorPattern = replacedLocator.toLowerCase();
		
		By byObject = null;
		//Only use 5 locator types: id/name/class/css/xpath
		if(lowerCaseLocatorPattern.startsWith("id")) {
			System.out.println("replacedLocator.substring: " + replacedLocator.substring(3));
			byObject = By.id(replacedLocator.substring(3));
		}else if(lowerCaseLocatorPattern.startsWith("name")) {
			System.out.println("replacedLocator.substring: " + replacedLocator.substring(5));
			byObject = By.name(replacedLocator.substring(5));
		}else if(lowerCaseLocatorPattern.startsWith("class")) {
			System.out.println("replacedLocator.substring: " + replacedLocator.substring(6));
			byObject = By.className(replacedLocator.substring(6));
		}else if(lowerCaseLocatorPattern.startsWith("css")) {
			System.out.println("replacedLocator.substring: " + replacedLocator.substring(4));
			byObject = By.cssSelector(replacedLocator.substring(4));
		}else if(lowerCaseLocatorPattern.startsWith("xpath")) {
			System.out.println("replacedLocator.substring: " + replacedLocator.substring(6));
			byObject = By.xpath(replacedLocator.substring(6));
		}
		
		return driver.findElement(byObject);
	}
	
	public String getTextElement(WebElement element) {
		return element.getText();
	}
	
	public String getTextElement(WebDriver driver, String locatorPattern, String... params) {
		return getWebElement(driver, locatorPattern, params).getText();
	}
	
	public String getAttributeValue(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}
	
	public String getAttributeValue(WebDriver driver, String locatorPattern, String attributeName, String... params) {
		return getWebElement(driver, locatorPattern, params).getAttribute(attributeName);
	}
	
	public String getCssValue(WebElement element, String cssAttribute) {
		return element.getCssValue(cssAttribute);
	}
	
	public String getCssValue(WebDriver driver, String locatorPattern, String cssAttribute, String... params) {
		return getWebElement(driver, locatorPattern, params).getCssValue(cssAttribute);
	}
	
	public boolean isWebElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public boolean isWebElementSelected(WebElement element) {
		return element.isSelected();
	}
	
	public boolean isWebElementEnabled(WebElement element) {
		return element.isEnabled();
	}
	
	public boolean isWebElementDisplayed(WebDriver driver, String locatorPattern, String... params) {
		return getWebElement(driver, locatorPattern, params).isDisplayed();
	}
	
	public boolean isWebElementSelected(WebDriver driver, String locatorPattern, String... params) {
		return getWebElement(driver, locatorPattern, params).isSelected();
	}
	
	public boolean isWebElementEnabled(WebDriver driver, String locatorPattern, String... params) {
		return getWebElement(driver, locatorPattern, params).isEnabled();
	}
	
	public void uncheckTheCheckbox(WebElement element) {
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public void selectDefaultDropdown(WebElement element, String item) {
		Select cb = new Select(element);
		cb.selectByVisibleText(item);
	}
	
	public void selectDefaultDropdown(WebDriver driver, String locatorPattern, String item) {
		Select cb = new Select(getWebElement(driver, locatorPattern));
		cb.selectByVisibleText(item);
	}
	
	public void clickToElement(WebElement element) {
		element.click();
	}
	
	public void clickToElement(WebDriver driver, String locatorPattern,  String... params) {
		getWebElement(driver, locatorPattern, params).click();
	}
	
	public void sendKeyToElement(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	public void sendKeyToElement(WebDriver driver, String locatorPattern, String value,  String... params) {
		WebElement element = getWebElement(driver, locatorPattern, params);
		element.clear();
		element.sendKeys(value);
	}
	
	public Actions createActionFromDriver(WebDriver driver) {
		return new Actions(driver);
	}
	
	public void dbClickToElement(WebDriver driver, WebElement element) {
		createActionFromDriver(driver).doubleClick(element).perform();
	}
	
	public void dbClickToElement(WebDriver driver, String locatorPattern,  String... params) {
		WebElement element = getWebElement(driver, locatorPattern, params);
		createActionFromDriver(driver).doubleClick(element).perform();
	}
	
	public void hoverMouseToElement(WebDriver driver, WebElement element) {
		createActionFromDriver(driver).moveToElement(element).perform();
	}
	
	public void hoverMouseToElement(WebDriver driver, String locatorPattern, String... params) {
		WebElement element = getWebElement(driver, locatorPattern, params);
		createActionFromDriver(driver).moveToElement(element).perform();
	}
	
	public void rightClickToElement(WebDriver driver, WebElement element) {
		createActionFromDriver(driver).contextClick(element).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String locatorPattern,  String... params) {
		createActionFromDriver(driver).contextClick(getWebElement(driver, locatorPattern, params)).perform();
	}
	
	public void dragAndDropToElement(WebDriver driver, WebElement a, WebElement b) {
		createActionFromDriver(driver).dragAndDrop(a, b).build().perform();
	}
	
	public void dragAndDropToElement(WebDriver driver, String locatorPatternA, String locatorPatternB, String... params) {
		WebElement a = getWebElement(driver, locatorPatternA, params);
		WebElement b = getWebElement(driver, locatorPatternB, params);
		createActionFromDriver(driver).dragAndDrop(a, b).build().perform();
	}
	
	//common actions
	public MyAccountObject clickMyAccountLinkOnFooter(WebDriver driver) {
		clickToElement(driver, CommonUI.FOOTER_LINKS_PATTERN, "My account");
		return PageGeneratorManager.getMyAccountPage(driver);
	}
	
	public SitemapObject clickSitemapLinkOnFooter(WebDriver driver) {
		clickToElement(driver, CommonUI.FOOTER_LINKS_PATTERN, "Sitemap");
		return PageGeneratorManager.getSitemapPage(driver);
	}
	
	public BlogObject clickBlogLinkOnFooter(WebDriver driver) {
		clickToElement(driver, CommonUI.FOOTER_LINKS_PATTERN, "Blog");
		return PageGeneratorManager.getBlogPage(driver);
	}
	
}
