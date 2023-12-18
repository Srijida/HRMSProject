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
	  private void performLogin(String username, String password) {
	        objLogin = new LoginPage(driver);
	        objLogin.setUsername(username);
	        objLogin.setPassword(password);
	        objLogin.clickLogin();
	   }
	  @Test(priority=1)
	    public void traning_test_nodata() throws InterruptedException, IOException {
	        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH,"Training");
	        String username = excelData.getCellData(1, 0);
	        String password = excelData.getCellData(1,1);
	        performLogin(username, password);
	        objtaining=new TrainingPage(driver);
	        objtaining.clicktraining();
	        objtaining.clicktrainingType();    
	        objtaining.clicksave();
	        Assert.assertTrue(objtaining.getToastMessage());	        
	
}

	 @Test(priority=2)
	    public void traning_test() throws InterruptedException, IOException {
	        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH,"Training");
	        String username = excelData.getCellData(1, 0);
	        String password = excelData.getCellData(1,1);
	        String training_type = excelData.getCellData(1,2);
	        performLogin(username, password);
	        objtaining=new TrainingPage(driver);
	        objtaining.clicktraining();
	        objtaining.clicktrainingType();
	        objtaining.strtraintypename(training_type);	     
	        objtaining.clicksave();
	        Assert.assertTrue(objtaining.getToastMessage());	        
	
}
}
