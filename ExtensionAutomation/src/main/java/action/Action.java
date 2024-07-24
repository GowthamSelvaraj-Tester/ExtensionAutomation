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
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import constants.FrameWorkConstants;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import listener.Listener;

public class Action {
	
	public WebDriver driver;
	public ExplicitWaitFactory wait;
	
	public Action(WebDriver driver) {
		this.driver = driver;
		this.wait = new ExplicitWaitFactory();
		PageFactory.initElements(driver,this);
	}
	
	public void entertext(By by, String value, WaitStrategy waitStrategy, String elementName) {
		try {
			wait.performExplicitWait(waitStrategy, by).sendKeys(value);
			Listener.extentTest.get().log(Status.INFO,"<b>" + value + "</b> is entered successfully in <b>" + elementName + "</b>");
		} catch(Exception e) {
			Listener.extentTest.get().log(Status.WARNING,"<b><i>" + message(e.getMessage()) + "</i></b>");
		}
	}
	
	public void clickButton(By by, WaitStrategy waitStrategy, String elementName) {
		try {
			wait.performExplicitWait(waitStrategy, by).click();
			Listener.extentTest.get().log(Status.INFO,"<b>"+ elementName + "</b> is clicked successfully");
		} catch(Exception e) {
			Listener.extentTest.get().log(Status.WARNING,"<b><i>" + message(e.getMessage()) + "</i></b>" );
		}
	}
	
	public void checkBox(By by, WaitStrategy waitStrategy, String elementName) {
		try {
			wait.performExplicitWait(waitStrategy, by);
			WebElement element = wait.performExplicitWait(waitStrategy, by);
			if(!element.isSelected()) {
				element.click();
			}
			Listener.extentTest.get().log(Status.INFO,"<b>"+ elementName + "</b> checkbox has been selected");
		} catch(Exception e) {
			Listener.extentTest.get().log(Status.WARNING,"<b><i>" + message(e.getMessage()) + "</i></b>" );
		}
	}
	
	public boolean isDisplayed(By by,WaitStrategy waitStrategy,String elementName) {
		try {
		   wait.performExplicitWait(waitStrategy, by);
		   WebElement element = wait.performExplicitWait(waitStrategy, by);
		   Listener.extentTest.get().log(Status.INFO,"<b>"+ elementName + "</b> is displayed successfully");
		   return element.isDisplayed();
		} catch(Exception e) {
			Listener.extentTest.get().log(Status.WARNING,"<b><i>" + message(e.getMessage()) + "</i></b>" );
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
					Listener.extentTest.get().log(Status.INFO,logText);
					return;
				}
			}
		} catch(Exception e) {
			Listener.extentTest.get().log(Status.WARNING,"<b><i>" + message(e.getMessage()) + "</i></b>");
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
					Listener.extentTest.get().log(Status.INFO,"<b>"+ windowTitles.get(window) + "</b> has been closed");
				}
			}
		} catch(Exception e) {
			Listener.extentTest.get().log(Status.WARNING,"<b><i>" + message(e.getMessage()) + "</i></b>");
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
			Listener.extentTest.get().log(Status.WARNING,"<b><i>" + message(e.getMessage()) + "</i></b>");
		} catch(Exception e) {
			Listener.extentTest.get().log(Status.WARNING,"<b><i>" + message(e.getMessage()) + "</i></b>" );
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
			Listener.extentTest.get().log(Status.WARNING, "<b><i>" + message(e.getMessage()) + "</i></b>" );
		}	catch(Exception e) {
			Listener.extentTest.get().log(Status.WARNING, "<b><i>" + message(e.getMessage()) + "</i></b>" );
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
					Listener.extentTest.get().log(Status.INFO,logText);
					try {
						Alert alert = driver.switchTo().alert();
						String alertMessage = alert.getText();
						Listener.extentTest.get().log(Status.INFO,"Alert is displayed with the message: "+alertMessage);
						alert.accept();
					} catch(NoAlertPresentException e) { 
						Listener.extentTest.get().log(Status.WARNING,"<b><i>" + message(e.getMessage()) + "</i></b>" );
				    }catch(Exception e) {
				    	Listener.extentTest.get().log(Status.WARNING,"<b><i>" + message(e.getMessage()) + "</i></b>");
					}
				}
			}
		} catch(Exception e) {
			Listener.extentTest.get().log(Status.WARNING,"<b><i>" + message(e.getMessage()) + "</i></b>");
		}
	}
	
	public String message(String message) {
		 String error = "<details><summary><b><font color=purple> Exception occured, click to see details: "
				+ FrameWorkConstants.ICON_WARNING + " </font></b>" + "</summary>" + message.replaceAll(",", "<br>")
				+ "</details> \n";
		 return error;
	}
}
