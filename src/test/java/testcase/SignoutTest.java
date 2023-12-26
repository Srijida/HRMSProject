package testcase;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
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
	        performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
	        objempexist = new SignoutPage(driver);
	        objempexist.clickempi_img();
	        objempexist.clicKsign_out();
	        Assert.assertTrue(objempexist.logocheck());
	        

}
}
