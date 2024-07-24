package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import driver.DriverManager;
import listener.Listener;
import script.DMailDashboardPageScript;
import script.DMailLaunchPageScript;
import script.MetaMaskExtensionPageScript;
import testBase.Base;
@Listeners(Listener.class)
public class DMail  extends Base{
	
	public WebDriver getDriver() {
		return DriverManager.getDriver();
	}

	@Test(priority=0,groups={"MetaMaskExtension"})
	public void ImportWalletIntoMetaMask() {
		try {
			MetaMaskExtensionPageScript script = new MetaMaskExtensionPageScript(getDriver());
			script.ImportWalletIntoMetaMask();
		} catch(Exception e) {
			Assert.fail();
		}
	}
  
	@Test(priority =1,groups= {"DMail"})
	public void TC001_CancelAccountConnection() {
		try {
			DMailLaunchPageScript script = new DMailLaunchPageScript(getDriver());
			script.TC001_CancelAccountConnection();
		} catch(Exception e) {
			Assert.fail();
		}
	}
	
	@Test(priority=2,groups= {"DMail"})
	public void TC002_ConnectAccountSuccessfully() {
		try {
			DMailLaunchPageScript script = new DMailLaunchPageScript(getDriver());
			script.TC002_ConnectAccountSuccessfully();
		} catch(Exception e) {
			Assert.fail();
		}
	}
	
	@Test(priority=3,groups= {"DMail"})
	public void TC003_DMailDashboardPageUIValidation() {
		try {
			DMailDashboardPageScript script = new DMailDashboardPageScript(getDriver());
			script.TC003_DMailDashboardPageUIValidation();
		} catch(Exception e) {
			Assert.fail();
		}
	}
}
