package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCasesTest extends BaseTest {

    @Test
    public void testVerifyTestCasesPage() {
        // Click on 'Test Cases'
        homePage.clickTestCases();

        // Verify navigation to test cases page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/test_cases"), "Not navigated to test cases page");
    }
}

