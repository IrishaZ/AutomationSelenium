package pageObjectTests.Additions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SimpleTest {
    @Test
    public void simpleTest(){
        System.setProperty("web.chrome.driver","chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
//                options.addArguments("--headless");
        options.addArguments("window-size=1400,1000");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa.koel.app");
        try{
            Thread.sleep(5000);
        } catch
        (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
    @Test(groups = "smoke")
    public void testLogin() {
        System.out.println("Executing login test.");
    }

    @Test(groups = "smoke")
    public void testHomePage() {
        System.out.println("Executing home page test.");
    }

    @Test(groups = "regression")
    public void testProductSearch() {
        System.out.println("Executing product search test.");
    }

    @Test(groups = "regression")
    public void testCheckout() {
        System.out.println("Executing checkout test.");
    }


}
