package module;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import action.Action;
import constants.FrameWorkConstants;
import enums.WaitStrategy;
import listener.Listener;
import pageObject.DMailDashboardPageObject;

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
				Listener.extentTest.get().log(Status.INFO,logText);
	            return;
			}
		} catch(Exception e) {
			Assert.fail();
			Listener.extentTest.get().fail("<b><i>" + message(e.getMessage()) + "</i></b>");
		}
	}
	
	public boolean isComposeButtonDisplayed() {
		try {
			 return reuse.isDisplayed(element.composeButton,WaitStrategy.VISIBILITY,"Compose Button");
		} catch(Exception e) {
			Assert.fail();
			Listener.extentTest.get().fail("<b><i>" + message(e.getMessage()) + "</i></b>");
			return false;
		}
	}
	
	public void composeButton() {
		try {
			if(isComposeButtonDisplayed()) {
				WebElement elements = (WebElement) element.composeButton;
				Listener.extentTest.get().log(Status.INFO,"Text Displayed on the Button: "+ elements.getText());
			}
		} catch(Exception e) {
			Assert.fail();
			Listener.extentTest.get().fail("<b><i>" + message(e.getMessage()) + "</i></b>");
		}
	}
	
	public String message(String message) {
		 String error = "<details><summary><b><font color=red> Exception occured, click to see details: "
				+ FrameWorkConstants.ICON_SMILEY_FAIL + " </font></b>" + "</summary>" + message.replaceAll(",", "<br>")
				+ "</details> \n";
		 return error;
	}

}
