package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {

	public static void main(String[] args) {
		
		//1) Open Browser
		ChromeDriver driver=new ChromeDriver();
		
		//2) Maximize it
		driver.manage().window().maximize();
		
		
		//3) Navigate to application
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		//4) Go inside frame That contains 'DEPRECATED' hyperlink
		driver.switchTo().frame("classFrame");
		
		//5) Click on DEPRECATED
		driver.findElement(By.linkText("DEPRECATED")).click();

	}

}
