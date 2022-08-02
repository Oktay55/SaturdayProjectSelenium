package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part2 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/oktaysaglam/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.applitools.com/");

        driver.manage().window().maximize();

        String enterName = "ttechno@gmail.com";
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(enterName);

        String userPassword = "techno123";
        WebElement enterUserPassword = driver.findElement(By.id("password"));
        enterUserPassword.sendKeys(userPassword);

        WebElement clickOnSignIn = driver.findElement(By.id("log-in"));
        clickOnSignIn.click();

        WebElement displayMessage = driver.findElement(By.id("time"));
        String str = displayMessage.getText();
        System.out.println(str);

        System.out.println(driver.getCurrentUrl());

        driver.quit();


    }
}
