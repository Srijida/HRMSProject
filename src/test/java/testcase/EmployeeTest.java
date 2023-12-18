package testcase;

import java.io.IOException;

import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import Pages.LoginPage;
import Pages.EmployeePage;
import utilities.ReadExcelData;

@Listeners(listeners.ListenerTestNG.class)
public class EmployeeTest extends BaseTest {
    private LoginPage objLogin;
    private EmployeePage objEmployee;
    
    private void performLogin(String username, String password) {
        objLogin = new LoginPage(driver);
        objLogin.setUsername(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
       System.out.println("Login successful");
   }
    @Test(priority=3)
    public void employee_blank_details() throws InterruptedException, IOException {
        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "EmployeeDetails");
        String username = excelData.getCellData(1, 0);
        String password = excelData.getCellData(1,1);
        performLogin(username, password);
    	objEmployee=new EmployeePage(driver);
        objEmployee.clickemployee();
        objEmployee.clickaddNewEmployee();
        objEmployee.clicksave();      
        Assert.assertTrue(objEmployee.getToastMessage());
       

    }
    @Test(priority=2)
    public void employee_skipped_lastname() throws InterruptedException, IOException {
        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "EmployeeDetails");
        
        String username = excelData.getCellData(1, 0);
        String password = excelData.getCellData(1,1);
        String firstname = excelData.getCellData(1,2);
        performLogin(username, password);
    	objEmployee=new EmployeePage(driver);
        objEmployee.clickemployee();
        objEmployee.clickaddNewEmployee();
        objEmployee.setFirstName(firstname);
        objEmployee.clicksave();      
       Assert.assertTrue(objEmployee.getToastMessage());      
    }

    @Test(priority=1)
    public void employee_skipped_employeeId() throws InterruptedException, IOException {
        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "EmployeeDetails");
        
        String username = excelData.getCellData(1, 0);
        String password = excelData.getCellData(1,1);
        String firstname = excelData.getCellData(1,2);
        String lastname = excelData.getCellData(1,3); 
        performLogin(username, password);
    	objEmployee=new EmployeePage(driver);
        objEmployee.clickemployee();
        objEmployee.clickaddNewEmployee();
        objEmployee.setFirstName(firstname);
        objEmployee.setLastNAme(lastname);
        objEmployee.clicksave();      
        Assert.assertTrue(objEmployee.getToastMessage());      

    }
    @Test(priority=4)
    public void employee_details() throws InterruptedException, IOException {
        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "EmployeeDetails");
        
        String username = excelData.getCellData(1, 0);
        String password = excelData.getCellData(1,1);
        String firstname = excelData.getCellData(1,2);
        String lastname = excelData.getCellData(1,3);
        String employeeId = excelData.getCellData(1,4);
        String day = excelData.getCellData(1,5); 
        String month = excelData.getCellData(1,6);   
        String year = excelData.getCellData(1,7); 
        String company=excelData.getCellData(1, 8);
        String location=excelData.getCellData(1, 9);
        String department=excelData.getCellData(1, 10);
        String designation=excelData.getCellData(1,11);
        String userName=excelData.getCellData(1,12);
        String email=excelData.getCellData(1,13);
        String gender=excelData.getCellData(1,14); 
        String shift=excelData.getCellData(1,15);
        String day1 = excelData.getCellData(1,16); 
        String month1 = excelData.getCellData(1,17);   
        String year1 = excelData.getCellData(1,18);
        String contact=excelData.getCellData(1, 19);
        String password2=excelData.getCellData(1,20);
        String confirmpassword=excelData.getCellData(1,21);
        String role=excelData.getCellData(1,22);
        String leave=excelData.getCellData(1,23); 
        String address=excelData.getCellData(1,24);
        performLogin(username, password);
    	objEmployee=new EmployeePage(driver);
        objEmployee.clickemployee();
        objEmployee.clickaddNewEmployee();
        objEmployee.setFirstName(firstname);
        objEmployee.setLastNAme(lastname);
        objEmployee.setEmployeeID(employeeId);
        objEmployee.selectDateOfJoining(day,month,year);
        objEmployee.setCompanyName(company);
        objEmployee.setLocationlist(location);
        objEmployee.setMainDept(department);
        objEmployee.setDesignation(designation);
        objEmployee.setUserName(userName);
        objEmployee.setEmail(email);
        objEmployee.setGender(gender);
        objEmployee.setofficeshift(shift);
        objEmployee.selectDOB(day1, month1, year1);
        objEmployee.setcontact(contact);
        objEmployee.setpassword(password2);
        objEmployee.setconfrimpass(confirmpassword);
        objEmployee.setRole(role);
        objEmployee.setleave(leave);
        objEmployee.setAddress(address);
        objEmployee.clicksave();      
        Assert.assertTrue(objEmployee.getToastMessage());      

    }
 
}







