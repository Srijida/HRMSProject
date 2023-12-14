package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitUtility {
public static final long IMPLICIT_WAIT=10;
public static final long PAGE_LOAD_WAIT=10;

	static WebDriver driver;
	public WaitUtility(WebDriver driver)
	{
		WaitUtility.driver=driver;
	}


	
	public static void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void fluent_Wait(long timeout, long polling, String path) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    wait.pollingEvery(Duration.ofSeconds(polling));
	    wait.ignoring(Exception.class);

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
	}

		
	}


