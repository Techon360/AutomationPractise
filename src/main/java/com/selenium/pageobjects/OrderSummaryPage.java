package com.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.actiondriver.Act;
import com.selenium.base.BaseClass;

public class OrderSummaryPage  extends BaseClass{
	
	public OrderSummaryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath=("//button[@type='submit']/span[text()='I confirm my order']")) public WebElement confirmOrderButton;
	
	
	
	public OrderConfirmationPage clickOnConfirmOrderButton()
	{
		confirmOrderButton.click();
		return new OrderConfirmationPage();
		
	}

}
