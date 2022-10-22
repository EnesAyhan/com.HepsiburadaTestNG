package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiburadaPage {

    public HepsiburadaPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy (xpath ="//div[@id='myAccount']" )
    public WebElement loginButton;

@FindBy (xpath ="//a[@id='login']" )
    public WebElement loginButton2;

@FindBy (xpath ="//button[@id='onetrust-accept-btn-handler']" )
    public WebElement cookiesAccept;

@FindBy (xpath ="//input[@name='username']" )
    public WebElement emailTextBox;

@FindBy (xpath ="//button[@name='btnLogin']" )
    public WebElement emailTextBoxLoginButton;












}
