package Utilities;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Execute {
	ArrayList<Step> stepList;

	public void execute(ArrayList<ArrayList> tcList) {

		DriverManager driverManager = new DriverManager();
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

		/** reads every test case in the tclist */
		for (int x = 0; x < tcList.size(); x++) {
			driver = new ChromeDriver();
			DriverManager driverManager1 = new DriverManager();
			ReportMaker report = new ReportMaker();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driverManager1.setDriver(driver);
			/** reads all */
			stepList = tcList.get(x);
			/** itera cada paso para mandarlos al driver manager */
			for (int i = 1; i < stepList.size(); i++) {
				/** imprime el paso */
				System.out.println(stepList.get(i).toString());
				// se crea un Web element y se ejecutan
				try {
					driverManager1.executeStep(stepList.get(i));
				} catch (Exception e) {
					System.out.println(" ups something went wrong.");
					stepList.get(i).setPass(false);
				}
			}
			report.reportMaker(stepList);
		}

	}

}
