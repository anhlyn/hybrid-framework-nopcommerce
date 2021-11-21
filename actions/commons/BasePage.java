package commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.interactions.Actions;

public class BasePage {
	
	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
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
	
	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(By.xpath(locator));
	}
	
	public List<WebElement> getWebElements(WebDriver driver, String locator){
		return driver.findElements(By.xpath(locator));
	}
	
	public String getTextElement(WebElement element) {
		return element.getText();
	}
	
	public String getTextElement(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}
	
	public String getAttributeValue(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}
	
	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		return getWebElement(driver, locator).getAttribute(attributeName);
	}
	
	public String getCssValue(WebElement element, String cssAttribute) {
		return element.getCssValue(cssAttribute);
	}
	
	public String getCssValue(WebDriver driver, String locator, String cssAttribute) {
		return getWebElement(driver, locator).getCssValue(cssAttribute);
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
	
	public boolean isWebElementDisplayed(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}
	
	public boolean isWebElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}
	
	public boolean isWebElementEnabled(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}
	
	public void uncheckTheCheckbox(WebElement element) {
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public void clickToElement(WebElement element) {
		element.click();
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}
	
	public void sendKeyToElement(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = getWebElement(driver, locator);
		element.clear();
		element.sendKeys(value);
	}
	
	public Actions createActionFromDriver(WebDriver driver) {
		return new Actions(driver);
	}
	
	public void dbClickToElement(WebDriver driver, WebElement element) {
		createActionFromDriver(driver).doubleClick(element).perform();
	}
	
	public void dbClickToElement(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		createActionFromDriver(driver).doubleClick(element).perform();
	}
	
	public void hoverMouseToElement(WebDriver driver, WebElement element) {
		createActionFromDriver(driver).moveToElement(element).perform();
	}
	
	public void hoverMouseToElement(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		createActionFromDriver(driver).moveToElement(element).perform();
	}
	
	public void rightClickToElement(WebDriver driver, WebElement element) {
		createActionFromDriver(driver).contextClick(element).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String locator) {
		createActionFromDriver(driver).contextClick(getWebElement(driver, locator)).perform();
	}
	
	public void dragAndDropToElement(WebDriver driver, WebElement a, WebElement b) {
		createActionFromDriver(driver).dragAndDrop(a, b).build().perform();
	}
	
	public void dragAndDropToElement(WebDriver driver, String locatorA, String locatorB) {
		WebElement a = getWebElement(driver, locatorA);
		WebElement b = getWebElement(driver, locatorB);
		createActionFromDriver(driver).dragAndDrop(a, b).build().perform();
	}
	
	
	
}