package testDataDriven;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelReader{
//Fetching Excel Data to Java Class
/*Before writing the code ensure the excel sheet is saved in the 
  same folder(package folder) where class is saved*/
	
//2.2 declaring globally Workbook so that can access from different class
public static Workbook books;

//3.1 To access Sheet globally
public static Sheet sheets;

//1.0 Creating Object to read Excel's file(is in the form of rows and columns)
public static Object[][] readExcelData(String Sheetname){
		
//1.1 File can be fetched only by FileInputStream and referring as null
FileInputStream file=null;
		
/*1.2 Using try catch block to pass the path of the excel file
	  and to print FileNotFoundException*/
try {
    file=new FileInputStream("C:\\Users\\jeeth\\eclipse-workspace\\AssignmentYourStore\\src\\test\\java\\testDataDriven\\YourStoreExcelSheet.xlsx");
	}
	catch(FileNotFoundException e) {
		  e.printStackTrace();
	}
		
//2.0 Creating WorkBook
/*WorkbookFactory for creating the appropriate kind of Workbook (be it HSSFWorkbook 
  or XSSFWorkbook), by auto-detecting from the supplied input.*/
		
/*2.1 Using try catch block on WorkbookFactory to create workbook and auto detect 
	  the format of the file that  is passed in Step 3*/
try {
	books=WorkbookFactory.create(file);
	}
	catch (IOException a) {
		 a.printStackTrace();
	}
		
//3.0 To read specific sheet in the workbook
//Workbook_referenceVariable.getSheet(SheetName) and store it with a reference variable
//use import statement: poi.ss user model	
sheets=books.getSheet(Sheetname);
		
//4.0 Fetching data from the 2D array [rows and columns]
Object[][] table=new Object[sheets.getLastRowNum()][sheets.getRow(0).getLastCellNum()];
//4.1 To fetch data from two dimensional arrays we use for loop
for(int i=0;i<sheets.getLastRowNum();i++) {
//using for loop for columns
for(int k=0;k<sheets.getRow(0).getLastCellNum();k++) {
//4.2 Final o/p=get the row from second row(i+1) and column and convert it to the string
	table[i][k]=sheets.getRow(i+1).getCell(k).toString();
			}
		}
//5.0 return statement
		return table;
	}
}


