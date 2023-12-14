package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.TrainingPage;
import utilities.ReadExcelData;
@Listeners(generalTest.ListenerTestNG.class)
public class TrainingTest extends BaseTest {
	LoginPage objLogin;
	TrainingPage objtaining;

	    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata")
	    public void LoginTest(String username, String password) throws InterruptedException {
	        objLogin = new LoginPage(driver);
	        objtaining = new TrainingPage(driver);

	        objLogin.setUsername(username);
	        objLogin.setPassword(password);
	        objLogin.clickLogin();
	        System.out.println("login successful");
	        objtaining.clicktraining();
	        objtaining.clicktrainingType();
	        objtaining.strtraintypename("Selenium automation");
	     
	        objtaining.clicksave();
	        	        
	
}
}
