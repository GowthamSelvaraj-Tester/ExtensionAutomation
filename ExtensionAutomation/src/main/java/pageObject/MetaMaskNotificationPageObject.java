package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetaMaskNotificationPageObject {
	
	WebDriver driver;
	
	public MetaMaskNotificationPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public final By cancelButton = By.xpath("//*[contains(text(),'Cancel')]");
	public final By nextButton = By.xpath("//*[contains(text(),'Next')]");
	public final By confirmButton = By.xpath("//*[contains(text(),'Confirm')]");
	public final By rejectButtpn = By.xpath("//*[contains(text(),'Reject')]");
}
