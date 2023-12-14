package testcase;

import java.awt.AWTException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.FileManagerPage;
import Pages.LoginPage;
import utilities.ReadExcelData;
@Listeners(generalTest.ListenerTestNG.class)
public class FileManagerTest extends BaseTest  { 
	LoginPage objLogin;
	FileManagerPage objfile;

@Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata")
public void LoginTest(String username, String password) throws InterruptedException, AWTException {
    objLogin = new LoginPage(driver);
    objfile = new FileManagerPage(driver);

    objLogin.setUsername(username);
    objLogin.setPassword(password);
    objLogin.clickLogin();
    System.out.println("login successful");
    objfile.clickfileManager();
    objfile.strdept(" MD Office");    
    objfile.clickfileUpload();
    objfile.clicksave();

}
}
