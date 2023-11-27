package pageObjectTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MainPage;

public class LoginPageFactory extends BaseTest{

    @Test
    public void loginToAppFactory_correctCredentials(){
        pageObjects.LoginPageFactory loginTestFactory = new pageObjects.LoginPageFactory(driver);
        loginTestFactory.open(url);
        MainPage mainPage = loginTestFactory.loginToApp(email,password);
        Assert.assertTrue(mainPage.isOpen());
    }
    @Test
    public void loginToAppFactory_incorrectCredentials(){
        pageObjects.LoginPageFactory loginTestFactory = new pageObjects.LoginPageFactory(driver);
        loginTestFactory.open(url);
        loginTestFactory.loginToApp(email,"wrongPassword");
        Assert.assertTrue(loginTestFactory.isError());
    }


}