package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import constants.FrameWorkConstants;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import report.ExtentLogger;

public class Action {
	
	public WebDriver driver;
	public ExplicitWaitFactory wait;
	public Actions actions;
	
	public Action(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver); 
		this.wait = new ExplicitWaitFactory();
		PageFactory.initElements(driver,this);
	}
	
	public void entertext(By by, String value, WaitStrategy waitStrategy, String elementName) {
		try {
			WebElement element = wait.performExplicitWait(waitStrategy, by);
	        actions.moveToElement(element).perform(); // Move to the element using Actions
	        element.sendKeys(value); 
			ExtentLogger.info("<b>" + value + "</b> is entered successfully in <b>" + elementName + "</b>");
		} catch(Exception e) {
			ExtentLogger.warning("<b><i>" + message(e.getMessage()) + "</i></b>");
		}
	}
	
	public void clickButton(By by, WaitStrategy waitStrategy, String elementName) {
		try {
			WebElement element = wait.performExplicitWait(waitStrategy, by);
			actions.moveToElement(element).perform();
			element.click();
			ExtentLogger.info("<b>"+ elementName + "</b> is clicked successfully");
		} catch(Exception e) {
			ExtentLogger.warning("<b><i>" + message(e.getMessage()) + "</i></b>" );
		}
	}
	
	public void checkBox(By by, WaitStrategy waitStrategy, String elementName) {
		try {
			wait.performExplicitWait(waitStrategy, by);
			WebElement element = wait.performExplicitWait(waitStrategy, by);
			if(!element.isSelected()) {
				element.click();
			}
			ExtentLogger.info("<b>"+ elementName + "</b> checkbox has been selected");
		} catch(Exception e) {
			ExtentLogger.warning("<b><i>" + message(e.getMessage()) + "</i></b>" );
		}
	}
	
	public boolean isDisplayed(By by,WaitStrategy waitStrategy,String elementName) {
		try {
		   wait.performExplicitWait(waitStrategy, by);
		   WebElement element = wait.performExplicitWait(waitStrategy, by);
		   ExtentLogger.info("<b>"+ elementName + "</b> is displayed successfully");
		   return element.isDisplayed();
		} catch(Exception e) {
			ExtentLogger.warning("<b><i>" + message(e.getMessage()) + "</i></b>" );
			return false;
		}
	}
	
	public void switchWindow(WebDriver driver,String pageTitle) {
		Set<String> windowHandles = driver.getWindowHandles();
		try{
			for (String handle : windowHandles) { // Iterate through each handle and print its title or URL
				driver.switchTo().window(handle);
				if(driver.getTitle().matches(pageTitle)) {
					String logText = FrameWorkConstants.ICON_NAVIGATE_RIGHT+ "Navigating to : <b>" + pageTitle +"</b>";
					ExtentLogger.info(logText);
					return;
				}
			}
		} catch(Exception e) {
			ExtentLogger.warning("<b><i>" + message(e.getMessage()) + "</i></b>");
		}
	}
	
	public void closeTabs(WebDriver driver) {
		Map<String, String> windowTitles = new HashMap<>();
	    String currentWindow = driver.getWindowHandle();
	    Set<String> windows = driver.getWindowHandles();
		try {
			for(String window: windows) {
				if(!window.equals(currentWindow)) {
					 String title = driver.switchTo().window(window).getTitle(); // Get title before switching
		                windowTitles.put(window, title);
		                driver.switchTo().window(window).close();
		                ExtentLogger.info("<b>"+ windowTitles.get(window) + "</b> has been closed");
				}
			}
		} catch(Exception e) {
			ExtentLogger.warning("<b><i>" + message(e.getMessage()) + "</i></b>");
		} finally {
			driver.switchTo().window(currentWindow);
		}
	}
	
	
	public int getTabCount(WebDriver driver) {
		try {
			Thread.sleep(2400);
			Set<String> windows = driver.getWindowHandles();
			return windows.size();
		} catch(InterruptedException e) {
			ExtentLogger.warning("<b><i>" + message(e.getMessage()) + "</i></b>");
		} catch(Exception e) {
			ExtentLogger.warning("<b><i>" + message(e.getMessage()) + "</i></b>" );
		}
		return 0;
	}
	
	public List<String> getTitle() {
		List<String> titles = new ArrayList<>();
		try {
			Thread.sleep(2400);
			Set<String> windows = driver.getWindowHandles();
			for(String window: windows) {
				driver.switchTo().window(window);
				titles.add(driver.getTitle());
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			ExtentLogger.warning("<b><i>" + message(e.getMessage()) + "</i></b>" );
		}	catch(Exception e) {
			ExtentLogger.warning("<b><i>" + message(e.getMessage()) + "</i></b>" );
		}
		return titles;
	}
	
	public void handleAlert(WebDriver driver) {
		try {
			String currentWindow = driver.getWindowHandle();
			Set<String> windows = driver.getWindowHandles(); 
			
			for(String window: windows) {
				if(!window.equals(currentWindow)) {
					driver.switchTo().window(window);
					String title = driver.switchTo().window(window).getTitle();
					String logText = FrameWorkConstants.ICON_NAVIGATE_RIGHT+ "Navigating to : <b>" + title +"</b>";
					ExtentLogger.info(logText);
					try {
						Alert alert = driver.switchTo().alert();
						String alertMessage = alert.getText();
						ExtentLogger.info("Alert is displayed with the message: "+alertMessage);
						alert.accept();
					} catch(NoAlertPresentException e) { 
						ExtentLogger.warning("<b><i>" + message(e.getMessage()) + "</i></b>" );
				    }catch(Exception e) {
				    	ExtentLogger.warning("<b><i>" + message(e.getMessage()) + "</i></b>");
					}
				}
			}
		} catch(Exception e) {
			ExtentLogger.warning("<b><i>" + message(e.getMessage()) + "</i></b>");
		}
	}
	
	public String message(String message) {
		 String error = "<details><summary><b><font color=purple> Exception occured, click to see details: "
				+ FrameWorkConstants.ICON_WARNING + " </font></b>" + "</summary>" + message.replaceAll(",", "<br>")
				+ "</details> \n";
		 return error;
	}
	
	public String getText(By by,WaitStrategy waitStrategy) {
		WebElement element = wait.performExplicitWait(waitStrategy,by);
		ExtentLogger.info("<b>"+ element.getText() + "</b> is displayed on the element");
		return element.getText();
	}
}
