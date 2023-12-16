package testCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.CaptureScreenshot;

public class VerifyMultipleCredentialsTest extends TestBase
{
	LoginPage login;
	@BeforeMethod(alwaysRun=true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
	}
	@DataProvider(name="Credentials")
	public Object[][] getData()
	{
		return new Object[][] 
				{
							// Username and passworld are given in swag lab page
					{"standard_user","secret_sauce"},
					{"locked_out_user","secret_sauce"},
					{"problem_user","secret_sauce"},
					{"performance_glitch_user","secret_sauce"},
					{"error_user","secret_sauce"},
					{"visual_user","secret_sauce"}
					
					/* some another example of username and passworld
				{"standard_user","secret_sauce"},	//correct username,correct Passworld
				{"standard_user","secret_sauce1"},	//correct username,incorrect passworld
				{"standard_user1","secret_sauce"},	//Incorrect username,correct passworld
				{"standard_user1","secret_sauce1"}	//incorrect username,incorrect passworld */
				
					
				
				};
	}
	
	@Test (dataProvider = "Credentials")
	public void loginToApplicationWithMultipleCredentialsTest(String un,String pass) 
	{
		SoftAssert s =new SoftAssert();
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=login.loginToApplicationMultiCreds(un, pass);
		s.assertEquals(expURL,actURL);
		s.assertAll();
		
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException	//it is object create of ITestResult
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.screenshot(it.getName());
		}	
		driver.close();
	}	
}

