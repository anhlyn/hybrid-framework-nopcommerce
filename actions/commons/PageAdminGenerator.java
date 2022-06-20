package commons;

import org.openqa.selenium.WebDriver;

import pageObject.admin.DashboardObject;
import pageObject.admin.LoginObject;

public class PageAdminGenerator {
	
	public static LoginObject getLoginPage(WebDriver d) {
		return new LoginObject(d);
	}
	
	public static DashboardObject getDashboardPage(WebDriver d){
		return new DashboardObject(d);
	}
}
