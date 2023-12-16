package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage1 extends TestBase
{

	//object repositoy
	@FindBy(xpath="//span[@class='title']") private WebElement titleOfChkOutPg;
	@FindBy(xpath="//input[@name='firstName']") private WebElement firstnameTextBox;
	@FindBy(xpath="//input[@name='lastName']") private WebElement lastnameTextBox;
	@FindBy(xpath="//input[@name='postalCode']") private WebElement zopcodeTextBox;
	@FindBy(xpath="//input[@name='continue']") private WebElement continueBtn;
	
	public CheckOutPage1()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyURLOfApplicatio()
	{
		return driver.getCurrentUrl();
		
	}
	public String verifyTitleOfApplication()
	{
		return titleOfChkOutPg.getText();
		
	}
	public String Inputinformation()
	{
		firstnameTextBox.sendKeys("Yogita");
		lastnameTextBox.sendKeys("Thube");
		zopcodeTextBox.sendKeys("411105");
		continueBtn.click();
		return driver.getCurrentUrl();
	}
}
