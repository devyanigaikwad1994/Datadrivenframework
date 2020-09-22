package com.stength.TestCases;

import com.stength.PageObjects.Login;
import com.stength.utilities.readConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClass {
    readConfig readconfig=new readConfig();

    public String baseUrl=readconfig.getApplication();
    public String uname=readconfig.getUname();
    public String password= readconfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;
    Login l=new Login(driver);

    @Parameters("browser")
    @BeforeClass
    public void steUp(String br) throws InterruptedException {
        logger=Logger.getLogger("ebanking");
        PropertyConfigurator.configure("log4j.properties");
        if(br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/devyanigaikwad/IdeaProjects/strength/Drivers/chromedriver");
            driver = new ChromeDriver();
        }
        else
        {
            System.out.println("Browser not found");
        }
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        logger.info("Url opened");
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    public void captureScreenshot(WebDriver driver,String tName) throws IOException {
        TakesScreenshot ts= (TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        File Target=new File("/Users/devyanigaikwad/IdeaProjects/strength/screenshots/" + tName + ".png");
        FileUtils.copyFile(source,Target);
        System.out.println("Failed screenshot");

    }
}
