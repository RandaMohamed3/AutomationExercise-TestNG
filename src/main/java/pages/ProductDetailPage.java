package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ProductDetailPage {
    WebDriver driver;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")
    WebElement productName;

    @FindBy(xpath = "//p[contains(text(),'Category')]")
    WebElement category;

    @FindBy(xpath = "//span[contains(text(),'Rs.')]")
    WebElement price;

    @FindBy(xpath = "//b[text()='Availability:']")
    WebElement availability;

    @FindBy(xpath = "//b[text()='Condition:']")
    WebElement condition;

    @FindBy(xpath = "//b[text()='Brand:']")
    WebElement brand;


    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductNameVisible() {
        return productName.isDisplayed();
    }

    public boolean isCategoryVisible() {
        return category.isDisplayed();
    }

    public boolean isPriceVisible() {
        return price.isDisplayed();
    }

    public boolean isAvailabilityVisible() {
        return availability.isDisplayed();
    }

    public boolean isConditionVisible() {
        return condition.isDisplayed();
    }

    public boolean isBrandVisible() {
        return brand.isDisplayed();
    }
}
