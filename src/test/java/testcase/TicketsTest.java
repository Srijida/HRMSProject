package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import Pages.LoginPage;
import Pages.TicketPage;
import utilities.ReadExcelData;
@Listeners(listeners.ListenerTestNG.class)
public class TicketsTest extends BaseTest{
	LoginPage objLogin;
	TicketPage objticket;
	 private void performLogin(String username, String password) {
	        objLogin = new LoginPage(driver);
	        objLogin.setUsername(username);
	        objLogin.setPassword(password);
	        objLogin.clickLogin();
	   }
	 @Test(priority=1)
	    public void tickets_test_incomplete_data() throws InterruptedException, IOException {
	        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH,"Tickets");
	        String username = excelData.getCellData(1, 0);
	        String password = excelData.getCellData(1,1);
	        String company = excelData.getCellData(1,2);
	        String subject = excelData.getCellData(1,3);
	        performLogin(username, password);
	        objticket=new TicketPage(driver);
	        objticket.clicktickets();
	        objticket.clickadd();
	        objticket.strcompname(company);
	        objticket.strsub(subject);

	        objticket.clicksave();
	        Assert.assertTrue(objticket.getToastMessage());	        
	
}
	
	 @Test(priority=2)
	    public void tickets_test() throws InterruptedException, IOException {
	        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH,"Tickets");
	        String username = excelData.getCellData(1, 0);
	        String password = excelData.getCellData(1,1);
	        String company = excelData.getCellData(1,2);
	        String subject = excelData.getCellData(1,3);
	        String ticket_for_employee = excelData.getCellData(1,4);
	        String priority = excelData.getCellData(1,5);
	        performLogin(username, password);
	        objticket=new TicketPage(driver);
	        objticket.clicktickets();
	        objticket.clickadd();
	        objticket.strcompname(company);
	        objticket.strsub(subject);
	        objticket.stremp_ticket(ticket_for_employee);
	        objticket.strpriority(priority);
	        objticket.clicksave();
	        Assert.assertTrue(objticket.getToastMessage());	        
	
}
	

	
}
