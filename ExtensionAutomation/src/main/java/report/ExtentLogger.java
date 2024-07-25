package report;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import constants.FrameWorkConstants;
import utility.ScreenshotUtility;


public class ExtentLogger {
	
	private ExtentLogger() {
		
	}
	
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}
	
	public static void pass(Markup message) {
		ExtentManager.getExtentTest().pass(message);
	}
	
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}
	
	public static void fail(Markup Message) {
		ExtentManager.getExtentTest().fail(Message);
	}
	
	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}
	
	public static void info(Markup message) {
		ExtentManager.getExtentTest().info(message);
	}
	
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	
	public static void skip(Markup message) {
		ExtentManager.getExtentTest().skip(message);
	}
	
	public static void warning(String message) {
		ExtentManager.getExtentTest().warning(message);
	}
	
	public static void warning(Markup message) {
		ExtentManager.getExtentTest().warning(message);
	}

	public static void pass(String message, boolean isScreenshotNeeded) {
		if(FrameWorkConstants.PASSED_STEP_SCREENSHOT.trim().matches("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.getBase64Image()).build());
		} else {
			ExtentManager.getExtentTest().pass(message);
		}
	}
	
	public static void pass(Markup message, boolean isScreenshotNeeded) {
		if(FrameWorkConstants.PASSED_STEP_SCREENSHOT.trim().equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().pass(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.getBase64Image()).build());
			ExtentManager.getExtentTest().pass(message);
		} else {
			ExtentManager.getExtentTest().pass(message);
		}
	}
	
	public static void fail(String message, boolean isScreenshotNeeded) {
		if(FrameWorkConstants.FAILED_STEP_SCREENSHOT.trim().equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.getBase64Image()).build());
		} else {
			ExtentManager.getExtentTest().fail(message);
		}
	}
	
	public static void fail(Markup message, boolean isScreenshotNeeded) {
		if(FrameWorkConstants.FAILED_STEP_SCREENSHOT.trim().equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.getBase64Image()).build());
			ExtentManager.getExtentTest().fail(message);
		} else {
			ExtentManager.getExtentTest().fail(message);
		}
	}
	
	public static void skip(String message, boolean isScreenshotNeeded) {
		if(FrameWorkConstants.SKIPPED_STEP_SCREENSHOT.trim().equalsIgnoreCase("yes")&& isScreenshotNeeded) {
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.getBase64Image()).build());
		} else {
			ExtentManager.getExtentTest().skip(message);
		}
	}
	
	public static void skip(Markup message, boolean isScreenshotNeeded) {
		if(FrameWorkConstants.SKIPPED_STEP_SCREENSHOT.trim().equalsIgnoreCase("yes")&& isScreenshotNeeded) {
			ExtentManager.getExtentTest().skip(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.getBase64Image()).build());
			ExtentManager.getExtentTest().skip(message);
		} else {
			ExtentManager.getExtentTest().skip(message);
		}
	}
}
