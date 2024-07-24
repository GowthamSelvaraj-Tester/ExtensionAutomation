package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DMailDashboardPageObject {
	
	WebDriver driver;
	
	public DMailDashboardPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public final By composeButton = By.xpath("//button[@class='compose-gradient-btn']");
}
