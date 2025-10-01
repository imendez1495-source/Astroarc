package www.Astroarc.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AstroarcShopPage extends AstroarcBase {
	
	By bootItem = By.xpath("//article/div/h2[text()='Astro Z1 Boot']/following-sibling::div/div");
	By cartButton = By.xpath("//div[normalize-space(.) = 'Cart']");
	By itemInCart = By.xpath("//div[contains(@class,'items-end')]//div[contains(@class,'text-white')]");
	By firstName = By.cssSelector("input[placeholder='First Name']");
	By lastName = By.cssSelector("input[placeholder='Last Name']");
	By email = By.cssSelector("input[placeholder='Email']");
	By payButton = By.xpath("//span[text() ='Pay With Crypto']");	

	public AstroarcShopPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void addToCartArticles() throws IOException {
		click(bootItem);
		click(cartButton);		
		assertEquals(itemInCart, "Astro Z1 Boot");
		sendKeys(firstName,"TestName");
		sendKeys(lastName,"TestLastName");
		sendKeys(email,"test@gmail.com");
		//For screenshots make sure to modify the method by including your path
		takeScreenShot();
		click(payButton);
		
	}
	
}
