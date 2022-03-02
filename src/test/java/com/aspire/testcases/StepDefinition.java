package com.aspire.testcases;

import com.aspire.pageObjects.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;


public class StepDefinition extends BaseClass{

    String productName = "ProductName"+ rand.nextInt(100);
    String orderNumber;

   @Test(priority = 1)
    public void login() throws InterruptedException {
       driver();
       //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       driver.get("https://aspireapp.odoo.com/");
       loginObject = new login(driver);
       loginObject.setUsername();
       loginObject.setPassword();
       loginObject.clickLoginButton();
       Thread.sleep(2000);
       System.out.println("User is successfully logged in");

        }

    @Test(priority =2)
    public void CreateNewProduct() throws InterruptedException {

       dashboardObject = new dashboard(driver);
       dashboardObject.clickInventory();
        //Thread.sleep(5000);


        inventoryObject = new Inventory(driver);
        inventoryObject.clickProductInMenu();
        Thread.sleep(1000);
        inventoryObject.clickSubMenuOptionProduct();
        Thread.sleep(2000);


        productsObject = new products(driver);
        productsObject.clickCreateButton();
        //Thread.sleep(10000);


        newproductObject = new newproduct(driver);
        newproductObject.setProductName(productName);
        //Thread.sleep(5000);
        newproductObject.clickSaveButton();
        Thread.sleep(5000);

        System.out.println("The new Product name is "+ productName);

    }

    @Test(priority =3)
    public void UpdateProductQuantity() throws InterruptedException {


        newproductObject.clickUpdateQuantity();
        Thread.sleep(2000);
        updatequantityObject = new updatequantity(driver);
        updatequantityObject.clickCreateButton();
        Thread.sleep(5000);
        updatequantityObject.setCountedQuantity();
        Thread.sleep(5000);
        updatequantityObject.clickSaveButton();
        Thread.sleep(1000);

        System.out.println("Product Quantity is successfully updated");

    }


    @Test(priority =4)
    public void CreatingManufacturingOrder() throws InterruptedException {

        newproductObject.clickHomeMenu();
        Thread.sleep(3000);

        dashboardObject.clickManufacturing();
        Thread.sleep(3000);


       manufacturingOrdersObject= new manufacturingOrders(driver);
       manufacturingOrdersObject.clickCreateButton();
       Thread.sleep(3000);




        newManufacturingOrderObject = new NewManufacturingOrder(driver);
        newManufacturingOrderObject.setProduct(productName);
        Thread.sleep(3000);
        newManufacturingOrderObject.clickConfirm();
        Thread.sleep(3000);
        newManufacturingOrderObject.clickMarkAsDone();
        Thread.sleep(3000);


        newManufacturingOrderObject.clickOKButton();
        Thread.sleep(3000);
        newManufacturingOrderObject.clickAppyButton();
        Thread.sleep(3000);
        newManufacturingOrderObject.clickSaveButton();
        Thread.sleep(3000);
        orderNumber = newManufacturingOrderObject.ManufacturingOrderNo();
        System.out.println("The Manufacturing order number created is: "+orderNumber);
    }

    @Test(priority =5)
    public void ValidatingCreatedManufacturingOrder() throws InterruptedException {

        newManufacturingOrderObject.clickManufacturingOrders();
        Thread.sleep(5000);

        manufacturingOrdersObject.removeManufacturingOrderInSearch();
        Thread.sleep(1000);

        manufacturingOrdersObject.setSearchTextField(orderNumber);

        Thread.sleep(5000);

        Assert.assertEquals(manufacturingOrdersObject.getManufacturingOrderNo(),orderNumber);
        Assert.assertEquals(manufacturingOrdersObject.getScheduledDate(),"Today");
        Assert.assertEquals(manufacturingOrdersObject.getProductName(), productName);
        Assert.assertEquals(manufacturingOrdersObject.getQuantity(),"1.00");
        Assert.assertEquals(manufacturingOrdersObject.getUoM(),"Units");
        Assert.assertEquals(manufacturingOrdersObject.getState(),"Done");
        System.out.println("The Manufacturing order is successfully validated");

        driver.quit();
    }


}
