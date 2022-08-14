package Test;

import POM.ContactUsPageElements;
import POM.HomePageElements;
import POM.MyAccountPageElements;
import Utilis.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTest extends BaseDriver {

    ContactUsPageElements contactUsPageElements;
    HomePageElements homePageElements;
    MyAccountPageElements myAccountPageElements;

    @Test
    public void addToCartTest() {

        contactUsPageElements = new ContactUsPageElements(driver);
        homePageElements = new HomePageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        myAccountPageElements.signInButton.click();
        myAccountPageElements.emailInput.sendKeys("test123@hello.com");
        myAccountPageElements.passwordInput.sendKeys("test12345");
        wait.until(ExpectedConditions.elementToBeClickable(myAccountPageElements.signInButton2));
        myAccountPageElements.signInButton2.click();

        homePageElements.homeButton.click();
        homePageElements.clickDressViewButton.click();
        wait.until(ExpectedConditions.visibilityOf(homePageElements.iframe));
        driver.switchTo().frame(homePageElements.iframe);

        homePageElements.addToCartButton.click();

        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.proceedToCheckoutButton1));
        homePageElements.proceedToCheckoutButton1.click();



        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.proceedToCheckoutButton2));
        homePageElements.proceedToCheckoutButton2.click();

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.proceedToCheckoutButton3));
        homePageElements.proceedToCheckoutButton3.click();

        homePageElements.radioCheckBoxButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.proceedToCheckoutButton4));
        homePageElements.proceedToCheckoutButton4.click();


        homePageElements.payByCheckButton.click();
        homePageElements.confirmMyOrderButton.click();

        String actualSuccessMessage = homePageElements.successMessage.getText();
        String expectedSuccessMessage = "Your order on My Store is complete.";
        Assert.assertEquals(actualSuccessMessage,expectedSuccessMessage);

        homePageElements.myOrdersButton.click();

       // String myOrderReferenceText = homePageElements.orderReferenceValue.getText();
       // Assert.assertEquals(myOrderReferenceText,"WBDVPHFSW");














    }


}
