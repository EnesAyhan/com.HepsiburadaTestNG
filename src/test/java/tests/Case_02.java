package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyCartPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Case_02 extends BaseClass {
    private String expectedProductInCart;
    MyCartPage myCartPage=new MyCartPage();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    Logger log=(Logger) LogManager.getLogger(Case_02.class);


    @Test(priority = 1)
    public void search_a_product() {
        homePage.searchBox.sendKeys(ConfigReader.getProperty("searchProduct") + Keys.ENTER);
        Assert.assertTrue(productPage.isOnProductPage());
        log.info("Verify it's a product page");
        extentTest.info("Verify it's a product page");

    }

    @Test(priority = 2)
    public void select_a_product() {
        productPage.selectProduct(1);
        productPage.swicthToSelectedProductPage();
        expectedProductInCart = productPage.searchedProductGetName.getText();
        System.out.println("expectedProductInCart = " + expectedProductInCart);
        log.info("Select a product");
        extentTest.info("Select a product");
    }
    @Test(priority = 3)
    public void select_product_diffirent_stores() {
        ReusableMethods.waitFor(2);
        jse.executeScript("window.scrollBy(0,400)");
        ReusableMethods.waitFor(2);
        ReusableMethods.clickWithJS(productPage.allSellersButton);
        productPage.selectDifferentStores(2);
        ReusableMethods.waitFor(2);
        log.info("Selected Different Stores");
        extentTest.info("Selected Different Stores");
        jse.executeScript("arguments[0].scrollIntoView();", homePage.myCartButton);
        ReusableMethods.waitFor(2);
    }
    @Test(priority = 5)
    public void product_check_in_my_cart() {

        homePage.myCartButton.click();
        Assert.assertTrue(myCartPage.controlOfMyCart(expectedProductInCart));
        log.info("Products in cart verified");
        extentTest.info("Products in cart verified");
        myCartPage.cleanAllProductInMyCart();
        log.info("Products in cart have been deleted");
        extentTest.info("Products in cart have been deleted");
    }






}
