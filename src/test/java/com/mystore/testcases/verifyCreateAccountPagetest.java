package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AccountCreationPage;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;

public class verifyCreateAccountPagetest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accPage;

	@Test(groups = "Sanity")
	public void verifyAccountCreationTest() throws Throwable {

		indexPage = new IndexPage();
		System.out.println("index page opened");
		loginPage = indexPage.clickOnSignIn(); // click on sign in btn its will give the login page object so store it
		System.out.println("signin btn clicked");

		accPage = loginPage.createNewAccount("asdfewrst@gmail.com"); // returns the AccountCreationPage object.
		System.out.println("account created successfully");

		boolean result =  accPage.validateAcountCreatePage();  //from AccountCreationPage object we are calling the method
		Assert.assertTrue(result);

	}
}
