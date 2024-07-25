package module;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import action.Action;
import constants.FrameWorkConstants;
import enums.WaitStrategy;
import pageObject.MetaMaskExtensionPageObject;
import report.ExtentLogger;
import utility.ConfigReaders;
import utility.ExcelUtility;
import utility.JSONReader;
import utility.ResourceUtility;


public class MetaMaskPageModule {

	WebDriver driver;
	public MetaMaskExtensionPageObject element;
	public Action reuse;
	public JSONReader data;
	
	public MetaMaskPageModule (WebDriver driver) {
		this.driver = driver;
		this.element = new MetaMaskExtensionPageObject(driver);
		this.reuse = new Action(driver);
		this.data = new JSONReader();
	}
	
	private String sheetpath = ResourceUtility.getFolderPath();
	private String sheetName = ConfigReaders.getProperty("metamaskSheetName");
	
	@SuppressWarnings("unchecked")
	public Map<String,String> getdata(String testCaseName) throws Exception{
		return new ExcelUtility().getdata(testCaseName,sheetpath, sheetName);
	}
	
	
	public void switchMetaMaskExtensionPage() {
		try {
			reuse.switchWindow(driver,"MetaMask");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	
	public void termsCheckBox() {
		try{
			reuse.checkBox(element.TermsOfUse,WaitStrategy.CLICKABLE,"Terms of Use CheckBox");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void importExistingWallet() {
		try {
			reuse.clickButton(element.ImportWallet,WaitStrategy.CLICKABLE,"Import Wallet Button");
		}catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void privacyPolicy() {
		try {
			reuse.checkBox(element.PrivacyPolicy,WaitStrategy.CLICKABLE,"Privacy Policy CheckBox");
		} catch(Exception e) {
			Assert.fail();
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
		}
	}
	
	public void agreePrivacyPolicy() {
		try {
			reuse.clickButton(element.AgreeButton,WaitStrategy.CLICKABLE,"Agree Privacy Policy Button");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void enterAccountRecoveryPhrases() {
		try {
			reuse.entertext(element.Phrase1,data.getValue("hint1"),WaitStrategy.CLICKABLE,"Recovery Phrase 1");
			reuse.entertext(element.Phrase2, data.getValue("hint2"),WaitStrategy.CLICKABLE,"Recovery Phrase 2");
			reuse.entertext(element.Phrase3,data.getValue("hint3"),WaitStrategy.CLICKABLE,"Recovery Phrase 3");
			reuse.entertext(element.Phrase4,data.getValue("hint4"),WaitStrategy.CLICKABLE,"Recovery Phrase 4");
			reuse.entertext(element.Phrase5,data.getValue("hint5"),WaitStrategy.CLICKABLE,"Recovery Phrase 5");
			reuse.entertext(element.Phrase6,data.getValue("hint6"),WaitStrategy.CLICKABLE,"Recovery Phrase 6");
			reuse.entertext(element.Phrase7,data.getValue("hint7"),WaitStrategy.CLICKABLE,"Recovery Phrase 7");
			reuse.entertext(element.Phrase8,data.getValue("hint8"),WaitStrategy.CLICKABLE,"Recovery Phrase 8");
			reuse.entertext(element.Phrase9,data.getValue("hint9"),WaitStrategy.CLICKABLE,"Recovery Phrase 9");
			reuse.entertext(element.Phrase10,data.getValue("hint10"),WaitStrategy.CLICKABLE,"Recovery Phrase 10");
			reuse.entertext(element.Phrase11,data.getValue("hint11"),WaitStrategy.CLICKABLE,"Recovery Phrase 11");
			reuse.entertext(element.Phrase12,data.getValue("hint12"),WaitStrategy.CLICKABLE,"Recovery Phrase 12");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void confirmPhrase() {
		try {
			reuse.clickButton(element.ConfirmPhrase,WaitStrategy.CLICKABLE,"Confirm Phrase Button");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void passwordSetup() {
		try {
			reuse.entertext(element.NewPassword,data.getValue("password"),WaitStrategy.CLICKABLE,"New Password");
			reuse.entertext(element.ConfirmNewPassword,data.getValue("confirmPassword"),WaitStrategy.CLICKABLE,"Confirm New Password");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void agreePasswordTerms() {
		try {
			reuse.checkBox(element.AgreePasswordTerms,WaitStrategy.CLICKABLE,"Agree Password Terms Checkbox");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void confirmWalletImport() {
		try {
			reuse.clickButton(element.ConfirmWalletImport,WaitStrategy.CLICKABLE,"Confirm Wallet Import Button");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void gotItButton() {
		try {
			reuse.clickButton(element.GotItButton,WaitStrategy.CLICKABLE,"Got It Button");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void nextButton() {
		try {
			reuse.clickButton(element.NextButton,WaitStrategy.CLICKABLE,"Next Button");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void doneButton() {
		try {
			reuse.clickButton(element.DoneButton,WaitStrategy.CLICKABLE,"Done Button");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void enableConfiguration() {
		try {
			reuse.clickButton(element.EnableConfigurationButton,WaitStrategy.CLICKABLE,"Enable Configuration Button");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void openAccountMenu() {
		try {
			reuse.clickButton(element.AccountMenu,WaitStrategy.CLICKABLE,"Account Menu");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void openAccountSettings() {
		try {
			reuse.clickButton(element.Settings,WaitStrategy.CLICKABLE,"Settings");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void openNetworkSettings() {
		try {
			reuse.clickButton(element.Network,WaitStrategy.CLICKABLE,"Network Settings");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void addNetwork() {
		try {
			reuse.clickButton(element.AddNetwork,WaitStrategy.CLICKABLE,"Add Network");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void addNetworkManually() {
		try {
			reuse.clickButton(element.AddNetworkManually,WaitStrategy.CLICKABLE,"Add Network Manually");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	
	public void addNetworkData() {
		try {
			reuse.entertext(element.NetWorkName,data.getValue("networkName"),WaitStrategy.CLICKABLE,"Network Name");
			reuse.entertext(element.RPCURL,data.getValue("rpcURL"),WaitStrategy.CLICKABLE,"RPC URL");
			reuse.entertext(element.ChainID,data.getValue("chainId"),WaitStrategy.CLICKABLE,"Chain ID");
			reuse.entertext(element.Currency,data.getValue("currency"),WaitStrategy.CLICKABLE,"Currency");
			reuse.entertext(element.BlockURL,data.getValue("blockURL"),WaitStrategy.CLICKABLE,"Block URL");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void saveButton() {
		try {
			reuse.clickButton(element.SaveButton,WaitStrategy.CLICKABLE,"Save Button");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
	
	public void switchNetwork() {
		try {
			reuse.clickButton(element.SwitchButton,WaitStrategy.CLICKABLE,"Switch Network");
		} catch(Exception e) {
			ExtentLogger.fail(FrameWorkConstants.ICON_BUG + "  " + "<b><i>" + e.getSuppressed().toString() + "</i></b>",true);
			Assert.fail();
		}
	}
}