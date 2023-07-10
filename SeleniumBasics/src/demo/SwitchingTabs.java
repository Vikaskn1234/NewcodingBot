package demo;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchingTabs {

	public static void main(String[] args) {
		//1) Open the browser
		ChromeDriver driver=new ChromeDriver();
		
		//2) Maximize it
		driver.manage().window().maximize();
		
		//3)Navigate to application
		driver.get("https://www.facebook.com/");
				
		//4) Click on 'Instagram'
		driver.findElement(By.linkText("Instagram")).click();
		
		ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		
		driver.findElement(By.name("username")).sendKeys("abc@gmail.com");

	}

}
