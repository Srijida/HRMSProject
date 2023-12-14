package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.StaffPage;
import utilities.ReadExcelData;
@Listeners(generalTest.ListenerTestNG.class)
public class StaffTest extends BaseTest {
	
	  LoginPage objLogin;
	  StaffPage objstaff;

	    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata")
	    public void LoginTest(String username, String password) throws InterruptedException {
	        objLogin = new LoginPage(driver);
	        objstaff = new StaffPage(driver);

	        objLogin.setUsername(username);
	        objLogin.setPassword(password);
	        objLogin.clickLogin();
	        System.out.println("login successful");
	        objstaff.clickstaff();
	        objstaff.clickrolprivi();
	        objstaff.clickadd();
	        objstaff.strrolname("Test1");
	        objstaff.straccess("All Menu Access");
	        objstaff.clicksave();
	        objstaff.clicksearch("dev");
	        Thread.sleep(3000);
	      
	       
	    }
}
