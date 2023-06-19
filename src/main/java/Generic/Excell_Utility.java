package Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excell_Utility 
{
	
	public String get_value(String sheetname,String ekey) throws Throwable
	{
		FileInputStream fis=new FileInputStream(Iconstantpaths.excellpath);
		
		Workbook book = WorkbookFactory.create(fis);
		Sheet csheat = book.getSheet(sheetname);
		int lrn=csheat.getLastRowNum();
		String value=null;
		for(int i=0;i<=lrn;i++)
		{
			String key=csheat.getRow(i).getCell(0).toString();
			if(key.equalsIgnoreCase(ekey))
			{
				value=csheat.getRow(i).getCell(1).toString();
				break;
			}
		}
		return value;
	}
	
	public Object[][] data_driven_testdata(String sheetname) throws Throwable
	{

		FileInputStream fis=new FileInputStream(Iconstantpaths.excellpath);
		
		Workbook  book = WorkbookFactory.create(fis);

		Sheet csheat = book.getSheet(sheetname);
		int lrn=csheat.getLastRowNum()+1;
		short lcn = csheat.getRow(0).getLastCellNum();
		Object[][] arr=new Object[lrn][lcn];
		for(int i=0;i<lrn;i++)
		{
			for(int j=0;j<lcn;j++)
			{
			 arr[i][j]=csheat.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return arr;
	}
}
