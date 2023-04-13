package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.*;


public class TC_Withdrawal_005 extends BaseClass {
	
	@Test
	public void withdrawFromAccount() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username Entered");
		lp.setPassword(password);
		logger.info("Password Entered");
		lp.clickSubmit();
		logger.info("Login Button Clicked!");
		
		Thread.sleep(3000);
		
		WithdrawFromAccount withdAcc = new WithdrawFromAccount(driver);
		withdAcc.clickWithdrawal();
		logger.info("Withdrwal Clicked!");
		logger.info("Entering Account Details...");
		
		withdAcc.accountNo("119886");
		logger.info("Customer Account Number Entered");
		
		withdAcc.ammount("500");
		logger.info("Withdrawal Amount Entered");
		
		withdAcc.typeDesc("Sapa!");
		logger.info("Withdrawal description Entered");
		
		Thread.sleep(3000);

		withdAcc.submitForm();
		logger.info("Form Submitted!");
		Thread.sleep(3000);
		
		logger.info("Validation Started...");
		
		Thread.sleep(3000);
		
			boolean res = driver.getPageSource().contains("Transaction ID");
			Thread.sleep(3000);
			
			if (res) {
			    Assert.assertTrue(true, "Transaction ID found in page. Test Passed!");
			    captureScreen(driver, "Withdrawal_Success");
			    logger.info("Saving Screenshot...");
			    logger.info("Test Passed!");
			    Thread.sleep(3000);
				withdAcc.logout();
			} else {
			    Assert.fail("Transaction details of Withdrawal for Account 119886 not found in page source. Test Failed!");
			    captureScreen(driver, "Withdrawal_Failed");
			    logger.info("Test failed!");
			    logger.info("Saving Screenshot...");
			}
			

	}

}
