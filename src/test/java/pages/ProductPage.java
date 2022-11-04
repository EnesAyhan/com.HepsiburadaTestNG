package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class ProductPage {

    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    Actions actions=new Actions(Driver.getDriver());


    //LOCATES
    @FindBy(xpath = "//h1[@class='product-name best-price-trick']")
    public WebElement searchedProductGetName;

    @FindBy(xpath = "//a[@class='optionsLength']")
    public WebElement allSellersButton;

    @FindBy(xpath = "//td[@class='merchantName']")
    public List<WebElement> sellersList;

    @FindBy(xpath = "//button[@class='add-to-basket button']")
    public List<WebElement> addToCartList;

    @FindBy(xpath = "//i[@class='close']")
    public WebElement closeButtonRepairPackage;

    @FindBy(xpath = "//a[@class='checkoutui-Modal-iHhyy79iR28NvF33vKJb']")
    public WebElement closeButtonOfGoToCartAlert;

    @FindBy(xpath = "//li[@class='productListContent-zAP0Y5msy8OHn5z7T_K_']")
    private List<WebElement> getAllProducts;

    @FindBy(xpath = "//div[@class='searchResultSummaryBar-HM2Hk6FnQ2zwnblc0BJb']")
    public WebElement searchResultText;




    //METHOD OF PRODUCTPAGE

    public void selectProduct(int i) {
        getAllProducts.get(i - 1).click();
    }

    public boolean isOnProductPage() {
        return searchResultText.isDisplayed();
    }

    public void swicthToSelectedProductPage() {
        String firstWindowHandleValue = Driver.getDriver().getWindowHandle();
        String secondWindowHandleValue = "";
        Set<String> windowsHandlesValues = Driver.getDriver().getWindowHandles();
        for (String each : windowsHandlesValues) {
            if (!each.equalsIgnoreCase(firstWindowHandleValue)) {
                secondWindowHandleValue = each;
                Driver.getDriver().switchTo().window(secondWindowHandleValue);
            }
        }
    }

    public void selectDifferentStores(int howManyDifferentSellers) {
        Random random = new Random();
        int n;

        for (int i = 0; i < howManyDifferentSellers; i++) {
            n = random.nextInt(sellersList.size() - 1);
            ReusableMethods.clickWithJS(addToCartList.get(n));


            ReusableMethods.waitFor(2);
            actions.moveByOffset(0,0).click().perform();


            if (n==0){
                ReusableMethods.clickWithJS(closeButtonRepairPackage);
            }

            if (closeButtonOfGoToCartAlert.isDisplayed()){
                ReusableMethods.clickWithJS(closeButtonOfGoToCartAlert);
            }

            actions.moveByOffset(0,0).click().perform();
            actions.moveByOffset(0,0).click().perform();

            ReusableMethods.waitFor(2);
        }

    }


}
