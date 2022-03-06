package com.aspire.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {

    WebDriver xdriver;

    public login(WebDriver ydriver) {
        xdriver = ydriver;
        PageFactory.initElements(ydriver, this);
    }

    @FindBy(xpath = "//input[@id='login']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    public void setUsername(String email) {
        username.sendKeys(email);
    }

    public void setPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void clickLoginButton() {
        loginButton.click();
    }


}
