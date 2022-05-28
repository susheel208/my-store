package com.mystore.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.w3c.dom.DOMConfiguration;

import com.mystore.actiondriver.Action;
import com.mystore.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

// public static WebDriver driver;
	public static Properties pro;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		// Get Driver from ThreadLocalMap
		return driver.get();
	}

	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void beforeSuite() throws IOException {
		ExtentManager.setExtent();						//only to call the methods from the Extent Manager
	
		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "log4j2.xml";
		ConfigurationSource source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
		Configurator.initialize(null, source);
	}

	@BeforeTest(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() {

		try {
			pro = new Properties();

			File f = new File(System.getProperty("user.dir") + "\\Configuration\\config.properties");
			FileInputStream fi = new FileInputStream(f);

			pro.load(fi); // load the properties file

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

//	@Parameters("browser")
	public static void launchApp(String br) {

		WebDriverManager.chromedriver().setup();
		// String browserName = pro.getProperty("browser");

		if (br.equalsIgnoreCase("chrome")) {
			// driver = new ChromeDriver();
			// set browser to ThreadLocalmap
			driver.set(new ChromeDriver());
		} else if (br.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		} else if (br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			// driver = new EdgeDriver();
			driver.set(new EdgeDriver());
		}

		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 30);

		getDriver().get(pro.getProperty("url")); // it is driver.get(url) but our url is in the properties file
		getDriver().manage().window().maximize();

	}

	@Parameters("browser") // this is required
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browserss) {
		launchApp(browserss);

	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();

	}

	
	@AfterSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
