package assertsInSelenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertsSelenium {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		String url="https://www.flipkart.com/";
		
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		WebElement loginButton=driver.findElement(By.xpath("//a/span[text()='Login']"));
		js.executeScript("arguments[0].setAttribute('style', 'background: none; border: 2px solid red;');", loginButton);
		String loginText=loginButton.getText();
		System.out.println(loginButton.getText());
		
		Assert.assertEquals("sdmhgfjwefb",loginText, "Login");
		Assert.assertNotEquals("sdjhfgsd",loginText, "Login");
		
		driver.quit();
		
	}

}
