package www.Astroarc.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

public class AstroarcBase {
	
	protected WebDriver driver;
	
	public AstroarcBase(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver chromeDriverConnection() {		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/webDrivers/chromedriver.exe" );
		driver = new ChromeDriver();
		return driver;
	}
	
	public void visit(String url) {
		driver.manage().window().maximize();
		driver.get(url);		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}	
	
	public void sendKeysAndEnter(String inputText , By locator) {
		driver.findElement(locator).sendKeys(inputText + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void sendKeys(By locator, String inputText) {
		driver.findElement(locator).sendKeys(inputText);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public Boolean explicitWait(By locator) {
		try {WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void setImplicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	public void lisOfElements(By listLocator, String optionFromList) {
		
		List<WebElement> options = driver.findElements(listLocator);
		WebElement wallet = driver.findElement(By.xpath("//div[text()='" + optionFromList + "']/img"));
		// 4. Loop and click the one with desired text
		for (WebElement option : options) {
			
			if (option.getText().equals(wallet)) {   // your target text
		        option.click();
		        break;
		    }
		}		
	}
	
	public String assertEquals(By actualText, String expectedText) {
		
		try {
	        String actual = driver.findElement(actualText).getText();
	        Assert.assertEquals(actual, expectedText, "Text does not match!");
	        System.out.println(actual + " is displayed");
	        return actual;
	    } catch (NoSuchElementException e) {
	        Assert.fail("Element not found: " + actualText, e);
	        return null; // won’t actually reach here if fail is triggered
	    } catch (AssertionError ae) {
	        // Optional: log the failure, then rethrow to mark test failed
	        System.err.println("Assertion failed: " + ae.getMessage());
	        throw ae;
	    }		
	}
	
	public void switchToIframe(By iframeLocator){
		WebElement iframe = driver.findElement(iframeLocator);
		driver.switchTo().frame(iframe);
	}
	
	public void switchToDefaultContent(){
		driver.switchTo().defaultContent();  // back to the top-level page
	}
	
	public void takeScreenShot() throws IOException {
		Random rand = new Random();
		int randomNum = rand.nextInt(300);
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f,new File("C:\\Users\\ferme\\Desktop\\Screenshots\\AstroArcTestScreenShot" + randomNum + ".png"));
	}
		
	public void windowHandleTochild() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    // Saving current window
	    String parentId = driver.getWindowHandle();
	    // Trigger the action that opens the new window BEFORE capturing handles
	 
	    // Wait until there are 2 windows
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2));

	    // Switch to the new window
	    for (String handle : driver.getWindowHandles()) {
	        if (!handle.equals(parentId)) {
	            driver.switchTo().window(handle);
	            break;
	        }
	    }
	}
	
	public void scrollAction(By locator) {
		WebElement listBox = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll to bottom
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", listBox);
	}	

}
