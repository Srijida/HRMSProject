package testcase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import Constant.constant;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    public static WebDriver driver;
    public static Properties prop = new Properties();
    LoginPage objLogin;
    @BeforeMethod
    @Parameters({"browser", "url"})
    public void setUp(String browser, String url) throws IOException {
        FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
        prop.load(fr);
        fr.close();

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(url);
    }


    @AfterMethod(alwaysRun=true)
 
    public void takeScreenshotOnFailure(ITestResult iTestResult) throws IOException {
    	System.out.println("after");
    	System.out.println(iTestResult.getStatus());
        System.out.println(ITestResult.FAILURE);
            if (iTestResult.getStatus() == ITestResult.FAILURE) {
               takeScreenShotOnFailure(iTestResult.getName());
               
            }
	      
  if(driver!=null)
  {
	  driver.quit();
    }
    }
    public String takeScreenShotOnFailure(String name) throws IOException {
    	   String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());
    	   File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//takes screenshot
    	   String destination =constant.screenShot_path+ name + dateName + ".png";
    	   File finalDestination = new File(destination);
    	   FileUtils.copyFile(source, finalDestination);
		    return destination;
    	      	}
    
   public void performLogin(String username, String password) throws InterruptedException {
       objLogin = new LoginPage(driver);
       objLogin.setUsername(username);
       objLogin.setPassword(password);
       objLogin.clickLogin();

   }

}
