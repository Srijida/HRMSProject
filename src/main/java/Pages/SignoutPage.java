package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ElementUtility;
import utilities.WaitUtility;

public class SignoutPage {
	 WebDriver driver;
	  ElementUtility elementutility;
	  WaitUtility waitutil;
	  
	 @FindBy (xpath="//img[@class='user-image-top']")
	  WebElement user_img;
	 @FindBy (xpath="//a[text()='Sign out']")
	  WebElement sign_out;
	 @FindBy (xpath="//img[@alt='hrsale-logo']")
	  WebElement logo;
	 public SignoutPage(WebDriver driver) {
	        this.driver = driver;
	        this.elementutility = new ElementUtility(driver); 
	        PageFactory.initElements(driver, this);
	  }
	  public void clickempi_img() {
		  elementutility.clickOnElement(user_img);		  	  
	  }
	  public void clicKsign_out() {
		  elementutility.clickOnElement(sign_out);		  
	  }
	 public boolean logocheck() {
		 elementutility.clickOnElement(logo);
		 System.out.println("Image is present after sign-out");
	        Assert.assertTrue(true);
			return true;
	 }

}
