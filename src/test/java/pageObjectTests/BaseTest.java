package pageObjectTests;

import com.github.javafaker.Faker;
import enums.BrowserType;
import helper.BrowserFabric;
import helper.Token;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObjects.MainPage;

public class BaseTest {
    protected WebDriver driver;
    protected String url;
    protected String username;
    protected String password;
    protected Faker faker;
    protected String token;

    @Parameters({"url","username","password","browser"})
    @BeforeMethod
    public void startUp(String url, String username, String password,String browser) {
        this.url=url;
        this.username = username;
        this.password=password;
        token = Token.get(username,password,url);
        BrowserType bt = browser.equals("Chrome") ? BrowserType.CHROME : BrowserType.FIREFOX;

        driver = BrowserFabric.getDriver(bt);

        faker = new Faker();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public MainPage login(){
        driver.get(url);

        String key = "api-token";
        String value = "\""+token+"\"";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.setItem(arguments[0],arguments[1])",key,value);

        driver.navigate().refresh();
        return new MainPage(driver);
    }
}
