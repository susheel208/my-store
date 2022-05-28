package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;

public class HomePageTest extends BaseClass {
IndexPage indexPage;
LoginPage loginPage;
HomePage homePage;


@Test (groups = "Smoke")                  // testcase to validate wishlist
public void wishListTest() {

	indexPage = new IndexPage();
	System.out.println("index page opened");
	loginPage = indexPage.clickOnSignIn(); 			// click on sign in btn its will give the login page object so store it
													// into thr login page object
	System.out.println("signin btn clicked");		// this concept is called as page chaining model
	
	System.out.println("entering Login details");
	homePage = loginPage.login(pro.getProperty("username"), pro.getProperty("password"));   // returns homepage so assigned to the homePage object
	boolean result = homePage.validateMyWishList();
	Assert.assertTrue(result);
}

@Test(groups = "Smoke")
public void orderHistoryTest() {

	indexPage = new IndexPage();
	System.out.println("index page opened");
	loginPage = indexPage.clickOnSignIn(); 			// click on sign in btn its will give the login page object so store it
													// into thr login page object
	System.out.println("signin btn clicked");		// this concept is called as page chaining model
	
	System.out.println("entering Login details");
	homePage = loginPage.login(pro.getProperty("username"), pro.getProperty("password"));   // returns homepage so assigned to the homePage object
	boolean result = homePage.validateOrderHistory();
	Assert.assertTrue(result);
}
}