package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage2 extends TestBase
{

	//object repository
	@FindBy(xpath="//span[@class='title']") private WebElement checkoutpage2label;
	
	@FindBy(xpath="//div[@class='cart_desc_label']") private WebElement Discription;
	@FindBy(xpath="//div[@class='cart_quantity_label']") private WebElement QTYlabel;
	
	@FindBy(xpath="//div[@class='summary_info_label']") private WebElement PaymentLabel;
	@FindBy(xpath="//div[@class='summary_info_label']") private WebElement Shippinglabel;
	@FindBy(xpath="//div[@class='summary_info_label']") private WebElement priceTotal;
	@FindBy(xpath="//div[@class='summary_info_label']") private WebElement Total;
	
	@FindBy(xpath="//button[@name='cancel']") private WebElement cancelBtn;
	@FindBy(xpath="//button[@name='finish']") private WebElement finishBtn; 
	
	public CheckOutPage2()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyLabel()
	{
		return checkoutpage2label.getText();
		
	}
	public String verifyDiscription() 
	{
		 return Discription.getText();
	}
	public String verifyQTYLabel()
	{
		return QTYlabel.getText();
	}
	public boolean verifyPaymentLabel()
	{
		return PaymentLabel.isDisplayed();
	}
	public boolean verifyShippingLabel()
	{
		return Shippinglabel.isDisplayed();
	}
	public boolean verifyPriceTotalLabel()
	{
		return priceTotal.isDisplayed();
	}
	public boolean verifyTotalLabel()
	{
		return Total.isDisplayed();
	}
	public String ClickOnCancelBtn()
	{
		cancelBtn.click();
		return driver.getCurrentUrl();
	}
	public String ClickOnFinishBtn()
	{
		finishBtn.click();
		return driver.getCurrentUrl();
	}
}
