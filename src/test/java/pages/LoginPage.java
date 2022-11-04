package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    HomePage homePage = new HomePage();

    //LOCATES
    @FindBy(xpath = "//div[@id='myAccount']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@id='login']")
    public WebElement loginButton2;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement cookiesAccept;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//button[@name='btnLogin']")
    public WebElement emailTextBoxLoginButton;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@kind='primary']")
    public WebElement loginButtonUnderPasswordTextBox;



    //METHOD OF LOGINPAGE
    public boolean isLoginSuccessful() {

        String expectedUserInfo = ConfigReader.getProperty("userNameSurname");
        String actualUserInfo = homePage.userInformationGetName.getText();
        return expectedUserInfo.equalsIgnoreCase(actualUserInfo);
    }
}
