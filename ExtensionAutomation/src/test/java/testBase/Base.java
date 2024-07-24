package testBase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import constants.FrameWorkConstants;
import driver.DriverManager;
import driver.DriverManager_OC;
import enums.DriverType;
import factories.DriverManagerFactory;
import listener.Listener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
@Listeners(Listener.class)
public class Base {
	
	public WebDriver getDriver() {
		return DriverManager.getDriver();
	}
	
	private void setDriver(WebDriver driver) {
		DriverManager.setDriver(driver);
	}
  
	@Parameters("browser")
	@BeforeClass
	public synchronized void startDriver(@Optional String browser) {
		if (browser == null || browser.isEmpty()) {
            browser = "CHROME";
        }
        DriverType driverType = DriverType.valueOf(browser.toUpperCase());
        DriverManager_OC manager = DriverManagerFactory.getManager(driverType);
        WebDriver driver = manager.createDriver(FrameWorkConstants.APPLICATION_URL);
        setDriver(driver);
        System.out.println("Initialized driver for browser: " + browser);
    }
	
	
	@AfterClass
	public void afterClass() {
	}
}
