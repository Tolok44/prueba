package testCases;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.DriverManager;
import Utilities.LeerXmls;
import Utilities.Step;

public class TC2 {
	public static void main(String[] args) throws IOException, InterruptedException {
		//Crea objeto tipo WebElementCreator
		DriverManager driverManager=new DriverManager();
		//Crea una lista para gardar los pasos
		ArrayList<Step> ListaObjetosStep;
		//Inicializa el WebDriver
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\driver\\chromedriver.exe" );
		 driver = new ChromeDriver();
		 driverManager.setDriver(driver);
		//Manda el driver a elemento
		LeerXmls TC = new LeerXmls();		
		ListaObjetosStep=TC.obtenObjetos("C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\excel\\TC1.xlsx");
		//lee cada uno de los steps
		for(int x=1;x<ListaObjetosStep.size();x++) {
			System.out.println(ListaObjetosStep.get(x).toString());
			Thread.sleep(2000);
			//se crea un Web element y se ejecutan
			driverManager.executeStep(ListaObjetosStep.get(x));
		}
	}

}
