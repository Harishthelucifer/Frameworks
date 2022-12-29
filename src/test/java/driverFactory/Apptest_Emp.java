package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.AddEmpPage;
import config.AppUtil_Emp;
import utilities.ExcelFileUtil;


public class Apptest_Emp  extends AppUtil_Emp{
	String inputpath ="C:\\ lucifer\\DataDriven_Maven\\TestInput\\employeedata.xlsx";
	String outputpath ="C:\\ lucifer\\DataDriven_Maven\\TestOutput\\empdata_results.xlsx";
	@Test
	public void startTest()throws Throwable
	{
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc =xl.rowCount("EmpData");
		Reporter.log("No of rows are::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			String fname =xl.getCellData("EmpData", i, 0);
			String mname =xl.getCellData("EmpData", i, 1);
			String lname =xl.getCellData("EmpData", i, 2);
			AddEmpPage emp =PageFactory.initElements(d, AddEmpPage.class);
			boolean res =emp.verifyEmp(fname, mname, lname);
			if(res)
			{
				xl.setcelldata("EmpData", i, 3,"pass" ,outputpath );
				
			}
			else
			{
				xl.setcelldata("EmpData", i, 3, "fail", outputpath);
			}

		}
	}
}


