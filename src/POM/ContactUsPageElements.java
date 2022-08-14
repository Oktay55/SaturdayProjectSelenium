package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPageElements {

    public ContactUsPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='id_contact']")
    public WebElement subjectHeadingDropDown;


    @FindBy(xpath = "(//select[@class='form-control'])[2]")
    public WebElement orderReferenceDropDown;

    @FindBy(id = "message")
    public WebElement messageInput;

    @FindBy(xpath = "//span[text()='Send']")
    public WebElement sendButton;

    @FindBy(xpath = "//p[text()='Your message has been successfully sent to our team.']")
    public WebElement successMessage;


}
