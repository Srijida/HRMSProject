package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.TicketPage;
import utilities.ReadExcelData;
@Listeners(generalTest.ListenerTestNG.class)
public class TicketsTest extends BaseTest{
	LoginPage objLogin;
	TicketPage objticket;

	

	 @Test(dataProviderClass=ReadExcelData.class, dataProvider="testdata")
	    public void LoginTest(String username, String password) throws InterruptedException {
	        objLogin = new LoginPage(driver);
	        objLogin.setUsername(username);
	        objLogin.setPassword(password);
	        objLogin.clickLogin();
	        System.out.println("login successful");
	        objticket=new TicketPage(driver);
	        objticket.clicktickets();
	        objticket.clickadd();
	        objticket.strcompname("CRROTHRM");
	        objticket.strsub("Ticket1");
	        objticket.stremp_ticket("John Smith");
	        objticket.strpriority("High");
	        objticket.clicksave();
	

}
}
