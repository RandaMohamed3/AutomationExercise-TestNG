package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By loginHeader = By.xpath("//h2[text()='Login to your account']");
    By emailInput = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
    By passwordInput = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");
    By loggedInMsg = By.xpath("//a[contains(text(),'Logged in as')]");
    By loggedOutBtn = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    By deleteAccountBtn = By.xpath("//a[@href='/delete_account']");


    public boolean isLoginHeaderVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeader)).isDisplayed();
    }

    public void login(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public boolean isLoggedIn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInMsg)).isDisplayed();
    }
    public void clickLogout() {
        driver.findElement(loggedOutBtn).click();
    }

    public void clickDeleteAccount() {
        driver.findElement(deleteAccountBtn).click();
    }

}
