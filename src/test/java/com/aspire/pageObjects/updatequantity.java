package com.aspire.pageObjects;

import com.aspire.testcases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class updatequantity extends BaseClass {

    WebDriver xdriver;

    public updatequantity(WebDriver ydriver) {
        xdriver = ydriver;
        PageFactory.initElements(ydriver, this);

    }

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    WebElement CreateButton;

    @FindBy(xpath = "//tbody/tr[1]/td[6]/input[1]")
    WebElement CountedQuantity;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement Save;

    public void clickCreateButton(){
        CreateButton.click();
    }

    public void setCountedQuantity(){
        //waitForElementToAppear(xdriver, By.xpath("//tbody/tr[1]/td[6]/input[1]"),5);
        CountedQuantity.clear();
        CountedQuantity.sendKeys("12");
    }

    public void clickSaveButton(){
        waitForElementToAppear(xdriver, By.xpath("//button[contains(text(),'Save')]"),5);
        Save.click();
    }
}
