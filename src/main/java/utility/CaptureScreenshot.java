package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class CaptureScreenshot extends TestBase
{
	public static String getDate()
	{
		return new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
		
	}
	public static void screenshot(String nameOfMethod) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Administrator\\Desktop\\Software testing Practicle\\eclipse-java-2023-09-R-win32-x86_64\\eclipse\\Selenium_28_Batch\\Screenshort\\" +nameOfMethod+"---"+getDate()+".jpeg");
							// (file path\\+nameOfMethod(Variable)+"----(separation)"+getDate()(it is method)+".jpeg(extention to store file"
		FileHandler.copy(source, dest);
	
	}

}
