package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;
    HomePage homePage;
    SignUpPage signupPage;
    LoginPage loginPage;
    ContactUsPage contactUsPage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    SearchPage searchPage;
    CartPage cartPage;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}