package Utilities;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DriverManager {
	public WebDriver driver;
	public WebElement elemento;
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
			elemento = driver.findElement(By.name(Obj.getValueLocator()));
			break;
		case "classname":
			elemento = driver.findElement(By.className(Obj.getValueLocator()));
			break;
		case "cssselector":
			elemento = driver.findElement(By.cssSelector(Obj.getValueLocator()));
			break;
		case "id":
			elemento = driver.findElement(By.id(Obj.getValueLocator()));
			break;
		case "xpath":
			elemento = driver.findElement(By.xpath(Obj.getValueLocator()));
			break;
		case "tagName":
			elemento = driver.findElement(By.tagName(Obj.getValueLocator()));
			break;
		}

		return elemento;

	}


	public File screenshot(WebDriver driver) {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		return scrShot.getScreenshotAs(OutputType.FILE);
	}

	public void executeStep(Step Obj) {
		WebElement auxElement = elementCreator(Obj);
		switch (Obj.getAccion().toLowerCase()) {
		case "navegate":
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
		}

	}
}
