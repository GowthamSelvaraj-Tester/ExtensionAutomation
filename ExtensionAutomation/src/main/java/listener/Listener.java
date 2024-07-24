package listener;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import constants.FrameWorkConstants;
import driver.DriverManager;
import report.ExtentReportNG;
import utility.Icon;
import utility.ScreenshotUtility;


public class Listener extends ScreenshotUtility implements ITestListener {

	// Static ExtentReports object for generating test reports
		public static ExtentReports extent = ExtentReportNG.getReportObject(FrameWorkConstants.EXTENT_REPORT_FOLDERPATH);
		// Map to store ExtentTest objects for each test class
		public static Map<String, ExtentTest> classTestMap = new HashMap<>();
		// ThreadLocal to store the current ExtentTest object
		public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

		public void onTestStart(ITestResult result) {
//			// Get the class name and test method name
//			String className = result.getTestClass().getName();
//			String testMethodName = result.getMethod().getMethodName();
//			// Get or create an ExtentTest object for the class
//			// Get or create an ExtentTest object for the class
//			ExtentTest classTest;
//			synchronized (classTestMap) {
//				classTest = classTestMap.computeIfAbsent(className, k -> extent.createTest(className));
//			}
//			// Create a node for the test method under the class test
//			ExtentTest test = classTest.createNode(Icon.getBrowserIcon() + " : " +testMethodName);
//			extentTest.set(test);// Set the current ExtentTest object to the ThreadLocal variable
			String testMethodName = result.getMethod().getMethodName();
			ExtentTest test = extent.createTest(Icon.getBrowserIcon() + " : "+testMethodName);
			extentTest.set(test);				
			// Log the start of the test
			extentTest.get().log(Status.INFO, "Execution of "+ testMethodName +" Started"); 
		}

		public void onTestSuccess(ITestResult result) {
			String logtext = "<b>"+ result.getMethod().getMethodName() + " is passed.</b>" + "  " + FrameWorkConstants.ICON_SMILEY_PASS;
			Markup markupMessage = MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
			extentTest.get().log(Status.PASS, markupMessage);
		}

		public void onTestFailure(ITestResult result) {
			// Get the instance of the test class and initialize WebDriver
			Object testInstance = result.getInstance();
			WebDriver driver = DriverManager.getDriver();
			try {
				// Get the WebDriver instance from the test class using reflection
				Method getDriverMethod = testInstance.getClass().getMethod("getDriver"); // Use the getter method
				driver = (WebDriver) getDriverMethod.invoke(testInstance);
				// Take a screenshot and get the path
				 String screenshotPath = takeScreenshot(driver,result.getMethod().getMethodName());
				 // Log the failure and attach the screenshot
				 extentTest.get().fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + result.getThrowable().toString() + "</i></b>");
				 String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
					String message = "<details><summary><b><font color=red> Exception occured, click to see details: "
							+ FrameWorkConstants.ICON_SMILEY_FAIL + " </font></b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>")
							+ "</details> \n";
				extentTest.get().fail(message);
				String logText = "<b>" + result.getMethod().getMethodName() + " is failed.</b>" + "  " +FrameWorkConstants.ICON_SMILEY_FAIL;
				Markup markupMessage = MarkupHelper.createLabel(logText, ExtentColor.RED);
				extentTest.get().fail(markupMessage);
				extentTest.get().addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
			} catch (Exception e) {
				// Log any exceptions that occur during screenshot capture
				 System.out.println("Unable to take Screenshot.");
				 e.printStackTrace();
			}
		}
		
		public void onTestSkipped(ITestResult result) { // Log test skip
			String testCaseName = result.getName();
			extentTest.get().log(Status.SKIP,"Execution of "+ testCaseName+" Skipped!");
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// Log partial success
			extentTest.get().fail(result.getThrowable());
		}

		public void onTestFailedWithTimeout(ITestResult result) {
			onTestFailure(result);
		}

		public void onStart(ITestContext context) {
			// Do any setup if necessary
		}

		public void onFinish(ITestContext context) {
			// Flush the extent reports to write the results to the report file
			extent.flush();
		}
}
