package Utilities;

import java.io.File;
import java.io.IOException;
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
	public static void main(String[] args) throws InterruptedException, IOException {
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
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\driver\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.navigate().to("https://scrum-metrics.herokuapp.com/start/home");
		WebElement searchBar = driver.findElement(By.xpath("//span[contains(text(),'Getting Started')]"));
		searchBar.click();
		Thread.sleep(2000);
		
		WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		login.click();
		Thread.sleep(2000);
		WebElement usr = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		usr.sendKeys("davidpena");
		
		WebElement pass = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		pass.sendKeys("hexaware123");
		Thread.sleep(2000);
		WebElement btn = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
		btn.click();
		
		Thread.sleep(5000);
		WebElement prof = driver.findElement(By.xpath("//h1[@class='user-name']"));
		prof.click();
		Thread.sleep(2000);
		WebElement profpic = driver.findElement(By.xpath("//a[@id='changephoto']"));
		profpic.click();
		
		Thread.sleep(2000);
		
		//AUTOMATIZACION WINDOWS	
		//Creamos un WebElement para la ventana de windows, lo identificamos con el Name.
		WebElement window = driverW.findElementByName("Open");
		//Creamos otro WebElement para seleccionar la carpeta de "Downloads"
		//dentro de la ventana de windows con el objeto "window" en vez de driver.
		WebElement Open1 = window.findElement(By.name("Open"));
		WebElement windowElem = window.findElement(By.name("Desktop"));
		windowElem.click();
		//WebElements para seleccionar la imagen dentro del panel "Items View"
		WebElement carpet = driverW.findElement(By.name("Prueba"));
		carpet.click();
		Open1.click();
		carpet.sendKeys(Keys.chord(Keys.ALT, "o"));
	    
		WebElement carpetFrameWork = driverW.findElement(By.name("frameWorkBatch3"));
		carpetFrameWork.click();
		
		carpetFrameWork.click();
		carpetFrameWork.click();
//		WebElement selPic = picture.findElement(By.name("sakila"));
//		selPic.click();
		
		//clic en el boton de Open
		WebElement btnW = window.findElement(By.xpath("//*[contains(@ClassName, 'Button')] and [contains(@Name, 'Open')]"));
		btnW.click();
		
		Thread.sleep(5000);
		driverW.quit();//Cierra de winium
		driver.quit();//Cierre de chromedriver
		service.stop();//Cierra servicio de winium
	}
	
}
