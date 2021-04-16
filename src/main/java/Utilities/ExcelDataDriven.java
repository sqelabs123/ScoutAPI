package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ScoutAPI.RestAssuredDemo.Base;

public class ExcelDataDriven {
	String h;
	ArrayList<String> ar;
	int coloumn;

	public static ArrayList<String> getData(String testsheet,String testcaseName,String dfg) throws IOException {
		// fileInputStream argument
		ArrayList<String> a = new ArrayList<String>();
		String xssffilelocation = Base.Propertis("XSSfFile");
		FileInputStream fis = new FileInputStream(xssffilelocation);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(testsheet)) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				// Identify Testcases coloum by scanning the entire 1st row

				Iterator<Row> rows = sheet.iterator();// sheet is collection of
														// rows
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();// row is collection
															// of cells
				int k = 0;
				int coloumn = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();

					if (value.getStringCellValue().equalsIgnoreCase(dfg)) {
						coloumn = k;

					}

					k++;
				}
				System.out.println(coloumn);

				//// once coloumn is identified then scan entire testcase coloum
				//// to identify purcjhase testcase row
				while (rows.hasNext()) {

					Row r = rows.next();

					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) {

						Iterator<Cell> v = r.cellIterator();

						while (v.hasNext()) {
							Cell j = v.next();
//							a.add((j.getStringCellValue()));
							if(j.getCellTypeEnum()==CellType.STRING)
							{
								
							a.add(j.getStringCellValue());
							}
							else{
								
								a.add(NumberToTextConverter.toText(j.getNumericCellValue()));
							
							}
						}
						/* String a =(r.getStringCellValue().toString()); */
						

					}

					/* System.out.println(h); */

				}

			}
		}

		return a;
	

	}
	
}
