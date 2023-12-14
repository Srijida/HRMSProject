package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.OrganisationPage;
import utilities.ReadExcelData;
@Listeners(generalTest.ListenerTestNG.class)
public class OrganisationTests extends BaseTest {
    LoginPage objLogin;
    OrganisationPage objorg;

    public void performLogin(String username, String password) throws InterruptedException {
        objLogin = new LoginPage(driver);
        objLogin.setUsername(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
        System.out.println("login successful");
    }

    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata",groups= {"Regression","Sanity"})
    public void LoginTest(String username, String password) throws InterruptedException {
        performLogin(username, password);
    }

    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata", dependsOnMethods = "LoginTest",groups= {"Regression"})
    public void OrganisationTest(String username, String password, String name, String company, String location, String DeptHead) throws InterruptedException {
        performLogin(username, password);
        objorg = new OrganisationPage(driver);
        objorg.clickorg();
        objorg.clickdept();
        objorg.setName(name);
        objorg.setcomp(company);
        objorg.setloc(location);
        objorg.setdeptHead(DeptHead);
        objorg.clicksave();
    }
}
