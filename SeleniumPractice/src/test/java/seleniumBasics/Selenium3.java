package seleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium3 {
	public static void main(String[] args) throws InterruptedException {
		
		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
		
		//Initialize driver
		WebDriver driver = new ChromeDriver();
		
		//Launch Web Browser
		String url="https://www.booking.com/";
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
		WebElement signIn = driver.findElement(By.xpath("//a[@aria-label='Sign in']"));
		signIn.click();
		Thread.sleep(2000);
		
		//formula for xpath //Tag[@attribute='value']
		
		//close browser
		driver.close();
		
		
		
	}

}
