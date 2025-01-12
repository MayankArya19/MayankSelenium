package Robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotClass {
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String url="https://www.google.co.in/";
		driver.get(url);
		driver.manage().window().maximize();
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));

		Robot robot = new Robot();
		search.sendKeys("Selenium");
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		
	}

}
