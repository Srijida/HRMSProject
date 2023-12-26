package testcase;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import Pages.LoginPage;
import Pages.SignoutPage;
import utilities.ReadExcelData;
@Listeners(listeners.ListenerTestNG.class)
public class SignoutTest extends BaseTest {
	LoginPage objLogin;
	SignoutPage objempexist;
	

	 @Test()
	    public void Signout() throws InterruptedException, AWTException, IOException {
		 ReadExcelData excelData = new ReadExcelData (constant.EXCEL_FILE_PATH, "Logout");
	        objLogin = new LoginPage(driver);
	        objLogin.setUsername(excelData.getCellData(1, 0));
	        objLogin.setPassword(excelData.getCellData(1, 1));
	        objLogin.clickLogin();
	        objempexist = new SignoutPage(driver);
	        objempexist.clickempi_img();
	        objempexist.clicKsign_out();
	        

}
}
