package Utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class CalendarHandler {
	public void calendar(WebDriver driver) 
	{
		
		List<WebElement> allsvg=driver.findElements(By.cssSelector("svg"));
		
		for(WebElement ele:allsvg)
		{
				ele.click();
			
		}
		
		
	}
}

