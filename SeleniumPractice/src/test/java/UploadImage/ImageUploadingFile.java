package UploadImage;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageUploadingFile {
	
	public static void main(String[] args) {

			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			String url="https://demoqa.com/automation-practice-form/";
			driver.get(url);
			WebElement fileUpload = wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadPicture")));
			fileUpload.sendKeys("C:\\Users\\Mayank\\Desktop\\WhatsApp Image 2024-12-31 at 21.38.57_d4f71b11.jpg");
			
			
			
	}

}
