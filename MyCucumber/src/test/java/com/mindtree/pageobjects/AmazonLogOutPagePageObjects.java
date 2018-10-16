package com.mindtree.pageobjects;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.uistore.AmazonHomePageUI;
import com.mindtree.uistore.AmazonLoginPageUI;
import com.mindtree.utilities.Logging;

public class AmazonLogOutPagePageObjects {

	public static void amazonLogOut() throws FileNotFoundException {

		// Setting the browser dimensions dynamically
		// ResponsiveWebDesign.setLoginDimensions(ReusableComponents.driver);

		// Configure Log4j to perform error logging
		Logging.configure();

		// Hovering over 'Hello, Gautam' drop down and selecting 'Sign Out'
		WebElement elementToHover = ReusableComponents.driver.findElement(AmazonHomePageUI.signInButton);
		WebElement elementToClick = ReusableComponents.driver.findElement(AmazonHomePageUI.signOutLink);
		Actions action = new Actions(ReusableComponents.driver);
		action.moveToElement(elementToHover).click(elementToClick).build().perform();

		ReusableComponents.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Logging.logger.info("Logged out successfully.");

		// Clicking on Amazon logo to navigate back to home page
		ReusableComponents.driver.findElement(AmazonLoginPageUI.logo).click();

		Logging.logger.info("Navigated back to the home page.");

	}

}
