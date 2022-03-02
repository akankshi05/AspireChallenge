package com.aspire.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class products {

    WebDriver xdriver;

    public products(WebDriver ydriver) {
        xdriver = ydriver;
        PageFactory.initElements(ydriver, this);
    }


        @FindBy(xpath = "//button[contains(text(),'Create')]")
    WebElement CreateButton;

        public void clickCreateButton(){
            CreateButton.click();
        }


}
