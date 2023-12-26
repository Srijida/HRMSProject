package testcase;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import Pages.AssetPage;
import utilities.ReadExcelData;
@Listeners(listeners.ListenerTestNG.class)
public class AssetTests extends BaseTest {

	AssetPage objasset;
	   
//retryAnalyzer=RetryAnalyzer.class
	
    @Test()

        public void ValidateAssetIsNotAdded() throws AWTException, InterruptedException, IOException {
    	 ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "AssetTest");
    	  performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
         objasset = new AssetPage(driver);
         objasset.clickasset();
         objasset.clickassetdrop();
         objasset.AlertPresent();     
         objasset.clickadd();
         objasset.strcatogory(excelData.getCellData(1, 2));
         objasset.strassetname(excelData.getCellData(1,3));
         objasset.strassetcode(excelData.getCellData(1,4));
         objasset.strworking(excelData.getCellData(1,5));
         objasset.strcomId(excelData.getCellData(1, 6));
         objasset.stremployee(excelData.getCellData(1,7));
         objasset.setpurDate(excelData.getCellData(1,8), 
        		 excelData.getCellData(1,9), excelData.getCellData(1,10));
         objasset.strinvoice(excelData.getCellData(1,11));
         objasset.strmanu(excelData.getCellData(1, 12));
         objasset.strserielnum(excelData.getCellData(1,13));
         objasset.setwarranty(excelData.getCellData(1,14), 
        		 excelData.getCellData(1,15), excelData.getCellData(1,16));
         objasset.clickfileUpload();
         objasset.clicksave();
         Assert.assertTrue(objasset.isFailureMessageDisplayed());
    

}
}
