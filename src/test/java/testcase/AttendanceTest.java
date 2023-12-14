package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.AttendancePage;
import Pages.LoginPage;
import utilities.ReadExcelData;
@Listeners(generalTest.ListenerTestNG.class)
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

	    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata")
	    public void LoginTest(String username, String password) throws InterruptedException {
	        performLogin(username, password);
	    }
	    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata", dependsOnMethods = "LoginTest")
	    public void Attendance(String username,String password,String date) throws InterruptedException {
	    	performLogin(username, password);
	    	objattend=new AttendancePage(driver);
	    	objattend.clicktimesheet();
	    	objattend.clickattendance();
	    	String[] parts = date.split("/");
	        String day = parts[0];
	        String month = parts[1];
	        String year = parts[2]; 
	        objattend.strdate(day, month, year);
	        objattend.clickget();
	        objattend.clicksearch();
	    }

}
