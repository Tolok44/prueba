package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/** This class returns a list of steps list read from the excel file. */
public class ReadXmls {

	/** This method return the list of test cases with their respective steps */
	public ArrayList<ArrayList> getTestCases(String rute) throws IOException {
		XSSFRow row;
		XSSFSheet spreadsheet;
		ArrayList<ArrayList> listTC = new ArrayList();

		FileInputStream fis = new FileInputStream(new File(rute));

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		/** Gets the number of sheets whit scripts */
		/** Variables to save the respective cell data */
		String tcName ="", action = "", description = "", vAccion = "", locator = "", vLocator = "", time = "",
				destination = "", destinationLocator = "";
		double Step = 0;
		double numericValue = 0;
		boolean screenshot = false;
		boolean pass = true;
		ArrayList parameters = null;
		ArrayList objects = null;
		Step aux;
		
		int rows = 0;
		int x = 0;
		/** Prints the number of test cases */
		System.out.println(workbook.getNumberOfSheets());
		/** in this while we iterate every spreadsheet */
		while (x <= (workbook.getNumberOfSheets() - 3)) {
			/**
			 * This arrayList is an auxiliary array so we can save the steps and then save
			 * it in another arrayList of arrayList.
			 */
			ArrayList<Step> TC = new ArrayList();
			spreadsheet = workbook.getSheetAt(x);
			/**
			 * Here we create folders with the test case names so later we save the
			 * screenshots.
			 */
			try {
				parameters = getParameters(workbook.getSheet("Parameters"));
			} catch (Exception e) {
				//System.out.println("Error reading parameters, check the sheet name is 'Parameters'.");
			}
			try {
				objects = getObjects(workbook.getSheet("Objects"));
			} catch (Exception e) {
				//System.out.println("Error reading parameters, check the sheet name is 'Objects'.");
			}

			File directory = new File("Screenshots/" + workbook.getSheetName(x));
			/** Prints the test case names */
			System.out.println(workbook.getSheetName(x));
			rows = spreadsheet.getLastRowNum() + 1;
			for (int r = 0; r < rows; r++) {
				row = spreadsheet.getRow(r);
				for (int c = 0; c < (row.getLastCellNum()); c++) {
					if (row.getCell(c) == null) {
					} else {
						tcName = workbook.getSheetName(x);
						if (r > 0) {
							switch (c) {
							/** reads the steps */
							case 0:
								Step = row.getCell(c).getNumericCellValue();
								break;
							/** reads the action */
							case 1:
								action = row.getCell(c).getStringCellValue();
								break;
							/** gets the description of the step */
							case 2:
								description = row.getCell(c).getStringCellValue();
								break;

							case 3:
								try {
								vAccion = row.getCell(c).getStringCellValue();
								}catch(Exception e){
									numericValue=row.getCell(c).getNumericCellValue();
									vAccion=numericValue+"";
									vAccion=vAccion.replace(".0","");
								}
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
							}
						}
					}
				}
				aux = new Step(tcName, Step, description, action, vAccion, locator, vLocator, screenshot,
						pass, time, destination, destinationLocator, parameters,objects);

				/** Here we save the steps in the auxiliary array. */
				TC.add(aux);
				tcName = "";
				Step = 0;
				description = "";
				action = "";
				vAccion = "";
				locator = "";
				vLocator = "";
				screenshot = false;
				numericValue = 0.0;
				destination = "";
				destinationLocator = "";
			}
			x++;
			/** Here we add the test case to the list of test cases */
			listTC.add(TC);

		}
		/** The file is closed. */
		fis.close();
		return listTC;

	}

	public ArrayList getParameters(XSSFSheet parameters) throws IOException {
		XSSFRow row;
		/** Variables to save the respective cell data */
		String name = "", value = "";
		Parameter aux;
		int rows = 0;
		/**
		 * This arrayList is an auxiliary array so we can save the steps and then save
		 * it in another arrayList of arrayList.
		 */
		ArrayList<Parameter> parameterList = new ArrayList();
		double numericValue=0;
		rows = parameters.getLastRowNum() + 1;
		for (int r = 0; r < rows; r++) {
			row = parameters.getRow(r);
			for (int c = 0; c < (row.getLastCellNum()); c++) {
				if (row.getCell(c) == null) {
				} else {
					if (r > 0) {
						switch (c) {
						/** reads names */
						case 0:
							name = row.getCell(c).getStringCellValue();
							break;
						/** reads value */
						case 1:
							try {
								value = row.getCell(c).getStringCellValue();
								}catch(Exception e){
									numericValue=row.getCell(c).getNumericCellValue();
									value=numericValue+"";
									value=value.replace(".0","");
								}
							break;
						}
					}
				}
			}
			/** add Parameters to the list */
			aux = new Parameter(name, value);
			parameterList.add(aux);
			name = "";
			value = "";
		}
		/** returns list of Parameters */
		// System.out.println(parameterList.toString());
		return parameterList;

	}

	public ArrayList getObjects(XSSFSheet objects) throws IOException {
		XSSFRow row;
		/** Variables to save the respective cell data */
		String name = "", description = "", locator = "", valueLocator = "";
		Object aux;

		int rows = 0;
		/**
		 * This arrayList is an auxiliary array so we can save the steps and then save
		 * it in another arrayList of arrayList.
		 */
		ArrayList<Object> objectList = new ArrayList<Object>();

		rows = objects.getLastRowNum() + 1;
		for (int r = 0; r < rows; r++) {
			row = objects.getRow(r);
			for (int c = 0; c < (row.getLastCellNum()); c++) {
				if (row.getCell(c) == null) {
				} else {
					if (r > 0) {
						switch (c) {
						/** reads names */
						case 0:
							name = row.getCell(c).getStringCellValue();
							break;
						/** reads value */
						case 1:
							description = row.getCell(c).getStringCellValue();
							break;
						case 2:
							locator = row.getCell(c).getStringCellValue();
							break;
						case 3:
							valueLocator = row.getCell(c).getStringCellValue();
							break;
						}
					}
				}
			}
			/** add Parameters to the list */
			aux = new Object(name,description,locator,valueLocator);
			objectList.add(aux);
			name = "";
			description = "";
			locator="";
			valueLocator="";
		}
		/** returns list of Parameters */
		 System.out.println(objectList.toString());
		return objectList;

	}

}
