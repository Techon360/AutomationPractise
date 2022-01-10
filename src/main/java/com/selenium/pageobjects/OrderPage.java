package com.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.actiondriver.Act;
import com.selenium.base.BaseClass;

public class OrderPage extends BaseClass {
	
	public OrderPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//td[@class='cart_unit']/span/span")) public WebElement unitPrice;
	
	@FindBy(xpath=("//span[@id='total_price']")) public WebElement totalPrice;
	
	@FindBy(xpath=("//span[text()='Proceed to checkout']")) public WebElement proceedToCheckout;
	
	
	
	
	public double getUnitPrice()
	{
		String unitPrice1=Act.getText(unitPrice);
		String unitPrice2=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalunitPrice=Double.parseDouble(unitPrice2);
		return finalunitPrice/100;	
	}
	
	public double getTotalPrice()
	{
		String totalPrice1=Act.getText(totalPrice);
		String totalPrice2=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finaltotalPrice=Double.parseDouble(totalPrice2);
		return finaltotalPrice/100;	
	}
	
	public LoginPage clickOnProceedToCheckOut()
	{
		Act.click(proceedToCheckout);
		return new LoginPage();
	}
}
