package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utility.CaptureScreenshot;
import utility.ReadData;
public class LoginPageTest  extends TestBase
{
	LoginPage login;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
	}
	//if enabled=false kiya to method kabhi bhi run nahi hogi
	@Test(enabled=true,priority=1,groups="Sanity")
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0,0); //Swag Labs (0,0)
		String actTitle=login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle, actTitle);
	}
	@Test(enabled=true,priority=3,groups={"Sanity","Retesting"})
	public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,1);//https://www.saucedemo.com/(0,1)
		String actURL=login.verifyURLOfApplication();
		Assert.assertEquals(expURL, actURL);
	}
	@Test(enabled=true,priority=2,groups="Regression" )
	public void loginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExcel(0,2);//https://www.saucedemo.com/inventory.html(0,2)
		String actURL=login.loginToApplication();
		Assert.assertEquals(expURL,actURL);
	}
	@AfterMethod (alwaysRun = true)
	//Screenshort ka code aftermethod likhate he
	public void closeBrowser(ITestResult it) throws IOException	//it is object create of ITestResult
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.screenshot(it.getName());
		}
		report.flush();    //report is obj in ExtendReportManager class
		driver.close();
	}

}

