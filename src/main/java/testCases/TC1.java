package testCases;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.LeerXmls;
import Utilities.Step;
import Utilities.DriverManager;

public class TC1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Crea objeto tipo WebElementCreator
		DriverManager driverManager=new DriverManager();
		//Crea una lista para gardar los pasos
		ArrayList<Step> ListaObjetosStep;
		//Inicializa el WebDriver
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Training\\Documents\\chromedriver.exe" );
		 driver = new ChromeDriver();
		 driverManager.setDriver(driver);
		//Manda el driver a elemento
		LeerXmls TC = new LeerXmls();		
		ListaObjetosStep=TC.obtenObjetos("C:\\Users\\Training\\Documents\\TC.xlsx");
		//lee cada uno de los steps
		for(int x=1;x<ListaObjetosStep.size();x++) {
			System.out.println(ListaObjetosStep.get(x).toString());
			Thread.sleep(1000);
			//se crea un Web element y se ejecutan
			driverManager.executeStep(ListaObjetosStep.get(x));
		}
	}

}
