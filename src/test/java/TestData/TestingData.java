package TestData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class TestingData {
	
	@Test
	public void requireTestData() throws IOException
	{
		FileInputStream fis = new FileInputStream("E://TestData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheets = workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("LoginCreds"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				Iterator<Cell> cell = firstrow.cellIterator();
				int k=0;
				int col=0;
				while (cell.hasNext())
				{
					Cell value =cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("UserType"))
					{
						//desired column
						col=k;
					}
					k++;
					
				}
				System.out.println(col);
				
				while(rows.hasNext())
				{
					Row r = rows.next();
					if(r.getCell(col).getStringCellValue().equalsIgnoreCase("Distributor"))
					{
						Iterator<Cell> cv = r.cellIterator();
						while(cv.hasNext())
						{
							System.out.println(cv.next().getStringCellValue());
							
						}
						
					}
					
				}
				
			}
			
			
		}
		
		
		
		
		
	}

}
