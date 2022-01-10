package com.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.actiondriver.Act;
import com.selenium.base.BaseClass;

public class IndexPage extends BaseClass{
	
	public IndexPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id=("search_query_top")) public WebElement productSearchBox;
	
	@FindBy(xpath=("//a[contains(text(),'Sign in')]")) public WebElement signButton;
	
	@FindBy(xpath=("//img[@class='logo img-responsive']")) public WebElement myStoreLogo; 

	@FindBy(xpath=("//button[@name='submit_search']")) public WebElement searchButton;
	
	public LoginPage clickOnSignIn()
	{
		Act.click(signButton);
		return new LoginPage();
	}
	
	public boolean validatLogo()
	{
		return Act.isElementDisplayed(myStoreLogo);
	}
	
	public String myStoreTitle()
	{
		return Act.getCurrentPageTitle();
	}
	
	public SearchResultPage searchProduct()
	{
		Act.typeAndEnter(productSearchBox, "t-shirt");
		return new SearchResultPage();
	}
}
