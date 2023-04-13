package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.*;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username Entered");
		lp.setPassword(password);
		logger.info("Password Entered");
		lp.clickSubmit();
		logger.info("Login Button Clicked!");
		
		Thread.sleep(3000);
		
		AddCustomerPage addCustomer = new AddCustomerPage(driver);
		addCustomer.clickAddNewCustomer();
		logger.info("Add New Customer Clicked!");
		
		logger.info("Entering Customer Details... ...");

//		---------------------------------
		addCustomer.typeName("efrancis");
		logger.info("Customer Name Entered");
		addCustomer.selectGender("male");
		logger.info("Customer Gender Selected");
		Thread.sleep(3000);
		addCustomer.selectDob("1990-01-02");
		Thread.sleep(3000);
		logger.info("Customer DOB Entered");
		Thread.sleep(3000);
		addCustomer.typeAddress("19 BLVD Kazakhastan");
		logger.info("Customer Address Entered");
		addCustomer.typeCity("Almaty");
		logger.info("Customer City Entered");
		addCustomer.typeState("AMaLtY");
		logger.info("Customer State Entered");
		addCustomer.typePin(453974);
		logger.info("Customer Pin Entered");
		addCustomer.typePhoneNum("901235467");
		logger.info("Customer Phone Number Entered");

		String email = randomEmail() + "@gmail.com";
		addCustomer.typeEmail(email);
		logger.info("Customer mail Entered");
		addCustomer.typePassword("fed@G99");
		logger.info("Customer password Entered");
		addCustomer.submitForm();
		logger.info("Form Submitted!");
		
		Thread.sleep(3000);
		
		logger.info("Validation Started...");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (res == true) {
			Assert.assertTrue(true);
			captureScreen(driver, "addNewCustomerDetails");
			logger.info("Test Passsed!");
		} else {
			Assert.assertTrue(false);
			logger.info("Test Failed!");
			captureScreen(driver, "addNewCustomer");
			logger.info("Saving Screenshot...");
		}
		
	}
	
	public String randomEmail() {
		String generatedMail = RandomStringUtils.randomAlphabetic(8);
		return (generatedMail);
	}
	
}
