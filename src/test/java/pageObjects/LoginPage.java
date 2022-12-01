package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage{
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getEmailField(){
        log.debug("Search emailField");
        return driver.findElement(By.xpath("//*[@type='email']"));
    }

    private WebElement getPasswordField(){
        log.debug("Search passwordField");
        return driver.findElement(By.xpath("//*[@type='password']"));
    }

    private WebElement getLoginButton(){
        By loginButtonLocator = By.tagName("button");
        return driver.findElement(loginButtonLocator);
    }

    public MainPage loginToApp(String username, String password){
        log.debug("Log to app");
        log.info("Username = "+username);
        log.info("Password = "+password);
        getEmailField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
        return new MainPage(driver);
    }
    public void open(String url){
        driver.get(url);
        log.error("Page opened");
    }

    public boolean isError() {
        By errorLocator = By.className("error");
        try {
            log.warn("Wrong password - Expected");
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
            return true;
        } catch (TimeoutException err){
            log.fatal("We got a bug");
            return false;
        }
    }
}
