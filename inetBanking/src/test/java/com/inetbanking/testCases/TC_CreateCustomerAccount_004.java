package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.*;

public class TC_CreateCustomerAccount_004 extends BaseClass {
	
	@Test
	public void createNewCustomerAccount() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username Entered");
		lp.setPassword(password);
		logger.info("Password Entered");
		lp.clickSubmit();
		logger.info("Login Button Clicked!");
		
		Thread.sleep(3000);
		
		OpenNewCustomerAccount  openAcc = new OpenNewCustomerAccount(driver);
		openAcc.clickNewAccount();
		logger.info("New Account Clicked!");
		logger.info("Entering Account Details...");
		
		openAcc.typeID("17395");
		logger.info("Customer ID Entered");
		
		openAcc.addDeposit("5000");
		logger.info("Customer Deposit Entered");
		
		openAcc.submitForm();
		logger.info("Form Submitted!");
		Thread.sleep(3000);

		logger.info("Validation Started...");
		
		Thread.sleep(3000);

		boolean res = driver.getPageSource().contains("Account Generated Successfully!!!");
		
		if (res == true) {
			Assert.assertTrue(true);
			captureScreen(driver, "create_NewCustomer_Sucess");
			logger.info("Test Passsed!");
			openAcc.continueBtn();
			Thread.sleep(3000);
			openAcc.logout();
			
		} else {
			Assert.assertTrue(false);
			logger.info("Test Failed!");
			captureScreen(driver, "create_NewCustomer_Failed");
			logger.info("Saving Screenshot...");
		}

	}
}
