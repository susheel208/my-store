/**
 * 
 */
package com.mystore.pageobject;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
/**
 * @author Sandip
 *
 */
public class OrderPage extends BaseClass {
	
	//Action action= new Action();
	
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	private WebElement unitPrice;
	
	@FindBy(id="total_price")
	private WebElement totalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice() {
		Action.fluentWait(getDriver(), unitPrice, 10);  //page is loading 
		String unitPrice1 = unitPrice.getText();
		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]","");  // output is string
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;			// this give value in decimals
		
	}
	public double getTotalPrice() {
		String totalPrice1 = totalPrice.getText();
		String tot = totalPrice1.replaceAll("[^a-zA-Z0-9]","");  // this will remove all the special carates like "dollar, . "
		double finalTotalPrice=Double.parseDouble(tot);
		return finalTotalPrice/100;			// this give value in decimals
		
	}
	
	public LoginPage clickOnCheckOut() {
		Action.click(getDriver(), proceedToCheckOut);
		return new LoginPage();
	}











}

