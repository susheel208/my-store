package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.AddressPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.OrderSummary;
import com.mystore.pageobject.PaymentPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.ShippingPage;

public class EndToEndTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummary orderSummary;
	OrderConfirmationPage orderConfirmationPage;
	
	@Test(groups = "Regression")
	public void endToEndTest() throws Throwable {

		indexPage = new IndexPage();
		System.out.println("index page opened");
		Thread.sleep(2000);
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuanty("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnCheckOut(); // returns the orderpage object
		loginPage = orderPage.clickOnCheckOut();  //opens the login page
		addressPage =loginPage.login1(pro.getProperty("username"), pro.getProperty("password"));
		shippingPage =	addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		
		paymentPage = shippingPage.clickOnProceedToCheckOut();
		orderSummary = paymentPage.clickOnPaymentMethod();
		orderConfirmationPage = orderSummary.clickOnconfirmOrderBtn();
		String ActualMessage = orderConfirmationPage.validateConfirmMessage();
		
		String expectedMessage = "Your order on My Store is complete.";
		
		Assert.assertEquals(ActualMessage, expectedMessage );

	}

}
