package pageObjects_my;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    private Actions actions;
    public MainPage(WebDriver driver) {
        super(driver);
        this.actions = new Actions(driver);
    }
    public  WebElement getPlusButton(){
        By plusButtonLocator = By.cssSelector("[title='Create a new playlist']");
        wait.until(ExpectedConditions.elementToBeClickable(plusButtonLocator));
        return driver.findElement(plusButtonLocator);
    };
    public WebElement getMenuNewPlaylist(){
        return driver.findElement(By.xpath("//*[text()='New Playlist']"));
    }
    public WebElement getEditField(){
        By playlistInputFieldLocator = By.cssSelector("[name='name']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(playlistInputFieldLocator));
        return driver.findElement(playlistInputFieldLocator);
    }
    public  WebElement getPlaylistById (int playlistId){
        WebElement playlist;
        By playlistLocator = By.xpath("//*[@ href='#!/playlist/"+playlistId+"']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(playlistLocator));
        return driver.findElement(playlistLocator);

    };
    public WebElement getSuccessBanner(){
        By successLocator = By.xpath("//*[@class='success show']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(successLocator));
        return driver.findElement(successLocator);
    }
    public boolean playlistExist(int playlistId, String playlistName){
        WebElement playlist;
        try {
            playlist = getPlaylistById(playlistId);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", playlist);
            return playlist.isDisplayed()&& playlist.getText().equals(playlistName);
        } catch (TimeoutException err){return false;}
    }
    public boolean playlistExist(int playlistId){
        WebElement playlist;
        try {
            playlist = getPlaylistById(playlistId);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", playlist);
            return playlist.isDisplayed();
        } catch (TimeoutException err){return false;}
    }
    public Integer addPlaylist(String playlistName){
        getPlusButton().click();
        getMenuNewPlaylist().click();
        getEditField().sendKeys(playlistName);
        getEditField().sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
        String url = driver.getCurrentUrl();
        String[] parts= url.split("/");
        return Integer.parseInt(parts[parts.length - 1]);
    }
    public void deletePlaylist(int playlistId){
        WebElement playlist = getPlaylistById(playlistId);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", playlist);
        actions.contextClick(playlist).build().perform();
        By deletePlaylistLocator = By.xpath("//*[text()='Delete']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(deletePlaylistLocator));
        WebElement deletePlaylist= driver.findElement(deletePlaylistLocator);
        deletePlaylist.click();
        getSuccessBanner();
    }
    public boolean isOpen(){
        By homeIconLocator = By.cssSelector("[class = 'home active']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homeIconLocator));
            return true;
        } catch(TimeoutException err){
            return false;
        }
    }
    public void renamePlaylist(Integer playlistId, String playlistName) throws InterruptedException {
        WebElement playlist = getPlaylistById(playlistId);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", playlist);
        actions.doubleClick(playlist).build().perform();
        getEditField().sendKeys(Keys.CONTROL+"A");
        getEditField().sendKeys(playlistName);
        getEditField().sendKeys(Keys.ENTER);
        getSuccessBanner();
//        return playlistName;
//        By successLocator = By.xpath("//*[@class='success show']");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(successLocator));

    }
}