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
	public void winiumManage(WebDriver driver)throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//Inicializar Winium Driver y Winium Driver Service
		WiniumDriver driverW = null;
		WiniumDriverService service = null;
	  
	    //Inicializar WiniumDriver Options y le damos la ruta del Driver
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
	    //El objeto driverW recibe el service y el option para poder usar los metodos del winium.
	    driverW = new WiniumDriver(service,option);
	    
	    //ChromeDriver
		
//		WebElement profpic = driver.findElement(By.xpath("//a[@id='changephoto']"));
//		profpic.click();
		
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

		Thread.sleep(5000);
		driverW.quit();//Cierra de winium
		service.stop();//Cierra servicio de winium
	}
	
}
