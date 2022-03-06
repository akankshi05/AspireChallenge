package com.aspire.pageObjects;

import com.aspire.testcases.BaseClass;
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

    ////button[normalize-space()='Create']
    @FindBy(xpath = "//button[contains(text(),'Create')]")
    WebElement CreateButton;

    @FindBy(xpath = "//tbody/tr[1]/td[6]/input[1]")
    WebElement CountedQuantity;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement Save;

    public void clickCreateButton() throws InterruptedException {
       WebElement createButton = waitForElementToAppear(xdriver,CreateButton,10);
       Thread.sleep(5000);
       createButton.click();
       waitForElementToAppear(xdriver, CountedQuantity,10);
    }

    public void setCountedQuantity(String quantity) {
        CountedQuantity.clear();
        CountedQuantity.sendKeys(quantity);
        waitForElementToAppear(xdriver, Save, 10);

    }

    public void clickSaveButton() {
        Save.click();
    }
}
