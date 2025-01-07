package dropDownListsInSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectDropDowns {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String url="https://demo.guru99.com/test/newtours/register.php";
		driver.get(url);
		WebElement country = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("country")));
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'auto', block: 'center' });", country);
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", country);
		Select select = new Select(country);
		select.selectByVisibleText("INDIA");
	}

}
