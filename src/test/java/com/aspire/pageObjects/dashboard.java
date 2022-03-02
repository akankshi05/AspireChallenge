package com.aspire.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashboard {

    WebDriver xdriver;

    public dashboard(WebDriver ydriver) {
        xdriver = ydriver;
        PageFactory.initElements(ydriver, this);
    }


        @FindBy(xpath = "//div[contains(text(),'Inventory')]")
       WebElement Inventory;

    @FindBy(css = "#result_app_2")
    WebElement Manufacturing;

        public void clickInventory(){
            Inventory.click();
        }

        public void clickManufacturing(){
            Manufacturing.click();
        }
}
