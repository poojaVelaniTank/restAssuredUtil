package restAssuredReference;
import java.io.IOException;

import utils.Excelutils;

public class ExcelutilsTest {
	
	public static void main(String[] args) throws IOException {
		
		String excelPath="./data/TestData.xlsx";
		String sheetName="Post Test_Data";
		
		
		Excelutils excel = new Excelutils(excelPath, sheetName);
		
		Excelutils.getRowCount();
		Excelutils.getCellData(1, 0);
		Excelutils.getCellData(1, 1);
		Excelutils.getCellData(1, 2);
		Excelutils.getCellData(1, 3);
		//excel.getCellData(1, 1);
		//excel.getCellData(1, 2);
	} 

}
 