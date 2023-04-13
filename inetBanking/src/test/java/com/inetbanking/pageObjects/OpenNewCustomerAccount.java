package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OpenNewCustomerAccount {
	
	WebDriver ldriver;
	
	public OpenNewCustomerAccount(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Account')]")
	@CacheLookup
	WebElement createAccount;
	
	@FindBy(how = How.NAME, using = "cusid")
	@CacheLookup
	WebElement customerID;
	
//	@FindBy(how = How.XPATH, using = "//tbody/tr[3]/td[2]/select[1]")
//	@CacheLookup
//	WebElement accountType;
	
	@FindBy(how = How.XPATH, using = "//tbody/tr[4]/td[2]/input[1]")
	@CacheLookup
	WebElement typeAmount;
	
	@FindBy(how = How.NAME, using = "button2")
	@CacheLookup
	WebElement submitBtn;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Continue')]")
	@CacheLookup
	WebElement continueBtn;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement logoutBtn;
	
	public void clickNewAccount() {
		createAccount.click();
	}
	
	public void typeID(String cuid) {
		customerID.sendKeys(cuid);
	}
	
	public void addDeposit(String cdep) {
		typeAmount.sendKeys(cdep);
	}
	
	public void submitForm() {
		submitBtn.click();
	}
	
	public void continueBtn() {
		continueBtn.click();
	}
	
	public void logout() {
		logoutBtn.click();
	}

}
