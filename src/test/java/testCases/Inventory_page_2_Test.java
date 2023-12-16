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
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class Inventory_page_2_Test extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2();
		login.loginToApplication();
				
		
	}
	@Test(enabled=true,priority=0,groups="Sanity" )
	public void verifyproductsLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel=ReadData.readExcel(0,3); //Products(0,3)
		String actLabel=invent.verifyproductsLabel();
		Assert.assertEquals(expLabel,actLabel);
		Reporter.log("Label of Inventory Page="+actLabel);
	}
	@Test(enabled=true,priority=1)
	public void verifyMenuBtnTest() throws EncryptedDocumentException, IOException
	{
		String expMenu=ReadData.readExcel(0,4); //Open Menu(0,4)
		String actMenu=invent.verifyMenuBtn();
		Assert.assertEquals(expMenu,actMenu);
		Reporter.log("Menu Button is Display="+actMenu);
	}
	@Test(enabled=true,groups="Retesting")
	public void verifytwitterLogoTest()
	{
		boolean result=invent.verifytwitterLogo();
		Assert.assertEquals(result,true);
		Reporter.log("Visibility of Twitter Logo="+result);
	}
	@Test(enabled=true)
	public void verifyFacebookLogoTest()
	{
		boolean r1=invent.verifyFacebookLogo();
		Assert.assertEquals(r1, true);
		Reporter.log("Visibility of Facebook Logo="+r1);
	}
	@Test(enabled=true)
	public void verifyLinkedinLogoTest()
	{
		boolean r2=invent.verifyLinkedinLogo();
		Assert.assertEquals(r2, true);
		Reporter.log("Visibility of LinkedIn Logo ="+r2);
	}
	
	@Test(enabled=true,priority=2,groups={"Retesting","Regression"})
	public void add6Products() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0,5); //6(0,5)
		String actCount=invent.add6Products();
		Assert.assertEquals(expCount,actCount);
		Reporter.log("Total Product added to cart="+actCount);
	}
	@Test(enabled=true,priority=3,groups={"Retesting","Regression"})
	public void remove2ProductsTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0,6); //4 (0,6)
		String actCount=invent.remove2Products();
		Assert.assertEquals(expCount,actCount);
		Reporter.log("Count of Product after removing="+actCount);
	}
	/*@Test
	
	public void verifyFooterCopyTest()
	{
		boolean Footerresult=invent.verifyFooterCopy();
		Assert.assertEquals(Footerresult, true);
		Reporter.log("Verifying visibility of footer copy text="+Footerresult);
	}*/
	
	@AfterMethod (alwaysRun = true)
	//Screenshort ka code aftermethod likhate he
		public void closeBrowser(ITestResult it) throws IOException	//it is object create of ITestResult
		{
			if(it.FAILURE==it.getStatus())
			{
				CaptureScreenshot.screenshot(it.getName());
			}	
			driver.close();
		}

	
}
