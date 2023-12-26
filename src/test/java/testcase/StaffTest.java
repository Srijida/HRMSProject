package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import Pages.LoginPage;
import Pages.StaffPage;
import utilities.ReadExcelData;
@Listeners(listeners.ListenerTestNG.class)
public class StaffTest extends BaseTest {
	
	  LoginPage objLogin;
	  StaffPage objstaff;
	 
	  @Test(priority=1)
	    public void tickets_test() throws InterruptedException, IOException {
	        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH,"Staff");
	       
	        objLogin = new LoginPage(driver);
	        objLogin.setUsername(excelData.getCellData(1, 0));
	        objLogin.setPassword(excelData.getCellData(1,1));
	        objLogin.clickLogin();
	        objstaff=new StaffPage(driver);
	        objstaff.clickstaff();
	        objstaff.clickrolprivi();
	        objstaff.clickadd();
	        objstaff.strrolname(excelData.getCellData(1,2));
	        objstaff.straccess(excelData.getCellData(1,3));
	        objstaff.clicksave();
	        objstaff.clicksearch(excelData.getCellData(1,4));
	        Assert.assertTrue(objstaff.getToastMessage());	        
	
}
	
	    
}
