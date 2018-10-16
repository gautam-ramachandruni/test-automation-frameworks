package com.mindtree.pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.uistore.AmazonHomePageUI;
import com.mindtree.uistore.AmazonProductPageUI;
import com.mindtree.utilities.ExcelUtils;
import com.mindtree.utilities.Logging;

/**
 * This page object class contains the business logic for searching keywords on
 * Google showing similarities to a keyword-driven framework
 * 
 * @author M1046633
 *
 */

public class AmazonHomePagePageObjects {

	public static void amazonSearch() throws Exception {

		// Setting the browser dimensions dynamically
		// ResponsiveWebDesign.setHomeDimensions(ReusableComponents.driver);

		// Configure Log4j to perform error logging
		Logging.configure();

		// Declaring the path of the keywords Excel file
		String excelPath = ExcelUtils.getKeywordsPath();

		// Pass Excel path and sheetName to connect to Excel
		ExcelUtils.setExcelFile(excelPath, "Amazon Products");

		FileInputStream inputExcel = new FileInputStream(new File(excelPath));

		// Creating workbook
		Workbook workbook = WorkbookFactory.create(inputExcel);

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);

		Logging.logger.info("Excel data is loaded.");

		for (int keywordIndex = 1; keywordIndex < 3; keywordIndex++) {

			// Store method name from Excel as keyword variable
			String keyword = ExcelUtils.getCellData(keywordIndex, 1);
			Logging.logger.info("Keyword '" + keyword + "' is running.");

			if (keyword.equals("validate")) {

				if (AmazonHomePageUI.title.contains(
						"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {

					Logging.logger.info("Navigated to the Amazon home page.");

				} else {

					Logging.logger.info("Wrong page!");

				}

			} else if (keyword.equals("search")) {

				for (int productIndex = 1; productIndex < 4; productIndex++) {

					// Get product name from Excel and perform search on Amazon
					String product = ExcelUtils.getCellData(productIndex, 3);
					Logging.logger.info("Searching for " + product + "...");
					ReusableComponents.driver.findElement(AmazonHomePageUI.amazonSearchBar).sendKeys(product);
					ReusableComponents.driver.findElement(AmazonHomePageUI.amazonSearchBar).sendKeys(Keys.ENTER);

					// Click on first product
					ReusableComponents.driver.findElement(AmazonProductPageUI.product).click();

					ReusableComponents.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					// Switching between windows (tabs)
					for (String handle : ReusableComponents.driver.getWindowHandles()) {

						ReusableComponents.driver.switchTo().window(handle);

					}

					// Add product to cart
					ReusableComponents.driver.findElement(AmazonProductPageUI.addToCartButton).click();
					Logging.logger.info("Product added to cart.");

					// Write to Excel that product has been added
					Cell cell = sheet.getRow(productIndex).getCell(4);
					cell.setCellValue("Added");

					// Outputting content to Excel
					FileOutputStream output = new FileOutputStream(excelPath);
					workbook.write(output);
					output.close();

					// Clear search bar
					ReusableComponents.driver.findElement(AmazonHomePageUI.amazonSearchBar).clear();

				}

			}

			Logging.logger.info("Keyword '" + keyword + "' has closed.");

		}

	}

}
