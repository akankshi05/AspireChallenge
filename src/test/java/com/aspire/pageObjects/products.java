package com.aspire.pageObjects;

import com.aspire.testcases.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class products extends BaseClass {

    WebDriver xdriver;

    public products(WebDriver ydriver) {
        xdriver = ydriver;
        PageFactory.initElements(ydriver, this);
    }


    @FindBy(xpath = "//button[contains(text(),'Create')]")
    WebElement CreateButton;


    public void clickCreateButton() {
        waitForElementToAppear(xdriver, CreateButton, 10);
        CreateButton.click();

    }


}
