package com.selenium.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.selenium.actiondriver.Act;
import com.selenium.utility.GetScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	public ExtentTest extenttest;
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extentreports;

	public Logger logger = LogManager.getLogger(this.getClass().getSimpleName());

	@BeforeSuite
	public void reportsetup() {

		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/MyReport.html");
		htmlreporter.config().setDocumentTitle("Ext-Report");
		htmlreporter.config().setReportName("WebNetram-Automation Report");
		htmlreporter.config().setTheme(Theme.STANDARD);
		extentreports = new ExtentReports();
		extentreports.attachReporter(htmlreporter);
		extentreports.setSystemInfo("Project Name", "WebNetram");
		extentreports.setSystemInfo("QA Name", "Vimal Panchal");
		extentreports.setSystemInfo("OS", "Window 10");
		extentreports.setSystemInfo("Browser", "Chrome");
	}
	
	@BeforeTest
	public static void loadConfigFile() throws IOException {
		prop = new Properties();
		FileInputStream inputstream = new FileInputStream(
		System.getProperty("user.dir") + "/configuration/config.properties");
		prop.load(inputstream);
	}

	public static void launchApp() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else
			System.out.println("please select ohther browser");

		Act.getUrl(prop.getProperty("url"));
		Act.ImplicitWait(10);
		Act.maximizeWindow();
		
	}

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenShotPath = GetScreenShot.capture(driver, "screenShotName");
			extenttest.fail(result.getThrowable());
			extenttest.fail("Snapshot below: " + extenttest.addScreenCaptureFromPath(screenShotPath));
			
		}
		driver.quit();
	}
	
	@AfterSuite
	public void endreport()
	{
		extentreports.flush();
	}

}
