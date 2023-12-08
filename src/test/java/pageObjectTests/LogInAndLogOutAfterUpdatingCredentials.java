package pageObjectTests;
import api.Api;
import helper.Token;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import testData.TestData;

public class LogInAndLogOutAfterUpdatingCredentials extends BaseTest {
    String wrongPassword="Password";
    String oldPassword;
    String oldEmail;
    String newPassword;

    @BeforeMethod
    public void beforeAll(){
           }

    @AfterMethod
    public void afterAll(){
         }
    @Test
    public void logInAfterUpdatedEmail() throws InterruptedException {
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
    public void logInWithOldEmail() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(url);
        loginPage.loginToApp(oldEmail,password);
        Assert.assertFalse(loginPage.isRedirected());
    }
    @Test
    public void logInAfterUpdatedPassword() throws InterruptedException {
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
    public void logInWithOldPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(url);
        loginPage.loginToApp(oldEmail,password);
        Assert.assertFalse(loginPage.isRedirected());
    }

}