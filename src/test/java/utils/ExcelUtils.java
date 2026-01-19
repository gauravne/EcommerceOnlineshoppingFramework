package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtils {
	
	@DataProvider(name = "TestData")
	public String[][] getdata(Method m) throws EncryptedDocumentException, IOException
	{
		
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\Testdata.xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fs);
		String expectedsheetName = m.getName();
		Sheet sheetName = wb.getSheet(expectedsheetName);
		
		int totalrows = sheetName.getLastRowNum();
		Row rowcells = sheetName.getRow(0);
		int totalcols = rowcells.getLastCellNum();
		
		DataFormatter format = new DataFormatter();
		
		String testData[][] = new String[totalrows] [totalcols] ;
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
			}
		}
	//	System.out.println(testData);
		return testData;
	
}
}
