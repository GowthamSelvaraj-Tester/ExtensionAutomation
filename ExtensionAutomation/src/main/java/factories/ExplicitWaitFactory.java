package factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import constants.FrameWorkConstants;
import driver.DriverManager;
import enums.WaitStrategy;

public class ExplicitWaitFactory {
	
	public ExplicitWaitFactory() {
		
	}

	public WebElement performExplicitWait(WaitStrategy waitType,By by) {
		WebElement element = null;
		if (waitType == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameWorkConstants.WAIT_EXPLICIT))
					.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if (waitType == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameWorkConstants.WAIT_EXPLICIT))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} 
		else if (waitType == WaitStrategy.VISIBILITY) {
			element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameWorkConstants.WAIT_EXPLICIT))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} 
		else if (waitType == WaitStrategy.NONE) {
			System.out.println("Not Waiting for anything");
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}
}
