// Required Cucumber plug-in is available at http://cucumber.github.io/cucumber-eclipse/update-site/ 
package com.mindtree.reusablecomponents;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class maintains all the reusable methods (components) used throughout
 * the project
 * 
 * @author M1046633
 *
 */

public class ReusableComponents {

	public static WebDriver driver;

	// Opening browser using Selenium WebDriver
	public static WebDriver openBrowser() throws Exception {

		// PropertiesConfigurator is used to configure URL from a .properties file
		FileInputStream inputProp = new FileInputStream(".\\properties\\other.properties");
		Properties property = new Properties();
		property.load(inputProp);

		// Setting the path of ChromeDriver file
		String driverPath = ".\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(property.getProperty("url"));

		return driver;

	}

	// Closing browser using Selenium WebDriver
	public static void closeBrowser() throws InterruptedException {

		Thread.sleep(2000);

		driver.quit();

	}

}
