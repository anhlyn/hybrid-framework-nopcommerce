package frontend;

public class DetailProductUI {
	
	//$s = Be the first to review this product / Add your review
	public static final String ADD_REVIEW = "xpath=//a[text()='%s']";
	
	public static final String REVIEW_TITLE_INPUT = "xpath=//input[@id='AddProductReview_Title']";
	public static final String REVIEW_TEXT_INPUT = "xpath=//textarea[@id='AddProductReview_ReviewText']";
	public static final String REVIEW_RATING_RDO_PATTERN = "xpath=//input[@id='addproductrating_%s']";
	public static final String REVIEW_SUBMIT_BTN = "xpath=//button[@type='submit' and @name='add-review']";
	
}
