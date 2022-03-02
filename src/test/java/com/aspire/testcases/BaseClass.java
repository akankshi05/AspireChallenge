package com.aspire.testcases;

import com.aspire.pageObjects.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    WebDriver driver;
    login loginObject;
    dashboard dashboardObject;
    Inventory inventoryObject;
    products productsObject;
    newproduct newproductObject;
    updatequantity updatequantityObject;
    manufacturingOrders manufacturingOrdersObject;
    NewManufacturingOrder newManufacturingOrderObject;

    Random rand = new Random();

    public void driver(){
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public WebElement waitForElementToAppear(WebDriver driver, By locatorOfElement,int timeToWait){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.presenceOfElementLocated(locatorOfElement));
        return driver.findElement(locatorOfElement);
    }
}
