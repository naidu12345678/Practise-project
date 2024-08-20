package Project_one;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderTest {
	@Test
	public void SelectCalenderTest() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://mis-qa.smartgms.in/#/login");
		// driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("ui_admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345678");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();

		driver.findElement(By.xpath("//span[normalize-space()='User Register']")).click();

		driver.findElement(By.xpath("//button[@aria-label='Create']")).click();

		driver.findElement(By.xpath("//div[18]//div[1]//div[1]//div[1]//div[1]//button[1]")).click();

		/// driver.findElement(By.xpath("//button[@title='Next month']")).click();
		//Approch 2
		
		String desired_month_year = "April 2025";
		String date = "25";

		// select month&year

		WebElement next_button = driver.findElement(By.xpath("//button[@title='Next month']"));
		
		while (true) {

			String current_month_year = driver.findElement(By.xpath(
					"//div[@class='MuiPickersFadeTransitionGroup-root css-1bx5ylf']//div[@class='MuiPickersCalendarHeader-label css-1v994a0']"))
					.getText();
			
			System.out.println(current_month_year);
			

			if (current_month_year.equals(desired_month_year)) 
			{

				break;
			} else
			{
				next_button.click();
			}

		}
			//select date
			
			List<WebElement> allDates=driver.findElements(By.xpath("//div[@class='MuiDayPicker-monthContainer css-i6bazn']//button[@class='MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin css-gnajhx']"));
			
			for(WebElement dt:allDates)
			{
				if(dt.getText().equals(date))
				{
					dt.click();
					break;
				}
			}
			
			
		
			
			
	}
}
			
			// select year
			/*
			 * driver.findElement(By.
			 * xpath("//button[@aria-label='calendar view is open, switch to year view']")).
			 * click(); List<WebElement> options=driver.findElements(By.
			 * xpath("//div[@class='MuiYearPicker-root css-f09ynp']//div[@class='PrivatePickersYear-root PrivatePickersYear-modeDesktop css-j9zntq']"
			 * )); System.out.println("Total number of options:"+options.size()); //print
			 * all the options from dropdown
			 * 
			 * //using normal for loop /*for(int i=0;i<options.size();i++) {
			 * System.out.println(options.get(i).getText()); }
			 */

			/*
			 * for(WebElement option:options) { String text=option.getText();
			 * if(text.equals("2005")) { option.click(); } }
			 * 
			 */

			// select month & year
			/*
			 * while(true) { String
			 * mon=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).
			 * getText(); String
			 * yr=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).
			 * getText();
			 * 
			 * if(mon.equals(month) && yr.equals(year)) { break; }
			 * 
			 * //driver.findElement(By.
			 * xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //
			 * Future date //driver.findElement(By.
			 * xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //Past
			 * date
			 * 
			 * 
			 * }
			 */

		

	

