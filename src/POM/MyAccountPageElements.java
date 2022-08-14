package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPageElements {

    public MyAccountPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);


    }
    @FindBy(className = "login")
    public WebElement signInButton;

    @FindBy(css = "input[id='email']")
    public WebElement emailInput;

    @FindBy(css = "input[id='passwd']")
    public WebElement passwordInput;

    @FindBy(xpath= "//i[@class='icon-lock left']")
    public WebElement signInButton2;

    @FindBy(xpath = "//a[text()='Contact us']")
    public WebElement contactUsButton;

    @FindBy(xpath = "//h1[text()='My account']")
    public WebElement myAccountHeader;




}
