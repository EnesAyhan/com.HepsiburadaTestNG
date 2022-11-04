package tests;

import com.aventstack.extentreports.ExtentTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class BaseClass extends TestBaseRapor {

    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();
    ProductPage productPage=new ProductPage();
    Logger log=(Logger) LogManager.getLogger(BaseClass.class);

    @BeforeClass
    public void setUp() {
        extentTest=extentReports.createTest("Hepsiburada Automation","Adding product to cart");
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));
        extentTest.info("Visited Hepsiburada page");
        ReusableMethods.waitForVisibility(loginPage.cookiesAccept,15);
        loginPage.cookiesAccept.click();
        ReusableMethods.waitFor(2);
    }

    @AfterClass
    public void tearDown(){
        Driver.getDriver().quit();
        log.info("user login verified");
        extentTest.info("Login successful");
    }












}
