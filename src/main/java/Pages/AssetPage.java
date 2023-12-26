package Pages;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.constant;
import utilities.ElementUtility;
import utilities.WaitUtility;

public class AssetPage {
	WebDriver driver;
	ElementUtility elementutility;
	WaitUtility waitutil;

	@FindBy(xpath = "//a/i[@class='fa fa-flask']")
	WebElement asset;

	@FindBy(xpath = "//a[@href='https://hrm.qabible.in/hrms/admin/assets']/i[@class='fa fa-check-circle-o']")
	WebElement dropasset;

	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement add;
	@FindBy(xpath = "//select[@name='category_id']")
	WebElement catogary;
	@FindBy(xpath = "//input[@name='asset_name']")
	WebElement assetname;

	@FindBy(xpath = "//input[@name='company_asset_code']")
	WebElement asset_code;

	@FindBy(xpath = "	//select[@name='is_working']")
	WebElement nameworking;

	@FindBy(xpath = "//select[@name='company_id']")
	WebElement companyId;

	@FindBy(xpath = "//select[@id='select2-demo-6']")
	WebElement employeeId;

	@FindBy(xpath = "//input[@name='purchase_date']")
	WebElement purchasedate;

	@FindBy(xpath = "//input[@name='invoice_number']")
	WebElement invoicenum;

	@FindBy(xpath = "//input[@name='manufacturer']")
	WebElement manufacture;

	@FindBy(xpath = "//input[@name='serial_number']")
	WebElement serialnum;

	@FindBy(xpath = "(//input[@class='form-control asset_date hasDatepicker'])[2]")
	WebElement warranty;

	@FindBy(xpath = "//input[@name='asset_image']")
	WebElement assetimage;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement submit;

	@FindBy(className = "toast-message")
	WebElement response;

	public AssetPage(WebDriver driver) {
		this.driver = driver;
		this.elementutility = new ElementUtility(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean AlertPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept(); // Handle alert by accepting
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public void clickasset() {
		elementutility.scrollToElement(asset);
		elementutility.clickOnElement(asset);
	}

	public void clickassetdrop() {
		elementutility.clickOnElement(dropasset);

	}

	public void clickadd() {
		elementutility.clickOnElement(add);
	}

	public void strcatogory(String name) {
		elementutility.selectDrpdown(catogary, name);
	}

	public void strassetname(String name) {
		elementutility.enterText(assetname, name);
	}

	public void strassetcode(String name) {
		elementutility.enterText(asset_code, name);
	}

	public void strworking(String value) {
		elementutility.selectDrpdown(nameworking, value);
	}

	public void strcomId(String value) {
		elementutility.selectDrpdown(companyId, value);
	}

	public void stremployee(String value) {
		elementutility.mouseHoverAndClickonElement(employeeId);
		waitutil.waitForElementToBeVisible(driver, employeeId);
		elementutility.selectDrpdown(employeeId, value);
	}

	public void setpurDate(String day, String month, String year) {

		elementutility.enterDate(purchasedate, day, month, year);
		waitutil.waitForElementToBeClickable(driver, purchasedate);

	}

	public void strinvoice(String name) {
		elementutility.enterText(invoicenum, name);
	}

	public void strmanu(String name) {
		elementutility.enterText(manufacture, name);
	}

	public void strserielnum(String name) {
		elementutility.enterText(serialnum, name);
	}

	public void setwarranty(String day, String month, String year) {
		elementutility.enterDate(warranty, day, month, year);
	}

	public void clickfileUpload() throws AWTException, InterruptedException {
		elementutility.mouseHoverAndClickonElement(assetimage);
		elementutility.FileUploadUsingRobotClass(driver, constant.Fileupload_path);
	}

	public void clicksave() {
		elementutility.clickOnElement(submit);
	}

	public boolean ResponseMessage() {
   	 System.out.println(response.getText());
		return true;
		
	}
	 public boolean isSaveSuccessMessageDisplayed() {
	        
    	 String toastText = response.getText();
    	    String successMessage =constant.SuccessMessage; 
    	    return toastText.contains(successMessage);
     }

     public boolean isFailureMessageDisplayed() {
    	 String toastText = response.getText();
 	    String failureMessage = constant.FailureMessage; 
 	    return toastText.contains(failureMessage);
     }
     


}
