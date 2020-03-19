package testCases;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Utilities.DriverManager;
import Utilities.LeerXmls1;
import Utilities.OpenHtml;
import Utilities.Step;
import Utilities.reportMethod;
/** In this class the test cases are iterated and executed */
public class TC1 {
	public static void main(String[] args) throws Exception {
		/**Creates an object type WebElementCreator*/
		DriverManager driverManager=new DriverManager();
		/**Creates a list to save the test cases*/
		ArrayList<ArrayList> tcList;
		ArrayList<Step> stepList;
		/**Initialize a WebDriver*/
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\driver\\chromedriver.exe" );
		 driver = new ChromeDriver();
		 driverManager.setDriver(driver);
		 /**Creates an Object OpenHtml*/
		 OpenHtml openHtml=new OpenHtml();
		 reportMethod report= new reportMethod();
		LeerXmls1 TC = new LeerXmls1();		
		tcList=TC.obtenObjetos("C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\excel\\TC.xlsx");
		/**Reads every test case list from the sheets*/
		for(int x=0;x<tcList.size();x++) {
			/**Receive every step list*/
			stepList=tcList.get(x);
			/**iterates every step*/
			for(int i=1;i<stepList.size();i++) {
				/**an step is printed */
			System.out.println(stepList.get(i).toString());
			/**a web element is created  and executed*/
			try {
			driverManager.executeStep(stepList.get(i));
			}catch(Exception e) {
			      System.out.println(" ups something went  wrong.");
			      stepList.get(i).setPass(false);
			}
			}
			/**sends the test case list to the reporter maker*/
			report.reportMaker(tcList.get(x));
		}
		/**Opens the report*/
		openHtml.OpenHtml();
	}


}
