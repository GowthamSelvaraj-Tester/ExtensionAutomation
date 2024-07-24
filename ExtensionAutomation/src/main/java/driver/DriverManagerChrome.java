package driver;

import java.io.File;
import java.util.Collections;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import constants.FrameWorkConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManagerChrome implements DriverManager_OC  {

	@Override
	public WebDriver createDriver(String URL) {
		WebDriverManager.chromedriver().setup();// This sets up the ChromeDriver Binary
		ChromeOptions option = new ChromeOptions(); // Creates ChromeOptions to customize the browser
		option.addArguments("--disable-cookies"); // Option to disable cookies
		option.addArguments("--disable-cache"); // Option to disable cache
		option.setExperimentalOption("excludeSwitches",Collections.singleton("enable-automation")); // Excludes automation switches to avoid detection as bot
		option.setExperimentalOption("useAutomationExtension",false); //Disable use of automation extension
		option.addArguments("--disable-web-security"); // Disable web security
	    option.addArguments("--disable-features=IsolateOrigins,site-per-process");// Disable certain Chrome features
	    option.addExtensions(new File(FrameWorkConstants.CHROMEEXTENSION_PATH));
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}
}
