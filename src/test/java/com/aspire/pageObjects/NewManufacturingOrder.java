package com.aspire.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewManufacturingOrder {

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

        public void setProduct(String pname){
            Product.sendKeys(pname);
        }

        public void clickConfirm(){
            Confirm.click();
        }

        public void clickMarkAsDone(){
            MarkAsDone.click();
        }

        public void clickOKButton(){
            OKButton.click();
        }

        public void clickAppyButton(){
            ApplyButton.click();
        }

        public void clickSaveButton(){
            SaveButton.click();
        }

        public String ManufacturingOrderNo(){
            return ManufacturingOrderNumberGenerated.getText();
        }

        public void clickManufacturingOrders(){
            ManufacturingOrdersLink.click();
        }

}
