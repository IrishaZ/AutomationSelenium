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
    protected String email;
    protected String password;
    protected Faker faker;
    protected String token;
    @Parameters({"url","email","password","browser"})
    @BeforeMethod
    public void beforeAll(String url, String email, String password,String browser){
        this.url=url;
        this.email = email;
        this.password=password;

        BrowserType bt = browser.equals("Firefox") ? BrowserType.FIREFOX : BrowserType.CHROME;

        // BrowserType bt; // if(browser.equals("Chrome")){bt=BrowserType.CHROME;} else {bt=BrowserType.FIREFOX;}
        driver = BrowserFabric.getDriver(bt);
        token = Token.getToken(email,password,url);
        faker = new Faker();
        System.out.println("Before method in base test");
    }
    @AfterMethod
    public void afterAll() throws InterruptedException {
        Thread.sleep(100);
        driver.quit();
        System.out.println("After method in base test");
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