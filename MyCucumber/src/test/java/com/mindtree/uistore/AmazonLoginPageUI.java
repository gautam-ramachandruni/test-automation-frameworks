package com.mindtree.uistore;

import org.openqa.selenium.By;

/**
 * This class contains all the required UI elements on the Amazon login page
 * 
 * @author M1046633
 *
 */

public class AmazonLoginPageUI {

	// Username input field
	public static final By usernameField = By.id("ap_email");

	// Password input field
	public static final By passwordField = By.id("ap_password");

	// Amazon logo
	public static final By logo = By.cssSelector("a[class='a-link-nav-icon'] i[class='a-icon a-icon-logo']");

}
