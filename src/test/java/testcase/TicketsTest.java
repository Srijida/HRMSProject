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
	
 @Test(priority=1)
	    public void tickets_test_incomplete_data() throws InterruptedException, IOException {
	        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH,"Tickets");
	        objLogin = new LoginPage(driver);
	        objLogin.setUsername(excelData.getCellData(1, 0));
	        objLogin.setPassword(excelData.getCellData(1,1));
	        objLogin.clickLogin();
	        objticket=new TicketPage(driver);
	        objticket.clicktickets();
	        objticket.clickadd();
	        objticket.strcompname(excelData.getCellData(1,2));
	        objticket.strsub( excelData.getCellData(1,3));
	        objticket.stremp_ticket(excelData.getCellData(1,4));
	        objticket.strpriority(excelData.getCellData(1,5));
	        objticket.clicksave();
	        Assert.assertTrue(objticket.ResponseMessage());	        
	
}
	
	 @Test(priority=2)
	    public void tickets_test() throws InterruptedException, IOException {
	        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH,"Tickets");
	        objLogin = new LoginPage(driver);
	        objLogin.setUsername(excelData.getCellData(1, 0));
	        objLogin.setPassword(excelData.getCellData(1,1));
	        objLogin.clickLogin();
	        objticket=new TicketPage(driver);
	        objticket.clicktickets();
	        objticket.clickadd();
	        objticket.strcompname(excelData.getCellData(1,2));
	        objticket.strsub( excelData.getCellData(1,3));
	        objticket.clicksave();
	        Assert.assertTrue(objticket.ResponseMessage());	        
	
}
	

	
}
