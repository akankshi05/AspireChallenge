package com.aspire.testcases;

import com.aspire.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class StepDefinition extends BaseClass {

    String productName = "ProductName" + rand.nextInt(100);
    String orderNumber;
    String UpdatedQuantityNo = String.valueOf(11 + rand.nextInt(20));


    @Test(priority = 1)
    public void login() throws InterruptedException {
        driver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(baseurl);
        loginObject = new login(driver);
        loginObject.setUsername(userName);   //Entering username
        loginObject.setPassword(password);   // Entering password
        loginObject.clickLoginButton();   //Clicked on Login button
        System.out.println("User is successfully logged in");

    }

    @Test(priority = 2)
    public void CreateNewProduct() throws InterruptedException {

        dashboardObject = new dashboard(driver);
        dashboardObject.clickInventory();  // Clicked on Inventory option


        inventoryObject = new Inventory(driver);
        inventoryObject.clickProductInMenu();  //clicked on Product in Menu
        inventoryObject.clickSubMenuOptionProduct(); // clicked on Product option under Product


        productsObject = new products(driver);
        productsObject.clickCreateButton();  // Clicked on Create button on Products page


        newproductObject = new newproduct(driver);
        newproductObject.setProductName(productName);  // entered Product name
        newproductObject.clickSaveButton(); //Saved New Product
        Thread.sleep(2000);

        System.out.println("The new Product name is " + productName);

    }

    @Test(priority = 3)
    public void UpdateProductQuantity() throws InterruptedException {


        newproductObject.clickUpdateQuantity(); //Clicked on Update Quantity button on New Products page
        updatequantityObject = new updatequantity(driver);
        updatequantityObject.clickCreateButton();   // Clicked on create button on Update Quantity page
        updatequantityObject.setCountedQuantity(UpdatedQuantityNo); // Entered the updated quantity
        updatequantityObject.clickSaveButton(); //saved updated quantity


        System.out.println("Product Quantity is successfully updated");

    }


    @Test(priority = 4)
    public void CreatingManufacturingOrder() throws InterruptedException {

        newproductObject.clickHomeMenu(); //clicked on Application icon at the top left of New Product page
        dashboardObject.clickManufacturing(); // clicked on Manufacturing option on Dashboard page


        manufacturingOrdersObject = new manufacturingOrders(driver);
        manufacturingOrdersObject.clickCreateButton(); // Clicked on Create button on Manufacturing  page


        newManufacturingOrderObject = new NewManufacturingOrder(driver);
        newManufacturingOrderObject.setProduct(productName); // Searching for the product created above
        Thread.sleep(1000);
        newManufacturingOrderObject.clickConfirm(); // clicked on Confirm button on New manufacturing order page
        newManufacturingOrderObject.clickMarkAsDone(); // Clicked on Mark As Done button on New Manufacturing screen


        newManufacturingOrderObject.clickOKButton(); // Selected OK button from the popup
        newManufacturingOrderObject.clickAppyButton(); // Selected Apply button from the popup
        Thread.sleep(1000);
        newManufacturingOrderObject.clickSaveButton(); // Clicked on Save to successfully create a new manufacturing order
        orderNumber = newManufacturingOrderObject.ManufacturingOrderNo();
        System.out.println("The Manufacturing order number created is: " + orderNumber);
    }

    @Test(priority = 5)
    public void ValidatingCreatedManufacturingOrder() throws InterruptedException {

        newManufacturingOrderObject.clickManufacturingOrders(); //Going back to Manufacturing Orders screen
        manufacturingOrdersObject.removeManufacturingOrderInSearch();
        manufacturingOrdersObject.setSearchTextField(orderNumber); //Entering the manufacturing order created above in Search
        Thread.sleep(1000);


        Assert.assertEquals(manufacturingOrdersObject.getManufacturingOrderNo(), orderNumber);
        Assert.assertEquals(manufacturingOrdersObject.getScheduledDate(), "Today");
        Assert.assertEquals(manufacturingOrdersObject.getProductName(), productName);
        Assert.assertEquals(manufacturingOrdersObject.getQuantity(), "1.00");
        Assert.assertEquals(manufacturingOrdersObject.getUoM(), "Units");
        Assert.assertEquals(manufacturingOrdersObject.getState(), "Done");
        System.out.println("The Manufacturing order is successfully validated");

        driver.quit();
    }


}
