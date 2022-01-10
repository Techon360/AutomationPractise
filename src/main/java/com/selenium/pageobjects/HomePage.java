 package com.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.actiondriver.Act;
import com.selenium.base.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//span[text()='My wishlists']")) public WebElement wishList;
	
	@FindBy(xpath=("//span[text()='Order history and details']")) public WebElement orderHistory;
	
	public boolean validatWishList()
	{
		return Act.isElementDisplayed(wishList);
	}
	
	public boolean validatOrderHistory()
	{
		return Act.isElementDisplayed(orderHistory);
	}
}
