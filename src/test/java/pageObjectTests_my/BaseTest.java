package pageObjectTests_my;

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
    protected String email;
    protected String password;
    protected Faker faker;
    @Parameters({"url","email","password","browser"})
    @BeforeMethod
    public void beforeAll(String url, String email, String password,String browser){
        this.url=url;
        this.email = email;
        this.password=password;
        BrowserType bt = browser.equals("Firefox") ? BrowserType.FIREFOX : BrowserType.CHROME;
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
    public void afterAll() throws InterruptedException {
        Thread.sleep(100);
        driver.quit();
    }

}