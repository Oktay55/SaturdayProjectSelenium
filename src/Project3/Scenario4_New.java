package Project3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Scenario4_New {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/oktaysaglam/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://shopdemo.e-junkie.com/");
        driver.manage().window().maximize();

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


        WebElement iframe2= driver.findElement(By.cssSelector("[name^='__privateStripeFrame']"));
        driver.switchTo().frame(iframe2);
        WebElement cardNumber= driver.findElement(By.xpath("//input[@aria-label='Credit or debit card number']"));
        cardNumber.sendKeys("1111 1111 1111 1111");

        driver.switchTo().parentFrame();


        WebElement invalidMessage = driver.findElement(By.xpath("//span[text()='Your card number is invalid.']"));
        System.out.println(invalidMessage.getText());

        if(invalidMessage.isDisplayed()){
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }















    }
}
