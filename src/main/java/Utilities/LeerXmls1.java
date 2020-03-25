package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeerXmls1 {
	public XSSFRow row;

	public ArrayList<ArrayList> getTestCases(String rute) throws IOException {
		/***/
		 ArrayList<ArrayList> listTC = new ArrayList();
		
		FileInputStream fis = new FileInputStream(new File(rute));

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet spreadsheet;

		/** Gets the number of sheets whit scripts*/
		int cols = 0;
		/**Variables to save the respective cell data*/
		String tcName="",action = "", description = "", vAccion = "", locator = "", vLocator = "",time="",destination="",destinationLocator="";
		double Step = 0;
		double numericValue = 0;
		boolean screenshot = false;
		boolean pass=true;
		Step aux;
		int rows=0;
		int x = 0;
		/**prints the test case names*/
		System.out.println(workbook.getNumberOfSheets());
		while( x <= (workbook.getNumberOfSheets()-1)) {
			ArrayList<Step> TC=new ArrayList();
			spreadsheet = workbook.getSheetAt(x);
			File directory = new File("C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\Screenshots\\"+workbook.getSheetName(x));
			System.out.println(workbook.getSheetName(x));
			rows = spreadsheet.getLastRowNum()+1;
			for (int r = 0; r < rows; r++) {
				row = spreadsheet.getRow(r);

				for (int c = 0; c < (row.getLastCellNum()); c++) {
					if (row.getCell(c) == null) {
						
					} else {
						tcName=workbook.getSheetName(x);
						if (r > 0) {
							switch (c) {

							case 0:
								Step = row.getCell(c).getNumericCellValue();
								break;

							case 1:
								action = row.getCell(c).getStringCellValue();
								break;

							case 2:
								description = row.getCell(c).getStringCellValue();
								break;

							case 3:
								vAccion = row.getCell(c).getStringCellValue();
								break;

							case 4:
								locator = row.getCell(c).getStringCellValue();
								break;

							case 5:
								vLocator = row.getCell(c).getStringCellValue();
								break;
							case 6:
								destination = row.getCell(c).getStringCellValue();
								break;

							case 7:
								destinationLocator = row.getCell(c).getStringCellValue();
								break;


							case 8:
								screenshot = row.getCell(c).getBooleanCellValue();
								break;

							case 9:
								numericValue = row.getCell(c).getNumericCellValue();
								break;
							}
						}
					}
				}
				aux = new Step(tcName,Step, description, action, vAccion, locator, vLocator, screenshot, numericValue,pass,time,destination,destinationLocator);
				TC.add(aux);
			}			
			x++;
			listTC.add(TC);
		}
		
		fis.close();
		return listTC;
		
		
	}
}
