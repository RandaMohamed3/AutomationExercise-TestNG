package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement signupLoginBtn;

    @FindBy(linkText = ("Contact us"))
    WebElement contactUsBtn;

    @FindBy(linkText = ("Test Cases"))
    WebElement testCasesBtn;

    @FindBy(xpath = "//a[text()=' Products']")
    WebElement productsBtn;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")
    WebElement cartBtn;

    @FindBy(id = "susbscribe_email")
    WebElement subscriptionEmailField;

    @FindBy(id = "subscribe")
    WebElement subscribeBtn;

    @FindBy(xpath = "//h2[text()='Subscription']")
    WebElement subscriptionText;

    @FindBy(xpath = "//*[contains(text(),'You have been successfully subscribed!')]")
    WebElement successMsg;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignupLogin() {
        signupLoginBtn.click();
    }

    public void clickContactUs() {
        contactUsBtn.click();
    }

    public void clickTestCases() {
        testCasesBtn.click();
    }

    public void clickProducts() {
        productsBtn.click();
    }

    public void clickCart() {
        cartBtn.click();
    }

    public void scrollToFooter() {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public boolean isSubscriptionTextVisible() {
        return subscriptionText.isDisplayed();
    }

    public void enterEmailAndSubmit(String email) {
        subscriptionEmailField.sendKeys(email);
        subscribeBtn.click();
    }

    public boolean isSuccessMessageVisible() {
        return successMsg.isDisplayed();
    }

}
