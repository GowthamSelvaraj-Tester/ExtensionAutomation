package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	//Imported the Required Dependencies to read the excel file 
	private XSSFWorkbook excelworkBook;
	private XSSFSheet excelSheet;
	private XSSFCell cell;
	private XSSFRow row;
				
	//Method to set the Excel file location and sheet name.
	public void setExcelFile(String sheetPath, String sheetName) throws Exception  {
		try {
			FileInputStream inputStream = new FileInputStream(sheetPath);// FileInputStream to read the Excel file
			excelworkBook = new XSSFWorkbook(inputStream);// Initialize the workbook with the file input stream
			excelSheet = excelworkBook.getSheet(sheetName.trim());// Get the sheet by name, trimming any extra spaces
			if (excelSheet == null) {
				throw new Exception("Sheet not found: " + sheetName);// Throw an exception if the sheet is not found
			}
		} catch (Exception e) {
			e.printStackTrace();// Print the stack trace if an exception occurs
		}
	}

	//Method to find out the exact row for the test case 
	private int getTestCaseRow(String testCaseName, int testCaseColumn) throws Exception {
		if (excelSheet == null) { // Check whether the sheet has been loaded
			throw new Exception("Excel sheet not loaded. Please call setExcelFile first.");// Throw an exception if the sheet is not loaded
		}
		int row = 0;// Initialize row index to 0
		try {
			int rowCount = excelSheet.getLastRowNum();// Get the last row number
			for (row = 0; row <= rowCount; row++) {
				if (getCellData(row, testCaseColumn).equalsIgnoreCase(testCaseName)) {// Check each row in the specified column for the test case name
					break;// Break the loop if the test case name is found
				}
			}
		} catch (Exception e) {
			e.printStackTrace();// Print the stack trace if an exception occurs
		}
		return row;// Return the row index where the test case name is found
	}
				    
	// Method to get cell data
	public String getCellData(int rowNumb, int colNumb) throws Exception {
		try {
			//Check the exact cell
			cell = excelSheet.getRow(rowNumb).getCell(colNumb);
			// Check the value of the Cell Type and convert into String if it's numeric
			if(cell.getCellType() == CellType.NUMERIC) {
				cell.setCellType(CellType.STRING);
			}
			String cellData = cell.getStringCellValue();// Get the string value of the cell
				return cellData;// Return the cell data
		} catch(Exception e) {
			e.printStackTrace();// Print the stack trace if an exception occurs
			return " ";// Return empty string in case of an exception
		}
	}
			
	// Method to set cell data
	public void setCellData(String result,int rowNumb, int colNumb, String excelFilePath) throws Exception {
		try {
			row = excelSheet.getRow(rowNumb); //Retrieves the specified row and cell.
			cell = row.getCell(colNumb);
			if(cell == null) { //Creates the cell if it doesn't exist or updates it if it does.
				cell = row.createCell(colNumb);
				cell.setCellValue(result);
			} else {
				cell.setCellValue(result);
			}
			FileOutputStream output = new FileOutputStream(excelFilePath);
			excelworkBook.write(output);//Writes the updated workbook
			output.flush();
			output.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
				
	//Method to fetch the data from the excel and store it in the Map<Object, Key> Method
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getdata(String testCaseName, String sheetPath, String sheetName) throws Exception {
		Map dataMap= new HashMap<String, String>(); // Create a new HashMap to store the data from the Excel sheet
		try {
			setExcelFile(sheetPath,sheetName); // Set the Excel file to read from
			int dataRow = getTestCaseRow(testCaseName.trim(),0); // Find the row number of the test case
			int columnCount = excelSheet.getRow(dataRow).getLastCellNum();// Get the number of columns in the row
			for(int i=0; i < columnCount ; i++) { // Iterate over each column in the row
				String cellData = null;
				cell = excelSheet.getRow(dataRow).getCell(i);
				if(cell!= null && cell.getCellType() == CellType.NUMERIC) { // If the cell contains numeric data, convert it to a string
					cell.setCellType(CellType.STRING);
				} 
				if(cell!=null) { 	// If the cell is not null, get the cell's string value
					cellData = cell.getStringCellValue();
				}
				dataMap.put(excelSheet.getRow(0).getCell(i).getStringCellValue(),cellData); // Store the header from the first row as the key and the cell data as the value in the map	
			}	
		} catch(Exception e) {
			e.printStackTrace();// Print the stack trace if an exception occurs
		}
		return dataMap ; // Return the map containing the data
	}
}
