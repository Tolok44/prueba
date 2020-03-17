package Utilities;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	public WebElement elementCreatorDrag(Step Obj) {
		switch (Obj.getDestinationLocator().toLowerCase()) {
		case "name":
			element = driver.findElement(By.name(Obj.getDestinationLocatorValue()));
			break;
		case "classname":
			element = driver.findElement(By.className(Obj.getDestinationLocatorValue()));
			break;
		case "cssselector":
			element = driver.findElement(By.cssSelector(Obj.getDestinationLocatorValue()));
			break;
		case "id":
			element = driver.findElement(By.id(Obj.getDestinationLocatorValue()));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(Obj.getDestinationLocatorValue()));
			break;
		case "tagName":
			element = driver.findElement(By.tagName(Obj.getDestinationLocatorValue()));
			break;
		}

		return element;

	}

	 public static void takeSnapShot(Step Obj) throws Exception{
		 if(Obj.getScreenshoot()==true) {
				 //Convert web driver object to TakeScreenshot

		        TakesScreenshot scrShot =((TakesScreenshot)driver);

		        //Call getScreenshotAs method to create image file

		                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		            //Move image file to new destination

		                File DestFile=new File("C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\Screenshots\\"+Obj.getTcName()+"\\Step "+Obj.getStep()+" "+Obj.getAccion()+".png");
		                FileUtils.copyFile(SrcFile, DestFile);
				System.out.print("Screenshot taken");
			}
	    }

	public void executeStep(Step Obj) throws Exception {
		LocalDateTime myObj = LocalDateTime.now();
	     DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	     String formattedDate = myObj.format(myFormatObj);
	     Obj.setTime(formattedDate);
		WebElement auxElement = elementCreator(Obj);
		int wait = (int) Obj.getWaitTime();
		Actions action = new Actions(driver);
		boolean confirm=false;
		Random random = new Random();
		int rand=0;
				
		switch (Obj.getAccion().toLowerCase()) {
		case "navigate":
			takeSnapShot(Obj);
			driver.navigate().to(Obj.getValueAccion());
			break;
		case "quit":
			takeSnapShot(Obj);
			driver.quit();
			break;
		case "type":
			takeSnapShot(Obj);
			auxElement.sendKeys(Obj.getValueAccion());
			break;
		case "typenumeric":
			takeSnapShot(Obj);
			String numeric=Obj.waitTime+"";
			String ignoredotcero=numeric.replace(".0","");
			auxElement.sendKeys(ignoredotcero);
			break;
		case "click":
			takeSnapShot(Obj);
			auxElement.click();
			break;
		case "clear":
			takeSnapShot(Obj);
			auxElement.clear();
			break;
		case "enter":
			takeSnapShot(Obj);
			auxElement.sendKeys(Keys.ENTER);
			break;
		case "selectByValue":
			takeSnapShot(Obj);
			select = new Select(elementCreator(Obj));
			select.selectByValue(Obj.getValueAccion());
			break;
		case "selectByIndex":
			takeSnapShot(Obj);
			select = new Select(elementCreator(Obj));
			select.selectByIndex(Integer.parseInt(Obj.getValueAccion()));
			break;
		case "Wait":
			takeSnapShot(Obj);
			Thread.sleep(wait*10000);	
			break;
		case "implicitlyWait":
			takeSnapShot(Obj);
			driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
			break;
		case "alert":
			takeSnapShot(Obj);
			driver.switchTo().alert().accept();
			break;
		case "confirm":
			takeSnapShot(Obj);
			confirm=auxElement.isDisplayed();
			if(confirm==true) {
				System.out.println("The element exists");
			}else {
				System.out.println("The element does not exists");

			}
			break;
		case "compto":
			takeSnapShot(Obj);
			System.out.println("comparing...");
			if(Obj.valueAccion.equals(auxElement.getText())) {
				confirm=true;
			}else {
				confirm=false;
			}
			if(confirm==true) {
				System.out.println("The element contains "+Obj.getValueAccion());
			}else {
				System.out.println("The element does not conatains "+Obj.getValueAccion());
			}
			break;
		case "randuser":
			takeSnapShot(Obj);
		    rand=random.nextInt(10000);
		    System.out.println(rand);
			auxElement.sendKeys("Rafita"+rand);
			break;
		case "randemail":
			takeSnapShot(Obj);
			rand=random.nextInt(10000);
			auxElement.sendKeys("Rafita"+rand+"@gmail.com");
			break;
			
		case "dragndrop":
			WebElement to=elementCreatorDrag(Obj);
			action.dragAndDrop(auxElement, to).build().perform();
		break;
			
		}
	}

		
	}

