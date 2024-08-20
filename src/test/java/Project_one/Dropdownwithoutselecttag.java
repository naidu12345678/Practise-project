package Project_one;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdownwithoutselecttag {

	@Test
	
	public void selectdropdownwithouttag() {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://mis-qa.smartgms.in/#/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("ui_admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String sampletext=driver.findElement(By.xpath("//div[@class='reapop__container reapop__container--top-right']")).getText();
		if(sampletext.contains(""))
		{
			System.out.println("successful login");
		}
		else
		{
			System.out.println("login failed");
		}
		driver.findElement(By.xpath("//ul[@class='MuiList-root MuiList-padding css-18jb1kr']//*[text()='Admin']")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//ul[@class='MuiList-root MuiList-padding css-18jb1kr']//*[text()='User Register']")).click();
		driver.findElement(By.xpath("//div[@class='MuiBox-root css-d0uhtl']//button[@aria-label='Create']")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("msnn");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("qa");
		
		driver.findElement(By.xpath("//div[@id='genderId']")).click();
		
		driver.findElement(By.xpath("//*[text()='MALE']")).click();
		
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("msnn_qa");
		
		driver.findElement(By.xpath("//button[@aria-label='Check Availability']")).click();
		
		
		}
		
		
		
		
	}

