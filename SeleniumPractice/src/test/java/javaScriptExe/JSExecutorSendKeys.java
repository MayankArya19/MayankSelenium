package javaScriptExe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSExecutorSendKeys {
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		
		String url="https://www.amazon.in/";
		
		driver.get(url);
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		
		WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		executor.executeScript("arguments[0].setAttribute('style', 'background: none; border: 2px solid red;');", search);
		executor.executeScript("arguments[0].value='abc';", search);
		
		

		
		
		
	}

}