package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utilities.ElementHelper;

public class ProductsPage {
    WebDriver driver;
    ElementHelper helper;

    @FindBy(xpath = "//h2[text()='All Products']")
    WebElement allProductsHeader;

    @FindBy(className = "features_items")
    WebElement productList;

    @FindBy(xpath = "(//div[@class='product-overlay']//a[contains(text(),'Add to cart')])[1]")
    WebElement firstAddToCartBtn;

    @FindBy(xpath = "(//div[@class='product-overlay']//a[contains(text(),'Add to cart')])[2]")
    WebElement secondAddToCartBtn;

    @FindBy(xpath = "(//a[text()='Add to cart'])[3]")
    WebElement thirdAddToCartBtn;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement continueShoppingBtn;

    @FindBy(xpath = "//u[text()='View Cart']")
    WebElement viewCartLink;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new ElementHelper(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean isAllProductsHeaderVisible() {
        return allProductsHeader.isDisplayed();
    }

    public boolean isProductsListVisible() {
        return productList.isDisplayed();
    }

    public void clickFirstViewProduct() {
        helper.waitForAdToDisappear();

        WebElement viewProduct = ElementHelper.waitForPresence(driver, By.xpath("(//a[text()='View Product'])[1]"), 10);
        helper.jsClick(viewProduct);
    }
}
