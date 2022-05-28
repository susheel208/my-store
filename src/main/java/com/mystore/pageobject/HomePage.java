package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//span[text()='My wishlists']")
	private WebElement myWishList;

	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;

	public boolean validateMyWishList() {
		return Action.isDisplayed(getDriver(), myWishList); // task is visible or not
	}

	public boolean validateOrderHistory(){
		return Action.isDisplayed(getDriver(), orderHistory);
		}
}
