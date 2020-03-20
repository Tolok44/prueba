package Utilities;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Execute {
	ArrayList<Step> stepList;
	public void execute( ArrayList<ArrayList> tcList) {
	
		
		DriverManager driverManager=new DriverManager();
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\driver\\chromedriver.exe" );
		driver = new ChromeDriver();
		DriverManager driverManager1=new DriverManager();
		reportMethod report= new reportMethod();
		driverManager1.setDriver(driver);
			
		
		//lee cada uno de los steps
				for(int x=0;x<tcList.size();x++) {
					//Receive la lista de pasos del test case
					stepList=tcList.get(x);
					//itera cada paso para mandarlos al driver manager
					for(int i=1;i<stepList.size();i++) {
						//imprime el paso 
					System.out.println(stepList.get(i).toString());
					//se crea un Web element y se ejecutan
					try {
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					driverManager1.executeStep(stepList.get(i));
					}catch(Exception e) {
					      System.out.println(" ups something went wrong.");
					      e.printStackTrace();
					      stepList.get(i).setPass(false);
					}
					}
					report.reportMaker(stepList);
				}
	}

}
