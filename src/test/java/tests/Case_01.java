package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class Case_01 extends BaseClass   {


    MyCartPage myCartPage = new MyCartPage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
    Logger log=(Logger) LogManager.getLogger(Case_01.class);

    private  String expectedProductInCart;



    @Test(priority = 1)
    public void user_login() {
        ReusableMethods.clickWithJS(loginPage.loginButton);
        ReusableMethods.waitFor(2);

        ReusableMethods.clickWithJS(loginPage.loginButton2);
        ReusableMethods.waitFor(2);

        loginPage.emailTextBox.sendKeys(ConfigReader.getProperty("validEmail"));
        loginPage.emailTextBoxLoginButton.click();
        log.info("Valid mail entered");
        extentTest.info("Valid mail entered");

        loginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("validPassword"));
        loginPage.loginButtonUnderPasswordTextBox.click();
        log.info("Valid password entered");
        extentTest.info("Valid password entered");

        ReusableMethods.waitFor(5);

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login not successful");
        log.info("Login successful");
        log.info("user login verified");
        extentTest.info("Login successful");
        extentTest.info("user login verified");
    }


    @Test(priority = 2)
    public void search_a_product() {
        homePage.searchBox.sendKeys(ConfigReader.getProperty("searchProduct") + Keys.ENTER);
        Assert.assertTrue(productPage.isOnProductPage());
        log.info("Verify it's a product page");
        extentTest.info("Verify it's a product page");

    }

    @Test(priority = 3)
    public void select_a_product() {
        productPage.selectProduct(1);
        productPage.swicthToSelectedProductPage();
        expectedProductInCart= productPage.searchedProductGetName.getText();
        log.info("Select a product");
        extentTest.info("Select a product");

    }

    @Test(priority = 4)
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
        ReusableMethods.waitFor(1);
        myCartPage.cleanAllProductInMyCart();
        log.info("Products in cart have been deleted");
        extentTest.info("Products in cart have been deleted");
    }



}
