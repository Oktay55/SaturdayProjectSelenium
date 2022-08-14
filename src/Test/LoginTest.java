package Test;

import POM.ContactUsPageElements;
import POM.MyAccountPageElements;
import Utilis.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseDriver {

    ContactUsPageElements contactUsPageElements;
    MyAccountPageElements myAccountPageElements;

    @Test
    public void loginPage() {
        myAccountPageElements = new MyAccountPageElements(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        myAccountPageElements.signInButton.click();
        myAccountPageElements.emailInput.sendKeys("test123@hello.com");
        myAccountPageElements.passwordInput.sendKeys("test12345");
        wait.until(ExpectedConditions.elementToBeClickable(myAccountPageElements.signInButton2));
        myAccountPageElements.signInButton2.click();
        wait.until(ExpectedConditions.elementToBeClickable(myAccountPageElements.contactUsButton));
        myAccountPageElements.contactUsButton.click();

        String myAccountHeaderText = myAccountPageElements.myAccountHeader.getText();

        Assert.assertEquals(myAccountHeaderText, "My Account");




    }


}
