package javaScriptExe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSExecutorScrollClick {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		
		String url="https://www.amazon.in/";
		
		driver.get(url);
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		
		WebElement cartElement=driver.findElement(By.id("nav-cart"));
		executor.executeScript("arguments[0].setAttribute('style', 'background: none; border: 2px solid red;');", cartElement);
		executor.executeScript("arguments[0].click();", cartElement);
		
		

		
		
		
	}


}
