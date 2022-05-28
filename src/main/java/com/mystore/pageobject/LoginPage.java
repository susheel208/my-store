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
public class LoginPage extends BaseClass{

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy (id = "email")
	WebElement userName;
	
	@FindBy (id = "passwd")
	WebElement password;
	
	@FindBy  (id = "SubmitLogin")
	WebElement signInBtn;
	
	@FindBy  (id="email_create")
	WebElement emailForNewAccount;
	
	@FindBy  (id="SubmitCreate")
	WebElement createNewccountBtn;
	
	
	// UserActionMethods
	
	public HomePage login(String uname, String pswd) {            // navigation
		Action.type(userName, uname);   //webelement , data
		Action.type(password, pswd);
		Action.click(getDriver(), signInBtn);
		return new HomePage();             // navigation to home page
	}
	
	public AddressPage login1(String uname, String pswd) {
		Action.type(userName, uname);   //webelement , data
		Action.type(password, pswd);
		Action.click(getDriver(), signInBtn);
		return new AddressPage();        // navigation to address page person who has done booked his order.
	}
	
	public AccountCreationPage createNewAccount(String newEmail ){
		Action.type(emailForNewAccount, newEmail); 
		Action.click(getDriver(), createNewccountBtn);
	return new AccountCreationPage();
	
	}
}

	
