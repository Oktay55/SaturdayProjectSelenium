package Project3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Scenario5 {

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
        cardNumber.sendKeys("4242 4242 4242 4242");

        WebElement expirationNumber = driver.findElement(By.cssSelector("input[placeholder='MM / YY']"));
        expirationNumber.sendKeys("12/22");

        WebElement cvvNumber = driver.findElement(By.cssSelector("input[placeholder='CVC']"));
        cvvNumber.sendKeys("000");

        driver.switchTo().parentFrame();

        WebElement pay = driver.findElement(By.xpath("//button[text()='Pay 0.50 USD']"));
        pay.click();

        driver.get("https://www.fatfreecartpro.com/ecom/rp.php?rdffc=true&txn_id=st-ch_3LTouAFWSmRjvnlt1dFIXleY&payer_email=samsun%40hello.com&client_id=341695&c_id=158227432&c_enc=42f3d2c7032bb3ca098103ed0fe675e1&cart_metadata=%7B%22gtag%22%3A%7B%22gtag%22%3A%22UA-273877-2%22%2C%22_ga%22%3A%222.166983549.233528395.1659799615-825000517.1659799615%22%7D%2C%22fbp%22%3A%7B%22fbp%22%3A%221714673711932838%22%7D%2C%22cart_source%22%3A%22https%3A%2F%2Fshopdemo.e-junkie.com%2F%22%2C%22em_updates%22%3Atrue%7D&&pending_reason=&_ga=2.166983549.233528395.1659799615-825000517.1659799615&&gajs=&auser=&abeacon=&");

        WebElement thanksMessage= driver.findElement(By.xpath("//span[text()='Tony, your order is confirmed. Thank you!']"));
        System.out.println(thanksMessage.getText());

        if(thanksMessage.isDisplayed()) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }

        driver.quit();




    }
}
