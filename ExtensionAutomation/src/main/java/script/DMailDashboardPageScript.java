package script;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import constants.FrameWorkConstants;
import module.DMailDashboardPageModule;
import report.ExtentLogger;

public class DMailDashboardPageScript {
	
	WebDriver driver;
	private DMailDashboardPageModule module;
	
	public DMailDashboardPageScript(WebDriver driver) {
		this.driver = driver;
		module = new DMailDashboardPageModule (driver);
	}

	public void TC003_DMailDashboardPageUIValidation() {
		try {
			module.swithDMailPage();
			module.composeButton();
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>");
			Assert.fail();
		}
	}
}
