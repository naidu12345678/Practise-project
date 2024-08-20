package Project_one;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class paginationTable {
	@Test
	public void pagenationTest() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://mis-qa.smartgms.in/#/login");
		//driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("ui_admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345678");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();

		driver.findElement(By.xpath("//span[normalize-space()='User Register']")).click();
	//	List<WebElement> allPages=driver.findElements(By.xpath("//*[contains(@class,'css-1od8na7')]/nav/ul/li"));
		//System.out.println("Total Pages:"+ allPages.size());
	//	WebElement currentpage=driver.findElement(By.xpath("//button[@aria-label='page 1']"));
		WebElement go_to_nextpage=driver.findElement(By.xpath("//button[@aria-label='Go to next page']"));
	//	WebElement go_to_previouspage=driver.findElement(By.xpath("//button[@aria-label='Go to previous page']"));
		
		//capture all webElements into list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[4]"));
		
		// capture text of all webelements into new(original) list

		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		
		//System.out.println(originalList);
		
		
	List<Object> username;
	do {
		List<WebElement>rows=driver.findElements(By.xpath("//tr/td[4]"));
		username=rows.stream().filter(s->s.getText().contains("sanuser_wd")).map(s->getUserName(s)).collect(Collectors.toList());
		username.forEach(a -> System.out.println(a));
			if(username.size()<1)
			{

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Go to next page']"))).click();
				//go_to_nextpage.click();

			}

			}while(username.size()<1);
		  }

	private static String getUserName(WebElement s) {

		// TODO Auto-generated method stub

		//String usernamevalue = s.findElement(By.xpath("following-sibling::td[4]")).getText();
		
		String usernamevalue = s.findElement(By.xpath("//tr[2]/td[1]")).getText();
		return usernamevalue;
	}

	
	
	
}



