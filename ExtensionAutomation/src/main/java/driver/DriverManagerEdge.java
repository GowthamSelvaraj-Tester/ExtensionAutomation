package driver;

import java.io.File;
import java.util.Collections;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import constants.FrameWorkConstants;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverManagerEdge implements DriverManager_OC{
	
	@Override
	public WebDriver createDriver(String URL) {
		WebDriverManager.edgedriver().setup();// This sets up the EdgeDriver binary
		EdgeOptions option = new EdgeOptions(); // Creates EdgeOptions to customize browser
		String existingProfilePath = "C:\\Users\\hp\\AppData\\Local\\Microsoft\\Edge\\UserData\\Default";
        option.addArguments("user-data-dir=" + existingProfilePath);
		option.addArguments("--disable-cookies"); // Option to disable cookies
		option.addArguments("--disable-cache"); // Option to disable cache
		option.addArguments("--no-first-run");
        option.addArguments("--no-default-browser-check");
		option.setExperimentalOption("excludeSwitches",Collections.singleton("enable-automation")); // Excludes automation switches to avoid detection as bot
		option.setExperimentalOption("useAutomationExtension",false); // Disable use of automation extension
		option.addArguments("--disable-web-security"); // Disable web security
		option.addArguments("--disable-features=IsolateOrigins,site-per-process");// Disable certain Edge features
		option.addExtensions(new File(FrameWorkConstants.EDGEEXTENSION_PATH));
		WebDriver driver = new EdgeDriver(option);
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}
}
