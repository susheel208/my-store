package com.mystore.testcases;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;




	@Test(groups = "Smoke")
	public void productAvailabiltyTest() throws Throwable {

		indexPage = new IndexPage();
		System.out.println("index page opened");
		Thread.sleep(2000);
		searchResultPage = indexPage.searchProduct("t-shirt");
		boolean result = searchResultPage.isProductAvailable();
		
		Assert.assertTrue(result);

	}
}
