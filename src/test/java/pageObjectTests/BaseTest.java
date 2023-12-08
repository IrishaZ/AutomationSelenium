package pageObjectTests;

import com.github.javafaker.Faker;
import helper.PickBrowser;
import helper.Token;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected String url;
    protected String email;
    protected String password;
    protected Faker faker;
    protected String token;
    protected WebDriverWait wait;
    @Parameters({"url","email","password","browser"})
    @BeforeMethod
    public void beforeAll(String url, String email, String password,String browser){
        this.url=url;
        this.email = email;
        this.password=password;
        driver= PickBrowser.pickBrowser(browser);
        token = Token.getToken(email,password,url);
        faker = new Faker();
        wait = new WebDriverWait(driver, Duration.ofMillis(200),Duration.ofMillis(1000));
    }
    @AfterMethod
    public void afterAll() throws InterruptedException {
        Thread.sleep(1000);
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
    public LoginPage logOut(){
        WebElement logOutButton= driver.findElement(By.cssSelector("[class='fa fa-sign-out']"));
        wait.until(ExpectedConditions.elementToBeClickable(logOutButton));
        logOutButton.click();
        return new LoginPage(driver);
    }

}