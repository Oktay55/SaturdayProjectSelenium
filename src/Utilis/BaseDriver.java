package Utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseDriver {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {

        if(browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/oktaysaglam/Downloads/chromedriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("http://automationpractice.com/index.php");
        } else if(browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/oktaysaglam/Downloads/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("http://automationpractice.com/index.php");
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();


    }
}


