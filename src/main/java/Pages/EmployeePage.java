package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementUtility;
import utilities.WaitUtility;
public class EmployeePage {
    WebDriver driver;
    ElementUtility elementutility;
    WaitUtility wait;
    
    @FindBy(xpath = "(//a[@href='https://hrm.qabible.in/hrms/admin/employees'])[2]")
    WebElement employee;
    @FindBy(xpath = "(//button[@class='btn btn-xs btn-primary'])[2]")
    WebElement addNewEmployee;
    @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstname;
    @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastname;
    @FindBy(xpath = "//input[@name='employee_id']")
    WebElement employeeID;
    @FindBy(xpath = "//input[@name='date_of_joining']")
    WebElement dateOfJoining;   
    @FindBy(xpath="(//select[@name='company_id'])[2]")
    WebElement company;    
    @FindBy(xpath="(//select[@name='location_id'])[2]")
    WebElement location;  
    @FindBy(xpath="(//select[@name='department_id'])[2]")
	WebElement department;  
    @FindBy(xpath="(//select[@name='designation_id'])[2]")
  	WebElement designation;   
    @FindBy(xpath="(//input[@class='form-control' ])[4]")
    WebElement username; 
    @FindBy(xpath="(//input[@class='form-control' ])[5]")
    WebElement email;   
    @FindBy(xpath="//select[@name='gender']")
    WebElement gender; 
    @FindBy(xpath="//select[@name='office_shift_id']")
    WebElement officeshift;   
    @FindBy(xpath="//input[@class='form-control date_of_birth hasDatepicker']")
    WebElement dateOfBirth;
    @FindBy(xpath="//input[@name='contact_no']")
    WebElement contactNum; 
    @FindBy(xpath="//input[@name='password']")
    WebElement password;
    @FindBy(xpath="//input[@name='confirm_password']")
    WebElement confirmPassword;
    @FindBy(xpath="//select[@name='role']")
    WebElement role;
    @FindBy(xpath="//select[@name='leave_categories[]']")
    WebElement leave; 
    @FindBy(xpath = "//input[@name='address']")
    WebElement address;   
    @FindBy(xpath = "(//button[@class='btn btn-primary'])[2]")
    WebElement save;
    @FindBy(className = "toast-message")
    WebElement toast;

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
        this.elementutility = new ElementUtility(driver); 
        PageFactory.initElements(driver, this);
        
    }

    public void clickemployee() {
        elementutility.clickOnElement(employee);
    }

    public void clickaddNewEmployee() {
    	elementutility.mouseHoverAndClickonElement(addNewEmployee);
       elementutility.clickOnElement(addNewEmployee);
       
       WaitUtility.waitForElementToBeClickable(driver, addNewEmployee);
    }

    public void setFirstName(String strfname) {
      elementutility.enterText(firstname, strfname);
      WaitUtility.waitForElementToBeVisible(driver, firstname);
    }

    public void setLastNAme(String strlname) {
       elementutility.enterText(lastname, strlname);
       WaitUtility.waitForElementToBeVisible(driver, lastname);
    }
    public void setEmployeeID(String strempID) {
    	 elementutility.enterText(employeeID, strempID);
       WaitUtility.waitForElementToBeVisible(driver, employeeID);
    }

    public void selectDateOfJoining(String day, String month, String year) {
    	elementutility.enterDate(dateOfJoining, day, month, year);
    	
    }
    public void setCompanyName(String name) {
     elementutility.selectDrpdown(company, name);
     }
   public void setLocationlist(String value){
	 elementutility.mouseHoverAndClickonElement(location);
	elementutility.selectDrpdown(location, value);
   }
    
  public void setMainDept(String value){
	  elementutility.mouseHoverAndClickonElement(department);
	  elementutility.selectDrpdown(department, value);	
	}     
   public void setDesignation(String value) {
	   elementutility.mouseHoverAndClickonElement(designation);
	 elementutility.selectDrpdown(designation, value);
      	
     }
       
    public void setUserName(String name) {
    	     elementutility.enterText(username, name);
    	     }
    	    
    public void setEmail(String name){
    	    	elementutility.enterText(email, name);
    	    }
     public void setGender(String name) {
    	        elementutility.selectDrpdown(gender, name);
    	        }
    	       
     public void setofficeshift(String name){
    	       	elementutility.selectDrpdown(officeshift, name);
    	       }
     public void selectDOB(String day, String month, String year) {
    	 elementutility.enterDate(dateOfBirth, day, month, year);
     	
     }
     public void setcontact(String num){
    	 elementutility.enterText(contactNum, num);    	 
     }
     public void setpassword(String value){
    	 elementutility.enterText(password, value);    	 
     }
     public void setconfrimpass(String value){
    	 elementutility.enterText(confirmPassword, value);    	 
     }
     public void setRole(String name) {
	        elementutility.selectDrpdown(role, name);
	        }
     public void setleave(String name){
	       	elementutility.selectDrpdown(leave, name);
}
     public void setAddress(String stradd) {
         elementutility.enterText(address, stradd);
      }
     public void clicksave() {
         elementutility.clickOnElement(save);
     }
     public boolean getToastMessage() {
    	 System.out.println(toast.getText());
    	    return toast.getText() != null;
    	}

    
}
       
    	    
 
    
   
