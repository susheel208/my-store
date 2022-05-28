package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.SearchResultPage;

public class OrderPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;

	@Test(groups = "Regression")
	public void verifyTotalPrice() throws Throwable {

		indexPage = new IndexPage();
		System.out.println("index page opened");
		Thread.sleep(2000);
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuanty("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnCheckOut(); // returns the orderpage object

		// verfing the caluclataions
		double unitPrice = orderPage.getUnitPrice();
		double totalPrice = orderPage.getTotalPrice();		// expected value
		double expectedPrice = (unitPrice * 2) + 2 ;      // actual value
		System.out.println(unitPrice);
		System.out.println(totalPrice);
		System.out.println(expectedPrice);
		Assert.assertEquals(expectedPrice, totalPrice );

	}

}
