package testcase;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import Pages.FileManagerPage;
import Pages.LoginPage;
import utilities.ReadExcelData;
@Listeners(listeners.ListenerTestNG.class)
public class FileManagerTest extends BaseTest  { 
	LoginPage objLogin;
	FileManagerPage objfile;

@Test()
public void SavingDataByUploadingFile() throws IOException, AWTException, InterruptedException{
	 ReadExcelData excelData = new ReadExcelData (constant.EXCEL_FILE_PATH, "FileUpload");
	 performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
    objfile = new FileManagerPage(driver);
    objfile.clickfileManager();
    objfile.strdept(excelData.getCellData(1, 2));    
    objfile.clickfileUpload();
    objfile.clicksave();
    Assert.assertTrue(objfile.ResponseMessage());
    Assert.assertTrue(objfile.isSaveSuccessMessageDisplayed());  

}
}
