package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	 

}
