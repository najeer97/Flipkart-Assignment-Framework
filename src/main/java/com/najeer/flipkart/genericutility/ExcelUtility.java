package com.najeer.flipkart.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is for Reading the data from excel sheet
 * @author Najeer
 *
 */

public class ExcelUtility {
	/**
	 * This method is used to read the String cell data
	 * @author Najeer
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return cellData
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String readStringData(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TrelloCommenData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String cellData = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		workbook.close();
		return cellData;
	}
	
	/**
	 * This method is used to read the Numeric data from the excel
	 * @author Najeer
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public double readNumericData(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TrelloCommenData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		double cellData = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
		workbook.close();
		return cellData;
	}
	
/**
 * This method is used to get last cell index value from the excel
 * @author Najeer
 * @param sheetName
 * @param rowNum
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public short lastCellIndex(String sheetName, int rowNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TrelloCommenData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		short lastCellNum = workbook.getSheet(sheetName).getRow(rowNum).getLastCellNum();
		return lastCellNum;
	}
}
