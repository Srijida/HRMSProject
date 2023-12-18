package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import Pages.LoginPage;
import Pages.StaffPage;
import Pages.TicketPage;
import utilities.ReadExcelData;
@Listeners(listeners.ListenerTestNG.class)
public class StaffTest extends BaseTest {
	
	  LoginPage objLogin;
	  StaffPage objstaff;
	  private void performLogin(String username, String password) {
	        objLogin = new LoginPage(driver);
	        objLogin.setUsername(username);
	        objLogin.setPassword(password);
	        objLogin.clickLogin();
	   }
	  @Test(priority=2)
	    public void tickets_test() throws InterruptedException, IOException {
	        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH,"Tickets");
	        String username = excelData.getCellData(1, 0);
	        String password = excelData.getCellData(1,1);
	        String rolename = excelData.getCellData(1,2);
	        String access = excelData.getCellData(1,3);
	        performLogin(username, password);
	        objstaff=new StaffPage(driver);
	        objstaff.clickstaff();
	        objstaff.clickrolprivi();
	        objstaff.clickadd();
	        objstaff.strrolname(rolename);
	        objstaff.straccess(access);
	        objstaff.clicksave();
	        objstaff.clicksearch("dev");
	        Assert.assertTrue(objstaff.getToastMessage());	        
	
}
	
	    
}
