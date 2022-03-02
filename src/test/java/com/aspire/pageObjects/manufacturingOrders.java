package com.aspire.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class manufacturingOrders {

    WebDriver xdriver;

    public manufacturingOrders(WebDriver ydriver) {
        xdriver = ydriver;
        PageFactory.initElements(ydriver, this);
    }

    @FindBy(xpath = "//i[@title='Remove']")
            WebElement ManufacturingOrderInSearch;

 @FindBy(xpath = "//input[@placeholder='Search...']")
         WebElement SearchTextField;

 @FindBy(xpath = "//tbody/tr[1]/td[3]")
         WebElement ManufacturingOrderNo;

 @FindBy(xpath = "//tbody/tr[1]/td[4]")
         WebElement ScheduledDate;

 @FindBy(xpath = "//tbody/tr[1]/td[5]")
         WebElement ProductName;

 @FindBy(xpath = "//tbody/tr[1]/td[9]")
         WebElement Quantity;

 @FindBy(xpath = "//tbody/tr[1]/td[10]")
         WebElement UoM;

 @FindBy(xpath = "//tbody/tr[1]/td[11]")
         WebElement State;



    @FindBy(xpath = "//button[contains(text(),'Create')]")
    WebElement CreateButton;



    public void clickCreateButton(){
        CreateButton.click();
    }

    public void removeManufacturingOrderInSearch(){
        ManufacturingOrderInSearch.click();
    }
    public void setSearchTextField(String orderno){
        SearchTextField.sendKeys(orderno);
        SearchTextField.sendKeys(Keys.RETURN);
    }

    public String getManufacturingOrderNo(){
        return ManufacturingOrderNo.getText();
    }

    public String getScheduledDate(){
        return ScheduledDate.getText();
    }

    public String getProductName(){
        return ProductName.getText();
    }

    public String getQuantity(){
        return Quantity.getText();
    }

    public String getUoM(){
        return UoM.getText();
    }

    public String getState(){
        return State.getText();
    }
}
