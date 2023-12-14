package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.ReadExcelData;
import Pages.LoginPage;
@Listeners(generalTest.ListenerTestNG.class)
public class LoginTests extends BaseTest {
    LoginPage objLogin;
   

    @Test(dataProviderClass=ReadExcelData.class, dataProvider="testdata")
    
    public void LoginTest(String username, String password) throws InterruptedException {
        objLogin = new LoginPage(driver);
        objLogin.setUsername(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
        String welcome= objLogin.getText();
        System.out.println(welcome);
    
        
    }
}
