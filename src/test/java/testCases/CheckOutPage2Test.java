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
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class CheckOutPage2Test extends TestBase
{

	LoginPage login;
	Inventory_page_2 invent;
	Cart_Page cartPage;
	CheckOutPage1 check1;
	CheckOutPage2 check2;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2();
		cartPage=new Cart_Page();
		check1=new CheckOutPage1();
		check2=new CheckOutPage2();
		login.loginToApplication();
		invent.add6Products();
		invent.ClickcartCout();
		cartPage.verifyCheckoutBtn();
		check1.Inputinformation();	//Inputinformation() function liye bcoz continueBtn vha present he our different menthod bhi create kr sakte he ham  
		
	}
	@Test(enabled=true,priority=0)
	public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,12);//https://www.saucedemo.com/checkout-step-two.html
		String actURL=check2.verifyURLOfApplication();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("Current URL of Check Out Page2="+actURL);
	}
	@Test(enabled=true,priority=1,dependsOnMethods = "verifyURLOfApplicationTest")
	public void verifyLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel=ReadData.readExcel(0,13);//Checkout: Overview
		String actLabel=check2.verifyLabel();
		Assert.assertEquals(expLabel,actLabel);
		Reporter.log("Label of Check 2 Page="+actLabel);
	}
	@Test(enabled=true,priority=3)
	public void verifyDiscriptionTest() throws EncryptedDocumentException, IOException
	{
		String expDis=ReadData.readExcel(0,14);//Description
		String actDis=check2.verifyDiscription();
		Assert.assertEquals(expDis,actDis);
		Reporter.log("Discription Label of Check Out Page 2"+actDis);
	}
	@Test(enabled=true,priority=2)
	public void verifyQTYLabelTest() throws EncryptedDocumentException, IOException
	{
		String expQTY=ReadData.readExcel(0,15);//QTY
		String actQTY=check2.verifyQTYLabel();
		Assert.assertEquals(expQTY,actQTY);
		Reporter.log("QTY Label of Check Out Page 2"+actQTY);
	}
	@Test(enabled=true,priority=4)
	public void verifyPaymentLabelTest()
	{
		boolean paymentLabel=check2.verifyPaymentLabel();
		Assert.assertEquals(paymentLabel, true);
		Reporter.log("Visibility of Payment Information ="+paymentLabel);
	}
	@Test(enabled=true,priority=6)
	public void verifyShippingLabelTest()
	{
		boolean shippingLabel=check2.verifyShippingLabel();
		Assert.assertEquals(shippingLabel, true);
		Reporter.log("Visibility of Shipping Information ="+shippingLabel);
	}
	@Test(enabled=true,priority=5)
	public void verifyPriceTotalLabelTest()
	{
		boolean PriceLabel=check2.verifyPriceTotalLabel();
		Assert.assertEquals(PriceLabel, true);
		Reporter.log("Visibility of Price Total Information ="+PriceLabel);
	}
	@Test(enabled=true,priority=7)
	public void verifyTotalLabelTest()
	{
		boolean TotalLabel=check2.verifyTotalLabel();
		Assert.assertEquals(TotalLabel, true);
		Reporter.log("Visibility of Total Information of All Products ="+TotalLabel);
	}
	@Test(enabled=true,priority=8)
	public void ClickOnCancelBtnTest() throws EncryptedDocumentException, IOException
	{
		String expcancelURL=ReadData.readExcel(0,16);//https://www.saucedemo.com/inventory.html
		String actcancelURL=check2.ClickOnCancelBtn();
		Assert.assertEquals(expcancelURL,actcancelURL);
		Reporter.log("Verify Functionali of Cancel Button on checkout page="+actcancelURL);
	}
	@Test(enabled=true,priority=9,dependsOnMethods = "verifyURLOfApplicationTest")
	public void ClickOnFinishBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,17);//https://www.saucedemo.com/checkout-complete.html
		String actURL=check2.ClickOnFinishBtn();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("URL of complete Page="+actURL);
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
