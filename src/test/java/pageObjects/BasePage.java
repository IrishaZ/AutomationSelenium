package pageObjects;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected AjaxElementLocatorFactory factory;
    public BasePage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofMillis(200),Duration.ofMillis(1000));
        factory=new AjaxElementLocatorFactory(driver,100);
        //ищет элементы только когда мы его используем
        PageFactory.initElements(factory,this);//ищет элементы
    }
    public void enterText(WebElement element, String textToEnter) {
        element.click();
        element.clear();
        element.sendKeys(textToEnter);
    }
}