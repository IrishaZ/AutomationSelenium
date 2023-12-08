package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
//    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@type='email']")
    private WebElement emailField;

    @FindBy(css = "[type='password']")
    private WebElement passwordField;

    @FindBy (tagName = "button")
    private WebElement loginButton;

    @FindBy(className = "error")
    private WebElement errorFrame;

    public pageObjects.MainPage loginToApp(String username, String password){
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return new MainPage(driver);
    }
    public void openPage(String url){driver.get(url);
    }
    public boolean isError() {
        try {
            return errorFrame.isDisplayed();
        } catch (NoSuchElementException err){
            return false;
        }
    }
    public boolean isRedirected(){
        By homeIconLocator = By.cssSelector("[class = 'home active']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homeIconLocator));
            return true;
        } catch(TimeoutException err){
            return false;
        }
    }
    public boolean isOpen(){
        try {
            wait.until(ExpectedConditions.visibilityOf(loginButton));
            return true;
        } catch(TimeoutException err){
            return false;
        }
    }

}