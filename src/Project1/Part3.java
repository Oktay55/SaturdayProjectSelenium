package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Part3 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/oktaysaglam/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

        driver.get("https://www.snapdeal.com/");

        driver.manage().window().maximize();

        String searchMessageInSearchBox = "teddy bear";
        WebElement searchMessage = driver.findElement(By.id("inputValEnter"));
        searchMessage.sendKeys(searchMessageInSearchBox);

        WebElement clickSearchBox = driver.findElement(By.cssSelector("button[class='searchformButton col-xs-4 rippleGrey']"));
        clickSearchBox.click();

        WebElement displayText = driver.findElement(By.cssSelector("#searchMessageContainer>div>span"));
        String str = displayText.getText();
        System.out.println(str);

        System.out.println(driver.getCurrentUrl());


        WebElement clickOnLogo = driver.findElement(By.cssSelector("img[class = 'notIeLogoHeader aspectRatioEqual sdLogo cur-pointer']"));
        clickOnLogo.click();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();

        WebElement currentValue = driver.findElement(By.id("inputValEnter"));
        String currentValueText = currentValue.getAttribute("value");
        System.out.println(currentValueText);


        if (searchMessageInSearchBox.equals(currentValueText)){
            System.out.println("Passed!");
        }else {
            System.out.println("Failed!");
        }







        driver.quit();






    }
}

