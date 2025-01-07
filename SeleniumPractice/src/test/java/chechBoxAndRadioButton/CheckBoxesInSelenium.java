package chechBoxAndRadioButton;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxesInSelenium {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String url="https://demoqa.com/automation-practice-form/";
		
		driver.get(url);
		//WebElement hobbies=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[text()='Sports']/preceding-sibling::input"))));
		System.out.println("Element finding");
		WebElement hobbies=driver.findElement(By.xpath("//label[text()='Sports']/preceding-sibling::input"));
		System.out.println("Element found");
		//WebElement name=driver.findElement(By.id("firstName"));
		//WebElement name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		System.out.println("before scroll");
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", hobbies);
		System.out.println("after scroll");
		System.out.println("before highlight");

		js.executeScript("arguments[0].scrollIntoView({ behavior: 'auto', block: 'center' });", hobbies);
		System.out.println("after highlight");


		//name.sendKeys("Mayank");
		System.out.println("before click");
		hobbies.click();
		System.out.println("after click");

		
	}

}
