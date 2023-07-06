package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyErrorMessage {

	public static void main(String[] args) {
		// 1) Open browser
		ChromeDriver driver=new ChromeDriver();
		
		//2) Navigate to application
		driver.get("http://facebook.com");
		
		//3) enter invalid username 'batsman554466@gmail.com' in the 'Email address or phone number' textbox
		driver.findElement(By.id("email")).sendKeys("batsman554466@gmail.com");
		
		// 4) Enter invalid password 'password@123' in the "Password' Textbox
		driver.findElement(By.id("pass")).sendKeys("password@123");
		
		// 5) Click Login Button
		driver.findElement(By.name("login")).click();
		
		// 6) Verify user sees the error message- "The email address you entered isn't connected to an account .
		//Find  your account
		
		String expectedErrMsg="The email address you entered isn't connected to an account. Find your account and log in.";
		//String actualErrMsg=driver.findElement(By.cssSelector("#email_container > div._9ay7")).getText();
		String actualErrMsg=driver.findElement(By.xpath("//*[@id=\"email_container\"]/div[2]")).getText();
		
		if(expectedErrMsg.equals(actualErrMsg))
		{
			System.out.println("test case Passed");
		}
		else
		{
			System.out.println("test case failed");
		}
		//7) Close the browser
		driver.quit();
		

	}

}
