package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HepsiburadaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Case_01 {
    HepsiburadaPage hepsiburadaPage=new HepsiburadaPage();


    @BeforeClass
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));
        ReusableMethods.waitFor(2);
        hepsiburadaPage.cookiesAccept.click();


    }


    @Test
    public void case01(){
        hepsiburadaPage.loginButton.click();
        ReusableMethods.waitFor(1);
        hepsiburadaPage.loginButton2.click();
        ReusableMethods.waitFor(1);
        hepsiburadaPage.emailTextBox.sendKeys(ConfigReader.getProperty("validEmail"));
        hepsiburadaPage.emailTextBoxLoginButton.click();


    }


}
