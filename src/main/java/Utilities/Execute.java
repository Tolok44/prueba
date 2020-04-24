package Utilities;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**This class iterates each of the steps in the list we receive from readxmls and sends them to the driver manager for execution
 * in addition to creating and opening reports.*/
public class Execute {
	ArrayList<Step> stepList;
	DriverManager driverManager1 = new DriverManager();
	
 /**This method iterates every test case an their steps via the class driver manager, generates the reports and opens them.*/
	public void execute(ArrayList<ArrayList> tcList) {

		DriverManager driverManager = new DriverManager();
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		
		/** reads every test case in the tclist */
		for (int x = 0; x < tcList.size(); x++) {
			driver = new ChromeDriver();
			ReportMaker report = new ReportMaker();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driverManager1.setDriver(driver);
			/** step list gets a step list from tcList */
			stepList = tcList.get(x);
			/**Executes the test case*/
			try {
			executetc(stepList);
			} catch (Exception e) {
				System.out.println(" ups something went wrong executing "+stepList.get(2).getTcName()+" sorry.");
				e.printStackTrace();
			}
			/**sends the list of steps to the report maker class*/
			report.reportMaker(stepList);
		}

	}
	/**This method executes a test case receiving an ArrayList panic*/
	public void executetc(ArrayList stepList) {
		for (int i = 1; i < stepList.size(); i++) {
			/**prints the step*/
			System.out.println(stepList.get(i).toString());
			/**a web element is created and they are executed*/
			try {
				
				driverManager1.executeStep((Step) stepList.get(i));
			} catch (Exception e) {
				try {
					driverManager1.takeSnapShot((Step) stepList.get(i));
				} catch (Exception e1) {
					System.out.println(" bummer,something went wrong taking error screenshot.");
					e1.printStackTrace();
				}
				System.out.println(" ups something went wrong. dont panic.");
				((Step) stepList.get(i)).setPass(false);
			}
		}
	}

}
