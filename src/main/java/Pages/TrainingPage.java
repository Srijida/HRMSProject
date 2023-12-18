package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtility;

public class TrainingPage {
	 WebDriver driver;
	 ElementUtility elementutility;
	 
	  
	  @FindBy (xpath="//a[i[contains(@class, 'fa-graduation-cap')]]")
	  WebElement training;
	  @FindBy (xpath="//a[@href='https://hrm.qabible.in/hrms/admin/training_type']")
	  WebElement triningType;
	  @FindBy (xpath="//input[@name='type_name']")
	  WebElement triningTypename;
	
	  @FindBy (xpath="(//button[@type='submit'])[1]")
	  WebElement save;	
	  @FindBy(className = "toast-message")
	    WebElement toast;
	  public TrainingPage(WebDriver driver) {
	        this.driver = driver;
	        this.elementutility = new ElementUtility(driver); 
	        PageFactory.initElements(driver, this);
	  }
	        
	        public void clicktraining( ) {
	        	elementutility.clickOnElement(training);
	        }
	        public void clicktrainingType( ) {
	        	elementutility.mouseHoverAndClickonElement(triningType);
	        	elementutility.clickOnElement(training);
	        }
	        public void strtraintypename(String name) {	        	
	        	elementutility.enterText(triningTypename, name);
	        }	        	
	    
	        public void clicksave() {
	        	elementutility.mouseHoverAndClickonElement(save);
	        	elementutility.clickOnElement(save);
	        }
	        public boolean getToastMessage() {
	          	 System.out.println(toast.getText());
	          	    return toast.getText() != null;
	          	}
	          
}
