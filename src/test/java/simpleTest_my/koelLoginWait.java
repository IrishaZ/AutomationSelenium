package simpleTest_my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class koelLoginWait {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeMethod
    public void beforeAll(){
        driver = new ChromeDriver();
        System.setProperty("web.chrome.driver", "chromedriver.exe");
        wait = new WebDriverWait(driver,10,200);
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
        By homeIconLocator = By.cssSelector("[class = 'home active']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeIconLocator));
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
        By errorLocator = By.className("error");
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
        WebElement error = driver.findElement(errorLocator);
        Assert.assertTrue(error.isDisplayed());
    }

}