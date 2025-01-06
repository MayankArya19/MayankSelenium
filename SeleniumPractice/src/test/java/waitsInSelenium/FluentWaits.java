package waitsInSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaits {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
				
				WebDriver driver=new ChromeDriver();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				
				driver.manage().window().maximize();
				Wait<WebDriver> wait = new FluentWait<>(driver).
						withTimeout(Duration.ofSeconds(30)).
						pollingEvery(Duration.ofSeconds(5)).
						ignoring(NoSuchElementException.class);
				String url="https://www.booking.com/";
				driver.get(url);
				WebElement popUp=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[starts-with(@aria-label,'Dismiss')]")));
				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", popUp);
				popUp.click();
				
				WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register")));
				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", register);

				register.click();
				driver.close();
			}

}
