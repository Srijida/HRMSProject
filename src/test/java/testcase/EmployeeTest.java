package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.EmployeePage;
import utilities.FakerUtility;
import utilities.ReadExcelData;

@Listeners(generalTest.ListenerTestNG.class)
public class EmployeeTest extends BaseTest {
    LoginPage objLogin;
    EmployeePage objemployee;

    public void performLogin(String username, String password) throws InterruptedException {
        objLogin = new LoginPage(driver);
        objLogin.setUsername(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
        System.out.println("login successful");
    }

    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata")
    public void LoginTest(String username, String password) throws InterruptedException {
        performLogin(username, password);
    }

    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata", dependsOnMethods = "LoginTest")
    public void EmployeeDetails(String username, String password, String firstname, String lastname, String employeeId, String dateofjoining, String company,
            String location, String department, String designation, String userName,
            String email, String gender, String shift, String dob, String contact, String pasword,
            String confirmpassword, String role, String leave, String address) throws InterruptedException {
        performLogin(username, password);
        objemployee =new EmployeePage(driver);
        objemployee.clickemployee();
        objemployee.clickaddNewEmployee();
        objemployee.setFirstName(firstname);
        objemployee.setLastNAme(lastname);
        objemployee.setEmployeeID(employeeId);
        String[] parts = dateofjoining.split("-");
        String month = parts[0];
        String day = parts[1];
        String year = parts[2];
        objemployee.setDate(day, month, year);
        objemployee.setCompanyName(company);
        objemployee.setLocationlist(location);
        objemployee.setMainDept(department);
        objemployee.setDesignation(designation);
        objemployee.setUserName(userName);
        objemployee.setEmail(email);
        objemployee.setGender(gender);
        objemployee.setofficeshift(shift);
        String[] parts1 = dob.split("-");
        String month1 = parts[0];
        String day1 = parts1[1];
        String year1 = parts1[2];
        objemployee.setDOB(day1, month1, year1);
        objemployee.setcontact(FakerUtility.phoneNumber());
        objemployee.setpassword(pasword);
        objemployee.setconfrimpass(confirmpassword);
        objemployee.setRole(role);
        objemployee.setleave(leave);
        objemployee.setAddress(address);
        objemployee.clicksave();
    }
}
