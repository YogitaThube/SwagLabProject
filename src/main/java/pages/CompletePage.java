package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CompletePage extends TestBase
{

	//object repository
	@FindBy(xpath="//span[@class='title']") private WebElement CheckOutCompleteLabel;
	
	@FindBy(xpath="//img[@class='pony_express']") private WebElement ImgLogo;
	
	@FindBy(xpath="//h2[@class='complete-header']") private WebElement ThankYouTxt;
	
	@FindBy(xpath="//div[@class='complete-text']") private WebElement OrderDispatchTxt;
	
	@FindBy(xpath="//button[@name='back-to-products']") private WebElement backHomeBtn;
	
	public CompletePage()	//constructor
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyCompleteLabel()
	{
		return CheckOutCompleteLabel.getText();
	}
	public boolean verifyImgLogo()
	{
		return ImgLogo.isDisplayed();
	}
	public boolean verifyThankYouText()
	{
		return ThankYouTxt.isDisplayed();
	}
	public String verifyOrderDispatchText()
	{
		return OrderDispatchTxt.getText();
		
	}
	public String BackHomeBtn()
	{
		backHomeBtn.click();
		return driver.getCurrentUrl();
	}
	
}
