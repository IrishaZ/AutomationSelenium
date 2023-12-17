package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class AlbumPage extends BasePage{
    public AlbumPage(WebDriver driver){
        super(driver);
    }

    public CurrentQueuePage openAlbumAirbitOrByName(String albumName ){
        List<WebElement> allAlbums=new ArrayList<>();
        List<WebElement> filteredList=new ArrayList<>();
        By locator=By.xpath("//*[@class='albums main-scroll-wrap as-thumbnails']/article");
//        Album name by default Airbit
        WebElement album = driver.findElement(By.xpath("//div/article[contains(@title,'Airbit')]"));
//        int i=0;
        try {
            allAlbums=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            System.out.println("There are "+allAlbums.size()+" albums presented on the page");
//            for(WebElement a:allAlbums){
//                System.out.println(i+"=====================");
//                System.out.println(a.getText());
//                i++;
//            }
            filteredList=allAlbums
                    .stream()
                    .filter(x->x.getText().contains(albumName))
                    .toList();
        } catch (TimeoutException err){
            System.out.println("AlbumPage wasn't load");
            driver.navigate().refresh();
        };
        if(filteredList.size()>0){album=filteredList.get(0);}
//        js.executeScript("arguments[0].scrollIntoView();",album);
        scrollTillVisible(album);
        album.click();
        return new CurrentQueuePage(driver);
    }
}
