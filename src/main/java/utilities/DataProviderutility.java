package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import Constant.constant;

public class DataProviderutility {
	
	@DataProvider(name = "testdata")
    public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
        String excelSheetName = m.getName();
        System.out.println(excelSheetName);

        FileInputStream fis = new FileInputStream(constant.EXCEL_FILE_PATH);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheet(excelSheetName);

        int totalRows = sheetName.getLastRowNum() + 1; 
        System.out.println("Total rows: " + totalRows);

        Row headerRow = sheetName.getRow(0);
        int totalCols = headerRow.getLastCellNum();
        System.out.println("Total columns: " + totalCols);

        DataFormatter format = new DataFormatter();

        String testData[][] = new String[totalRows - 1][totalCols]; 
        for (int i = 1; i < totalRows; i++) {
            Row row = sheetName.getRow(i);
            if (row != null) {
                for (int j = 0; j < totalCols; j++) {
                    testData[i - 1][j] = format.formatCellValue(row.getCell(j));
                    System.out.println(testData[i - 1][j]);
                }
            } else {
                System.out.println("Row " + i + " is null or empty.");
            }
        }
        return testData;
    }
	    }


