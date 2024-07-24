package script;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import constants.FrameWorkConstants;
import listener.Listener;
import module.DMailDashboardPageModule;

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
			Assert.fail();
			Listener.extentTest.get().fail("<b><i>" + message(e.getMessage())+ "</i></b>");
		}
	}
	
	public String message(String message) {
		 String error = "<details><summary><b><font color=red> Exception occured, click to see details: "
				+ FrameWorkConstants.ICON_SMILEY_FAIL + " </font></b>" + "</summary>" + message.replaceAll(",", "<br>")
				+ "</details> \n";
		 return error;
	}
}
