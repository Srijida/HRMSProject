package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtility;
import utilities.WaitUtility;

public class TicketPage {
	 WebDriver driver;
	  ElementUtility elementutility;
	  WaitUtility waitutil;
	  
	  @FindBy (xpath="//a[i[contains(@class, 'fa-ticket')]]")
	  WebElement tickets;
	  @FindBy (xpath="(//a//button[@type='button'])[1]")
	  WebElement add;
	  @FindBy (xpath="//select[@id='aj_company']")
	  WebElement companyname;
	  @FindBy (xpath="//input[@name='subject']")
	  WebElement subject;
	  @FindBy (xpath="//select[@name='employee_id']")
	  WebElement employeeTicket;
	  @FindBy (xpath="//select[@id='select2-demo-6']")
	  WebElement priority;
	  @FindBy (xpath="(//button[@type='submit'])[1]")
	  WebElement save;
	  
	  
	  public TicketPage(WebDriver driver) {
	        this.driver = driver;
	        this.elementutility = new ElementUtility(driver); 
	        PageFactory.initElements(driver, this);
	  }
	        
	        public void clicktickets( ) {
	        	elementutility.clickOnElement(tickets);
	        }	        
	        public void clickadd() {
	        	elementutility.clickOnElement(add);
	        }
	        public void strcompname(String name) {
	        	elementutility.mouseHoverAndClickonElement(companyname);
	        	elementutility.selectDrpdown(companyname, name);
	        }
	        public void strsub(String name) {
	        	elementutility.enterText(subject, name);;
	        }
	        public void stremp_ticket(String name) {
	        	elementutility.selectDrpdown(employeeTicket, name);
	        }
	        public void strpriority(String name) {
	        	elementutility.mouseHoverAndClickonElement(priority);
	        	elementutility.selectDrpdown(priority, name);
	        }
	        public void clicksave() {
	        	elementutility.mouseHoverAndClickonElement(save);
	        	elementutility.clickOnElement(save);
	        }	  	  

}
