package com.selenium.actiondriver;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.base.BaseClass;

public  class Act extends BaseClass {
	
	public static void click(WebElement element)
	{
		element.click();
	}
	
	public static void jsClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("Argument[0].click();", element);
	}
	
	public static void type(WebElement element, String text)
	{
		element.clear();
		element.sendKeys(text);
	}
	
	public static void typeAndEnter(WebElement element, String text)
	{
		element.clear();
		element.sendKeys(text, Keys.ENTER);
	}
	
	public static void getUrl(String url)
	{
		driver.get(url);
	}
	
	public static boolean isElementDisplayed(WebElement element)
	{
		return element.isDisplayed();
	}
	
	public static void selectByIndex(WebElement element, int byIndex)
	{
		Select sel=new Select(element);
		sel.selectByIndex(byIndex);
	}
	
	public static void selectByValue(WebElement element, String byValue)
	{
		Select sel=new Select(element);
		sel.selectByValue(byValue);
	}
	
	public static void selectByVisibleText(WebElement element, String byVisibleText)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(byVisibleText);
	}
	
	public static void ImplicitWait( int timeInSecond)
	{
		driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
	}
	
	public static void ExplicitWait(WebElement element, int timeInSecond)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeInSecond);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void fluentWait(WebElement element, int timeInSecond)
	{
		FluentWait wait=new FluentWait(driver);
		wait.withTimeout(15, TimeUnit.SECONDS);
		wait.pollingEvery(timeInSecond, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
	}
	
	public static String getCurrentPageTitle()
	{
		return driver.getTitle();
	}
	
	public static String getText(WebElement element)
	{
		return element.getText();
	}
	
	public static void maximizeWindow()
	{
		driver.manage().window().maximize();
	}
	
	public static String randomEmailId()
	{
		String emailid=RandomStringUtils.randomAlphabetic(5)+"98@gmail.com";
		return emailid;
	}
	
	

}
