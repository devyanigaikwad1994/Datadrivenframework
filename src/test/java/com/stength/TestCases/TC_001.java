package com.stength.TestCases;

import com.stength.PageObjects.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_001 extends BaseClass {
    @Test
    public void Login() throws InterruptedException, IOException {
        logger.info("Url opened");
        Thread.sleep(3000);
        Login l=new Login(driver);
        l.accept();
        Thread.sleep(3000);
        l.setUserName(uname);
        l.setPassword(password);
        l.clickLogin();
        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
            Assert.assertTrue(true);
            logger.info("Test passed:  with login");
        }
        else {
            Assert.assertTrue(false);
            logger.info("Test failed : without login");
            captureScreenshot(driver,"login Test");
        }
    }
}
