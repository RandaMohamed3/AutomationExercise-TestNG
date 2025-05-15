package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsTest extends BaseTest {

    @Test
    public void testContactUsTest() {
        // Navigate to Contact Us
        homePage.clickContactUs();

        // Verify 'GET IN TOUCH'
        contactUsPage = new ContactUsPage(driver);
        Assert.assertTrue(contactUsPage.isGetInTouchVisible());

        // Submit the form
        String filePath = System.getProperty("user.dir") + "/src/test/testfile.txt";
        contactUsPage.submitForm("Randa", "randa@test.com", "Test Subject", "Test Message", filePath);

        // Handle alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // Verify success message
        Assert.assertTrue(contactUsPage.isSuccessMessageVisible());

        // Click Home and verify redirection
        contactUsPage.clickHome();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
    }
}