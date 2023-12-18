package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import utilities.ReadExcelData;
import Pages.LoginPage;

@Listeners(listeners.ListenerTestNG.class)
public class LoginTests extends BaseTest {
    LoginPage objLogin;

    @Test(priority=1)
    public void Valid_LoginTest() throws InterruptedException, IOException {
       
        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "LoginTest");
        String username = excelData.getCellData(1, 0);
        String password = excelData.getCellData(1, 1);
        String value =excelData.getCellData(1, 2);

        objLogin = new LoginPage(driver);
        objLogin.setUsername(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
        Assert.assertTrue(objLogin.getToastMessage());
        Assert.assertTrue(objLogin.verifyWelcomeText(value));
      
    }
    @Test(priority=2)
    public void Invalid_Username_Test() throws InterruptedException, IOException {
       
        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "LoginTest");
        String username = excelData.getCellData(2, 0);
        String password = excelData.getCellData(2, 1);

        objLogin = new LoginPage(driver);
        objLogin.setUsername(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
        Assert.assertTrue(objLogin.getToastMessage());
      

    }
    @Test(priority=3)
    public void Invalid_Password_Test() throws InterruptedException, IOException {
       
        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "LoginTest");
        String username = excelData.getCellData(3, 0);
        String password = excelData.getCellData(3, 1);

        objLogin = new LoginPage(driver);
        objLogin.setUsername(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
        Assert.assertTrue(objLogin.getToastMessage());
      

    }
    @Test(priority=4)
    public void Invalid_LoginTest() throws InterruptedException, IOException {
       
        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "LoginTest");
        String username = excelData.getCellData(4, 0);
        String password = excelData.getCellData(4, 1);


        objLogin = new LoginPage(driver);
        objLogin.setUsername(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
        Assert.assertTrue(objLogin.getToastMessage());
      

    }
}
