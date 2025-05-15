package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    WebDriver driver;

    @FindBy(name = "name")
    WebElement nameField;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "subject")
    WebElement subjectField;

    @FindBy(name = "message")
    WebElement messageField;

    @FindBy(name = "upload_file")
    WebElement uploadField;

    @FindBy(name = "submit")
    WebElement submitBtn;

    @FindBy(xpath = "//div[contains(text(),'Success! Your details have been submitted successfully.')]")
    WebElement successMessage;

    @FindBy(xpath = "//a[text()=' Home']")
    WebElement homeBtn;

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    WebElement getInTouchHeader;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void submitForm(String name, String email, String subject, String message, String filePath) {
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        subjectField.sendKeys(subject);
        messageField.sendKeys(message);
        uploadField.sendKeys(filePath);
        submitBtn.click();
    }

    public boolean isGetInTouchVisible() {
        return getInTouchHeader.isDisplayed();
    }

    public boolean isSuccessMessageVisible() {
        return successMessage.isDisplayed();
    }

    public void clickHome() {
        homeBtn.click();
    }
}
