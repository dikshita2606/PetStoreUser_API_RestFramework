package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testData//UserTestData.xlsx";
		XLUtility xlutil = new XLUtility(path);
		
		int rowNum = xlutil.getRowCount("Sheet1");
		int colNum = xlutil.getCellCount("Sheet1", rowNum);
		
		String apidata[][] = new String[rowNum][colNum];
		
		for(int r=1 ;r<=rowNum;r++) //Row will start from 1 because at 0 index header row will be there
		{
			for(int c=0;c<colNum;c++)
			{
				apidata[r-1][c]= xlutil.getCellData("Sheet1",r, c);
			}
		}
		return apidata;		
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//UserTestData.xlsx";
		XLUtility xlUtils=new XLUtility(path);
	
		int rownum=xlUtils.getRowCount("Sheet1");	
			
		String apidata[]=new String[rownum];
		
		for(int r=1;r<=rownum;r++)
		{		
			apidata[r-1]= xlUtils.getCellData("Sheet1",r, 1);  
		}
	
		return apidata;
	}
}
