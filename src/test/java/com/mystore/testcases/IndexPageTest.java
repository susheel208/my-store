package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.IndexPage;

public class IndexPageTest extends BaseClass {

	IndexPage indexpage;


	@Test(groups = "Smoke")
	public void verifyLogo() {
		indexpage = new IndexPage(); // craete an object to call the methhods
		boolean result = indexpage.validateLogo();
		Assert.assertTrue(result);
	}

	@Test(groups = "Smoke")
	public void verifyTitle() {

		String actTitle = indexpage.getMyStoreTitle();
		//System.out.println(actTitle);
		Assert.assertEquals(actTitle, "My Store1"); // right click > page source --> page title
		
	}

}
