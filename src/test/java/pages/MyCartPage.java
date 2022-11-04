package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class MyCartPage {

    public MyCartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    Actions actions = new Actions(Driver.getDriver());


    //LOCATES
    @FindBy(xpath = "//div[@class='product_name_3Lh3t']")
    public List<WebElement> productNameListOfInMyCart;

    @FindBy(xpath = "//a[@class='delete_product_3DFC0']")
    public List<WebElement> deleteButtonListOfInMyCart;


    @FindBy(xpath = "//a[@class='close_2kUgV']")
    public WebElement closeButtonOfAddToLikeCart;


    //METHODS OF MY CARTS

    public boolean controlOfMyCart(String nameOfProductInMy) {
        boolean flag = true;

        for (int i = 0; i < productNameListOfInMyCart.size(); i++) {
            System.out.println(productNameListOfInMyCart.get(i).getText());
            flag = productNameListOfInMyCart.get(i).getText().contains(nameOfProductInMy);
        }
        return flag;
    }

    public void cleanAllProductInMyCart() {

        for (int i = deleteButtonListOfInMyCart.size(); i > 0; i--) {

            ReusableMethods.waitFor(1);
            WebElement firstDeleteButton = Driver.getDriver().findElement(By.xpath("(//a[@class='delete_product_3DFC0'])[1]"));
            ReusableMethods.waitFor(2);
            ReusableMethods.clickWithJS(firstDeleteButton);
            ReusableMethods.waitFor(2);
            actions.moveByOffset(0, 0).click().perform();
            ReusableMethods.waitFor(2);
        }

    }


}
