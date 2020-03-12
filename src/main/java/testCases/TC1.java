package testCases;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.LeerXmls;
import Utilities.LeerXmls1;
import Utilities.Step;
import Utilities.DriverManager;

public class TC1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Crea objeto tipo WebElementCreator
		DriverManager driverManager=new DriverManager();
		//Crea una lista para guardar los pasos
		ArrayList<ArrayList> tcList;
		ArrayList<Step> stepList;
		//Inicializa el WebDriver
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\driver\\chromedriver.exe" );
		 driver = new ChromeDriver();
		 driverManager.setDriver(driver);
		//Manda el driver a elemento
		LeerXmls1 TC = new LeerXmls1();		
		tcList=TC.obtenObjetos("C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\excel\\TC.xlsx");
		//lee cada uno de los steps
		for(int x=0;x<tcList.size();x++) {
			//resive la lista de pasos del test case
			stepList=tcList.get(x);
			//itera cada paso para mandarlos al driver manager
			for(int i=1;i<stepList.size();i++) {
				//imprime el paso 
			System.out.println(stepList.get(x).toString());
			Thread.sleep(1000);
			//se crea un Web element y se ejecutan
			driverManager.executeStep(stepList.get(x));
			}
		}
	}

}
