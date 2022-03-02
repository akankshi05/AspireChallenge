package com.aspire.pageObjects;

import com.aspire.testcases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inventory extends BaseClass {

    WebDriver xdriver;

    public Inventory(WebDriver ydriver) {
        xdriver = ydriver;
        PageFactory.initElements(ydriver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement MenuOptionProduct;

    @FindBy(xpath = "//a[contains(text(),'Products')]")
    WebElement SubMenuOptionProduct;

    public  void clickProductInMenu(){
        waitForElementToAppear(xdriver, By.xpath("//span[contains(text(),'Products')]"),5);
        MenuOptionProduct.click();
    }

    public  void clickSubMenuOptionProduct(){
        SubMenuOptionProduct.click();
    }
}
