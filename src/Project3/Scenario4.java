package Project3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Scenario4 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "/Users/oktaysaglam/Downloads/chromedriver");

        driver = new ChromeDriver();

        driver.get("https://shopdemo.e-junkie.com/");
        driver.manage().window().maximize();

    }

    @Test
    public void Scenario4() {

        WebElement addToCartButton = driver.findElement(By.xpath("(//button[text()=' Add To Cart'])[2]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        wait.until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);

        WebElement payDebitButton = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        wait.until(ExpectedConditions.visibilityOf(payDebitButton));
        payDebitButton.click();

        WebElement emailInput = driver.findElement(By.cssSelector("input[placeholder='Email']"));
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys("samsun@hello.com");


        WebElement confirmEmailInput = driver.findElement(By.cssSelector("input[placeholder='Confirm Email']"));
        wait.until(ExpectedConditions.visibilityOf(confirmEmailInput));
        confirmEmailInput.sendKeys("samsun@hello.com");


        WebElement nameOnCardInput = driver.findElement(By.cssSelector("input[placeholder='Name On Card']"));
        wait.until(ExpectedConditions.visibilityOf(nameOnCardInput));
        nameOnCardInput.sendKeys("Tony Gibson");

        WebElement phoneNumberInput = driver.findElement(By.cssSelector("input[placeholder='Optional']"));
        wait.until(ExpectedConditions.visibilityOf(phoneNumberInput));
        phoneNumberInput.sendKeys("(123)-565-9889");

        WebElement companyName = driver.findElement(By.cssSelector("input[autocomplete='company']"));
        wait.until(ExpectedConditions.visibilityOf(companyName));
        companyName.sendKeys("Sony");


        WebElement cardNumberInput = driver.findElement(By.cssSelector("//*[@id='root']/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input"));
        wait.until(ExpectedConditions.visibilityOf(cardNumberInput));
        cardNumberInput.sendKeys("1234 1200 1122 1010");

        String expectedResult = "Your card number is invalid.";

        WebElement invalidCardNumberMessage = driver.findElement(By.xpath("//*[@id='SnackBar']"));
        String actual = invalidCardNumberMessage.getText();

        boolean isMessageDisplayed = invalidCardNumberMessage.isDisplayed();

        Assert.assertTrue(isMessageDisplayed);

        Assert.assertEquals(actual, expectedResult);


    }

    @Test
    public void scenario5() {


    }
}
