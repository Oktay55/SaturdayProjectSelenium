package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Scenario2 {

    public static void main(String[] args) {

        String cartItemsAfterAdding="1";
        String cartItemsAfterRemoving="0";

        System.setProperty("webdriver.chrome.driver", "/Users/oktaysaglam/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://shopdemo.e-junkie.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement addToCart = driver.findElement(By.xpath("(//button[text()=' Add To Cart'])[2]"));
        addToCart.click();

        WebElement iFrame1 = driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));

        wait.until(ExpectedConditions.visibilityOf(iFrame1));

        driver.switchTo().frame(iFrame1);

        WebElement addedCartItem = driver.findElement(By.xpath("//*[@id=\"Overlay\"]/div/div[2]/div/div[2]/div[1]/span"));
        String verifyCartItem = addedCartItem.getText();
        System.out.println("after Added Cart Item = " + cartItemsAfterAdding);
        if (verifyCartItem.equals(cartItemsAfterAdding)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        WebElement removeButton = driver.findElement(By.xpath("//button[@class ='Product-Remove']"));
        wait.until(ExpectedConditions.visibilityOf(removeButton));
        removeButton.click();

        WebElement continueShoppingButton = driver.findElement(By.xpath("//button[@class ='Continue-Button Close-Cart']"));
        continueShoppingButton.click();

        driver.switchTo().defaultContent();

        WebElement afterRemoveItem = driver.findElement(By.xpath("//span[@id='cart_item_nos']"));
        String ItemCartTextAfterRemoving = afterRemoveItem.getText();
        System.out.println("After Removed Cart Item = " + cartItemsAfterRemoving);

        if (ItemCartTextAfterRemoving.equals(cartItemsAfterRemoving)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();

















    }
}
