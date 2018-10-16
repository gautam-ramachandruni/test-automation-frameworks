package com.mindtree.uistore;

import org.openqa.selenium.By;

import com.mindtree.reusablecomponents.ReusableComponents;

/**
 * This class contains all the required UI elements present on the Amazon home
 * page
 * 
 * @author M1046633
 *
 */

public class AmazonHomePageUI {

	// Amazon home page title
	public static final String title = ReusableComponents.driver.getTitle();

	// Amazon search bar
	public static final By amazonSearchBar = By.id("twotabsearchtextbox");

	// Amazon sign in button
	public static final By signInButton = By.id("nav-link-yourAccount");

	// 'Sign Out' link
	public static final By signOutLink = By.id("nav-item-signout-sa");

}
