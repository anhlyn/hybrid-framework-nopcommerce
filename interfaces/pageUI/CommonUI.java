package pageUI;

public class CommonUI {

	//HEADER LINKS
	//register/login/logout/wishlist/cart/account
	public static final String HEADER_LINKS_PATTERN = "xpath=//div[@class='header-links']//a[@class='ico-%s']";
	
	public static final String SEARCH_INPUT = "css=input#small-searchterms"; //"//input[@id='small-searchterms']"
	public static final String SEARCH_BUTTON = "xpath=//form[@id='small-search-box-form']//button";
	
	public static final String PAGE_TITLE = "css=div.page-title h1"; //"//div[@class='page-title']//h1"
	
	//FOOTER LINKS AND MY ACCOUNT AREA
	//My account/Sitemap/Blog...
	public static final String FOOTER_LINKS_PATTERN = "xpath=//ul[@class='list']//a[text()='%s']";
	
}
