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
public void FileUploadTest() throws IOException, AWTException, InterruptedException{
	 ReadExcelData excelData = new ReadExcelData (constant.EXCEL_FILE_PATH, "FileUpload");
    objLogin = new LoginPage(driver);
    objfile = new FileManagerPage(driver);

    objLogin.setUsername(excelData.getCellData(1, 0));
    objLogin.setPassword(excelData.getCellData(1,1));
    objLogin.clickLogin();
    objfile.clickfileManager();
    objfile.strdept(excelData.getCellData(1, 2));    
    objfile.clickfileUpload();
    objfile.clicksave();
    Assert.assertTrue(objfile.ResponseMessage());
    Assert.assertTrue(objfile.isSaveSuccessMessageDisplayed());  

}
}
