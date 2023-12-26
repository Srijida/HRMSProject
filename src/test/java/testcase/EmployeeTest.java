package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import Pages.EmployeePage;
import utilities.ReadExcelData;

@Listeners(listeners.ListenerTestNG.class)
public class EmployeeTest extends BaseTest {
         LoginTests objLogin;
         EmployeePage objEmployee;
    
   
    @Test(priority=3)
    public void verifyEmployeeDetailsWithoutPassingAnyData() throws InterruptedException, IOException {
       ReadExcelData excelData = new ReadExcelData (constant.EXCEL_FILE_PATH, "EmployeeDetails");
       performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
    	objEmployee=new EmployeePage(driver);
        objEmployee.clickemployee();
        objEmployee.clickaddNewEmployee();
        objEmployee.clicksave();
        Assert.assertTrue(objEmployee.ResponseMessage());
        Assert.assertTrue(objEmployee.isFailureMessageDisplayed());
       

    }
    @Test(priority=2)
    public void verifyEmployeeDetailsByPAssingOnlyTheFirstName() throws InterruptedException, IOException {
        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "EmployeeDetails");
        performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
    	objEmployee=new EmployeePage(driver);
        objEmployee.clickemployee();
        objEmployee.clickaddNewEmployee();
        objEmployee.setFirstName(excelData.getCellData(1,2));
        objEmployee.clicksave();
       Assert.assertTrue(objEmployee.isFailureMessageDisplayed());      
    }

    @Test(priority=1)
    public void verifyEmployeeDetailsByPassingFirstTwoDatas() throws InterruptedException, IOException {
        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "EmployeeDetails");
        performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
    	objEmployee=new EmployeePage(driver);
        objEmployee.clickemployee();
        objEmployee.clickaddNewEmployee();
        objEmployee.setFirstName(excelData.getCellData(1,2));
        objEmployee.setLastNAme(excelData.getCellData(1,3));
        objEmployee.clicksave();
        Assert.assertTrue(objEmployee.ResponseMessage());
        Assert.assertTrue(objEmployee.isFailureMessageDisplayed());      

    }
    @Test(priority=4)
    public void veriftEmployeeDetailsByPassingAllTheDatas() throws InterruptedException, IOException {
        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "EmployeeDetails");
        performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
    	objEmployee=new EmployeePage(driver);
        objEmployee.clickemployee();
        objEmployee.clickaddNewEmployee();
        objEmployee.setFirstName(excelData.getCellData(1,2));
        objEmployee.setLastNAme(excelData.getCellData(1,3));
        objEmployee.setEmployeeID(excelData.getCellData(1,4));
        objEmployee.selectDateOfJoining(excelData.getCellData(1,5),excelData.getCellData(1,6),excelData.getCellData(1,7));
        objEmployee.setCompanyName(excelData.getCellData(1,8));
        objEmployee.setLocationlist(excelData.getCellData(1,9));
        objEmployee.setMainDept(excelData.getCellData(1,10));
        objEmployee.setDesignation(excelData.getCellData(1,11));
        objEmployee.setUserName(excelData.getCellData(1,12));
        objEmployee.setEmail(excelData.getCellData(1,13));
        objEmployee.setGender(excelData.getCellData(1,14));
        objEmployee.setofficeshift(excelData.getCellData(1,15));
        objEmployee.selectDOB(excelData.getCellData(1,16), excelData.getCellData(1,17), excelData.getCellData(1,18));
        objEmployee.setcontact(excelData.getCellData(1,19));
        objEmployee.setpassword(excelData.getCellData(1,20));
        objEmployee.setconfrimpass(excelData.getCellData(1,21));
        objEmployee.setRole(excelData.getCellData(1,22));
        objEmployee.setleave(excelData.getCellData(1,23));
        objEmployee.setAddress(excelData.getCellData(1,24));
        objEmployee.clicksave();
        Assert.assertTrue(objEmployee.ResponseMessage());
        Assert.assertTrue(objEmployee.isSaveSuccessMessageDisplayed());      

    }
 
}







