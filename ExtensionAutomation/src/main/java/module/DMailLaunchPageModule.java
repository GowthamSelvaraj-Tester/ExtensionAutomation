package module;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import action.Action;
import constants.FrameWorkConstants;
import enums.WaitStrategy;
import listener.Listener;
import pageObject.DMailLaunchPageObject;
import pageObject.MetaMaskNotificationPageObject;

public class DMailLaunchPageModule {
	
	WebDriver driver;
	public DMailLaunchPageObject element;
	public MetaMaskNotificationPageObject metaMaskElement;
	
	public Action reuse;
	
	
	public DMailLaunchPageModule(WebDriver driver) {
		this.driver = driver;
		element = new DMailLaunchPageObject(driver);
		metaMaskElement = new MetaMaskNotificationPageObject(driver);
		reuse = new Action(driver);
	}
	
	public void switchDMailPage() {
		try {
			int tabs = reuse.getTabCount(driver);
			if(tabs <=1) {
				return;
			}
			List<String> titles = reuse.getTitle();
			for(String title: titles) {
				String currentTitle = title;
				if(currentTitle.matches("DMail")) {
					reuse.switchWindow(driver,currentTitle);
					reuse.closeTabs(driver);
					String logText = FrameWorkConstants.ICON_NAVIGATE_LEFT+ "Navigating back to : <b>" + "DMail Page";
					Listener.extentTest.get().log(Status.INFO,logText);
					return;
				}
			}
			
		} catch(Exception e) {
			Assert.fail();
			Listener.extentTest.get().fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>");
		}
	}
	
	public void switchExtensionPage() {
		try {
			if(isMetaMaskExtensionDisplayed()) {
				reuse.switchWindow(driver,"MetaMask");
			}
		} catch(Exception e) {
			Assert.fail();
			Listener.extentTest.get().fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>");
		}
	}
	
	public void cancelButton() {
		try {
			reuse.clickButton(metaMaskElement.cancelButton,WaitStrategy.CLICKABLE, "Cancel Button");
		} catch(Exception e) {
			Assert.fail();
			Listener.extentTest.get().fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>");
		}
	}
	
	public void nextButton() {
		try {
			reuse.clickButton(metaMaskElement.nextButton,WaitStrategy.CLICKABLE, "Next Button");
		} catch(Exception e) {
			Assert.fail();
			Listener.extentTest.get().fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>");
		}
	}
	
	public void confirmButton() {
		try {
			reuse.clickButton(metaMaskElement.confirmButton,WaitStrategy.CLICKABLE,"Confirm Button");
		} catch(Exception e) {
			Assert.fail();
			Listener.extentTest.get().fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>");
		}
	}
	
	public void clickMetaMaskIcon() {
		try {
			reuse.clickButton(element.metaMaskIcon,WaitStrategy.CLICKABLE,"MetaMask Icon");
		} catch(Exception e) {
			Assert.fail();
			Listener.extentTest.get().fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>");
		}
	}
	
	public boolean isMetaMaskExtensionDisplayed() {
		try {
			int tabs = reuse.getTabCount(driver);
			if(tabs > 1) {
				List<String> titles = reuse.getTitle();
				for(String title : titles) {
					if(title.equals("MetaMask")) {
						return true;
					}
				}
			}
			return false;
		} catch(Exception e) {
			Assert.fail();
			Listener.extentTest.get().fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>");
			return false;
		}
	}
	
	public void acceptAlert() {
		try {
			reuse.handleAlert(driver);
			Listener.extentTest.get().log(Status.INFO,"Alert Pop-up dismissed.");
		} catch(Exception e) {
			Assert.fail();
			Listener.extentTest.get().fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>");
		}
	}
}
