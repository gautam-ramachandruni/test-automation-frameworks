package com.mindtree.utilities;

import org.openqa.selenium.WebDriver;
import com.mindtree.reusablecomponents.ReusableComponents;

/**
 * This utility will open the generated extent report
 * 
 * @author M1046633
 *
 */

public class OpenCucumberReport {

	public static void openReport() throws Exception {

		WebDriver driver = ReusableComponents.openBrowser();

		// Report time stamp
		String time = FileUtils.timeStamp;

		// File to open
		String file = ".\\reports\\cucumber-reports\\cucumber-extent-" + time + ".html";

		// Opening Cucumber extent report
		driver.get(file);

	}

}
