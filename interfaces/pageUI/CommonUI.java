package pageUI;

public class CommonUI {
	public static final String PAGE_TITLE = "//div[@class='page-title']/h1";
	public static final String RESULT_MSG = "//div[@class='page-body']/div[@class='result']";
	public static final String SUMMARY_ERR_MSG = "//div[contains(@class, 'validation-summary-errors')]/ul";
	
	public static final String LOGOUT_LINK_ON_HEADER = "//div[@class='header-links']//a[text()='Log out']";
	
	public static final String BAR_NOTI_SUCCESS_CONTENT = "//div[@class='bar-notification success']/p[@class='content']";
	public static final String BAR_NOTI_CLOSE = "//div[contains(@class, 'bar-notification')]//span[@class='close']";
	
}
