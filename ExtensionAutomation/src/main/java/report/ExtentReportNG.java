package report;

import java.util.Objects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.FrameWorkConstants;
import utility.Icon;
import utility.ReportPath;

public class ExtentReportNG {
	// Declare a static ExtentReports object
	private static ExtentReports extent;
	
	public static void initReports() {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter reporter = new ExtentSparkReporter(ReportPath.getReportPath());
			extent.attachReporter(reporter);
			reporter.config().setTheme(Theme.STANDARD);
			reporter.config().setReportName(FrameWorkConstants.EXTENT_REPORT_TITLE);// Set the report name in the configuration
			reporter.config().setDocumentTitle(FrameWorkConstants.EXTENT_REPORT_TITLE);// Set the document title in the configuration
			extent.setSystemInfo("Organization", "App Innovation Technology");
			extent.setSystemInfo("Executor","Gowtham S");
			extent.setSystemInfo("Skill","Automation Test Engineer");
			extent.setSystemInfo("Java Version",FrameWorkConstants.JAVA_VERSION);
		}
	}
	
	public static void flushReport() {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
	}
	
	public static void createTest(String testCaseName) {
		ExtentManager.setExtentTest(extent.createTest(Icon.getBrowserIcon()+" : " + testCaseName));
	}

}


