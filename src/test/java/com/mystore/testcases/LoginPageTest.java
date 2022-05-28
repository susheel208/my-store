package com.mystore.testcases;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.utilities.Log;

public class LoginPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;




	@Test(groups = {"Smoke", "Sanity"}, dataProvider = "credentials" , dataProviderClass = DataProviders.class )
	public void loginTest(String uname, String pswd) {   // if the data is coming from external then only the arguments must be passed into the method
		
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("index page opened");
		loginPage = indexPage.clickOnSignIn(); 			// click on sign in btn its will give the login page object so store it
														// into thr login page object
		Log.info("signin btn clicked");		// this concept is called as page chaining model
		
		Log.info("entering Login details");
	//	homePage = loginPage.login(pro.getProperty("username"), pro.getProperty("password"));   // returns homepage so assigned to the homePage object
		homePage = loginPage.login(uname, pswd);
		String actualURL = getDriver().getCurrentUrl();
		String ExpectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualURL, ExpectedUrl);
		Log.info("Login is Successfull");
		Log.endTestCase("loginTest");
	}
}
