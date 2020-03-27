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

public class WiniumManager {
	public void winiumManage() throws InterruptedException, IOException {

		/**Initialize Winium Driver y Winium Driver Service*/
		WiniumDriver driverW = null;
		WiniumDriverService service = null;
		/**Initialize WiniumDriver Option and gave the rute of Driver*/
		DesktopOptions option = new DesktopOptions();
		option.setDebugConnectToRunningApp(true);
		File driverPath = new File("/driver/Winium.Desktop.Driver.exe");
		System.setProperty("webdriver.winium.desktop.driver", "/driver/Winium.Desktop.Driver.exe");
		service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true)
				.withSilent(false).buildDesktopService();
		try {
			service.start();
		} catch (IOException e) {
			System.out.println("Exception while starting WINIUM service");
			e.printStackTrace();
		}
		Thread.sleep(1000);
		/** Windows Automation */
		driverW.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		driverW.quit();// Cierra de winium
		service.stop();// Cierra servicio de winium
	}

}
