package testcase;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import Pages.AttendancePage;
import Pages.LoginPage;
import utilities.ReadExcelData;
@Listeners(listeners.ListenerTestNG.class)
public class AttendanceTest extends BaseTest{
	LoginPage objLogin;
	AttendancePage objattend;
	 public void performLogin(String username, String password) throws InterruptedException {
	        objLogin = new LoginPage(driver);
	        objLogin.setUsername(username);
	        objLogin.setPassword(password);
	        objLogin.clickLogin();
	        System.out.println("login successful");
	    }
	    @Test(priority=1)
	    public void Attendance() throws InterruptedException, IOException {
	    	ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "Attendance");
	           String username = excelData.getCellData(1, 0);
	           String password = excelData.getCellData(1,1);
	           String day = excelData.getCellData(1, 2);
	           String month = excelData.getCellData(1, 3);   
	           String year = excelData.getCellData(1, 4);   
	    	performLogin(username, password);
	    	objattend=new AttendancePage(driver);
	    	objattend.clicktimesheet();
	    	objattend.clickattendance();	    	
	        objattend.strdate(day,month,year);
	        objattend.clickget();
	        objattend.clicksearch();
	    }

}
