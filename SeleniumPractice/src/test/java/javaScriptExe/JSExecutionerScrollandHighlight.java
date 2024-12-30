package javaScriptExe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.Execution;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JSExecutionerScrollandHighlight {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		
		String url="https://www.amazon.in/";
		
		driver.get(url);
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		
		WebElement cartElement=driver.findElement(By.id("nav-cart"));
		executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", cartElement);
		WebElement socialConnectText=driver.findElement(By.xpath("//div[text()='Connect with Us']"));
		executor.executeScript("arguments[0].scrollIntoView({ behavior: 'auto', block: 'center' });", socialConnectText);

		Thread.sleep(2000);
		executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", socialConnectText);

		
		
		
	}

}
