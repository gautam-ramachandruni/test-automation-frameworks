package com.mindtree.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.mindtree.utilities.ConfigFileReader;
import com.mindtree.utilities.Logging;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TestRunners are used to run the test steps by 'gluing' together the test
 * steps listed in the feature file with their definitions in the step
 * definitions package
 * 
 * @author M1046633
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = { ".\\features\\amazon.feature" }, glue = { "com.mindtree.stepdefinitions" }, plugin = {
		"pretty", "html:.\\reports\\cucumber-reports\\",
		"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:" }, monochrome = true)

public class AmazonTestRunner {

	static String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());

	// This will execute before all test steps start
	@BeforeClass
	public static void setup() throws FileNotFoundException {

		// Configure Log4j to perform error logging
		Logging.configure();

		Logging.logger.info("In the setup() method of AmazonTestRunner.");

		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath(".\\reports\\cucumber-reports\\cucumber-extent-" + timeStamp + ".html");

		Logging.logger.info("The path has been set for Cucumber extent report generation.");

	}

	/*
	 * @Before() public void embedScreenshotStep(Scenario scenario) {
	 * 
	 * myScenario = scenario;
	 * 
	 * }
	 */

	// This will execute after all test steps finish
	@AfterClass
	public static void teardown() throws Exception {

		Logging.logger.info("In the teardown() method of AmazonTestRunner.");

		Reporter.loadXMLConfig(new File(ConfigFileReader.getReportConfigPath()));

		// Setting multiple system properties to the report
		Reporter.setSystemInfo("Username ", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone ", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine ", "Windows 10" + "64 Bit");
		Reporter.setSystemInfo("Java Version ", "1.8.0_151");

		Logging.logger.info("Cucumber extent report generated.");

		/*
		 * Logging.logger.info("Opening Cucumber extent report..."); // Opening
		 * generated Cucumber extent report OpenCucumberReport.openReport();
		 */

	}

}
