package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeerXmls1 {
	static ArrayList<Step> TC = new ArrayList();
	static ArrayList<ArrayList> listTC = new ArrayList();;
	public XSSFRow row;

	public ArrayList<ArrayList> obtenObjetos(String name) throws IOException {

		FileInputStream fis = new FileInputStream(new File(name));

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet spreadsheet;

		// Obtengo el número de columnas ocupadas en la hoja
		int cols = 0;
		
		// Cadena que usamos para almacenar la lectura de la celda
		String tcName="",action = "", description = "", vAccion = "", locator = "", vLocator = "",time="";
		double Step = 0;
		double waitTime = 0;
		boolean screenshot = false;
		boolean pass=false;

		Step aux;
		int rows=0;
		int x = 0;
		System.out.println(workbook.getNumberOfSheets());
		while( x <= (workbook.getNumberOfSheets()-1)) {
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
								screenshot = row.getCell(c).getBooleanCellValue();
								break;

							case 7:
								waitTime = row.getCell(c).getNumericCellValue();
								break;
							}
						}
					}
				}
				aux = new Step(tcName,Step, description, action, vAccion, locator, vLocator, screenshot, waitTime,pass,time);
				TC.add(aux);
				tcName="";
				action = "";
				description = "";
				vAccion = "";
				locator = "";
				vLocator = "";	
			}			
			x++;
		}
		listTC.add(TC);
		fis.close();
		return listTC;
		
		
	}
}
