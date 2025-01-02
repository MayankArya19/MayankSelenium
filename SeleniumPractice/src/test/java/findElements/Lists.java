package findElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lists {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		String url = "https://www.booking.com/";

		driver.get(url);

		driver.manage().window().maximize();
		Thread.sleep(5000);
		try {
		WebElement cross=driver.findElement(By.xpath("//button[starts-with(@aria-label,'Dismiss')]"));
		executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", cross);
		Thread.sleep(1000);
		cross.click();
		}
		catch(NoSuchElementException ex) {
			System.out.println("No popup");
		}
		finally {
			Thread.sleep(1000);
	}
		
		List<WebElement> list =driver.findElements(By.tagName("a"));
		
		System.out.println(list.size());
		for(WebElement ele : list) {
			System.out.println(ele.getDomAttribute("href"));
		}
		Thread.sleep(1000);
		driver.quit();
		
		
		


}
}
