package seleniumBasics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementName {
	
		public static void main(String[] args) throws InterruptedException {
			
			//Setup chrome driver
			WebDriverManager.chromedriver().setup();
			
			//Initialize driver
			WebDriver driver = new ChromeDriver();			
			//Launch Web Browser
			String url="https://www.google.co.in/";
			driver.get(url);
			
			//Maximize browser
			driver.manage().window().maximize();
			
			//Print page title
			System.out.println(driver.getTitle());
			
			//Wait for 2 seconds
			Thread.sleep(2000);
			
			//Locators
			//aria-label="Sign in"
			// //a[@aria-label='Sign in']
			WebElement inputBox = driver.findElement(By.xpath("//textarea[@name='q']"));
			//WebElement inputBox = driver.findElement(By.name("q"));
			inputBox.sendKeys("booking.com");
			inputBox.sendKeys(Keys.ENTER);

			Thread.sleep(2000);
			WebElement siteLink= driver.findElement(By.xpath("//h3[contains(text(),'Official site')]"));
			siteLink.click();
			Thread.sleep(2000);
			
//			WebElement search = driver.findElement(By.id(":rh:"));
//			search.sendKeys("Ambala");
//			Thread.sleep(2000);

			//formula for xpath //Tag[@attribute='value']
			
			//close browser
			driver.quit();
			
			
			
		}
}

	


