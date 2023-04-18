package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, 10);
        }
        return wait;
    }

    protected void stopDriver() {
        driver.quit();
        wait = null;

    }

    static WebDriver createDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    @BeforeMethod
    protected void beforeMethod(Method method) {
        try {

            driver = createDriver();

        } catch (Exception e) {
            stopDriver();
            throw e;
        }
    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult testResult) {
        stopDriver();
    }
}
