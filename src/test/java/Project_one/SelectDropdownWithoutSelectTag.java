package Project_one;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdownWithoutSelectTag {

	@Test
	public void SelectCalenderTest() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://192.168.134.252:5671/#/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("super.admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String sampletext=driver.findElement(By.xpath("//div[@class='reapop__container reapop__container--top-right']")).getText();
		

		//if(sampletext.contains("Successfully Logged In"))
		//if(sampletext.contains("Successfully Logged In\r\n"
		//		+ ""))
		if(sampletext.contains(""))
		{
			System.out.println("successful login");
		}
		else
		{
			System.out.println("login failed");
		}
		
		driver.findElement(By.xpath("//*[@class='MuiGrid-root draweMenu css-9qucjj']//*[text()='Basic Configuration']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@class='MuiGrid-root draweMenu css-9qucjj']//*[text()='Vehicle Registry']")).click();
		
		driver.close();
	}
}
