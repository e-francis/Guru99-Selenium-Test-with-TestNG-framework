package com.inetbanking.testCases;

import java.io.IOException;
import com.inetbanking.pageObjects.*;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.Thread;

import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

    @Test(dataProvider = "LoginData")
    public void loginDDT(String usrname, String pword) throws InterruptedException {

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(usrname);
        logger.info("Username Entered: " + usrname); // Updated logger message
        lp.setPassword(pword);
        logger.info("Password Entered: " + pword); // Updated logger message
        lp.clickSubmit();
        logger.info("Button Clicked!");
        
        Thread.sleep(3000);

        if (isAlertPresent()) {
            driver.switchTo().alert().accept(); // clicks to close the alert
            driver.switchTo().defaultContent();
            Assert.assertTrue(true, "Login Failed: Invalid Credentials!");
            logger.info("Verify user cannot login with invalid credentials");
        } else {
            Assert.assertTrue(true, "Login Passed: Valid Credentials!");
            logger.info("Verify user can login with valid credentials"); // Updated logger message
            lp.clickLogout();
            Thread.sleep(3000);
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }
    }

    // Check if alert is present or not
    public boolean isAlertPresent() {

        try {
            driver.switchTo().alert();
            return true;

        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
        String[][] logindata = null;

        int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		logindata = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
		    for (int j = 0; j < colcount; j++) {
		        logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
		    }
		}

        return logindata;
    }

}
