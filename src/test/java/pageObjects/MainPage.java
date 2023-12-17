package pageObjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    private static final Logger log = LogManager.getLogger(MainPage.class);
    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "avatar")
    private WebElement studentAvatar;
    @FindBy(xpath = "//*[text()='student']")
    private WebElement studentProfile;
    @FindBy(css="[class='queue']")
    private WebElement queueTab;
    @FindBy(css="[class='songs']")
    private WebElement allSongsTab;
    @FindBy(css="[class='albums']")
    private WebElement albumsTab;
    @FindBy(css="[class='artists']")
    private WebElement artistTab;
    @FindBy(css="[class='playlist favorites']")
    private WebElement playlistFavoritesTab;
    @FindBy(css="[class='playlist recently-played']")
    private WebElement recentlyPlayedTab;

    public ProfilePage openProfilePage() {
        wait.until(ExpectedConditions.elementToBeClickable(studentProfile));
        studentProfile.click();
        return new ProfilePage(driver);
    }
    public CurrentQueuePage openCurrentQueuePage() {
        wait.until(ExpectedConditions.elementToBeClickable(queueTab));
        queueTab.click();
        return new CurrentQueuePage(driver);
    }
    public AllSongsPage openAllSongPage() {
        wait.until(ExpectedConditions.elementToBeClickable(allSongsTab));
        allSongsTab.click();
        return new AllSongsPage(driver);
    }
    public AlbumPage openAlbumPage() {
        wait.until(ExpectedConditions.elementToBeClickable(albumsTab));
        albumsTab.click();
        return new AlbumPage(driver);
    }
    public ArtistPage openArtistPage() {
        wait.until(ExpectedConditions.elementToBeClickable(artistTab));
        artistTab.click();
        return new ArtistPage(driver);
    }
    public FavoritesPage openFavoritesPage() {
        wait.until(ExpectedConditions.elementToBeClickable(playlistFavoritesTab));
        playlistFavoritesTab.click();
        return new FavoritesPage(driver);
    }
    public  RecentlyPlayedPage openRecentlyPlayedPage() {
        wait.until(ExpectedConditions.elementToBeClickable(playlistFavoritesTab));
        playlistFavoritesTab.click();
        return new RecentlyPlayedPage(driver);
    }
    public void playSong(String songTitle){
        By songLocator = By.xpath("//*[@class='details'][contains ( text(),'"+songTitle+"')]");
        WebElement song=driver.findElement(songLocator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", song);
        actions.doubleClick(song).perform();
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
    public void formCSP_open(){
        WebElement plusButton = getPlusButton();
        plusButton.click();
        By newSmartPlaylist=By.xpath("//*[text()='New Smart Playlist']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(newSmartPlaylist));
        WebElement newSmartPlaylistField=driver.findElement(newSmartPlaylist);
        newSmartPlaylistField.click();
    }
    @FindBy(css ="[name='name']")
    private WebElement formCSP_NameField;
    @FindBy(css="[name='value[]']")
    private WebElement formCSP_QueryField;
    @FindBy(xpath = "//*[text()='Save']")
    private WebElement formCSP_SaveButton;
    @FindBy(css="[name='model[]']")
    private WebElement formCSP_ModelDropdown;
    @FindBy(css="[name='operator[]']")
    private WebElement formCSP_OperatorDropdown;
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
    public void createSP_OneRule_DefaultValues(String name, String queryName) throws InterruptedException {
        formCSP_open();
        formCSP_FillPlaylistName(name);
        formCSP_QueryField.sendKeys(queryName);
        formCSP_SaveButton.click();
    }
    public void createSP_OneRule_CustomValues(String name, String model, String operator, String queryName) throws InterruptedException {
        formCSP_open();
        formCSP_FillPlaylistName(name);
        formCSP_ModelDropdown.click();
        By modelXpath = By.xpath("//*[ text()='"+model+"']");
        WebElement modelChose= wait.until(ExpectedConditions.visibilityOfElementLocated(modelXpath));
        modelChose.click();
        formCSP_OperatorDropdown.click();
        log.info("The model chosen "+ model);
        By operatorXpath = By.xpath("//*[@value='[object Object]'][contains ( text(), '"+operator+"' ) ] ");
        WebElement operatorChose=wait.until(ExpectedConditions.visibilityOfElementLocated(operatorXpath));
        operatorChose.click();
        log.info("The model chosen "+ operator);
//        formCSP_ChooseModelAndOperator(model,operator);
        formCSP_QueryField.sendKeys(queryName);
        log.info("The query chosen "+ queryName);
        formCSP_SaveButton.click();
    }
    public void formCSP_FillPlaylistName (String playlistName) throws InterruptedException {
        WebElement nameField=wait.until(ExpectedConditions.visibilityOf(formCSP_NameField));
        nameField.sendKeys(playlistName);
    }
}
//    public void formCSP_ChooseModelAndOperator( String model, String operator) throws InterruptedException {
//          formCSP_ModelDropdown.click();
//          Thread.sleep(1000);
//          By modelXpath = By.xpath("//*[ text()='"+model+"']");
//          WebElement modelChose= wait.until(ExpectedConditions.visibilityOfElementLocated(modelXpath));
//          modelChose.click();
//          Thread.sleep(1000);
//          formCSP_OperatorDropdown.click();
//          By operatorXpath = By.xpath("//*[@value='[object Object]'][contains ( text(), '"+operator+"' ) ] ");
//          WebElement operatorChose=wait.until(ExpectedConditions.visibilityOfElementLocated(operatorXpath));
//          operatorChose.click();
//    }