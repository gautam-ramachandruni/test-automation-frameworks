package com.mindtree.uistore;

import org.openqa.selenium.By;

/**
 * This class contains all the required UI elements on the Amazon products page
 * 
 * @author M1046633
 *
 */

public class AmazonProductPageUI {

	// Product link
	public static final By product = By.cssSelector("li[id='result_0'] div[class='a-column a-span12 a-text-center']");

	// Add to cart button
	public static final By addToCartButton = By.id("add-to-cart-button");

}
