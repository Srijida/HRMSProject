package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import Pages.LoginPage;
import Pages.OrganisationPage;
import utilities.ReadExcelData;
@Listeners(listeners.ListenerTestNG.class)
public class OrganisationTests extends BaseTest {
    LoginPage objLogin;
    OrganisationPage objorg;

    public void performLogin(String username, String password) throws InterruptedException {
        objLogin = new LoginPage(driver);
        objLogin.setUsername(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
        System.out.println("login successful");
    }
    @Test(priority=1)
    public void OrganisationTest_missingFeilds() throws InterruptedException, IOException {
    	   ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "OrganisationTest");
           String username = excelData.getCellData(1, 0);
           String password = excelData.getCellData(1,1);          
           performLogin(username, password);
        objorg = new OrganisationPage(driver);
        objorg.clickorg();
        objorg.clickdept();
        objorg.clicksave();
        Assert.assertTrue(objorg.getToastMessage());
    }
    @Test(priority=2)
    public void OrganisationTest_only_name() throws InterruptedException, IOException {
    	   ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "OrganisationTest");
           String username = excelData.getCellData(1, 0);
           String password = excelData.getCellData(1,1);
           String name = excelData.getCellData(1, 2);      
           performLogin(username, password);
        objorg = new OrganisationPage(driver);
        objorg.clickorg();
        objorg.clickdept();
        objorg.setName(name); 
        objorg.clicksave();
        Assert.assertTrue(objorg.getToastMessage());
    }

    @Test(priority=3)
    public void OrganisationTest() throws InterruptedException, IOException {
    	   ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "OrganisationTest");
           String username = excelData.getCellData(1, 0);
           String password = excelData.getCellData(1,1);
           String name = excelData.getCellData(1, 2);
           String company = excelData.getCellData(1,3);
           String location = excelData.getCellData(1,4);
           String DeptHead = excelData.getCellData(1,5);      
           performLogin(username, password);
        objorg = new OrganisationPage(driver);
        objorg.clickorg();
        objorg.clickdept();
        objorg.setName(name);
        objorg.setcomp(company);
        objorg.setloc(location);
        objorg.setdeptHead(DeptHead);    
        objorg.clicksave();
        Assert.assertTrue(objorg.getToastMessage());
    }
}
