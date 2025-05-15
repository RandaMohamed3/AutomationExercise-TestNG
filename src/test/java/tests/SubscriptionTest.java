package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class SubscriptionTest extends BaseTest {
    @Test
    public void testSubscriptionInHomePage() {
        homePage = new HomePage(driver);
        homePage.scrollToFooter();

        Assert.assertTrue(homePage.isSubscriptionTextVisible());

        homePage.enterEmailAndSubmit("randa@test.com");

        Assert.assertTrue(homePage.isSuccessMessageVisible());
    }
    @Test
    public void testSubscriptionInCartPage() {
        CartPage cartPage = new CartPage(driver);
        homePage = new HomePage(driver);

        homePage.clickCart();
        cartPage.scrollToFooter();
        Assert.assertTrue(cartPage.isSubscriptionTextVisible());

        cartPage.enterEmailForSubscription("test@email.com");
        cartPage.clickSubscribeButton();

        Assert.assertTrue(cartPage.isSuccessMessageVisible());
    }

}
