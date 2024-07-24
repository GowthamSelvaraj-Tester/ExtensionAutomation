package utility;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import driver.DriverManager;

public final class BrowserInfo {
	
	private BrowserInfo() {
		super();
	}
	
	public static String getBrowserInfo() {
		Capabilities capabilities = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
		return capabilities.getBrowserName().toUpperCase();
	}
	
	public static String getBrowserVersionInfo() {
		Capabilities capabilities = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
		return capabilities.getBrowserVersion();
	}
}
