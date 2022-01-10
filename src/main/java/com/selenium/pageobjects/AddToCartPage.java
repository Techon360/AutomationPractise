package com.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.actiondriver.Act;
import com.selenium.base.BaseClass;

public class AddToCartPage extends BaseClass {
	
	public AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id=("quantity_wanted")) public WebElement quantity;
	
	@FindBy(id=("group_1")) public WebElement size;
	
	@FindBy(xpath=("//button[@name='Submit']")) public WebElement addToCartButton;
	
	@FindBy(xpath=("//h2/i")) public WebElement addToCartMessage;
	
	@FindBy(xpath=("//span[contains(text(),'Proceed to checkout')]")) public WebElement checkOutButton;
	
	
	
	public void enterQuantity()
	{
		Act.type(quantity, "2");
		
	}
	
	public void selectSize()
	{
		Act.selectByVisibleText(size, "M");
		
	}
	
	public boolean validateAddToCartMessage()
	{
		Act.ExplicitWait(addToCartMessage, 5);
		return Act.isElementDisplayed(addToCartMessage);
		
	}
	
	public OrderPage clickOnCheckOutButton()
	{
		Act.click(checkOutButton);
		return new OrderPage();
		
	}
	
	public void clickAddToCartButton()
	{
		Act.click(addToCartButton);
		
		
	}

}
