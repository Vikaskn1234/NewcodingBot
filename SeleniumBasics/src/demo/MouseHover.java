package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHover {

	public static void main(String[] args) {
		//1) Open the browser
		ChromeDriver driver=new ChromeDriver();
		
		//2) Maximize it
		driver.manage().window().maximize();
		
		//3) Navigate  to application
		driver.get("http://ebay.com");
		
		//4) Hover the pointer over 'Motors'
		
		WebElement motors= driver.findElement(By.linkText("Motors"));
		
		Actions actions =new Actions(driver);
		actions.moveToElement(motors).build().perform();
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Engines and parts")));
		
		
		//5) click on 'Engines and parts' in the sub menu
		driver.findElement(By.linkText("Engines and parts")).click();
		
		

	}

}
