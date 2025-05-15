package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignUpPage;

public class SignUp_Login_Tests extends BaseTest {
    String name = "RandaTest";
    String email = "randa" + System.currentTimeMillis() + "@test.com";
    String password = "123456";

    @Test(priority = 1)
    public void registerNewUser() {
        homePage.clickSignupLogin();
        signupPage = new SignUpPage(driver);
        signupPage.enterNameAndEmail(name, email);
        signupPage.clickSignupButton();
        signupPage.fillAccountDetails("Ms", password, "12", "May", "2000");
        signupPage.selectNewsletters();
        signupPage.fillAddress("Randa", "Test", "Test Company", "Test Address", "Cairo", "Australia", "12345", "01001234567");
        signupPage.clickCreateAccount();
        Assert.assertTrue(signupPage.isAccountCreatedVisible());
        signupPage.clickContinueAfterRegister();
        Assert.assertTrue(signupPage.isLoggedInAsVisible(name));
    }

    @Test(priority = 2)
    public void loginWithCorrectCredentials() {
        homePage.clickSignupLogin();
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginHeaderVisible());
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isLoggedIn());
    }

    @Test(priority = 3)
    public void loginWithIncorrectCredentials() {
        homePage.clickSignupLogin();
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginHeaderVisible());
        loginPage.login("wrong@email.com", "wrongpass");
        boolean isErrorShown = driver.getPageSource().contains("Your email or password is incorrect!");
        Assert.assertTrue(isErrorShown, "Expected error message not shown");
    }

    @Test(priority = 4)
    public void logoutUser() {
        // login first
        homePage.clickSignupLogin();
        loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isLoggedIn());
        loginPage.clickLogout();

        // confirm we're back to login page
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test(priority = 5)
    public void registerUserWithExistingEmail() {
        homePage.clickSignupLogin();
        signupPage = new SignUpPage(driver);
        signupPage.enterNameAndEmail("RandaTest", email);  // existing email
        signupPage.clickSignupButton();

        boolean isErrorShown = driver.getPageSource().contains("Email Address already exist!");
        Assert.assertTrue(isErrorShown, "Expected error message not shown");
    }
    @Test(priority = 6)
    public void deleteAccount() {
        homePage.clickSignupLogin();
        loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isLoggedIn());
        loginPage.clickDeleteAccount();
    }
}
