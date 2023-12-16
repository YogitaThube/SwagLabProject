package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{
	//object repository
	@FindBy(xpath="//input[@name='user-name']") private WebElement userTxtBox;
	@FindBy(xpath="//input[@name='password']") private WebElement passwordTxtBox;
	@FindBy(xpath="//input[@name='login-button']") private WebElement loginBtn;
	
	
	public LoginPage()	//constructor
	{
		PageFactory.initElements(driver, this);
	}
	public String loginToApplication() 
	{
		logger=report.createTest("Login to Sauce Lab Application");	//logger is object,created in TestBase class in base folder
		userTxtBox.sendKeys("standard_user");
		logger.log(Status.INFO, "UserName is Entered");
		passwordTxtBox.sendKeys("secret_sauce");
		logger.log(Status.INFO, "passworld is Entered");
		loginBtn.click();
		logger.log(Status.INFO, "Login Button is Click");
		logger.log(Status.PASS, "Logging is Sucessful");
		return driver.getCurrentUrl();
		
	}
	/*
	public String loginToApplication() throws IOException	//method
	{
		userTxtBox.sendKeys(ReadData.readPropertyFile("UserName"));	//username from config properties
		passwordTxtBox.sendKeys(ReadData.readPropertyFile("Passworld"));	////passworld from config properties
		loginBtn.click();
		return driver.getCurrentUrl();
	}*/
	public String loginToApplicationMultiCreds(String un,String pass)	//This method of accept multiple username and passworld
	{
		userTxtBox.sendKeys(un);
		passwordTxtBox.sendKeys(pass);
		loginBtn.click();
		return driver.getCurrentUrl();

	}
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
	}
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
	}
	
}