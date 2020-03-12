package Utilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import org.junit.Assert;

public class DriverManager {
	public WebDriver driver;
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

	public File screenshot(WebDriver driver) {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		return scrShot.getScreenshotAs(OutputType.FILE);
	}

	public void executeStep(Step Obj) throws InterruptedException {
		WebElement auxElement = elementCreator(Obj);
		int wait = (int) Obj.getWaitTime();
		Actions action = new Actions(driver);
		boolean confirm=false;
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
			driver.manage().timeouts().wait(wait * 1000);
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
		}

	}
}
