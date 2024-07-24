package script;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import constants.FrameWorkConstants;
import listener.Listener;
import module.MetaMaskPageModule;

public class MetaMaskExtensionPageScript {
	
	WebDriver driver;
	public MetaMaskPageModule module;
	
	public MetaMaskExtensionPageScript(WebDriver driver) {
		this.driver = driver;
		module = new MetaMaskPageModule(driver);
	}
	
	public void ImportWalletIntoMetaMask() {
		try {
			module.switchMetaMaskExtensionPage();
			module.termsCheckBox();
			module.importExistingWallet();
			module.privacyPolicy();
			module.agreePrivacyPolicy();
			module.enterAccountRecoveryPhrases();
			module.confirmPhrase();
			module.passwordSetup();
			module.agreePasswordTerms();
			module.confirmWalletImport();
			module.gotItButton();
			module.nextButton();
			module.doneButton();
			module.enableConfiguration();
			module.openAccountMenu();
			module.openAccountSettings();
			module.openNetworkSettings();
			module.addNetwork();
			module.addNetworkManually();
			module.addNetworkData();
			module.saveButton();
			module.switchNetwork();
		} catch (Exception e) {
			Assert.fail();
			Listener.extentTest.get().fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>");
		}
	}
	
}
