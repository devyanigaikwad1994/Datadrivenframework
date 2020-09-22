package com.stength.TestCases;

import com.stength.PageObjects.Login;
import com.stength.utilities.XLUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_002_data extends BaseClass{
@Test(dataProvider = "LoginData")
    public void LoginDDT(String user,String password)
    {
        Login login=new Login(driver);
        login.accept();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        login.setUserName(user);
        logger.info("Username entered");
        login.setPassword(password);
        logger.info("Password entered");
        login.clickLogin();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
        if(isAlertPresent()==true)
        {
            driver.switchTo().alert().accept();
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
            driver.switchTo().defaultContent();
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
            Assert.assertTrue(false);
            logger.warning("Login failed");
        }
        else
        {
            Assert.assertTrue(true);
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
            login.clickLogout();
            driver.switchTo().alert().accept();
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
            driver.switchTo().defaultContent();
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
            logger.info("Login logout successfully done");
        }
    }

    public boolean isAlertPresent()
    {
        try {
            driver.switchTo().alert();
            return true;
        }
        catch(NoAlertPresentException E)
        {
            return false;
        }
    }

    @DataProvider(name = "LoginData")
    Object [][] getData() throws IOException {
        String path=System.getProperty("user.dir") + "/src/test/java/com/stength/TestData/Untitled spreadsheet.xlsx";
        int rowNum= XLUtils.getRowCount(path,"Sheet1");
        int colcount=XLUtils.getCellCount(path,"Sheet1",1);
        String loginData[][]= new String [rowNum][colcount];
        for (int i=1;i<=rowNum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                loginData[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
            }
        }
        return loginData;
}

}
