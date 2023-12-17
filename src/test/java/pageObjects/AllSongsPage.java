package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver driver){
        super(driver);
    }
    public void playSong(String songTitle){
        By songLocator = By.xpath("//*[text()='"+ songTitle+"']");
        WebElement song=driver.findElement(songLocator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", song);
        actions.doubleClick(song).perform();
    }


}
