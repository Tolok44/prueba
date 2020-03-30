package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
/**This class handles winium drivers to be able to select a photo. for the edit profile and project creation stories.*/
public class WiniumManager {
	public void winiumManage(WebDriver driver)throws InterruptedException, IOException {
		
		/**Initialize Winium Driver and Winium Driver Service*/
		WiniumDriver driverW = null;
		WiniumDriverService service = null;
	    /**Initialize Winium Driver Options and we give the path of the Driver**/
	    DesktopOptions option = new DesktopOptions();
	    option.setDebugConnectToRunningApp(true);
	    File driverPath = new File("C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\driver\\Winium.Desktop.Driver.exe");
	    System.setProperty("webdriver.winium.desktop.driver", "C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\driver\\Winium.Desktop.Driver.exe" );
	    //Iniciamos el servicio de Winium Driver
	    service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
	    try {
	    	service.start();
	    }catch(IOException e) {
	    	System.out.println("Exception while starting WINIUM service");
	    	e.printStackTrace();
	    }
	    /**The driverW object receives the service and the option to use the winium methods.*/
	    driverW = new WiniumDriver(service,option);
		Thread.sleep(2000);  
		/**Windows Automation*/
		WebElement window = driverW.findElementByName("Open");
		WebElement windowElem = window.findElement(By.name("Desktop"));
		windowElem.click();
		WebElement carpet = driverW.findElement(By.name("Prueba"));
		carpet.click();
		  WebElement window2 = driverW.findElementByXPath("/*[@ControlType='ControlType.Pane']");
	        window2.submit();
			WebElement carpetFramework = driverW.findElement(By.name("frameWorkBatch3"));
			carpetFramework.click();
			window2.submit();
			WebElement carpetImage = driverW.findElement(By.name("image"));
			carpetImage.click();
			window2.submit();
			WebElement carpetRewindTime = driverW.findElement(By.name("RewindTime"));
			carpetRewindTime.click();
			window2.submit();
		Thread.sleep(1000);
		/**close winium driver*/
		driverW.quit();
		/**close service*/
		service.stop();
	}
	
}
