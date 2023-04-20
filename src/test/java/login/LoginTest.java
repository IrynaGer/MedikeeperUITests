package login;

import org.testng.annotations.Test;
import pages.LoginPage;
import  org.testng.asserts.Assertion;

public class LoginTest extends BaseTest {
    @Test
    public void verifyUserLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(createDriver());
        loginPage.goToLoginPage(URL);
        loginPage.getInputUsername().sendKeys("user");
        loginPage.getInputPassword().sendKeys("pass");
        loginPage.getSubmitButton().click();
        loginPage.verifyUserLogedIn();

    }
    @Test
    public void verifyUserLoginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(createDriver());
        loginPage.goToLoginPage(URL);
        loginPage.getInputUsername().sendKeys("tttt");
        loginPage.getInputPassword().sendKeys("aaa");
        loginPage.getSubmitButton().click();
        loginPage.verifyErrorMessage("cancel\n" +
                "close\n" +
                "Error! You no longer have access to this system, if you have any questions please contact your administrator.");

    }

    @Test
    public void verifyUIElements() {
        LoginPage loginPage = new LoginPage(createDriver());
        loginPage.goToLoginPage(URL);
        loginPage.verifyInputUsername();
        loginPage.verifyInputPassword();
        loginPage.verifySubmitButton();


        loginPage.getInputPassword().sendKeys("pass");
        loginPage.getSubmitButton().click();
        loginPage.verifyUserLogedIn();

    }


    private static final String URL = "https://wwwprep.medikeeper.com/";
}
