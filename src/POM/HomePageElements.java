package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageElements {

    public HomePageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Home']")
    public WebElement homeButton;

    @FindBy(css = "img[title='Printed Dress']")
    public WebElement clickDressViewButton;

    @FindBy(xpath = "(//button[@name='Submit'])")
    public WebElement addToCartButton;

    @FindBy(xpath = "//iframe[@class='fancybox-iframe']")
    public WebElement iframe;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    public WebElement proceedToCheckoutButton1;

    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    public WebElement proceedToCheckoutButton2;

    @FindBy(css = "button[name='processAddress']")
    public WebElement proceedToCheckoutButton3;

    @FindBy(css = "input[type='checkbox']")
    public WebElement radioCheckBoxButton;

    @FindBy(css = "button[name='processCarrier']")
    public WebElement proceedToCheckoutButton4;

    @FindBy(xpath = "//a[@title='Pay by check.']")
    public WebElement payByCheckButton;

    @FindBy(xpath = "//span[text()='I confirm my order']")
    public WebElement confirmMyOrderButton;

    @FindBy(xpath = "//p[text()='Your order on My Store is complete.']")
    public WebElement successMessage;

    @FindBy(xpath = "//a[text()='My orders']")
    public WebElement myOrdersButton;

    @FindBy(xpath = "//a[@class='color-myaccount']")
    public WebElement orderReferenceValue;










}
