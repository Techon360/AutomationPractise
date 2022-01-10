package com.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.actiondriver.Act;
import com.selenium.base.BaseClass;

public class SearchResultPage  extends BaseClass{
	
	public SearchResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")) public WebElement productResult;
	
	public boolean isProductAvailable()
	{
		return Act.isElementDisplayed(productResult);
		
	}
	
	public AddToCartPage clickOnProduct()
	{
		Act.click(productResult);
		return new AddToCartPage();
	}

}
