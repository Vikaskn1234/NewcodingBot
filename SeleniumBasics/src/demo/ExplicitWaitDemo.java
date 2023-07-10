package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	public static void main(String[] args) {
		// 1) open the browser 
		ChromeDriver driver =new ChromeDriver();
		
		//2) Maximize it
		driver.manage().window().maximize();
		
		// 3) Navigate to application
		driver.get("https://whitecircleschool.com/explicit-wait-demo1/");
		
		// 4) click on 'start ' button
		driver.findElement(By.id("start")).click();
		
		//5) verify the text "hello world !" appears on the web-page
		String expectedText="Hello World!";
		
		//6) wait for the text to appear
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish > h4")));
		String actualText=driver.findElement(By.cssSelector("#finish > h4")).getText();
		
		System.out.println(expectedText);
		System.out.println(actualText);
		if(actualText.equals(expectedText))
		{
			System.out.println("test case passed");
		}
		else
		{
			System.out.println("Test case failed");
		}
		
		//7) close the browser
		driver.quit();
	}

}
