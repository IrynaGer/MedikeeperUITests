package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class LoginPage extends BasePage {

    @FindBy(id = "ctl00_MainContent_loginForm_tbxLoginUsername")
    private WebElement inputUsername;

    @FindBy(id = "ctl00_MainContent_loginForm_tbxLoginPassword")
    private WebElement inputPassword;

    @FindBy(id = "ctl00_MainContent_loginForm_btnSubmitLogin")
    private WebElement submitButton;

    @FindBy(id = "ctl00_MainContent_errorMessageAlert")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage(String url) {
        getDriver().get(url);
        return this;
    }

    public void login(String username, String password) {

    }

    public WebElement getInputUsername() {
        return inputUsername;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void verifyUserLogedIn() {
    }

    public void verifyInputUsername() {
        getInputUsername().isDisplayed();
    }

    public void verifyInputPassword() {
        getInputPassword().isDisplayed();
    }

    public void verifySubmitButton() {
        getSubmitButton().isDisplayed();
    }

    public void verifyErrorMessage(String expectedMessage) {
        String message =  getErrorMessage().getText();
        Assert.assertEquals(expectedMessage, message);

    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}