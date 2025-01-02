package alertsInSelenium;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlerts {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		String url="https://demo.guru99.com/test/delete_customer.php";
		
		driver.get(url);
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement cusID = driver.findElement(By.name("cusid"));
		
		cusID.sendKeys("Mayank");
		
		WebElement submit=driver.findElement(By.name("submit"));
		
		submit.click();
		Thread.sleep(2000);
		
		Alert alert= driver.switchTo().alert();
		System.out.println(alert.getText());

		alert.accept();
		Thread.sleep(2000);

		System.out.println(alert.getText());

		alert.dismiss();
		Thread.sleep(2000);

		
		driver.quit();
		
		
		
	}

}
