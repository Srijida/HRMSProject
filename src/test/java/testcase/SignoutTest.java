package testcase;

import java.awt.AWTException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.SignoutPage;
import utilities.ReadExcelData;
@Listeners(generalTest.ListenerTestNG.class)
public class SignoutTest extends BaseTest {
	LoginPage objLogin;
	SignoutPage objempexist;
	

	 @Test(dataProviderClass=ReadExcelData.class, dataProvider="testdata")
	    public void LoginTest(String username, String password) throws InterruptedException, AWTException {
	        objLogin = new LoginPage(driver);
	        objLogin.setUsername(username);
	        objLogin.setPassword(password);
	        objLogin.clickLogin();
	        objempexist = new SignoutPage(driver);
	        objempexist.clickempi_img();
	        objempexist.clicKsign_out();
	        

}
}
