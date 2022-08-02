package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Scenario3 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/oktaysaglam/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://shopdemo.e-junkie.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addToCart = driver.findElement(By.xpath("(//button[text()=' Add To Cart'])[2]"));
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        addToCart.click();

        WebElement iFrame1 = driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));

        wait.until(ExpectedConditions.visibilityOf(iFrame1));

        driver.switchTo().frame(iFrame1);

        WebElement payDebitCard = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        wait.until(ExpectedConditions.visibilityOf(payDebitCard));
        payDebitCard.click();

        // WebElement payButton = driver.findElement(By.cssSelector("button[class='Pay-Button']"));
        //wait.until(ExpectedConditions.visibilityOf(payButton));
        WebElement payButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='Pay-Button']")));
        payButton.click();

        WebElement validateText = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SnackBar']/span")));
        //WebElement validateText = driver.findElement(By.cssSelector("div[id='SnackBar']>span"));

        boolean isDisplayedAfterClick = validateText.isDisplayed();



        System.out.println(isDisplayedAfterClick);
        System.out.println(validateText.getText());


        driver.quit();




    }
}
