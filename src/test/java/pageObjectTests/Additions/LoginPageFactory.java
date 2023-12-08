package pageObjectTests.Additions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectTests.BaseTest;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class LoginPageFactory extends BaseTest {

    @Test
    public void loginToAppFactory_correctCredentials(){
        LoginPage loginTestFactory = new LoginPage(driver);
        loginTestFactory.openPage(url);
        MainPage mainPage = loginTestFactory.loginToApp(email,password);
        Assert.assertTrue(mainPage.isOpen());
    }
    @Test
    public void loginToAppFactory_incorrectCredentials(){
        LoginPage loginTestFactory = new LoginPage(driver);
        loginTestFactory.openPage(url);
        loginTestFactory.loginToApp(email,"wrongPassword");
        Assert.assertTrue(loginTestFactory.isError());
    }


}