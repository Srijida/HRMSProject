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
    public void savingOrganisationTestWithoutPassingAnuData() throws InterruptedException, IOException {
        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "OrganisationTest");
        performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
        objorg = new OrganisationPage(driver);
        objorg.clickorg();
        objorg.clickdept();
        objorg.clicksave();
        Assert.assertTrue(objorg.getResponseMessage());
    }
    @Test(priority=2)
    public void savingOrganisationTestByPassingOnlyNameData() throws InterruptedException, IOException {
    	ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "OrganisationTest");
        performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
        objorg = new OrganisationPage(driver);
        objorg.clickorg();
        objorg.clickdept();
        objorg.setName(excelData.getCellData(1, 2)); 
        objorg.clicksave();
        Assert.assertTrue(objorg.getResponseMessage());
    }

    @Test(priority=3)
    public void savingOrganisationTestByPassingAllTheDatas() throws InterruptedException, IOException {
    	ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "OrganisationTest");
        performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
        objorg = new OrganisationPage(driver);
        objorg.clickorg();
        objorg.clickdept();
        objorg.setName(excelData.getCellData(1, 2));
        objorg.setcomp(excelData.getCellData(1, 3));
        objorg.setloc(excelData.getCellData(1, 4));
        objorg.setdeptHead(excelData.getCellData(1, 5));    
        objorg.clicksave();
        Assert.assertTrue(objorg.getResponseMessage());
    }
}
