package pageObjects.Draft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BasePage;
import pageObjects.MainPage;

public class LoginPageLogging extends BasePage {
    private static final Logger log = LogManager.getLogger(LoginPageSpare.class);

    public LoginPageLogging(WebDriver driver) {
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
    public void openPage(String url){
        driver.get(url);
        log.error("Page opened");
    }

    public boolean isError() {
        By errorLocator = By.className("error");
        try {
            log.warn("Wrong password - Expected");
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
            return true;
        } catch (NoSuchElementException err){
            log.fatal("We got a bug");
            return false;
        }
    }
}
