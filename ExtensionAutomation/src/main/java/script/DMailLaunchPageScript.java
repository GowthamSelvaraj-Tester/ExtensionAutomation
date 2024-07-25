package script;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import constants.FrameWorkConstants;
import module.DMailLaunchPageModule;
import report.ExtentLogger;

public class DMailLaunchPageScript {
	
	WebDriver driver;
	public DMailLaunchPageModule module;
	
	public DMailLaunchPageScript(WebDriver driver) {
		this.driver = driver;
		module = new DMailLaunchPageModule(driver);
	}
	
	public void TC001_CancelAccountConnection() {
		try {
			module.switchDMailPage();
			module.clickMetaMaskIcon();
			module.switchExtensionPage();
			module.cancelButton();
			module.acceptAlert();
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>");
			Assert.fail();
		}
	}
	
	public void TC002_ConnectAccountSuccessfully() {
		try {
			module.clickMetaMaskIcon();
			module.switchExtensionPage();
			module.nextButton();
			module.confirmButton();
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>");
			Assert.fail();
		}
	}
}
