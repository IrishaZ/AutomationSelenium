package pageObjects;
import enums.FirstDropdown;
import enums.SecondDropdown;
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
    public void getCreateSmartPlaylistForm(){
        WebElement plusButton = getPlusButton();
        plusButton.click();
        By newSmartPlaylist=By.xpath("//*[text()='New Smart Playlist']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(newSmartPlaylist));
        WebElement newSmartPlaylistField=driver.findElement(newSmartPlaylist);
        newSmartPlaylistField.click();
    }
    public void createSmartPlaylistFormFillName(String name) {
        By nameFieldSelector=By.cssSelector("[name='name']");
        wait.until(ExpectedConditions.elementToBeClickable(nameFieldSelector));
        WebElement nameField = driver.findElement(nameFieldSelector);
        nameField.sendKeys(name);
    }
    public void createSmartPlaylistFormDropdown(FirstDropdown item1, SecondDropdown item2){
        WebElement firstDropdown = driver.findElement(By.cssSelector("[name='model[]']"));
        firstDropdown.click();
        By firstXpath = By.xpath("//*[@value='[object Object]'][contains ( text(), '"+item1+"' ) ] ");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstXpath));
        WebElement first = driver.findElement(firstXpath);
        first.click();
        WebElement secondDropdown = driver.findElement(By.cssSelector("[name='operator[]']"));
        secondDropdown.click();
        By secondXpath = By.xpath("//*[@value='[object Object]'][contains ( text(), '"+item2+"' ) ] ");
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondXpath));
        WebElement second= driver.findElement(secondXpath);
        second.click();
//        Thread.sleep(3000);
    }
    public void createSmartPlaylistFillForm(String name,FirstDropdown item1, SecondDropdown item2, String text) throws InterruptedException {
        createSmartPlaylistFormFillName(name);
        createSmartPlaylistFormDropdown(item1,item2);
        WebElement textField= driver.findElement(By.cssSelector("[name='value[]']"));
        textField.sendKeys(text);
        WebElement save=driver.findElement(By.xpath("//*[text()='Save']"));
        save.click();
    }
    public void createSmartPlaylistOneRuleText(String name,FirstDropdown item1, SecondDropdown item2, String text) throws InterruptedException {
        getCreateSmartPlaylistForm();
        createSmartPlaylistFillForm(name,item1,item2,text);
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
    public void renamePlaylist(int playlistId, String playlistName) throws InterruptedException {
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