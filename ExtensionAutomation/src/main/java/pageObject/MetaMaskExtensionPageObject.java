package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetaMaskExtensionPageObject {
	WebDriver driver;
	
	public MetaMaskExtensionPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public final By TermsOfUse = By.id("onboarding__terms-checkbox");
	public final By ImportWallet = By.xpath("//div//button[@class='button btn--rounded btn-secondary']"); 
	public final By PrivacyPolicy = By.id("metametrics-opt-in");
	public final By AgreeButton = By.xpath("//div//button[@data-testid='metametrics-i-agree']");
	public final By Phrase1 = By.id("import-srp__srp-word-0");
	public final By Phrase2 = By.id("import-srp__srp-word-1");
	public final By Phrase3 = By.id("import-srp__srp-word-2");
	public final By Phrase4 = By.id("import-srp__srp-word-3");
	public final By Phrase5 = By.id("import-srp__srp-word-4");
	public final By Phrase6 = By.id("import-srp__srp-word-5");
	public final By Phrase7 = By.id("import-srp__srp-word-6");
	public final By Phrase8 = By.id("import-srp__srp-word-7");
	public final By Phrase9 = By.id("import-srp__srp-word-8");
	public final By Phrase10 = By.id("import-srp__srp-word-9");
	public final By Phrase11 = By.id("import-srp__srp-word-10");
	public final By Phrase12 = By.id("import-srp__srp-word-11");
	public final By ConfirmPhrase = By.xpath("//*[contains(text(),'Confirm Secret Recovery Phrase')]");
	public final By NewPassword = By.xpath("//input[@data-testid='create-password-new']");
	public final By ConfirmNewPassword = By.xpath("//input[@data-testid='create-password-confirm']");
	public final By AgreePasswordTerms = By.xpath("//input[@data-testid='create-password-terms']");
	public final By ConfirmWalletImport = By.xpath("//*[contains(text(),'Import my wallet')]");
	public final By GotItButton = By.xpath("//button[@class='button btn--rounded btn-primary btn--large']");
	public final By NextButton = By.xpath("//button[@data-testid='pin-extension-next']");
	public final By DoneButton = By.xpath("//*[contains(text(),'Done')]");
	public final By EnableConfigurationButton = By.xpath("//*[contains(text(),'Enable')]");
	public final By AccountMenu = By.xpath("//button[@data-testid='account-options-menu-button']");
	public final By Settings = By.xpath("//button[@data-testid='global-menu-settings']");
	public final By Network = By.xpath("//*[contains(text(),'Networks')]");
	public final By AddNetwork = By.xpath("//*[contains(text(),'Add a network')]");
	public final By AddNetworkManually = By.xpath("//*[contains(text(),'Add a network manually')]");
	public final By NetWorkName = By.xpath("//input[@data-testid='network-form-network-name']");
	public final By RPCURL = By.xpath("//input[@data-testid='network-form-rpc-url']");
	public final By ChainID = By.xpath("//input[@data-testid='network-form-chain-id']");
	public final By Currency = By.xpath("//input[@data-testid='network-form-ticker-input']");
	public final By BlockURL = By.xpath("//input[@data-testid='network-form-block-explorer-url']");
	public final By SaveButton = By.xpath("//*[contains(text(),'Save')]");
	public final By SwitchButton = By.xpath("//button[@class='button btn--rounded btn-primary home__new-network-added__switch-to-button']");
	
}
