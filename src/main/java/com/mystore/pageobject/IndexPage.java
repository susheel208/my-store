package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	public IndexPage() {
		
		PageFactory.initElements(getDriver(), this);  // here "this" will intalize the all the page objects of the class 
	}
	

	@FindBy (xpath =  "//a[@class = 'login']")
	WebElement signInBtn;  // webElement name from user side
	
	@FindBy (xpath =  "//*[@id='header_logo']/a/img")
	WebElement myStoreLogo;

	@FindBy (xpath = "//*[@id=\"search_query_top\"]")
	WebElement searchProductBox;
	
	@FindBy (name = "submit_search")
	WebElement searchButton;
	
	
	// user actions methods
	
	public LoginPage clickOnSignIn() {
		
		Action.click(getDriver(), signInBtn);
		return new LoginPage();              // this will link the login Page, it is actually "creating + returning" the object of loginpage 
		
	}
	
	public boolean validateLogo() {
		return  Action.isDisplayed(getDriver(), myStoreLogo);     // isDIspalyed is Boolean
	}
	
	public  String getMyStoreTitle() {
	String mystoreTitle = getDriver().getTitle();
		return mystoreTitle;
	}
	
	public SearchResultPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), searchButton);  // when we click the saerch btn it will return the search result page
		return new SearchResultPage();
		
	}
}
