package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.FrameWorkConstants;
import utility.DateUtility;

public class ExtentReportNG {
	// Declare a static ExtentReports object
	public static ExtentReports extent;
	
	// Method to get a synchronized instance of ExtentReports
	public static synchronized ExtentReports getReportObject(String reportPath) {
		if (extent == null) { // Check if the ExtentReports object is null
			String timestamp = DateUtility.getStringDate("_ddMMyyyy_HHmmss");
	        String formattedReportPath = reportPath + FrameWorkConstants.EXTENT_REPORT_NAME + timestamp + ".html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(formattedReportPath);// Create a new ExtentSparkReporter with the specified report path
			reporter.config().setTheme(Theme.STANDARD);
			reporter.config().setReportName(FrameWorkConstants.EXTENT_REPORT_TITLE);// Set the report name in the configuration
			reporter.config().setDocumentTitle(FrameWorkConstants.EXTENT_REPORT_TITLE);// Set the document title in the configuration
								
			extent = new ExtentReports(); // Create a new ExtentReports object and attach the reporter
			extent.attachReporter(reporter);
			extent.setSystemInfo("Organization", "App Innovation Technology");
			extent.setSystemInfo("Executor","Gowtham S");
			extent.setSystemInfo("Skill","Automation Test Engineer");
			extent.setSystemInfo("Java Version",FrameWorkConstants.JAVA_VERSION);
		}
		return extent; // Return the ExtentReports object
	}
}


