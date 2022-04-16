package commons;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
	
	public void pageLoadTimeout(WebDriver driver, int x) {
		driver.manage().timeouts().pageLoadTimeout(x, TimeUnit.MILLISECONDS);
	}
	
	private WebElement getWebElement(WebDriver driver, String locatorPattern, String... params) {		
		return driver.findElement(By.xpath(String.format(locatorPattern, (Object[])params)));	
	}
	
	protected List<WebElement> getWebElements(WebDriver driver, String locatorPattern, String... params) {
		return driver.findElements(By.xpath(String.format(locatorPattern, (Object[])params)));
	}
	
	public List<String> getTextElements(WebDriver driver, String locatorPattern, String...params) {
		List<WebElement> elements = getWebElements(driver, locatorPattern, params);
		List<String> result = new ArrayList<String>();
		for(WebElement element:elements) {
			result.add(element.getText());
		}
		return result;
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
	
	public void uncheckTheCheckbox(WebDriver driver, String locatorPattern, String... params) {
		WebElement element = getWebElement(driver, locatorPattern, params);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public void selectDefaultDropdown(WebElement element, String item) {
		Select cb = new Select(element);
		cb.selectByVisibleText(item);
	}
	
	public void selectDefaultDropdown(WebDriver driver, String item, String locatorPattern, String... params) {
		Select cb = new Select(getWebElement(driver, locatorPattern, params));
		cb.selectByVisibleText(item);
	}
	
	public String getSelectedOptionTextInDropdown(WebDriver driver, String locatorPattern) {
		Select cb = new Select(getWebElement(driver, locatorPattern));
		return cb.getFirstSelectedOption().getText();
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
	
}
