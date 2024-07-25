package listener;

import java.util.Arrays;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import constants.FrameWorkConstants;
import report.ExtentLogger;
import report.ExtentReportNG;
import utility.BrowserInfo;
import utility.Icon;



public class Listener implements ITestListener,ISuiteListener {
	
	
	@Override
	public void onStart(ISuite suite) {
		ExtentReportNG.initReports();
	}
	@Override
	public void onTestStart(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		ExtentReportNG.createTest(testMethodName);	
		ExtentLogger.info("Execution of <b>" + testMethodName + "</b> is Started on "+ "<b>"+ Icon.getOSIcon() + " & " + Icon.getBrowserIcon()+" -------- "+ BrowserInfo.getBrowserVersionInfo() +"</b>");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String logtext = "<b>"+ result.getMethod().getMethodName() + " is passed.</b>" + "  " + FrameWorkConstants.ICON_SMILEY_PASS;
		Markup markupMessage = MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
		ExtentLogger.pass(markupMessage);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + result.getThrowable().toString() + "</i></b>");
		
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		String message = "<details><summary><b><font color=red> Exception occured, click to see details: "
							+ FrameWorkConstants.ICON_SMILEY_FAIL + " </font></b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>")
							+ "</details> \n";
		ExtentLogger.fail(message);
		
		String logText = "<b>" + result.getMethod().getMethodName() + " is failed.</b>" + "  " +FrameWorkConstants.ICON_SMILEY_FAIL;
		Markup markupMessage = MarkupHelper.createLabel(logText, ExtentColor.RED);
		ExtentLogger.fail(markupMessage,true);
		
	}
		
	@Override
	public void onTestSkipped(ITestResult result) { // Log test skip
		String testCaseName = result.getName();
		ExtentLogger.skip(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + result.getThrowable().toString() + "</i></b>");
		
		String logText = "<b>" + testCaseName + " is skipped.</b>" + "  " + FrameWorkConstants.ICON_SMILEY_FAIL;
		Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		ExtentLogger.skip(markup_message, true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		onTestFailure(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// Do any setup if necessary
	}

	@Override
	public void onFinish(ITestContext context) {
		// Flush the extent reports to write the results to the report file
		ExtentReportNG.flushReport();
	}
}
