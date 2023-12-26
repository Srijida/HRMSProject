package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.EmployeePage;
import Pages.LoginPage;
import utilities.DataProviderutility;
import utilities.FakerUtility;

public class EmployeeDataTest extends BaseTest {
	LoginPage objLogin;
	EmployeePage objemployee;
		 	 
	    @Test(dataProviderClass = DataProviderutility.class, dataProvider = "testdata")
	    public void VerifyEmployeeDetailsAdded(String username, String password, String firstname,String lastname,String employeeId,String day,String month,String year, String company,
	    		String location,String department,String designation,String userName,
	    		String email,String gender,String shift,String day1,String month1,String year1,String contact,String pasword,
	    		String confirmpassword,String role,String leave,String address) throws InterruptedException {
	    	performLogin(username,password);
	    	objemployee=new EmployeePage(driver);
	        objemployee.clickemployee();
	        objemployee.clickaddNewEmployee();
	        objemployee.setFirstName(firstname);
	        objemployee.setLastNAme(lastname);
	        objemployee.setEmployeeID(employeeId);
	        objemployee.selectDateOfJoining(day,month,year);
	        objemployee.setCompanyName(company);
	        objemployee.setLocationlist(location);
	        objemployee.setMainDept(department);
	        objemployee.setDesignation(designation);
	        objemployee.setUserName(userName);	        
            objemployee.setEmail(email);
            objemployee.setGender(gender);
            objemployee.setofficeshift(shift);    
	        objemployee.selectDOB(day1, month1, year1);
            objemployee.setcontact(FakerUtility.phoneNumber());
            objemployee.setpassword(pasword);
            objemployee.setconfrimpass(confirmpassword);
            objemployee.setRole(role);
            objemployee.setleave(leave);
            objemployee.setAddress(address);
	        objemployee.clicksave();
	        Assert.assertTrue(objemployee.isSaveSuccessMessageDisplayed());  

}

}
