package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class Product_ProductDetailTest extends BaseTest {
    @Test
    public void testProductDetailsPage() {
        homePage.clickProducts();
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isAllProductsHeaderVisible());
        Assert.assertTrue(productsPage.isProductsListVisible());

        productsPage.clickFirstViewProduct();

        productDetailPage = new ProductDetailPage(driver);
        Assert.assertTrue(productDetailPage.isProductNameVisible());
        Assert.assertTrue(productDetailPage.isCategoryVisible());
        Assert.assertTrue(productDetailPage.isPriceVisible());
        Assert.assertTrue(productDetailPage.isAvailabilityVisible());
        Assert.assertTrue(productDetailPage.isConditionVisible());
        Assert.assertTrue(productDetailPage.isBrandVisible());
    }
    @Test
    public void testSearchProduct() {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        searchPage = new SearchPage(driver);

        homePage.clickProducts();

        Assert.assertTrue(productsPage.isAllProductsHeaderVisible());

        searchPage.enterSearchText("dress");
        searchPage.clickSearchButton();

        Assert.assertTrue(searchPage.isSearchedProductsTitleVisible());

        Assert.assertTrue(searchPage.areSearchResultsVisible());
    }
}