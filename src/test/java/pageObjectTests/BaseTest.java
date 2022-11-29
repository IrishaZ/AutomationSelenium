package pageObjectTests;

import enums.BrowserType;
import helper.BrowserFabric;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected String url;
    protected String username;
    protected String password;

    @BeforeMethod
    public void startUp() {
        driver = BrowserFabric.getDriver(BrowserType.CHROME);

        url="https://bbb.testpro.io";
        username="sim@email.com";
        password = "te$t$tudent";
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
