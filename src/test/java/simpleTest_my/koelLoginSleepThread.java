package simpleTest_my;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class koelLoginSleepThread {
    private WebDriver driver;
    @BeforeMethod
    public void beforeAll(){
        driver = new ChromeDriver();
        System.setProperty("web.chrome.driver", "chromedriver.exe");
        driver.get("https://qa.koel.app");
    }
    @AfterMethod
    public void afterAll() throws InterruptedException {
        Thread.sleep(100);
        driver.quit();
    }
    @Test
    public void loginCorrectCredentials() throws InterruptedException {
        By emailFieldLocator = By.xpath("//*[@type='email']");
        WebElement emailField = driver.findElement(emailFieldLocator);
        By loginFieldLocator = By.cssSelector("[type='password']");
        WebElement loginField = driver.findElement(loginFieldLocator);
        By loginButtonLocator = By.tagName("button");
        WebElement loginButton = driver.findElement(loginButtonLocator);
        emailField.sendKeys("demo@class.com");
        loginField.sendKeys("te$t$tudent");
        loginButton.click();
        Thread.sleep(2000);
        By homeIconLocator = By.cssSelector("[class = 'home active']");
        WebElement homeIcon = driver.findElement(homeIconLocator);
        Assert.assertTrue(homeIcon.isDisplayed());
    }
    @Test
    public void loginWrongPassword() throws InterruptedException {
        By emailFieldLocator = By.xpath("//*[@type='email']");
        WebElement emailField = driver.findElement(emailFieldLocator);
        By loginFieldLocator = By.cssSelector("[type='password']");
        WebElement loginField = driver.findElement(loginFieldLocator);
        By loginButtonLocator = By.tagName("button");
        WebElement loginButton = driver.findElement(loginButtonLocator);
        emailField.sendKeys("demo@class.com");
        loginField.sendKeys("wrongPassword");
        loginButton.click();
        Thread.sleep(2000);
        By errorLocator = By.className("error");
        WebElement error = driver.findElement(errorLocator);
        Assert.assertTrue(error.isDisplayed());
    }

}