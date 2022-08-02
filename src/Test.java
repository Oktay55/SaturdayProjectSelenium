import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/oktaysaglam/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");

        driver.manage().window().maximize();

        String fullName = "Automation";
        WebElement automation = driver.findElement(By.cssSelector("input[placeholder='Full Name']"));
        automation.sendKeys(fullName);


        String email1 = "Testing@gmail.com";
        WebElement emailInput = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        emailInput.sendKeys(email1);

        String address = "Testing Current Address";
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(address);

        String permanent = " Testing Permanent Address";
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(permanent);

        WebElement submit = driver.findElement(By.cssSelector("#submit"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down by 2000 pixels
        js.executeScript("window.scrollBy(0,300)");

        submit.click();



    }
}
