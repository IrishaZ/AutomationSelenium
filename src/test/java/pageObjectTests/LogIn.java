package pageObjectTests;
import api.Api;
import helper.Token;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import testData.TestData;

public class LogIn extends BaseTest {
    String wrongPassword="Password";
    String oldPassword;
    String oldEmail;
    @Test
    public void loginCorrectCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(url);
        MainPage mainPage =loginPage.loginToApp(email,password);
        Assert.assertTrue(mainPage.isOpen());
    }
    @Test( dataProvider = "invalidCredentialsFrontEnd", dataProviderClass = TestData.class)
    public void loginWithInvalidCredentialsFrontEnd(String userEmail, String userPassword) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(url);
        loginPage.loginToApp(userEmail,userPassword);
        Assert.assertFalse(loginPage.isRedirected());
    }
    @Test( dataProvider = "invalidCredentialsBackEnd", dataProviderClass = TestData.class)
    public void loginWithInvalidCredentialsBackEnd(String userEmail, String userPassword) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(url);
        loginPage.loginToApp(userEmail,userPassword);
        Assert.assertTrue(loginPage.isError());
    }
    @Test
    public void logInAfterUpdatedEmail() {
        String newEmail="new"+email;
        oldEmail=newEmail;
        Api.updateUser(url,token,"student",newEmail,password,password);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(url);
        MainPage mainPage =loginPage.loginToApp(newEmail,password);
        Assert.assertTrue(mainPage.isOpen());

        String newToken= Token.getToken(newEmail,password,url);
        Api.updateUser(url,newToken,"student",email,password,password);

    }
    @Test
    public void logInWithOldEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(url);
        loginPage.loginToApp(oldEmail,password);
        Assert.assertFalse(loginPage.isRedirected());
    }
    @Test
    public void logInAfterUpdatedPassword() {
        String newPassword="new"+password;
        oldPassword=newPassword;
        Api.updateUser(url,token,"student",email,password,newPassword);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(url);
        MainPage mainPage =loginPage.loginToApp(email,newPassword);
        Assert.assertTrue(mainPage.isOpen());

        String newToken= Token.getToken(email,newPassword ,url);
        Api.updateUser(url,newToken,"student",email,newPassword,password);
    }
    @Test
    public void logInWithOldPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(url);
        loginPage.loginToApp(oldEmail,password);
        Assert.assertFalse(loginPage.isRedirected());
    }

}