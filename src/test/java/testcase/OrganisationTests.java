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

  
    @Test(priority=1)
    public void OrganisationTest_missingFeilds() throws InterruptedException, IOException {
    	   ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "OrganisationTest");
    	objLogin = new LoginPage(driver);
        objLogin.setUsername(excelData.getCellData(1, 0));
        objLogin.setPassword(excelData.getCellData(1,1));
        objLogin.clickLogin();
        objorg = new OrganisationPage(driver);
        objorg.clickorg();
        objorg.clickdept();
        objorg.clicksave();
        Assert.assertTrue(objorg.getToastMessage());
    }
    @Test(priority=2)
    public void OrganisationTest_only_name() throws InterruptedException, IOException {
    	   ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "OrganisationTest");
        objLogin = new LoginPage(driver);
        objLogin.setUsername(excelData.getCellData(1, 0));
        objLogin.setPassword(excelData.getCellData(1,1));
        objLogin.clickLogin();
        objorg = new OrganisationPage(driver);
        objorg.clickorg();
        objorg.clickdept();
        objorg.setName(excelData.getCellData(1, 2)); 
        objorg.clicksave();
        Assert.assertTrue(objorg.getToastMessage());
    }

    @Test(priority=3)
    public void OrganisationTest() throws InterruptedException, IOException {
    	   ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "OrganisationTest");
    	objLogin = new LoginPage(driver);
        objLogin.setUsername(excelData.getCellData(1, 0));
        objLogin.setPassword(excelData.getCellData(1,1));
        objLogin.clickLogin();
        objorg = new OrganisationPage(driver);
        objorg.clickorg();
        objorg.clickdept();
        objorg.setName(excelData.getCellData(1, 2));
        objorg.setcomp(excelData.getCellData(1, 3));
        objorg.setloc(excelData.getCellData(1, 4));
        objorg.setdeptHead(excelData.getCellData(1, 5));    
        objorg.clicksave();
        Assert.assertTrue(objorg.getToastMessage());
    }
}
