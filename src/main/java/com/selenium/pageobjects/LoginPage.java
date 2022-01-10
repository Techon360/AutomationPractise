package com.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.actiondriver.Act;
import com.selenium.base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//input[@id='email_create']")) public WebElement emailId;
	
	@FindBy(xpath=("//input[@id='email']")) public WebElement userName;
	
	@FindBy(xpath=("//input[@id='passwd']")) public WebElement password; 
	
	@FindBy(xpath=("//button[@id='SubmitLogin']")) public WebElement signInButton;
	
	public HomePage loginUser()
	{
		Act.type(userName, prop.getProperty("username"));
		Act.type(password, prop.getProperty("passowrd"));
		Act.click(signInButton);
		return new HomePage();
	}
	
	public AddressPage loginUser1()
	{
		Act.type(userName, prop.getProperty("username"));
		Act.type(password, prop.getProperty("passowrd"));
		Act.click(signInButton);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount()
	{
		Act.typeAndEnter(emailId, Act.randomEmailId());
		return new AccountCreationPage();
	}

}
