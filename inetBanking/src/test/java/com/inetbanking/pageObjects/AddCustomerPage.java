package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement lnkCustomerName;
	
	@FindBy(how = How.CSS, using = "table.layout:nth-child(8) table:nth-child(1) tbody:nth-child(1) tr:nth-child(5) td:nth-child(2) > input:nth-child(1)")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how = How.NAME, using = "dob")
	@CacheLookup
	WebElement chDOB;
	
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtPhoneNum;
	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement submitBtn;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement logoutBtn;
	
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	
	public void typeName(String cname) {
		lnkCustomerName.sendKeys(cname);
	}
	
	public void selectGender(String cgender) {
		rdGender.click();
	}
	
	public void selectDob(String dob) {
		chDOB.sendKeys(dob);

	}
	
	public void typeAddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}
	
	public void typeCity(String tcity) {
		txtCity.sendKeys(tcity);
	}
	
	public void typeState(String cstate) {
		txtState.sendKeys(cstate);
	}
	
	public void typePin(int cpin) {
		txtPin.sendKeys(String.valueOf(cpin));
	}
	 
	public void typePhoneNum(String cphoneNum) {
		txtPhoneNum.sendKeys(cphoneNum);
	}
	
	public void typeEmail(String cemail) {
		txtEmail.sendKeys(cemail);
	}
	
	public void typePassword(String cpassword) {
		txtPassword.sendKeys(cpassword);
	}
	
	public void submitForm() {
		submitBtn.click();
	}
	
	public void logout() {
		logoutBtn.click();
	}

}
