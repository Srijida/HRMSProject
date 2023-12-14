package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtility;

public class OrganisationPage {
	 WebDriver driver;
	  ElementUtility elementutility;
	 
	  
	  @FindBy (xpath="//a[.//span[text()='Organization']]")
	  WebElement organization;
	  @FindBy (xpath="//a[@href='https://hrm.qabible.in/hrms/admin/department']")
	  WebElement department;
	  @FindBy (xpath="//input[@name='department_name']")
	  WebElement name;
	  @FindBy (xpath="//select[@id='aj_company']")
	  WebElement company;
	  @FindBy (xpath="//span[@id='select2-location_id-oc-container' and text()='Chennai Branch']")
	  List<WebElement> locatioId;
	  @FindBy (xpath="//select[@id='select2-demo-6']")
	  WebElement departmentHead;
	  @FindBy (xpath="(//button[@name='hrsale_form'])[1]")
	  WebElement save;
	  public OrganisationPage(WebDriver driver) {
	        this.driver = driver;
	        this.elementutility = new ElementUtility(driver); 
	        PageFactory.initElements(driver, this);	        
	    }
	  public void clickorg() {
	        elementutility.clickOnElement(organization);
	    }

	    public void clickdept() {
	       elementutility.clickOnElement(department);
	    }

	    public void setName(String strname) {
	      elementutility.enterText(name, strname);
	    }
	    public void setcomp(String name) {
	        elementutility.selectDrpdown(company, name);
	        }

	    public void setloc(String name) {
	        elementutility.dropDownWithoutSelect(locatioId, name);
	        }
	    public void setdeptHead(String name) {
	        elementutility.selectDrpdown(departmentHead, name);
	        }
	    public void clicksave() {
        	elementutility.mouseHoverAndClickonElement(save);
        	elementutility.clickOnElement(save);
        }

	    }  
	    


