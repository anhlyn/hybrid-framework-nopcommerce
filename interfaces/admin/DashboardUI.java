package admin;

public class DashboardUI {
	public static final String FIRST_NAV = "//ul[@role='menu' and @data-widget='treeview']/li/a/p[contains(text(),'%s')]";
	public static final String SECOND_NAV = "//ul[@role='menu' and @data-widget='treeview']/li/a/p[contains(text(),'%s')]/ancestor::li[contains(@class,'menu-open')]/ul/li//p[contains(text(),'%s')]";
}
