package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Acciones {
	
	public WebDriver driver;
	public WebElement click;
	public WebElement type;
	
	
	
	//-------------------------------------------------------------------------------
	//Browser************************************************************************
	//-------------------------------------------------------------------------------
	public void Navegar(String URL){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Training\\Documents\\chromedriver.exe" );
		this.driver = new ChromeDriver();
		this.driver.navigate().to(URL);
		
	}
	
	public void CloseService() throws InterruptedException {
		Thread.sleep(5000);
		this.driver.quit();
		}
	//-------------------------------------------------------------------------------
	//clicks*************************************************************************
	//-------------------------------------------------------------------------------
	
	
	
public void click(String element, String text) {
		
		switch(element) {
		
		case "className":click = driver.findElement(By.className(text));
						 click.click();
						 
		case "id": click = driver.findElement(By.id(text));
				   click.click();
				   
		case "name": click = driver.findElement(By.name(text));
					 click.click();
		
		case "xpath": click = driver.findElement(By.xpath(text));
		 			  click.click();
		
		case "cssSelector": click = driver.findElement(By.cssSelector(text));
		  					click.click();
		}
		
		
		
		
	}
	
	//--------------------------------------------------------------------------------------------
	//Types***************************************************************************************
	//--------------------------------------------------------------------------------------------
	
	
	public void TypeByName(String name, String text){
		type = driver.findElement(By.name(name));
		 type.sendKeys(text);
		
	}
	
	public void TypeByClassName(String className, String text){
		type = driver.findElement(By.name(className));
		 type.sendKeys(text);
		
	}
	
	public void TypeById(String id, String text){
		type = driver.findElement(By.name(id));
		 type.sendKeys(text);
		
	}
	
	public void TypeByXpath(String xpath, String text){
		type = driver.findElement(By.name(xpath));
		 type.sendKeys(text);
		
	}
	
	public void TypeByCssSelector(String cssSelector, String text){
		type = driver.findElement(By.name(cssSelector));
		 type.sendKeys(text);
		
	}
	
}
