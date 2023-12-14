package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtility;
import utilities.WaitUtility;

public class LoginPage {
    WebDriver driver;
    ElementUtility elementutility;
    WaitUtility waitutil;
    
    @FindBy(xpath="//input[@id='iusername']")
    WebElement userName;

    @FindBy(id="ipassword")
    WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    WebElement loginButton;
    
    @FindBy(xpath = "//div[@class='widget-user-header']")
    WebElement welcome;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.elementutility = new ElementUtility(driver);
        PageFactory.initElements(driver, this);
        
    }

    public void setUsername(String strusername) {
    	elementutility.enterText(userName, strusername);
        
    }

    public void setPassword(String strpassword) {
    	elementutility.enterText(password, strpassword);
    }

    public void clickLogin() {
    	elementutility.clickOnElement(loginButton);
    }
    public String getText() {
        return welcome.getText();
    }

   
   
   
}
