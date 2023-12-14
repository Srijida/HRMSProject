package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementUtility;
import utilities.WaitUtility;

public class EventsPage {
	 WebDriver driver;
	 ElementUtility elementutility;
	 WaitUtility wait;
	 
	  
	  @FindBy (xpath="//a[span[text()='Events & Meetings']]")
	  WebElement events_meeting;
	  @FindBy (xpath="//a[@href='https://hrm.qabible.in/hrms/admin/events']")
	  WebElement events;
	  @FindBy (xpath="//select[@name='company_id']")
	  WebElement company;	
	  @FindBy (xpath="//select[@name='employee_id']")
	  WebElement employee;
	  @FindBy (xpath="//input[@name='event_title']")
	  WebElement event_title;		  	
	  @FindBy (xpath="//input[@name='event_date']")
	  WebElement event_date;
	  @FindBy (xpath="//input[@class='form-control timepicker']")
	  WebElement event_time;
	  @FindBy (xpath="//div[@class='clockpicker-dial clockpicker-hours']")
	  WebElement hourdial ;
	  @FindBy (xpath="//div[@class='clockpicker-dial clockpicker-minutes']")
	  WebElement mindial ;
	  @FindBy(xpath = "//div[contains(@class, 'clockpicker-tick') and contains(@class, 'clockpicker-hours') and text() = '{hourValue}']")
	  private List<WebElement> hourTicks;
	  @FindBy (xpath="//div[contains(@class, 'clockpicker-tick') and contains(@class, 'clockpicker-minutes')]")
	  private List<WebElement>  minuteTicks;
	  @FindBy (xpath="//input[@name='event_note']")	
	  WebElement event_note;
	  @FindBy (xpath="(//button[@type='submit'])[1]")
	  WebElement save;
	  
	  public EventsPage(WebDriver driver) {
	        this.driver = driver;
	        this.elementutility = new ElementUtility(driver); 
	        PageFactory.initElements(driver, this);
	  }
	        
	        public void clickevents_meeting( ) {
	        	elementutility.scrollToElement(events_meeting);
	        	elementutility.clickOnElement(events_meeting);
	        }
	        public void clickevents( ) {
	        	elementutility.clickOnElement(events);
	        }
	        public void strcomp(String name) {
	        	elementutility.selectDrpdown(company, name);
	        }
	        public void stremp(String name) {
	        	elementutility.mouseHoverAndClickonElement(employee);
	        	elementutility.selectDrpdown(employee, name);
	        }
	        public void strevent_title(String name) {	        	
	        	elementutility.enterText(event_title, name);
	        }
	        public void strdate(String day, String month, String year) {
	        	elementutility.mouseHoverAndClickonElement(event_date);
	        	elementutility.enterDate(event_date, day, month, year);
	        }
	        public void setEventTime(String hourValue, String minValue) throws InterruptedException {
	            elementutility.clickOnElement(event_time);
	            WaitUtility.waitForElementToBeVisible(driver, hourdial);
	            for (WebElement tick : hourTicks) {
	                if (tick.getText().equals(hourValue)) {
	                    elementutility.clickOnElement(tick);
	                    break;
	                }
	            }
	            // Add a log message for debugging
	            System.out.println("Hour dial is visible");
	            WaitUtility.waitForElementToBeVisible(driver, mindial);
	            for (WebElement tick : minuteTicks) {
	                if (tick.getText().equals(minValue)) {
	                    elementutility.clickOnElement(tick);
	                    break;
	                }
	            }
	            System.out.println("Minute dial is visible");
	        }

	        public void clicksave() {
	            JavascriptExecutor executor = (JavascriptExecutor) driver;
	            executor.executeScript("arguments[0].click();", save);
	        }

}
