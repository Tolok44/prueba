package Utilities;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.apache.commons.io.FileUtils;

public class DriverManager {
	public static WebDriver driver;
	public WebElement element;
	public Select select;

	public DriverManager() {
		super();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement elementCreator(Step Obj) {
		switch (Obj.getLocator().toLowerCase()) {
		case "name":
			element = driver.findElement(By.name(Obj.getValueLocator()));
			break;
		case "classname":
			element = driver.findElement(By.className(Obj.getValueLocator()));
			break;
		case "cssselector":
			element = driver.findElement(By.cssSelector(Obj.getValueLocator()));
			break;
		case "id":
			element = driver.findElement(By.id(Obj.getValueLocator()));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(Obj.getValueLocator()));
			break;
		case "tagName":
			element = driver.findElement(By.tagName(Obj.getValueLocator()));
			break;
		}

		return element;

	}

	 public static void takeSnapShot(Step Obj) throws Exception{

	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)driver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File("C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\Screenshots\\"+"Step "+Obj.getStep()+" "+Obj.getAccion()+".png");
	                FileUtils.copyFile(SrcFile, DestFile);

	    }

	public void executeStep(Step Obj) throws Exception {
		WebElement auxElement = elementCreator(Obj);
		int wait = (int) Obj.getWaitTime();
		Actions action = new Actions(driver);
		boolean confirm=false;
		Random random = new Random();
		int rand=0;
				if(Obj.getScreenshoot()==true) {
					takeSnapShot(Obj);
					System.out.print("Screenshot taken");
				}
		switch (Obj.getAccion().toLowerCase()) {
		case "navigate":
			driver.navigate().to(Obj.getValueAccion());
			break;

		case "quit":
			driver.quit();
			break;
		case "type":
			auxElement.sendKeys(Obj.getValueAccion());
			break;
		case "typenumeric":
			String numeric=Obj.waitTime+"";
			String ignoredotcero=numeric.replace(".0","");
			auxElement.sendKeys(ignoredotcero);
			break;
		case "click":
			auxElement.click();
			break;
		case "clear":
			auxElement.clear();
			break;
		case "enter":
			auxElement.sendKeys(Keys.ENTER);
			break;
		case "selectByValue":
			select = new Select(elementCreator(Obj));
			select.selectByValue(Obj.getValueAccion());
			break;
		case "selectByIndex":
			select = new Select(elementCreator(Obj));
			select.selectByIndex(Integer.parseInt(Obj.getValueAccion()));
			break;
		case "Wait":
			Thread.sleep(wait*10000);	
			break;
		case "implicitlyWait":
			driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
			break;
		case "alert":
			driver.switchTo().alert().accept();
			break;
		case "confirm":
			confirm=element.isDisplayed();
			if(confirm==true) {
				System.out.println("The element exists");
			}else {
				System.out.println("The element does not exists");

			}
			break;
		case "randuser":
		    rand=random.nextInt(10000);
		    System.out.println(rand);
			auxElement.sendKeys("Marselo"+rand);
			break;
		case "randemail":
			rand=random.nextInt(10000);
			auxElement.sendKeys("Marselo"+rand+"@gmail.com");
			break;
		}

	}
}
