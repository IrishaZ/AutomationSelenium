package pageObjectTests;

import com.github.javafaker.Faker;
import enums.BrowserType;
import helper.BrowserFabric;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    protected String url;
    protected String username;
    protected String password;
    protected Faker faker;

    @Parameters({"url","username","password","browser"})
    @BeforeMethod
    public void startUp(String url, String username, String password,String browser) {
        this.url=url;
        this.username = username;
        this.password=password;
        BrowserType bt = browser.equals("Chrome") ? BrowserType.CHROME : BrowserType.FIREFOX;

//        BrowserType bt;
//        if(browser.equals("Chrome")){
//            bt=BrowserType.CHROME;
//        } else {
//            bt=BrowserType.FIREFOX;
//        }

        driver = BrowserFabric.getDriver(bt);

        faker = new Faker();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
