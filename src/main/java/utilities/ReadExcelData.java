package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
    private XSSFSheet sheet;
    private XSSFWorkbook workbook;

    public ReadExcelData(String path, String sheetName) throws IOException {
        File src = new File(path);
        FileInputStream fi = new FileInputStream(src);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
    }
    public String[][] readAllData() {
        int totalRows = sheet.getPhysicalNumberOfRows();
        int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();

        String testData[][] = new String[totalRows - 1][totalCols]; // Exclude header row
        DataFormatter format = new DataFormatter();

        for (int i = 1; i < totalRows; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                for (int j = 0; j < totalCols; j++) {
                    testData[i - 1][j] = format.formatCellValue(row.getCell(j));
                }
            }
        }
        return testData;
    }
    public String getCellData(int row, int columnNo) {
        XSSFCell cell = sheet.getRow(row).getCell(columnNo);

        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((int) cell.getNumericCellValue());
        } else {
            return null;
        }
    }
  

    
}

/*import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
    private XSSFSheet sheet;
    private XSSFWorkbook workbook;

    public ReadExcelData(String path, String sheetName) throws IOException {
       
            File src = new File(path);
            FileInputStream fi = new FileInputStream(src);
            workbook = new XSSFWorkbook(fi);
            sheet = workbook.getSheet(sheetName);
        
    }

    public String getCellData(int rowNo, int columnNo) {
     
            XSSFCell cell = sheet.getRow(rowNo).getCell(columnNo);

            if (cell.getCellType() == CellType.STRING) {
                return cell.getStringCellValue();
            } else if (cell.getCellType() == CellType.NUMERIC) {
                return String.valueOf((int) cell.getNumericCellValue());
            } else {
                return null;
                
            }
            
       
    }
    
}
/* @DataProvider(name = "testdata")
    public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
        String excelSheetName = m.getName();
        System.out.println(excelSheetName);

        FileInputStream fis = new FileInputStream(constant.EXCEL_FILE_PATH);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheet(excelSheetName);

        int totalRows = sheetName.getLastRowNum() + 1; // Include the last row
        System.out.println("Total rows: " + totalRows);

        Row headerRow = sheetName.getRow(0);
        int totalCols = headerRow.getLastCellNum();
        System.out.println("Total columns: " + totalCols);

        DataFormatter format = new DataFormatter();

        String testData[][] = new String[totalRows - 1][totalCols]; // Exclude header row
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
    }*/
