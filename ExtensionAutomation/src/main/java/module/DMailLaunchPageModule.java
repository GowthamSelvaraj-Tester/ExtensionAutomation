package module;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import action.Action;
import constants.FrameWorkConstants;
import enums.WaitStrategy;
import pageObject.DMailLaunchPageObject;
import pageObject.MetaMaskNotificationPageObject;
import report.ExtentLogger;

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
					String logText = FrameWorkConstants.ICON_NAVIGATE_LEFT+ "Navigating back to : <b>" + "DMail";
					ExtentLogger.info(logText);
					return;
				}
			}
			
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void switchExtensionPage() {
		try {
			if(isMetaMaskExtensionDisplayed()) {
				reuse.switchWindow(driver,"MetaMask");
			}
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void cancelButton() {
		try {
			reuse.clickButton(metaMaskElement.cancelButton,WaitStrategy.CLICKABLE, "Cancel Button");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void nextButton() {
		try {
			reuse.clickButton(metaMaskElement.nextButton,WaitStrategy.CLICKABLE, "Next Button");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void confirmButton() {
		try {
			reuse.clickButton(metaMaskElement.confirmButton,WaitStrategy.CLICKABLE,"Confirm Button");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void clickMetaMaskIcon() {
		try {
			reuse.clickButton(element.metaMaskIcon,WaitStrategy.CLICKABLE,"MetaMask Icon");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
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
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
			return false;
		}
	}
	
	public void acceptAlert() {
		try {
			reuse.handleAlert(driver);
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
}
