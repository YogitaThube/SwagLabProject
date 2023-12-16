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
import pages.CheckOutPage2;
import pages.CompletePage;
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class CompletePageTest extends TestBase
{

	LoginPage login;
	Inventory_page_2 invent;
	Cart_Page cartPage;
	CheckOutPage1 check1;
	CheckOutPage2 check2;
	CompletePage complete;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2();
		cartPage=new Cart_Page();
		check1=new CheckOutPage1();
		check2=new CheckOutPage2();
		complete=new CompletePage();
		login.loginToApplication();
		invent.add6Products();
		invent.ClickcartCout();
		cartPage.verifyCheckoutBtn();
		check1.Inputinformation();	//continue Btn
		check2.ClickOnFinishBtn();
		
	}
	@Test(enabled=true,priority=0,dependsOnMethods = "verifyOrderDispatchTextTest")
	public void verifyCompleteLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel=ReadData.readExcel(0,18);//Checkout: Complete!
		String actLabel=complete.verifyCompleteLabel();
		Assert.assertEquals(expLabel,actLabel);
		Reporter.log("Verify Complete Label final Page="+actLabel);
	}
	@Test(enabled=true,priority=2)
	public void verifyImgLogoTest()
	{
		boolean imgLogo=complete.verifyImgLogo();
		Assert.assertEquals(imgLogo, true);
		Reporter.log("Visibility of Img Logo ="+imgLogo);
	}
	@Test(enabled=true,priority=4)
	public void verifyThankYouTextTest()
	{
		boolean ThankUTxt=complete.verifyThankYouText();
		Assert.assertEquals(ThankUTxt, true);
		Reporter.log("Visibility of Thank You Text ="+ThankUTxt);
	}
	@Test(enabled=true,priority=1)
	public void verifyOrderDispatchTextTest() throws EncryptedDocumentException, IOException
	{
		String expTxt=ReadData.readExcel(0,19);//Your order has been dispatched, and will arrive just as fast as the pony can get there!
		String actTxt=complete.verifyOrderDispatchText();
		Assert.assertEquals(expTxt,actTxt);
		Reporter.log("Visible of Order Dispatch and arrive text="+actTxt);
	}
	
	@Test(enabled=true,priority=3,dependsOnMethods = "verifyOrderDispatchTextTest")
	public void BackHomeBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,20);//https://www.saucedemo.com/inventory.html
		String actURL=complete.BackHomeBtn();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("Verify URL of Complete Page="+actURL);
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
