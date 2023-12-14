package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Constant.constant;

public class ExtentUtility {

    public static ExtentReports createextentreport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(constant.ExtentReport_path);
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }
}
