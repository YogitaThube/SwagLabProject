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
import pages.CheckOutPage1;
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class CheckOutPage1_Test extends TestBase
{
	
	LoginPage login;
	Inventory_page_2 invent;
	Cart_Page cartPage;
	CheckOutPage1 check1;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2();
		cartPage=new Cart_Page();
		check1=new CheckOutPage1();
		login.loginToApplication();
		invent.add6Products();
		invent.ClickcartCout();
		cartPage.verifyCheckoutBtn();
		
	}
	@Test(enabled=true,priority=0)
	public void verifyURLOfApplicatioTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,9);//https://www.saucedemo.com/checkout-step-one.html
		String actURL=check1.verifyURLOfApplicatio();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("URL of CheckOut Page="+actURL);
	}
	@Test(enabled=true,priority=1,dependsOnMethods = "verifyURLOfApplicatioTest")
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0,10); //Checkout: Your Information
		String actTitle=check1.verifyTitleOfApplication();
		Assert.assertEquals(expTitle,actTitle);
		Reporter.log("Tital of check out page applicaion="+actTitle);
	}
	@Test(enabled=true,priority=2,dependsOnMethods = "verifyURLOfApplicatioTest")
	public void InputinformationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,11); //https://www.saucedemo.com/checkout-step-two.html
		String actURL=check1.Inputinformation();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("Title of check out page 2="+actURL);
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
