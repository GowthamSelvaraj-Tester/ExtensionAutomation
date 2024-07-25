package constants;

import utility.ConfigReaders;
import utility.GlobalVariables;

public class FrameWorkConstants {
	
	private FrameWorkConstants() {
	}
	
	public static final String PROJECT_PATH = GlobalVariables.basepath; 
	
	public static final String APPLICATION_URL = ConfigReaders.getProperty("applicationURL");
	public static final String CHROMEEXTENSION_PATH = PROJECT_PATH+ConfigReaders.getProperty("chromeExtension");
	public static final String EDGEEXTENSION_PATH = PROJECT_PATH+ConfigReaders.getProperty("edgeExtension");
	
	public static final String SCREENSHOT_PATH = PROJECT_PATH + ConfigReaders.getProperty("screenShotFolderPath");
	public static final String IMAGE_FORMAT = ConfigReaders.getProperty("fileFormat");
	
	public static final String EXTENT_REPORT_FOLDERPATH = PROJECT_PATH+"//ExtentReports//";
	public static final String EXTENT_REPORT_NAME = "AutomationTestReport.html";
	
	public static final String EXTENT_REPORT_TITLE ="Automation Test Suite Report - DMail";
	
	public static final String EXCEL_PATH = PROJECT_PATH+ConfigReaders.getProperty("sheetPath");
	
	public static final String JSON_PATH = PROJECT_PATH + ConfigReaders.getProperty("jsonFilePath");
	
	public static final int WAIT_EXPLICIT = Integer.parseInt(ConfigReaders.getProperty("waitTime")); 
	
	public static final String PASSED_STEP_SCREENSHOT = ConfigReaders.getProperty("passed_steps_screenshot");
	public static final String FAILED_STEP_SCREENSHOT = ConfigReaders.getProperty("failed_steps_screenshot");
	public static final String SKIPPED_STEP_SCREENSHOT = ConfigReaders.getProperty("skipped_steps_screenshot");
	public static final String RETRY_STEP_SCREENSHOT = ConfigReaders.getProperty("retry_failed_tests");
	
	public static final String ICON_SMILEY_PASS = "<i class='fa fa-smile-o' style='font-size:24px'></i>";
	public static final String ICON_SMILEY_SKIP = "<i class=\"fas fa-frown-open\"></i>";
	public static final String ICON_SMILEY_FAIL = "<i class='fa fa-frown-o' style='font-size:24px'></i>";
	public static final String ICON_BUG = "<i class='fa fa-bug' ></i>";
	public static final String ICON_WARNING = "<i class='fa fa-exclamation-triangle' ></i>";
	
	public static final String ICON_OS_WINDOWS = "<i class='fa fa-windows' ></i>";
	public static final String ICON_OS_MAC = "<i class='fa fa-apple' ></i>";
	public static final String ICON_OS_LINUX = "<i class='fa fa-linux' ></i>";
	
	public static final String JAVA_VERSION = System.getProperty("java.version");
	
	public static final String ICON_BROWSER_CHROME = "chrome";
	public static final String ICON_BROWSER_PREFIX = "<i class=\"fa fa-";
	public static final String ICON_BROWSER_SUFFIX = "\" aria-hidden=\"true\"></i>";
	
	public static final String ICON_NAVIGATE_RIGHT = "<i class='fa fa-arrow-circle-right' ></i>";
	public static final String ICON_NAVIGATE_LEFT = "<i class='fa fa-arrow-circle-left' ></i>";
	
	public static void main(String[] args) {
		System.out.println(PASSED_STEP_SCREENSHOT);
	}
}
