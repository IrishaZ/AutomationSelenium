package pageObjectTests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTestOriginal {
    protected WebDriver driver;
    protected String url;
    protected String email;
    protected String password;
    protected Faker faker;
    @Parameters({"url","username","password","browser"})
    @BeforeMethod
    public void beforeAll(){
//        System.setProperty("web.chrome.driver", "chromedriver.exe");
//        after installing WebDriverManager we delete file chromedrive.exe
//        and use that:
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        url= "https://qa.koel.app";
        email = "demo@class.com";
        password = "te$t$tudent";
    }

    @AfterMethod
    public void afterAll() throws InterruptedException {
        Thread.sleep(100);
        driver.quit();
    }

}