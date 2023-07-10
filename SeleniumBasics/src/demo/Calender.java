package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) {
		//1) open the browser
		ChromeDriver driver=new ChromeDriver();
		
		//2) Maximize it
		driver.manage().window().maximize();
		
		//3) Navigate to application
		driver.get("https://www.expedia.co.in/");
		
		//4) 
		driver.findElement(By.id("date_form_field-btn")).click();
		
		WebElement nextmonth=driver.findElement(By.xpath("(//table[contains(@class, 'weeks')])[2]"))
;			
			
	    List<WebElement> rows=nextmonth.findElements(By.tagName("tr"));
	    
	    for(int i=1;i<rows.size();i++)
	    {
	    	WebElement row=rows.get(i);
	    	List<WebElement> columns=row.findElements(By.tagName("button"));
	    	
	    	for(WebElement x: columns)
	    	{
	    		if(x.getAttribute("data-day").equals("9"))
	    		{
	    			x.click();
	    			break;
	    		}
	    	}
	    }
	    
	    driver.findElement(By.xpath("//button[contains(@data-stid, 'apply-date')]")).click();

	}

}
