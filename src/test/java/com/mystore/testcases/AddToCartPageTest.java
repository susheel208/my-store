package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AccountCreationPage;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.SearchResultPage;

public class AddToCartPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;

	@Test(groups = {"Regression" , "Sanity"})
	public void AadToCartPageTest() throws Throwable {

		indexPage = new IndexPage();
		System.out.println("index page opened");
		Thread.sleep(2000);
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuanty("2");

		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		boolean result = addToCartPage.validateAddToCart();
		Assert.assertTrue(result);

	}

}
