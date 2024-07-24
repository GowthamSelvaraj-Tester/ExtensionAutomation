package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManagerFireFox implements DriverManager_OC {
	
	@Override
	public WebDriver createDriver(String URL) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.cookie.cookieBehavior", 2); // 0 = Accept all cookies, 2 = Block all cookies
		profile.setPreference("browser.cache.disk.enable", false); // Disable cache
		profile.setPreference("browser.cache.memory.enable", false); // Disable cache
		profile.setPreference("browser.cache.offline.enable", false); // Disable cache
		profile.setPreference("browser.cache.disk_cache_ssl", false); // Disable cache
		profile.setPreference("dom.webnotifications.enabled", false); // Disable web notifications
		FirefoxOptions option = new FirefoxOptions();
		option.setProfile(profile);
		option.addPreference("dom.disable_open_during_load", false); // Disable pop-up blocker
		option.addArguments("--disable-web-security"); // Disable web security
		WebDriver driver = new FirefoxDriver(option);
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}

}
