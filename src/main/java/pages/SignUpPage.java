package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.ElementHelper;

public class SignUpPage {
    WebDriver driver;
    ElementHelper helper;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new ElementHelper(driver);

    }

    // Locators
    By nameField = By.xpath("//input[@data-qa='signup-name']");
    By emailField = By.xpath("//input[@data-qa='signup-email']");
    By signupButton = By.xpath("//button[@data-qa='signup-button']");

    By titleMs = By.id("id_gender2");
    public By password = By.id("password");
    By day = By.id("days");
    By month = By.id("months");
    By year = By.id("years");

    By newsletter = By.id("newsletter");
    By optin = By.id("optin");

    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By company = By.id("company");
    By address = By.id("address1");
    By state = By.id("state");
    By country = By.id("country");
    By city = By.id("city");
    By zip = By.id("zipcode");
    By mobile = By.id("mobile_number");

    By createAccountBtn = By.xpath("//button[@data-qa='create-account']");
    By accountCreatedMsg = By.xpath("//b[text()='Account Created!']");
    By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");
    By deleteAccount = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");
    By accountDeletedMsg = By.xpath("//b[text()='Account Deleted!']");

    // Actions
    public void enterNameAndEmail(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }

    public void fillAccountDetails(String title, String pass, String d, String m, String y) {
        if (title.equalsIgnoreCase("Ms")) {
            driver.findElement(titleMs).click();
        }
        driver.findElement(password).sendKeys(pass);
        new Select(driver.findElement(day)).selectByVisibleText(d);
        new Select(driver.findElement(month)).selectByVisibleText(m);
        new Select(driver.findElement(year)).selectByVisibleText(y);
    }

    public void selectNewsletters() {
        helper.waitForAdToDisappear();
        helper.jsClick(newsletter);
        helper.jsClick(optin);
    }

    public void fillAddress(String fname, String lname, String comp, String addr, String cityName, String countryName, String zipCode, String phone) {
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(company).sendKeys(comp);
        driver.findElement(address).sendKeys(addr);
        driver.findElement(state).sendKeys("State");
        driver.findElement(city).sendKeys(cityName);
        new Select(driver.findElement(country)).selectByVisibleText(countryName);
        driver.findElement(zip).sendKeys(zipCode);
        driver.findElement(mobile).sendKeys(phone);
    }

    public void clickCreateAccount() {
        helper.waitForAdToDisappear();
        helper.jsClick(createAccountBtn);
    }

    public boolean isAccountCreatedVisible() {
        return driver.findElement(accountCreatedMsg).isDisplayed();
    }

    public void clickContinueAfterRegister() {
        driver.findElement(continueBtn).click();
    }

    public boolean isLoggedInAsVisible(String username) {
        return driver.findElement(loggedInAs).getText().contains(username);
    }

    public void deleteAccount() {
        driver.findElement(deleteAccount).click();
    }

    public boolean isAccountDeletedVisible() {
        return driver.findElement(accountDeletedMsg).isDisplayed();
    }
}
