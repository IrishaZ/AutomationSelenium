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
    @FindBy(css = "[name='name']")
    private WebElement nameField;
    @FindBy(css = "[name='email']")
    private WebElement emailField;
    @FindBy(css = "[name='new_password']")
    private WebElement newPasswordField;
    @FindBy(xpath ="//*[text()='Save']")
    private WebElement saveButton;

    public void passwordUpdate(){

    }
    public void credentialsUpdate(String currentPassword,String newEmail, String newPassword ) throws InterruptedException {
        enterText(currentPasswordField,currentPassword);
        enterText(emailField,newEmail);
        enterText(newPasswordField,newPassword);
        saveButton.click();
    }
}
