package helper;

import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFabric {
    public static WebDriver getDriver(BrowserType browserType){
        switch (browserType){
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
//                options.addArguments("--headless");
                options.addArguments("--width=1000");
                options.addArguments("--height=700");
                return new FirefoxDriver(options);
            }
            case EDGE:{
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            default:{
                System.setProperty("web.chrome.driver","chromedriver.exe");
//                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--headless");
                options.addArguments("window-size=1400,1000");
                return new ChromeDriver(options);
            }
        }
    }

}
