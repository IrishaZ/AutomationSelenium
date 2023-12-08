package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver driver){
        super(driver);
    }
    @FindBy(css = "[name='current_password']")
    private WebElement currentPasswordField;
    @FindBy(id = "inputProfileName")
    private WebElement profileNameField;
    @FindBy(id = "inputProfileEmail")
    private WebElement profileEmailField;
    @FindBy(css = "[name='new_password']")
    private WebElement newPasswordField;
    @FindBy(xpath = "//*[text()='Save']")
    private WebElement saveButton;
    @FindBy(css = "[data-testid='btn-logout']")
    private WebElement logOutButton;
    @FindBy(xpath = "//*[@class='success show']")
    private WebElement successBanner;
    public void updatePassword(String password, String newPassword) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(currentPasswordField));
        enterText(currentPasswordField,password);
        newPasswordField.sendKeys(newPassword);
        saveButton.click();
    }
    public LoginPage logOut(){
       wait.until(ExpectedConditions.elementToBeClickable(logOutButton));
       logOutButton.click();
       return new LoginPage(driver);
    }
    public boolean successBannerIsDisplayed(){
        try {
            wait.until(ExpectedConditions.visibilityOf(successBanner));
            return true;
        } catch(TimeoutException err){
            return false;
        }
    }

}
