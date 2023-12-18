package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.EventsPage;
import Pages.LoginPage;
import retry_analyzer.RetryAnalyzer;
import utilities.ReadExcelData;
@Listeners(listeners.ListenerTestNG.class)
public class EventsTest extends BaseTest {
	LoginPage objLogin;
	EventsPage objevents;

	    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata",retryAnalyzer=RetryAnalyzer.class)
	    public void LoginTest(String username, String password) throws InterruptedException {
	        objLogin = new LoginPage(driver);
	        objevents = new EventsPage(driver);

	        objLogin.setUsername(username);
	        objLogin.setPassword(password);
	        objLogin.clickLogin();
	        System.out.println("login successful");
	        objevents.clickevents_meeting();
	        objevents.clickevents();
	        objevents.strcomp("CRROTHRM");
	        objevents.stremp(" John Smith");
	        objevents.strevent_title("Dev&Testing");
	        Thread.sleep(3000);
	        objevents.strdate("10","Dec","2023");
	        Thread.sleep(3000);    
	        objevents.setEventTime("16","30");
//	        objevents.strhour("16");
//	        objevents.strmin("30");
	        objevents.clicksave();
	        Thread.sleep(4000);

}
}
