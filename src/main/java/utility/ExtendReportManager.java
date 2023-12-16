package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class ExtendReportManager extends TestBase
{
	static ExtentReports report;
	public static ExtentReports getReportInstance()
	{
		if(report==null)
		{
			String reportName = new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
			ExtentHtmlReporter htmlReporter =new ExtentHtmlReporter("C:\\Users\\Administrator\\Desktop\\Software testing Practicle\\eclipse-java-2023-09-R-win32-x86_64\\eclipse\\Selenium_28_Batch\\ExtentReport\\report.html");
				//("xpath\\report(It is filename).html")
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
			report.setSystemInfo("OS","Windows");
			report.setSystemInfo("Enviroment","SIT");
			report.setSystemInfo("Build Number","102.02.02.126");
			report.setSystemInfo("Browser","Chrome");
			htmlReporter.config().setReportName("UI Test Report");
		}
		
		return report;
		
	}
}
