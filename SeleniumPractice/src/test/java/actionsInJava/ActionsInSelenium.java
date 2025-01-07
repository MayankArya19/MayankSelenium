package actionsInJava;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsInSelenium {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String url="https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop";
		driver.get(url);
		Actions actions = new Actions(driver);
		WebElement frame= wait.until(ExpectedConditions.elementToBeClickable(By.id("iframeResult")));
		driver.switchTo().frame(frame);
		WebElement drag = wait.until(ExpectedConditions.elementToBeClickable(By.id("drag1")));
		WebElement drop = wait.until(ExpectedConditions.elementToBeClickable(By.id("div1")));
		actions.dragAndDrop(drag, drop).build().perform();
		
		url="https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick";
		driver.get(url);
		driver.switchTo().frame(frame);
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ondblclick='myFunction()']")));
		actions.doubleClick(button).build().perform();
		

		
	}

}
