package com.mindtree.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import com.mindtree.pageobjects.AmazonHomePagePageObjects;
import com.mindtree.pageobjects.AmazonLogOutPagePageObjects;
import com.mindtree.pageobjects.AmazonLoginPagePageObjects;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.utilities.Logging;
import cucumber.api.java.en.And;

/**
 * This step definition class is used to define each of the test steps as
 * specified in the Cucumber features file
 * 
 * @author M1046633
 *
 */

public class AmazonTestSteps {

	// private Scenario myScenario;

	@Given("^I navigate to home page$")
	public void iNavigateToHomePage() throws Throwable {

		// Setting the browser dimensions dynamically
		// ResponsiveWebDesign.setHomeDimensions(ReusableComponents.driver);

		// Configure Log4j to perform error logging
		Logging.configure();

		Logging.logger.info("A new test suite has started.");

		// Opening browser using Selenium WebDriver
		ReusableComponents.openBrowser();
		Logging.logger.info("ChromeDriver has opened Amazon.");

	}

	@When("^I log in as user$")
	public void iLogInAsUser() throws Throwable {

		AmazonLoginPagePageObjects.amazonLogin();

	}

	@And("^I log out$")
	public void iLogOut() throws Throwable {

		AmazonLogOutPagePageObjects.amazonLogOut();

	}

	@Then("^I search products to add to cart$")
	public void iSearchProductsToAddToCart() throws Throwable {

		AmazonHomePagePageObjects.amazonSearch();

	}

	/*
	 * @Then("^I take a screenshot$") public void iTakeAScreenshot() throws
	 * Throwable {
	 * 
	 * 
	 * myScenario.write("Current Page URL is " + driver.getCurrentUrl()); byte[]
	 * screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	 * myScenario.embed(screenshot, "image/png"); // Stick it in the report
	 * (WebDriverException somePlatformsDontSupportScreenshots) {
	 * log.error(somePlatformsDontSupportScreenshots.getMessage());
	 * 
	 * }
	 */

	@And("^I close the browser$")
	public void iCloseTheBrowser() throws Throwable {

		Logging.logger.info("The current test suite has completed.");

		// Closing browser using Selenium WebDriver
		ReusableComponents.closeBrowser();
		Logging.logger.info("ChromeDriver has closed Amazon.");

	}

}
