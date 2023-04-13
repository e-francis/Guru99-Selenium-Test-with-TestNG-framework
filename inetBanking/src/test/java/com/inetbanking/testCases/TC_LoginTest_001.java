package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException {
        
        driver.get(baseURL);
        
        logger.info("URL is opened");
        
        LoginPage lp = new LoginPage(driver);
        
        lp.setUserName(username);
        logger.info("Entered Username");

        lp.setPassword(password);
        logger.info("Entered Password");

        lp.clickSubmit();
        
        String actualTitle = driver.getTitle();
        String expectedTitle = "Guru99 Bank Manager HomePage";
        
        if(actualTitle.equals(expectedTitle)) {
            Assert.assertTrue(true, "Login Test passed: Title matched");
            logger.info("Login Test passed");
        }
        else {
        	captureScreen(driver, "loginTest");
            Assert.assertTrue(false, "Login Test failed: Title mismatched");
            logger.info("Login Test failed");
        }
    }
}
