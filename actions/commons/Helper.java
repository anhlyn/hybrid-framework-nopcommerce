package commons;

import org.openqa.selenium.WebDriver;

public class Helper extends BasePage {

	public static String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
}
