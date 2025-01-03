package multipleWindows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindow {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String url="https://demoqa.com/browser-windows";
		driver.manage().window().maximize();
		
		driver.get(url);
		

		
		Thread.sleep(2000);
		//js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", cartElement);
		
		WebElement newTab=driver.findElement(By.id("tabButton"));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", newTab);
		WebElement newWindow=driver.findElement(By.id("windowButton"));
		WebElement newWindowMessage=driver.findElement(By.id("messageWindowButton"));
		Thread.sleep(1000);
		newTab.click();
		Thread.sleep(1000);
		String parentHandle = driver.getWindowHandle();
		
		System.out.println("1st site starts");
		
		Set<String> handles=driver.getWindowHandles();
		
		
		for(String handle:handles) {
			System.out.println(handle);
			if(parentHandle.compareTo(handle)!=0) {
				Thread.sleep(2000);
				System.out.println("Child 1 handle " + handle);

				driver.switchTo().window(handle);
				driver.close();
			}
		}
		
		driver.switchTo().window(parentHandle);
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'auto', block: 'center' });", newWindow);

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", newWindow);
		Thread.sleep(1000);
		newWindow.click();
		Thread.sleep(3000);
		System.out.println("2nd site starts");

		handles=driver.getWindowHandles();
		for(String handle:handles) {
			System.out.println(handle);
			if(parentHandle.compareTo(handle)!=0) {
				Thread.sleep(2000);
				System.out.println("Child 2 handle " + handle);

				driver.switchTo().window(handle);
				System.out.println(driver.getCurrentUrl());
				driver.close();
			}
		}
		Thread.sleep(2000);
		driver.switchTo().window(parentHandle);
		
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'auto', block: 'center' });", newWindowMessage);

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", newWindowMessage);
		Thread.sleep(1000);
		newWindowMessage.click();
		Thread.sleep(5000);
		handles=driver.getWindowHandles();
		System.out.println(handles);

		System.out.println("3rd site");

		for(String handle:handles) {
			System.out.println(handle);
			if(parentHandle.compareTo(handle)!=0) {
				Thread.sleep(2000);
				System.out.println("Child 3 handle " + handle);

				driver.switchTo().window(handle);
				System.out.println(driver.getCurrentUrl());

				driver.manage().window().maximize();
				driver.close();
			}
		}
		Thread.sleep(2000);
		driver.switchTo().window(parentHandle);

		
		driver.close();
		
	
	}

}
