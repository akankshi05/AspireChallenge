package com.aspire.pageObjects;

import com.aspire.testcases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class newproduct extends BaseClass {

    WebDriver xdriver;

    public newproduct(WebDriver ydriver) {
        xdriver = ydriver;
        PageFactory.initElements(ydriver, this);

    }


        @FindBy(css = "#o_field_input_11")
    WebElement ProductName;

        @FindBy(xpath = "//button[contains(text(),'Save')]")
        WebElement SaveButton;

        @FindBy(xpath = "//span[contains(text(),'Update Quantity')]")
        WebElement UpdateQuantity;

        @FindBy(xpath = "//header/nav[1]/a[1]")
        WebElement HomeMenu;

        public void setProductName(String productname){
            waitForElementToAppear(xdriver, By.cssSelector("#o_field_input_11"),10);
            ProductName.sendKeys(productname);
        }

        public void clickSaveButton(){
           // waitForElementToAppear(xdriver, By.xpath("//button[contains(text(),'Save')]"),10);
            SaveButton.click();
        }

        public void clickUpdateQuantity(){
            waitForElementToAppear(xdriver, By.xpath("//span[contains(text(),'Update Quantity')]"),10);
            UpdateQuantity.click();
        }

        public void clickHomeMenu(){
            HomeMenu.click();
        }
}
