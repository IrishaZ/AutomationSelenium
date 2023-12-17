package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CurrentQueuePage extends BasePage{
    public CurrentQueuePage(WebDriver driver){
        super(driver);
    }
    public ArrayList<String> getAllSongs(){
        ArrayList<String> arrayList= new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("(//*[@class='items'])[1]/tr/td[2]"));
        WebElement element;
        for(int i=0;i< elements.size();i++){
            element= elements.get(i);
            arrayList.add(element.getText());
        }
        return arrayList;
    }
}
