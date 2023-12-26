package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import Pages.AttendancePage;
import utilities.ReadExcelData;
@Listeners(listeners.ListenerTestNG.class)
public class AttendanceTest extends BaseTest{
	AttendancePage objattend;

	    @Test(priority=1)
	    public void ValidateAttendanceBasedOnDate() throws InterruptedException, IOException {
	    	ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "Attendance");	           
	    	performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
	    	objattend=new AttendancePage(driver);
	    	objattend.clicktimesheet();
	    	objattend.clickattendance();	    	
	        objattend.strdate(excelData.getCellData(1, 2),excelData.getCellData(1, 3),excelData.getCellData(1, 4));
	        objattend.clickget();
	        objattend.clicksearch();
	        Assert.assertTrue(objattend.areResultsDisplayed());

	    }

}

