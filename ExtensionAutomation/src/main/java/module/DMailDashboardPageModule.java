package module;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import action.Action;
import constants.FrameWorkConstants;
import enums.WaitStrategy;
import pageObject.DMailDashboardPageObject;
import report.ExtentLogger;

public class DMailDashboardPageModule {
	
	WebDriver driver;
	private DMailDashboardPageObject element;
	private Action reuse;
	
	public DMailDashboardPageModule(WebDriver driver) {
		this.driver = driver;
		element = new DMailDashboardPageObject(driver);
		reuse = new Action(driver);
	}
	
	public void swithDMailPage() {
		try {
			int tabs = reuse.getTabCount(driver);
			if(tabs == 1) {
				List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
	            driver.switchTo().window(windowHandles.get(0));
	            String logText = FrameWorkConstants.ICON_NAVIGATE_LEFT+ "Navigating back to : <b>" + "DMail Page </b>";
				ExtentLogger.info(logText);
	            return;
			}
		} catch(Exception e) {
			ExtentLogger.fail("<b><i>" + message(e.getMessage()) + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public boolean isComposeButtonDisplayed() {
		try {
			 return reuse.isDisplayed(element.composeButton,WaitStrategy.VISIBILITY,"Compose Button");
		} catch(Exception e) {
			ExtentLogger.fail("<b><i>" + message(e.getMessage()) + "</i></b>",true);
			Assert.fail();
			return false;
		}
	}
	
	public void composeButton() {
		try {
			if(isComposeButtonDisplayed()) {
				ExtentLogger.pass("Button is Displayed", true);
				reuse.getText(element.composeButton,WaitStrategy.VISIBILITY);
			}
		} catch(Exception e) {
			ExtentLogger.fail("<b><i>" + message(e.getMessage()) + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public String message(String message) {
		 String error = "<details><summary><b><font color=red> Exception occured, click to see details: "
				+ FrameWorkConstants.ICON_SMILEY_FAIL + " </font></b>" + "</summary>" + message.replaceAll(",", "<br>")
				+ "</details> \n";
		 return error;
	}

}
