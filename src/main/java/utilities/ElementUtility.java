package utilities;

import org.apache.poi.hpsf.Date;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class ElementUtility {
    	JavascriptExecutor js;
    	
    	
    	    private WebDriver driver;

    	    // Constructor to initialize the WebDriver
    	    public ElementUtility(WebDriver driver) {
    	        this.driver = driver;
    	    }

    	    // Method to enter text into a text field
    	    public  void enterText(WebElement element,String text){
    	        element.sendKeys(text);
    	        System.out.println(text);
    	    }

    	   // Method to get the text of a WebElement
    	       public String getElementText(WebElement element) {
    		        String text = element.getText();
    		        return text;
    		    }

    	    // Method to check if a WebElement is displayed
    	    public boolean isElementDisplayed(WebElement element) {
    	        return element.isDisplayed();
    	    }
    	    //method to check element is enabled
    	    public boolean isElementEnabled(WebElement element) {
    	        return element.isEnabled();
    	    }
    	    
    	    //click
    	    public  void clickOnElement(WebElement element){
    	        element.click();
    	    }
    	    
    	    //dropdown with select tag
    	    public void selectDrpdown(WebElement element,String value) {
    	    	
    	    	Select drpobject = new Select(element);
    	    	drpobject.selectByVisibleText(value);
    	    	System.out.println(value);
    	    	
    	    	
    	    	
    	    }
    	    //vertical scroll to a particular element
    	    public Object scrollToElement(WebElement element) 
    	    {
    	    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	    	return js.executeScript("arguments[0].scrollIntoView();", (element));
    			
    	    }
    	    public String get_TimeStamp() {
    			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
    			return timeStamp;
    		}
    	    
    	   //dropdown without select


// 	    public void dropDownWithoutSelect(List<WebElement> element,String value)
//  	    {
//  	    	
//   			for(WebElement w:element)  		    {
//		    	System.out.println(w.getText());  		    	
//   				if (w.getText().equals(value)) 
//   			{
//  		         w.click();
//  		    	}
//   		    }
//   			
//   		}
   	    public void dropDownWithoutSelect(List<WebElement> elements, String value) {
	        if (elements == null || value == null) {
    	            throw new IllegalArgumentException("Input parameters cannot be null");
    	        }
    	        for (WebElement element : elements) {
   	            System.out.println(element.getText());
    	            System.out.println("value is " + value);

    	            if (element.getText().trim().equalsIgnoreCase(value.trim())) {
    	       
						js.executeScript("arguments[0].scrollIntoView();", (element));
   	                element.click();
    	                break; // Assuming you want to exit the loop after finding a match
    	            }
    	        }
    	    }
    	    
    	  
    	      	
    			//File upload using robot class

    				public void FileUploadUsingRobotClass(WebDriver driver, String path) throws AWTException, InterruptedException
    				{
    				   StringSelection s = new StringSelection(path);
    				   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
    				   Robot r = new Robot();
    				   Thread.sleep(5000);
    				   r.keyPress(KeyEvent.VK_ENTER);
    				   r.keyRelease(KeyEvent.VK_ENTER);
    				   Thread.sleep(5000);
    				   r.keyPress(KeyEvent.VK_CONTROL);
    				   r.keyPress(KeyEvent.VK_V);
    				   Thread.sleep(5000);
    				   r.keyRelease(KeyEvent.VK_CONTROL);
    				   r.keyRelease(KeyEvent.VK_V);
    				   Thread.sleep(5000);
    				   r.keyPress(KeyEvent.VK_ENTER);
    				   r.keyRelease(KeyEvent.VK_ENTER);
    				}
                 //gettitle
    				public String getPageTitle(WebDriver driver){
    			        String title=driver.getTitle();
    			        return title;
    			    }
    			
    			   //alert accept
    			public void simpleAlert(WebDriver driver){
    			        Alert alert = driver.switchTo().alert();
    			        alert.accept();
    			    }
    			//allert dismiss
    			    public void confirmationAlert(WebDriver driver){
    			        Alert alert = driver.switchTo().alert();
    			        alert.dismiss();
    			    }
    			    //prompt alert
    			    public void promptAlert(WebDriver driver, String text) {
    			        Alert alert = driver.switchTo().alert();
    			        alert.sendKeys(text);
    			        alert.accept();
    			    }
//    			    public void enterDate(WebElement element,String day, String month, String year) {
//    			    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    			        element.click();      
//    			        System.out.println(day+"-"+ month+"-"+ year);
//    			        List<WebElement> allDates = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//    			                By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td")));
//    			        
//    			        for (WebElement date : allDates) {
//    			            if (date.getText().equals(day)) {
//    			                wait.until(ExpectedConditions.elementToBeClickable(date)).click();
//    			                break;
//    			            }
//    			        }
//    			    }
    			    public void enterDate(WebElement dateField, String day, String month, String year) {
    			    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    			    	  // Click the date field to open the calendar
    			    	  dateField.click();

    			    	  // Wait for the calendar to be visible
    			    	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));

    			    	  // Select the desired month and year (if needed)
    			    	  String currentMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).getText();
    			    	  String currentYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).getText();
    			    	  if (!currentMonth.equals(month) || !currentYear.equals(year)) {
    			    	    WebElement monthSelect = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
    			    	    WebElement yearSelect = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
    			    	    Select monthDropdown = new Select(monthSelect);
    			    	    Select yearDropdown = new Select(yearSelect);
    			    	    monthDropdown.selectByVisibleText(month);
    			    	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yearSelect.findElement(By.xpath("//option[text()='" + year + "']")));
    			            yearDropdown.selectByVisibleText(year);
    			    	  }

    			    	  // Find and click the desired day
    			    	  List<WebElement> allDates = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td")));
    			    	  for (WebElement date : allDates) {
    			    	    if (date.getText().equals(day)) {
    			    	      wait.until(ExpectedConditions.elementToBeClickable(date)).click();
    			    	      break;
    			    	    }
    			    	  }
    			    	  System.out.println(day+"/"+month+"/"+year);
    			    	}

    			    public void mouseHoverAndClickonElement(WebElement element){
    			        Actions action=new Actions(driver);
    			        action.moveToElement(element).click().build().perform();
    			    }
    			    public boolean Alert(WebDriver driver) {
    					boolean presentFlag = false;
    					Alert alert = null;

    					try {
    						// Check the presence of alert
    						alert = driver.switchTo().alert();
    						// if present consume the alert
    						alert.accept();
    						presentFlag = true;
    					} catch (NoAlertPresentException ex) {
    						// Alert present; set the flag

    						// Alert not present
    						ex.printStackTrace();
    					} finally {
    						if (!presentFlag) {
    							System.out.println("The Alert is handled successfully");		
    						} else{
    							System.out.println("There was no alert to handle");
    						}
    					}

    					return presentFlag;
    				}
    			    public boolean isAlertPresent() {
    			        try {
    			           
    			            Alert alert = driver.switchTo().alert();
    			            System.out.println("Alert Text: " + alert.getText());
    			            alert.accept(); // You can use alert.dismiss() if needed
    			            return true;
    			        } catch (NoAlertPresentException e) {
    			            return false;
    			        }
    			    }
    			   
					
    		
    }

 