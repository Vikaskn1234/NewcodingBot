package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	public static void main(String[] args) {
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://whitecircleschool.com/explicit-wait-demo1/");
		driver.findElement(By.id("start")).click();
		String expectedText="Hello World!";
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
		driver.quit();
	}

}
