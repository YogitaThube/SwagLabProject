package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart_Page extends TestBase	//testBase extends bcoz driver use karna he
{
	//object repository
	@FindBy(xpath="//span[@class='title']") private WebElement label;
	@FindBy(xpath="//button[@name='checkout']") private WebElement checkoutBtn;
	
	public Cart_Page()	//constructor=constructure is same name of class & not given to any return type like void and string
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyCartPageURL()
	{
		return driver.getCurrentUrl();
		
	}
	public String verifyCartLabel()
	{
		return label.getText();
		
	}
	public void verifyCheckoutBtn()
	{
		 checkoutBtn.click();
		
	}
	
	
}
