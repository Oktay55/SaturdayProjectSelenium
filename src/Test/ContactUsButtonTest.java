package Test;

import POM.ContactUsPageElements;
import POM.MyAccountPageElements;
import Utilis.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactUsButtonTest extends BaseDriver {

    ContactUsPageElements contactUsPageElements;
    MyAccountPageElements myAccountPageElements;

    @Test
    @Parameters({"message"})
    public void contactUsButtonTest(String message) {
        myAccountPageElements = new MyAccountPageElements(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        myAccountPageElements.signInButton.click();
        myAccountPageElements.emailInput.sendKeys("test123@hello.com");
        myAccountPageElements.passwordInput.sendKeys("test12345");
        wait.until(ExpectedConditions.elementToBeClickable(myAccountPageElements.signInButton2));
        myAccountPageElements.signInButton2.click();
        wait.until(ExpectedConditions.elementToBeClickable(myAccountPageElements.contactUsButton));
        myAccountPageElements.contactUsButton.click();


        contactUsPageElements = new ContactUsPageElements(driver);
        Select selectSubjectHeading = new Select( contactUsPageElements.subjectHeadingDropDown);
        selectSubjectHeading.selectByVisibleText("Customer service");
        Select selectOrderReferenceDropDown = new Select(contactUsPageElements.orderReferenceDropDown);
        selectOrderReferenceDropDown.selectByVisibleText("-- Choose --");
        contactUsPageElements.messageInput.sendKeys(message);
        contactUsPageElements.sendButton.click();
        String actualSuccessMessage = contactUsPageElements.successMessage.getText();
        String expectedSuccessMessage = "Your message has been successfully sent to our team.";
        Assert.assertEquals(actualSuccessMessage,expectedSuccessMessage);
    }
}
