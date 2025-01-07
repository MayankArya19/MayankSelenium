package waitsInSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaits {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		String url="https://www.booking.com/";
		driver.get(url);
		
		WebElement popUp = driver.findElement(By.xpath("//button[starts-with(@aria-label,'Dismiss')]"));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", popUp);
		popUp.click();
		driver.close();
		
	}

}
