package multipleWindows;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handlers {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String url="https://demoqa.com/browser-windows";
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		//js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", cartElement);
		
		WebElement newTab=driver.findElement(By.id("tabButton"));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", newTab);
		Thread.sleep(1000);
		newTab.click();
		Thread.sleep(1000);
		String parentHandle = driver.getWindowHandle();
		
		System.out.println(parentHandle);
		
		Set<String> handles=driver.getWindowHandles();
		
		System.out.println(handles);
		
		for(String handle:handles) {
			System.out.println(handle);
			if(parentHandle.compareTo(handle)!=0) {
				Thread.sleep(2000);
				driver.switchTo().window(handle);
				driver.close();
			}
		}
		
		driver.switchTo().window(parentHandle);
		driver.close();
		
	}

}
