package testcase;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import Pages.AssetPage;
import Pages.LoginPage;
import utilities.ReadExcelData;
@Listeners(listeners.ListenerTestNG.class)
public class AssetTests extends BaseTest {
	LoginPage objLogin;
	AssetPage objasset;
	   
//retryAnalyzer=RetryAnalyzer.class
	public void performLogin(String username, String password) throws InterruptedException {
        objLogin = new LoginPage(driver);
        objLogin.setUsername(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
        System.out.println("login successful");
    }

    @Test()

        public void AssetTest() throws AWTException, InterruptedException, IOException {
    	 ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "AssetTest");
         
         String username = excelData.getCellData(1, 0);
         String password = excelData.getCellData(1,1);
         String catogory = excelData.getCellData(1, 2);
         String name = excelData.getCellData(1,3);
         String assetcode = excelData.getCellData(1,4);
         String working = excelData.getCellData(1,5);
         String companyID = excelData.getCellData(1, 6);
         String employee = excelData.getCellData(1,7);
         String day = excelData.getCellData(1,8);
         String month = excelData.getCellData(1,9);
         String year = excelData.getCellData(1,10);
         String Invoice = excelData.getCellData(1,11);
         String manufacture = excelData.getCellData(1, 12);
         String Serielnum = excelData.getCellData(1,13);
         String day1 = excelData.getCellData(1,14);
         String month1 = excelData.getCellData(1,15);
         String year1 = excelData.getCellData(1,16);
         performLogin(username, password);
        objasset=new AssetPage(driver);       
        objasset.clickasset();
        objasset.clickassetdrop();
        objasset.AlertPresent();     
        objasset.clickadd();;
        objasset.strcatogory(catogory);
        objasset.strassetname(name);
        objasset.strassetcode(assetcode);
        objasset.strworking(working);
        objasset.strcomId(companyID);
        objasset.stremployee(employee);
        objasset.setpurDate(day, month, year);
        objasset.strinvoice(Invoice);
        objasset.strmanu(manufacture);
        objasset.strserielnum(Serielnum);
        objasset.setwarranty(day1, month1, year1);
        objasset.clickfileUpload();
        objasset.clicksave();
        Assert.assertTrue(objasset.getToastMessage()); 
    
        

}
}
