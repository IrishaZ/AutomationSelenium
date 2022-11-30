package pageObjectTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class LoginToApp extends BaseTest{
    @Test
    public void loginToApp_correctCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp(username, password);
        Assert.assertTrue(mainPage.isOpen());
    }
    @Test
    public void loginToApp_incorrectCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        loginPage.loginToApp(username,"WrongPassword");
        Assert.assertTrue(loginPage.isError());
    }
    @Test
    public void loginToApp_correctCredentials1(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp(username, password);
        Assert.assertTrue(mainPage.isOpen());
    }
    @Test
    public void loginToApp_incorrectCredentials1(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        loginPage.loginToApp(username,"WrongPassword");
        Assert.assertTrue(loginPage.isError());
    }
    @Test
    public void loginToApp_correctCredentials2(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp(username, password);
        Assert.assertTrue(mainPage.isOpen());
    }
    @Test
    public void loginToApp_incorrectCredentials2(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        loginPage.loginToApp(username,"WrongPassword");
        Assert.assertTrue(loginPage.isError());
    }
    @Test
    public void loginToApp_correctCredentials3(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp(username, password);
        Assert.assertTrue(mainPage.isOpen());
    }
    @Test
    public void loginToApp_incorrectCredentials3(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        loginPage.loginToApp(username,"WrongPassword");
        Assert.assertTrue(loginPage.isError());
    }

}
