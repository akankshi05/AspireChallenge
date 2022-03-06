package com.aspire.pageObjects;

import com.aspire.testcases.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewManufacturingOrder extends BaseClass {

    WebDriver xdriver;

    public NewManufacturingOrder(WebDriver ydriver) {
        xdriver = ydriver;
        PageFactory.initElements(ydriver, this);

    }


    @FindBy(css = "#o_field_input_205")
    WebElement Product;

    @FindBy(xpath = "//span[contains(text(),'Confirm')]")
    WebElement Confirm;

    @FindBy(xpath = "//button[@class='btn btn-primary']//span[contains(text(),'Mark as Done')]")
    WebElement MarkAsDone;

    @FindBy(xpath = "//span[normalize-space()='Ok']")
    WebElement OKButton;

    @FindBy(xpath = "//span[normalize-space()='Apply']")
    WebElement ApplyButton;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement SaveButton;

    @FindBy(xpath = "//span[@placeholder='Manufacturing Reference']")
    WebElement ManufacturingOrderNumberGenerated;

    @FindBy(xpath = "//a[normalize-space()='Manufacturing Orders']")
    WebElement ManufacturingOrdersLink;

    public void setProduct(String pname) {
        waitForElementToAppear(xdriver, Product, 10);
        Product.sendKeys(pname);
    }

    public void clickConfirm() {
        waitForElementToAppear(xdriver, Confirm, 10);
        Confirm.click();
    }

    public void clickMarkAsDone() {
        waitForElementToAppear(xdriver, MarkAsDone, 10);
        MarkAsDone.click();
    }

    public void clickOKButton() {
        waitForElementToAppear(xdriver, OKButton, 10);
        OKButton.click();
    }

    public void clickAppyButton() {
        waitForElementToAppear(xdriver, ApplyButton, 10);
        ApplyButton.click();
    }

    public void clickSaveButton() {
        waitForElementToAppear(xdriver, SaveButton, 10);
        SaveButton.click();
        waitForElementToAppear(xdriver, ManufacturingOrderNumberGenerated, 10);
    }

    public String ManufacturingOrderNo() {
        return ManufacturingOrderNumberGenerated.getText();
    }

    public void clickManufacturingOrders() {
        ManufacturingOrdersLink.click();
    }

}
