package Utilities;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**This class iterates each of the steps in the list we receive from readxmls and sends them to the driver manager for execution
 * in addition to creating and opening reports.*/
public class Execute {
	ArrayList<Step> stepList;
 /**This class iterates every test case an their steps via the class driver manager, generates the reports and opens them.*/
	public void execute(ArrayList<ArrayList> tcList) {

		DriverManager driverManager = new DriverManager();
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		
		/** reads every test case in the tclist */
		for (int x = 0; x < tcList.size(); x++) {
			driver = new ChromeDriver();
			DriverManager driverManager1 = new DriverManager();
			ReportMaker report = new ReportMaker();
			driver.manage().timeouts().implicitlyWait(17, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driverManager1.setDriver(driver);
			/** step list gets a step list from tcList */
			stepList = tcList.get(x);
			/**iterate each step to send them to the driver manager */
			for (int i = 1; i < stepList.size(); i++) {
				/**prints the step*/
				System.out.println(stepList.get(i).toString());
				/**a web element is created and they are executed*/
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
