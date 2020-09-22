package com.stength.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;
    public Login(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="details-button")
    WebElement AcceptSecurityCheck;
    @FindBy(id="proceed-link")
    WebElement proceedlink;
    @FindBy(name = "uid")
    @CacheLookup
    WebElement name;
    @FindBy(name="password")
    @CacheLookup
    WebElement password;
    @FindBy(name="btnLogin")
    @CacheLookup
    WebElement login;
    @FindBy(name="btnLogout")
    @CacheLookup
    WebElement logout;

    public void accept (){
    AcceptSecurityCheck.click();
    proceedlink.click();}

    public void setUserName(String Uname) {
        name.sendKeys(Uname);
    }

    public void setPassword(String Password) {
        System.out.println(Password);
        password.sendKeys(Password);
    }

    public void clickLogin() {
        login.click();
    }

    public void clickLogout() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
        Actions actions = new Actions(driver);
        actions.moveToElement(logout);
        actions.perform();
        logout.click();
    }
}
