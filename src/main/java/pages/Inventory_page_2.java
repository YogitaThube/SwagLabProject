package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.HandleDropdownList;

public class Inventory_page_2 extends TestBase
{
	//object repository
	@FindBy (xpath="//span[@class='title']") private WebElement productsLable;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement CartCount;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement dropDown;
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") private WebElement MenuBtn;
	//element Added
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPackProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTShirt;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleeceJacket;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement Onesie;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement TshirtRed;	
	//element remove
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']") private WebElement removeOnesie;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement removeBikeLight;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeBoltTshirt;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removeRedTShirt;
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement removebackpack;
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removeFleeceJacket;
	
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement FacebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement LinkedinLogo;
	
	@FindBy(xpath="div[@class='footer_copy']") private WebElement FooterCopy;

	
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement ClickcartCoutBag;
	//constructor
	public Inventory_page_2()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyproductsLabel()
	{
		return productsLable.getText();
		
	}
	public boolean verifyFooterCopy()
	{
		return FooterCopy.isDisplayed();
		
	}
	public String verifyMenuBtn()
	{
		return MenuBtn.getText();
		
	}
	public boolean verifytwitterLogo()
	{
		return twitterLogo.isDisplayed();
	}
	public boolean verifyFacebookLogo()
	{
		return FacebookLogo.isDisplayed();
		
	}
	public boolean verifyLinkedinLogo()
	{
		return LinkedinLogo.isDisplayed();
		
	}
	
	public String add6Products()
	{
		HandleDropdownList.handleSelectClass(dropDown,"Price (low to high)");
		
		backPackProduct.click();
		bikeLightProduct.click();
		boltTShirt.click();
		fleeceJacket.click();
		Onesie.click();
		TshirtRed.click();
		return CartCount.getText();
		
	}
	public String remove2Products() 
	{
		add6Products();
		removebackpack.click();
		removeBikeLight.click();
		return CartCount.getText();
	}
	public void ClickcartCout()
	{
		ClickcartCoutBag.click();
	}
}
