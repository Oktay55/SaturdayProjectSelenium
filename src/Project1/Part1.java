package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part1 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/oktaysaglam/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");

        driver.manage().window().maximize();

        String userName = "Automation";
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys(userName);

        String userEmail = "Testing@gmail.com";
        WebElement emailAddress = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        emailAddress.sendKeys(userEmail);

        String userCurrentAddress = "Testing Current Address";
        WebElement currentAddress = driver.findElement(By.cssSelector("#currentAddress"));
        currentAddress.sendKeys(userCurrentAddress);

        String userPermAddress = "Testing Permanent Address";
        WebElement permanentAddress = driver.findElement(By.cssSelector("#permanentAddress"));
        permanentAddress.sendKeys(userPermAddress);

        WebElement submit = driver.findElement(By.cssSelector("#submit"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down by 2000 pixels
        js.executeScript("window.scrollBy(0,300)");
        submit.click();

        driver.quit();



    }
}
