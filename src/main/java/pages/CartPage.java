package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class CartPage {
    WebDriver driver;

    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    WebElement subscriptionText;

    @FindBy(id = "susbscribe_email")
    WebElement emailInput;

    @FindBy(id = "subscribe")
    WebElement subscribeButton;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    WebElement successMessage;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void scrollToFooter() {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public boolean isSubscriptionTextVisible() {
        return subscriptionText.isDisplayed();
    }

    public void enterEmailForSubscription(String email) {
        emailInput.sendKeys(email);
    }

    public void clickSubscribeButton() {
        subscribeButton.click();
    }

    public boolean isSuccessMessageVisible() {
        return successMessage.isDisplayed();
    }
}
