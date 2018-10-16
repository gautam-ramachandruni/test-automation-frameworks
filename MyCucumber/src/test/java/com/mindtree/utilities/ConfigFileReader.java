package com.mindtree.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This reader utility reads the configuration path of the Cucumber extent
 * report
 * 
 * @author M1046633
 *
 */

public class ConfigFileReader {

	public static String getReportConfigPath() throws IOException {

		// PropertiesConfigurator is used to configure URL from a .properties file
		FileInputStream inputProp = new FileInputStream(".\\properties\\other.properties");
		Properties property = new Properties();
		property.load(inputProp);

		String reportConfigPath = property.getProperty("reportConfigPath");
		if (reportConfigPath != null) {

			return reportConfigPath;

		} else {

			throw new RuntimeException("The reportConfigPath is not specified!");
		}

	}

}
