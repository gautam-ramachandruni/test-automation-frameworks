package com.mindtree.reusablecomponents;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import com.mindtree.utilities.Logging;

/**
 * This test class comprises of the auxiliary annotations (methods) that coexist
 * along with the main test methods
 * 
 * @author M1046633
 *
 */

public class BaseClass {

	public static WebDriver driver;

	@BeforeClass
	public static void setup() throws Exception {

		// Configure Log4j to perform error logging
		Logging.configure();

		Logging.logger.info("In the setup() method.");
		Logging.logger.info("A new test suite has started.");

		// Opening browser using Selenium WebDriver
		driver = ReusableComponents.openBrowser();
		Logging.logger.info("ChromeDriver has opened Amazon.");

	}

	@AfterClass
	public static void teardown() throws InterruptedException {

		Logging.logger.info("In the teardown() method.");
		Logging.logger.info("The current test suite has completed.");

		// Closing browser using Selenium WebDriver
		ReusableComponents.closeBrowser();
		Logging.logger.info("ChromeDriver has closed Amazon.");

	}

}
