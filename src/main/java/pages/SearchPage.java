package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchInput = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By searchedProductsTitle = By.xpath("//h2[text()='Searched Products']");
    private By searchResults = By.xpath("//div[@class='features_items']/div");

    public void enterSearchText(String productName) {
        driver.findElement(searchInput).sendKeys(productName);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public boolean isSearchedProductsTitleVisible() {
        return driver.findElement(searchedProductsTitle).isDisplayed();
    }

    public boolean areSearchResultsVisible() {
        List<WebElement> products = driver.findElements(searchResults);
        return products.size() > 0;
    }
}

