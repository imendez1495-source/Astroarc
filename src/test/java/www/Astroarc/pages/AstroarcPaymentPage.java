package www.Astroarc.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AstroarcPaymentPage extends AstroarcBase {

	By moreOptions = By.xpath("//*[@id=\"wrapper\"]/div[2]/button[1]");
	By tableToScroll = By.xpath("//ul[@id=':r4:-listbox']");	
	By exchangesButton = By.xpath("//button[text()='Exchanges']");
	By allButton = By.xpath("//button[text()='All']");
	By continuePaymentButton = By.xpath("//button[contains(@class,'6k04')]");
	By bluePayButton = By.xpath("//button[contains(@class,'1myj1q3')]");
	//wallets		
	By walletMetamaskOption = By.xpath("//div[text()='Metamask']");
		
	//iframe view
	By iframe = By.xpath("//iframe[contains(@id,'mesh')]");
	By PayWithCrypto = By.xpath("//h1[contains(@class, 'h4-m')]");
	By iframeButton = By.xpath("//button[text()='Continue to Coinbase']");
	By ifrmeCloseButton = By.xpath("//button[@data-testid='close-button']");
	By iframYesExitButton = By.xpath("//button[text()='Yes, exit']");
	
	By iframetext = By.xpath("//h1[text()='Pay in your wallet']");
	By iframeExitAlert = By.xpath("//div[contains(@class,'flex')]/h1[contains(@class,'h4')]");
	By iframeCoinBasetext = By.xpath("//div[contains(@class, 'block')]/img/following::h1");
	
	public AstroarcPaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void payWithCrypto() throws InterruptedException, IOException {
		windowHandleTochild();		
		explicitWait(moreOptions);		
		click(moreOptions);	
		explicitWait(tableToScroll);
		takeScreenShot();
		scrollAction(tableToScroll);
		//Make sure to modify the method takeScreenShot() by including your file path  
		takeScreenShot();
		click(exchangesButton);
		//Make sure to modify the method takeScreenShot() by including your file path  
		takeScreenShot();
		click(allButton);		
		click(walletMetamaskOption);			
		switchToIframe(iframe);
		explicitWait(iframetext);	
		assertEquals(iframetext, "Pay in your wallet");		
		click(ifrmeCloseButton);
		explicitWait(iframeExitAlert);
		assertEquals(iframeExitAlert, "Are you sure you want to exit?");
		setImplicitWait(4);
		//Make sure to modify the method takeScreenShot() by including your file path  
		takeScreenShot();
		click(iframYesExitButton);
		switchToDefaultContent();  		
		explicitWait(continuePaymentButton);
		takeScreenShot();
		click(continuePaymentButton);
		click(bluePayButton);	
		switchToIframe(iframe);
		explicitWait(iframeCoinBasetext);
		assertEquals(iframeCoinBasetext, "Log in to your account");
		setImplicitWait(6);
		//Make sure to modify the method takeScreenShot() by including your file path  
		takeScreenShot();		
	}
}
