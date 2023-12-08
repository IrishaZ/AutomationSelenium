package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPageSpare extends BasePage{
    public LoginPageSpare(WebDriver driver) {
        super(driver);
    }
    public WebElement getEmailField(){
        By emailFieldLocator = By.xpath("//*[@type='email']");
        return driver.findElement(emailFieldLocator);
    }
    public WebElement getPasswordField(){
        By loginFieldLocator = By.cssSelector("[type='password']");
        return driver.findElement(loginFieldLocator);
    }
    public WebElement getLoginButton(){
        By loginButtonLocator = By.tagName("button");
        return driver.findElement(loginButtonLocator);
    }
    public void openPage(String url){
        driver.get(url);
    }
    public MainPage loginToApp(String email, String password){
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
        return new MainPage(driver);
    }
    public  boolean isError(){
        By errorLocator = By.className("error");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
            return true;
        } catch (NoSuchElementException err){
            return false;
        }
    }

}