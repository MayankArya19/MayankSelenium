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

public class SelectDate {

	public static void main(String[] args) {
		int i,j = 0;
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String url = "https://makemytrip.com/";
		String month = "January 31";
		String date="31";
		String xpathForDate="//div[@class='DayPicker-Month']//*[text()="+"'"+date+"']";
		//String xpathForDate="//div[@class='DayPicker-Month' and div[@class='DayPicker-Caption' and text()='January']]//div[@class='DayPicker-Day' and text()='31']";

		driver.get(url);
		WebElement cross = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-cy='closeModal']")));
		cross.click();
		WebElement departure = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='departure']")));
		//// span[@data-cy='closeModal']

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", departure);
		departure.click();

		WebElement nextMonth = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-label='Next Month']")));
		// nextMonth.click();
		// WebElement prevMonth =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-label='Previous
		// Month']")));
		List<WebElement> Totalmonths = driver.findElements(By.xpath("//div[@role='heading']"));
		i=MonthName(Totalmonths.get(1).getText());
		j=MonthName(month + " 2025");
		int numberOfClicks=j-i;
		for(int k=0;k<numberOfClicks;k++) {
			nextMonth.click();
		}
		List<WebElement> months = driver.findElements(By.xpath("//div[@role='heading']"));
		List<WebElement> dates = driver.findElements(By.xpath(xpathForDate));
		i=MonthName(months.get(0).getText());
		if(j-i==0) {
			dates.get(0).click();
		}
		else {
			if(dates.size()>1) {
			dates.get(1).click();
			}
			else {
				dates.get(0).click();

			}
		}


		//WebElement dates = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label='Wed Mar 05 2025']")));
		
		
		// WebElement planeDate=driver.findElement(By.id);
//		for (WebElement ele : months) {
//
//			System.out.println(ele.getText());
//			if (ele.getText().startsWith(month)) {
//				System.out.println("Month Found");
//				
//
//			} else {
//				flag++;
//				if (flag == 2) {
//					nextMonth.click();
//					months.add(driver.findElement(By.xpath("//div[@role='heading'][1]")));
//					System.out.println("Date Found");
//
//					flag = 0;
//				}
//
//			}
//			
//
//		}

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
