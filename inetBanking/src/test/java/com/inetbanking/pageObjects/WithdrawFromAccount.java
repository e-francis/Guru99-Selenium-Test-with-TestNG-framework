package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WithdrawFromAccount {
	
	WebDriver ldriver;
	
	public WithdrawFromAccount(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Withdrawal')]")
	@CacheLookup
	WebElement clickWithdrawal;
	
	@FindBy(how = How.NAME, using = "accountno")
	@CacheLookup
	WebElement typeAccountNumber;
	
	@FindBy(how = How.NAME, using = "ammount")
	@CacheLookup
	WebElement typeWithdrawalAmount;
	
	@FindBy(how = How.NAME, using = "desc")
	@CacheLookup
	WebElement typeDescription;
	
	@FindBy(how = How.NAME, using = "AccSubmit")
	@CacheLookup
	WebElement submitBtn;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement logoutBtn;
	
	public void clickWithdrawal() {
		clickWithdrawal.click();
	}
	
	public void accountNo(String accno) {
		typeAccountNumber.sendKeys(accno);
	}
	
	public void ammount(String amnt) {
		typeWithdrawalAmount.sendKeys(amnt);
	}
	
	public void typeDesc(String descript) {
		typeDescription.sendKeys(descript);
	}
	
	public void submitForm() {
		submitBtn.click();
	}
	
	public void logout() {
		logoutBtn.click();
	}
}
