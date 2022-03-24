package pageUI;

public class CommonUI {

	//HEADER LINKS
	//register/login/logout/wishlist/cart/account
	public static final String HEADER_LINKS_PATTERN = "xpath=//div[@class='header-links']//a[@class='ico-%s']";
	public static final String PAGE_TITLE = "xpath=//div[@class='page-title']//h1"; 
	
	//FOOTER LINKS AND MY ACCOUNT AREA
	//My account/Sitemap/Blog...
	public static final String FOOTER_LINKS_PATTERN = "xpath=//ul[@class='list']//a[text()='%s']";
	
	public static final String SIDEBAR_ADDRESSES = "xpath=//div[@class='side-2']//a[text()='Addresses']";
	public static final String SIDEBAR_CHANGEPASS = "xpath=//div[@class='side-2']//a[text()='Change password']";
	public static final String SIDEBAR_MYREVIEW = "xpath=//div[@class='side-2']//a[text()='My product reviews']";
	
}
