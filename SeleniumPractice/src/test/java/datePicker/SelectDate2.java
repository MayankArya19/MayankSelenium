package datePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDate2 {

	public static void main(String[] args) throws InterruptedException {
		int i,j = 0;
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String url = "https://makemytrip.com/";
		String month = "March";
		String date="31";
		String xpathForDate="//div[@class='DayPicker-Month']//div[@class='DayPicker-Caption']//div[contains(text(),'"+month+"')]/parent::div/following-sibling::div[2]//p[text()='"+date+"']";

		driver.get(url);
		WebElement cross = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-cy='closeModal']")));
		cross.click();
		WebElement departure = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='departure']")));


		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", departure);
		departure.click();

		WebElement nextMonth = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-label='Next Month']")));

		List<WebElement> Totalmonths = driver.findElements(By.xpath("//div[@role='heading']"));
		System.out.println(Totalmonths);
		i=MonthName(Totalmonths.get(1).getText());
		System.out.println(i);
		j=MonthName(month + " 2025");
		System.out.println(j);
		
		int numberOfClicks=j-i;
		for(int k=0;k<numberOfClicks;k++) {
			nextMonth.click();
		}

		WebElement dates = driver.findElement(By.xpath(xpathForDate));
		dates.click();
		Thread.sleep(Duration.ofSeconds(4));
		driver.quit();

	}
	public static int MonthName(String a) {
		int i=0;
		switch(a) {
		case "January 2025":
			i=1;
			break;
		case "February 2025":
			i=2;
			break;
		case "March 2025":
			i=3;
			break;

		case "April 2025":
			i=4;
			break;

		case "May 2025":
			i=5;
			break;

		case "June 2025":
			i=6;
			break;

		case "July 2025":
			i=7;
			break;

		case "August 2025":
			i=8;
			break;

		case "September 2025":
			i=9;
			break;

		case "October 2025":
			i=10;
			break;

		case "November 2025":
			i=11;
			break;

		case "December 2025":
			i=12;
			break;

		}
		return i;
	}

}
