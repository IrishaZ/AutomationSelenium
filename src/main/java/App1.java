import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App1 {
    public static void main(String[] args) {
        System.out.println("Hi");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://translate.google.com/");
        driver.quit();
    }
}
