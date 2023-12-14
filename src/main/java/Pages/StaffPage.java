package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtility;
import utilities.WaitUtility;

public class StaffPage {
	  WebDriver driver;
	  ElementUtility elementutility;
	  WaitUtility waitutil;
	  
	  @FindBy (xpath="//a[contains(@href, '#')]//i[contains(@class, 'fa-user')]/ancestor::a")
	  WebElement staff;
	  @FindBy (xpath="(//a[@href='https://hrm.qabible.in/hrms/admin/roles'][normalize-space()='Roles & Privileges'])[2]")
	  WebElement rolesAndPrivilages;
	  @FindBy (xpath="//a//button[@type='button']")
	  WebElement add;
	  @FindBy (xpath="//input[@name='role_name']")
	  WebElement rolesname;
	  @FindBy (xpath="//select[@id='role_access']")
	  WebElement access;
	  @FindBy (xpath="(//button[@name='hrsale_form'])[1]")
	  WebElement save;
	  @FindBy (xpath="//input[@type='search']")
	  WebElement search;
	  
	  public StaffPage(WebDriver driver) {
	        this.driver = driver;
	        this.elementutility = new ElementUtility(driver); 
	        PageFactory.initElements(driver, this);
	  }
	        
	        public void clickstaff( ) {
	        	elementutility.clickOnElement(staff);
	        }
	        public void clickrolprivi() {
	        	elementutility.clickOnElement(rolesAndPrivilages);	        	
	        }
	        public void clickadd() {
	        	elementutility.clickOnElement(add);
	        }
	        public void strrolname(String name) {
	        	elementutility.enterText(rolesname, name);
	        }
	        public void straccess(String name) {
	        	elementutility.selectDrpdown(access, name);
	        }
	        public void clicksave() {
	        	elementutility.mouseHoverAndClickonElement(save);
	        	elementutility.clickOnElement(save);
	        }
	 
			public void clicksearch(String value) {
				elementutility.mouseHoverAndClickonElement(search);
	        	elementutility.clickOnElement(search);
	        	elementutility.enterText(search, value);
	        	
	        }
	 
	  
	  

}

