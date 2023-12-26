package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import Pages.LoginPage;
import Pages.TrainingPage;
import utilities.ReadExcelData;
@Listeners(listeners.ListenerTestNG.class)
public class TrainingTest extends BaseTest {
	LoginPage objLogin;
	TrainingPage objtaining;
	 
	  @Test(priority=1)
	    public void traning_test_nodata() throws InterruptedException, IOException {
	        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH,"Training");
	       
	        objLogin = new LoginPage(driver);
	         objLogin.setUsername(excelData.getCellData(1, 0));
	         objLogin.setPassword(excelData.getCellData(1,1));
	         objLogin.clickLogin();
	        objtaining=new TrainingPage(driver);
	        objtaining.clicktraining();
	        objtaining.clicktrainingType();    
	        objtaining.clicksave();
	        Assert.assertTrue(objtaining.getToastMessage());	        
	
}

	 @Test(priority=2)
	    public void traning_test() throws InterruptedException, IOException {
	        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH,"Training");
	        objLogin = new LoginPage(driver);
	         objLogin.setUsername(excelData.getCellData(1, 0));
	         objLogin.setPassword(excelData.getCellData(1,1));
	         objLogin.clickLogin();
	        objtaining=new TrainingPage(driver);
	        objtaining.clicktraining();
	        objtaining.clicktrainingType();
	        objtaining.strtraintypename(excelData.getCellData(1,2));	     
	        objtaining.clicksave();
	        Assert.assertTrue(objtaining.getToastMessage());	        
	
}
}
