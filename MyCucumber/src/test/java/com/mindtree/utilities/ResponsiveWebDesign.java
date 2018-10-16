package com.mindtree.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusablecomponents.ReusableComponents;

public class ResponsiveWebDesign {

	// Declaring the path of the keywords Excel file
	static String excelPath = ExcelUtils.getResponsivePath();

	public static void setHomeDimensions(WebDriver driver) throws Exception {

		// Pass Excel path and sheetName to connect to Excel
		ExcelUtils.setExcelFile(excelPath, "Dimensions");

		FileInputStream inputExcel = new FileInputStream(new File(excelPath));

		// Creating workbook
		Workbook workbook = WorkbookFactory.create(inputExcel);

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);

		String height = sheet.getRow(1).getCell(0).toString();
		int intHeight = (int) Float.parseFloat(height);

		String width = sheet.getRow(1).getCell(1).toString();
		int intWidth = (int) Float.parseFloat(width);

		Dimension dim = new Dimension(intHeight, intWidth);
		driver.manage().window().setSize(dim);

		ReusableComponents.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public static void setLoginDimensions(WebDriver driver) throws Exception {

		// Pass Excel path and sheetName to connect to Excel
		ExcelUtils.setExcelFile(excelPath, "Dimensions");

		FileInputStream inputExcel = new FileInputStream(new File(excelPath));

		// Creating workbook
		Workbook workbook = WorkbookFactory.create(inputExcel);

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);

		String height = sheet.getRow(2).getCell(0).toString();
		int intHeight = (int) Float.parseFloat(height);

		String width = sheet.getRow(2).getCell(1).toString();
		int intWidth = (int) Float.parseFloat(width);

		Dimension dim = new Dimension(intHeight, intWidth);
		driver.manage().window().setSize(dim);

		ReusableComponents.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

}
