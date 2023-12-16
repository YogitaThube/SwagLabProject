package testCases;


import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class Cart_Page_Test  extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	Cart_Page cartPage;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2();
		cartPage=new Cart_Page();
		login.loginToApplication();
		invent.add6Products();
		invent.ClickcartCout();
	}
	@Test(enabled=true,priority=0)
	public void verifyCartPageURLTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,7);//"https://www.saucedemo.com/cart.html"
		String actURL=cartPage.verifyCartPageURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL Of Cart Page Is="+actURL);
	}
	@Test(enabled=true,priority=1,dependsOnMethods = "verifyCartPageURLTest")
	public void verifyCartLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel=ReadData.readExcel(0,8);//Your Cart
		String actLabel=cartPage.verifyCartLabel();
		Assert.assertEquals(expLabel,actLabel);
		Reporter.log("Label of Cart Page is="+actLabel);
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
