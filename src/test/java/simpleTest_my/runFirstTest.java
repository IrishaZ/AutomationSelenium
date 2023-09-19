package simpleTest_my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class runFirstTest {

    @Test
    public void runFirstTest(){
        System.setProperty("web.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa.koel.app");
        try{
            Thread.sleep(5000);
        } catch  (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}