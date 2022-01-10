package com.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.actiondriver.Act;
import com.selenium.base.BaseClass;

public class AccountCreationPage extends BaseClass {
	
	public AccountCreationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//h1[text()='Create an account']")) public WebElement formTitle;
	
	public boolean validateAcountCreatPage()
	{
		return Act.isElementDisplayed(formTitle);
		
	}

}
