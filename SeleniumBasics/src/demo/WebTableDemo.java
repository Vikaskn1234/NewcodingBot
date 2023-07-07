package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableDemo {

	public static void main(String[] args) {
		//1) Open the browser
		ChromeDriver driver=new ChromeDriver();
		
		//2) maximize it
		driver.manage().window().maximize();
		
		//3) navigate to application
		driver.get("https://letcode.in/table");
		
		// 4) sum up all the prices shown in the table and varify it should be equal to 858
		WebElement firstTable=driver.findElement(By.id("shopping"));
		
		// 4.1) Capture all the rows of the table and put them in a list
		List<WebElement> rows=firstTable.findElements(By.tagName("tr"));
		
		// 4.2) From each row capture all the td elements in a separate list and get the 2nd td element
		// from the new list
		int sum=0;
		for(int i=1;i<rows.size();i++)
		{
			WebElement row=rows.get(i);
			List<WebElement> columns=row.findElements(By.tagName("td"));
			int price=Integer.parseInt(columns.get(1).getText());
			sum=sum+price;
			
		}
		int expectedSum=858;
		if(expectedSum==sum)
		{
			System.out.println("Test case passed");
		}
		else
		{
			System.out.println("Test case failed"); 
		}
		
		
	}

}
