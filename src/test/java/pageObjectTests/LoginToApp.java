package pageObjectTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class LoginToApp extends BaseTest {
    String wrongPassword="wrongPassword";
    @Test
    public void loginCorrectCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(url);
        MainPage mainPage =loginPage.loginToApp(email,password);
        Assert.assertTrue(mainPage.isOpen());
    }
    @Test
    public void loginWithWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(url);
        loginPage.loginToApp(email,wrongPassword);
        Assert.assertTrue(loginPage.isError());
    }

}