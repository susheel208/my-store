/**
 * 
 */
package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Sandip
 *
 */
public class AddToCartPage extends BaseClass {
	
	//Action action= new Action();
	
	@FindBy(id="quantity_wanted")
	private WebElement quantity;
	
	@FindBy(name="group_1")
	private WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@class = \"icon-ok\"]")		//
	private WebElement addToCartMessag;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;

	public AddToCartPage() {
		PageFactory.initElements( getDriver(), this);
	}
	public void enterQuanty(String quantity1) {
		Action.type(quantity, quantity1);
	}
	public void selectSize(String size1) {
		Action.selectByVisibleText(size1, size);		//(visible_text ,webelement)
	}
	public void clickOnAddToCart() {
		Action.click(getDriver(), addToCartBtn);
		
	} public boolean validateAddToCart() {				   // after clicking on the addcart, checking for msg that conf
		Action.fluentWait(getDriver(), addToCartMessag, 10);  //msg is taking time to display
		return Action.isDisplayed(getDriver(),addToCartMessag);
	}
	public OrderPage clickOnCheckOut() throws Exception {
		Action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
		Action.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}
	
	
	
}
	
	
	
	