package pageObjectTests;

import listener.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPageFactory;
import pageObjects.MainPage;

public class LoginTestFactory extends BaseTest{
    int count = 0;
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void flakyTest(){
        if(count++<2){
            Assert.assertTrue(false);
        }
        Assert.assertTrue(true);
    }

    @Test
    public void loginToAppFactory_correctCredentials(){
        LoginPageFactory loginTestFactory = new LoginPageFactory(driver);
        loginTestFactory.open(url);
        MainPage mainPage = loginTestFactory.loginToApp(username,password);
        Assert.assertTrue(mainPage.isOpen());
    }
    @Test
    public void loginToAppFactory_incorrectCredentials(){
        LoginPageFactory loginTestFactory = new LoginPageFactory(driver);
        loginTestFactory.open(url);
        loginTestFactory.loginToApp(username,"wrongPassword");
        Assert.assertTrue(loginTestFactory.isError());
    }
    @Test
    public void loginToAppFactory_correctCredentials1(){
        LoginPageFactory loginTestFactory = new LoginPageFactory(driver);
        loginTestFactory.open(url);
        MainPage mainPage = loginTestFactory.loginToApp(username,password);
        Assert.assertTrue(mainPage.isOpen());
    }
    @Test
    public void loginToAppFactory_incorrectCredentials1(){
        LoginPageFactory loginTestFactory = new LoginPageFactory(driver);
        loginTestFactory.open(url);
        loginTestFactory.loginToApp(username,"wrongPassword");
        Assert.assertTrue(loginTestFactory.isError());
    }
    @Test
    public void loginToAppFactory_correctCredentials2(){
        LoginPageFactory loginTestFactory = new LoginPageFactory(driver);
        loginTestFactory.open(url);
        MainPage mainPage = loginTestFactory.loginToApp(username,password);
        Assert.assertTrue(mainPage.isOpen());
    }
    @Test
    public void loginToAppFactory_incorrectCredentials2(){
        LoginPageFactory loginTestFactory = new LoginPageFactory(driver);
        loginTestFactory.open(url);
        loginTestFactory.loginToApp(username,"wrongPassword");
        Assert.assertTrue(loginTestFactory.isError());
    }
    @Test
    public void loginToAppFactory_correctCredentials3(){
        LoginPageFactory loginTestFactory = new LoginPageFactory(driver);
        loginTestFactory.open(url);
        MainPage mainPage = loginTestFactory.loginToApp(username,password);
        Assert.assertTrue(mainPage.isOpen());
    }
    @Test
    public void loginToAppFactory_incorrectCredentials3(){
        LoginPageFactory loginTestFactory = new LoginPageFactory(driver);
        loginTestFactory.open(url);
        loginTestFactory.loginToApp(username,"wrongPassword");
        Assert.assertTrue(loginTestFactory.isError());
    }
}
