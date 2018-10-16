package com.mindtree.pageobjects;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.uistore.AmazonHomePageUI;
import com.mindtree.uistore.AmazonLoginPageUI;
import com.mindtree.utilities.Logging;

/**
 * This page object class holds the business logic to sign into Google
 * 
 * @author M1046633
 *
 */

public class AmazonLoginPagePageObjects {

	public static void amazonLogin() throws Exception {

		// Setting the browser dimensions dynamically
		// ResponsiveWebDesign.setLoginDimensions(ReusableComponents.driver);

		// Configure Log4j to perform error logging
		Logging.configure();

		// PropertiesConfigurator is used to configure URL from a .properties file
		FileInputStream inputProp = new FileInputStream(".\\properties\\other.properties");
		Properties property = new Properties();
		property.load(inputProp);

		ReusableComponents.driver.findElement(AmazonHomePageUI.signInButton).click();

		// Enter an existing username
		ReusableComponents.driver.findElement(AmazonLoginPageUI.usernameField)
				.sendKeys(property.getProperty("username"));
		ReusableComponents.driver.findElement(AmazonLoginPageUI.usernameField).sendKeys(Keys.ENTER);
		Logging.logger.info("Entered valid username.");

		ReusableComponents.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Enter corresponding password
		ReusableComponents.driver.findElement(AmazonLoginPageUI.passwordField)
				.sendKeys(property.getProperty("password"));
		ReusableComponents.driver.findElement(AmazonLoginPageUI.passwordField).sendKeys(Keys.ENTER);
		Logging.logger.info("Entered corresponding password.");

		ReusableComponents.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Logging.logger.info("Log in successful!");

	}

}
