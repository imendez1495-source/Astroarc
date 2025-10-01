package www.Astroarc.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import www.Astroarc.pages.AstroarcPaymentPage;
import www.Astroarc.pages.AstroarcShopPage;

public class AstroarcPaymentTest {
	
	private WebDriver driver;
	
	AstroarcPaymentPage paymentPage;
	AstroarcShopPage shopPage;
	
	@BeforeClass
	public void BeforeMethod() throws Exception{
		paymentPage = new AstroarcPaymentPage(driver);
		driver = paymentPage.chromeDriverConnection();	
		paymentPage.visit("https://crypto.shift4.com/demo/space-shop");
	}
	
	@Test
	public void purhcaseWithCrypto() throws Exception{
		shopPage = new AstroarcShopPage(driver);
		shopPage.addToCartArticles();
		paymentPage.payWithCrypto();			
	}
	
	@AfterClass
	public void AfterMethod() throws Exception{
		//driver.quit();
	}	
}
