package simpleTest_my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class seleniumTry {
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
    public void seleniumTry(){
        String url = driver.getCurrentUrl();
        System.out.println(url);
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        WebElement button = driver.findElement(By.tagName("Button"));
        ArrayList<WebElement> buttons = (ArrayList<WebElement>) driver.findElements(By.tagName("Button"));
        System.out.println(buttons.size());
        System.out.println(button.getText());
        System.out.println(button.getAttribute("type"));
        System.out.println(button.getCssValue("background"));
    }
}