package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DMailLaunchPageObject {
	
	WebDriver driver;
	
	public DMailLaunchPageObject(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public final By metaMaskIcon = By.xpath("//div[@class='initial-div-ele-actions cursor-pointer']") ;

}
