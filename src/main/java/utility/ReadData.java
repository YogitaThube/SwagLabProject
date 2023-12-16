package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData
{
	public static String readPropertyFile(String value) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\Administrator\\Desktop\\Software testing Practicle\\eclipse-java-2023-09-R-win32-x86_64\\eclipse\\Selenium_28_Batch\\TestData\\config.properties");
		prop.load(file);
		return prop.getProperty(value);	//value menas URL pass	
	}
	public static String readExcel(int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Administrator\\Desktop\\Software testing Practicle\\eclipse-java-2023-09-R-win32-x86_64\\eclipse\\Selenium_28_Batch\\TestData\\Book1.xlsx"); //book1 path  
		Sheet es = WorkbookFactory.create(file).getSheet("Sheet1");
		String value =es.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;
	}
	
}
