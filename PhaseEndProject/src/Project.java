import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Project {

	public static void main(String[] args) {
ChromeDriver driver=new ChromeDriver();
        
		//2) Maximize it
		driver.manage().window().maximize();
        
		//3)Navigate To 
		driver.get("https://www.amazon.in/");
        
		//4) Click on 'Mobiles' in the navigator bar
		driver.findElement(By.linkText("Mobiles")).click();
        
		//5) Hover the pointer over 'Mobiles & Accessories'
		WebElement mobiles= driver.findElement(By.cssSelector("#nav-subnav > a:nth-child(2) > span.nav-a-content"));
		Actions actions =new Actions(driver);
		actions.moveToElement(mobiles).build().perform();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apple")));
        
		//6) Click 'Apple' in the Sub-menu
		driver.findElement(By.linkText("Apple")).click();
       
		//7) Click on First available phone
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div[2]/span/a/div/img")).click();
		
		ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        
		//8) Switch to focus on new tab
		driver.switchTo().window(tabs.get(1));
		
		//9) Click on 'Buy Now ' button
		driver.findElement(By.id("buy-now-button")).click();
        
	    //10)verify user sees the text "Sign in' on the last page
		WebElement signInElement=driver.findElement(By.id("ap_email"));
		if(signInElement.isDisplayed())
		{
			System.out.println("user not signed");
		}
		else
		{
			System.out.println("user is signed");
		}
		
		//11) Close the window
		driver.quit();


	}

}
