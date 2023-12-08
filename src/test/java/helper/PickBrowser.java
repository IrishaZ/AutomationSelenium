package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class PickBrowser {
    public static WebDriver pickBrowser(String browser){
        switch (browser){
            case "Firefox": {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
//                options.addArguments("--headless");
                options.addArguments("--width=1000");
                options.addArguments("--height=700");
                return new FirefoxDriver(options);
            }
            case "Edge":{
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            default:{
                System.setProperty("web.chrome.driver","chromedriver.exe");
//                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--headless");
                options.addArguments("window-size=1500,1200");
                return new ChromeDriver(options);
            }
        }
    }

}
