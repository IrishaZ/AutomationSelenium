package simpleTest_my;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class createPlaylist {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    @BeforeMethod
    public void beforeAll() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10,100);
        actions = new Actions(driver);
        System.setProperty("web.chrome.driver", "chromedriver.exe");
        driver.get("https://qa.koel.app");
        WebElement emailField = driver.findElement(By.xpath("//*[@type='email']"));
        WebElement loginField = driver.findElement(By.cssSelector("[type='password']"));
        WebElement loginButton = driver.findElement(By.tagName("button"));
        emailField.sendKeys("demo@class.com");
        loginField.sendKeys("te$t$tudent");
        loginButton.click();
        By homeIconLocator = By.cssSelector("[class = 'home active']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeIconLocator));
    }
    @AfterMethod
    public void afterAll() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void createPlaylist() throws InterruptedException {
        By plusButtonLocator = By.cssSelector("[title='Create a new playlist']");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(plusButtonLocator));
        WebElement plusButton= driver.findElement(plusButtonLocator);
        plusButton.click();
        WebElement newPlaylist = driver.findElement(By.xpath("//*[text()='New Playlist']"));
        newPlaylist.click();
        WebElement enterField = driver.findElement(By.cssSelector("[name='name']"));
        enterField.sendKeys("added list");
        enterField.sendKeys(Keys.ENTER);
    }
    @Test
    public void deletePlaylist() throws InterruptedException {
        By addedPlaylistLocator = By.xpath("//*[text()='added list']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addedPlaylistLocator));
        WebElement addedPlaylist= driver.findElement(addedPlaylistLocator);
        actions.contextClick(addedPlaylist).build().perform();
        By deletePlaylistLocator = By.xpath("//*[text()='Delete']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(deletePlaylistLocator));
        WebElement deletePlaylist= driver.findElement(deletePlaylistLocator);
        deletePlaylist.click();
    }


}