package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected AjaxElementLocatorFactory factory;
    protected Actions actions;
    protected JavascriptExecutor js;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMillis(100), Duration.ofMillis(1000));
        actions = new Actions(driver);
        factory = new AjaxElementLocatorFactory(driver, 100);
        //ищет элементы только когда мы его используем
        PageFactory.initElements(factory, this);//ищет элементы
        js=(JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//*[@class='success show']")
    private WebElement successBanner;
    @FindBy(css = "[title='View song information']")
    private WebElement infoButton;
    @FindBy(xpath = "//*[@id='extraTabAlbum']")
    private WebElement infoPanelAlbumTab;
    @FindBy(xpath = "//*[@id='extraTabArtist']")
    private WebElement infoPanelArtistTab;
    @FindBy(xpath = "//*[@id='extraTabLyrics']")
    private WebElement infoPanelLyricsTab;
    @FindBy(css = "[class='text-secondary showing']")
    private WebElement infoPanel;
    @FindBy(css = "[class='text-secondary']")
    private WebElement infoPanelHidden;
    @FindBy(xpath = "//*[@class='album-info sidebar']/h1/button")
    private WebElement shuffleButtonInfoPanelAlbumTab;
    @FindBy(xpath = "//*[@class='artist-info sidebar']/h1/button")
    private WebElement shuffleButtonInfoPanelArtistTab;

    public void enterText (WebElement element, String textToEnter){
            element.click();
            element.clear();
            element.sendKeys(textToEnter);
    }
    public String getWebElementText (WebElement webElement){
            String text = null;
            text = webElement.getText();
            return text;
        }
    public void scrollTillVisible(WebElement webElement){
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }
    public boolean infoPanelIsDisplayed() {
        return infoPanel.isDisplayed();
    }
    public boolean infoPanelIsHidden() {
        return infoPanelHidden.isDisplayed();
    }
    public void openInfoPanel() {
        if(infoPanelIsHidden()==true){infoButton.click();};
    }
    public void closeInfoPanel() {
        if(infoPanelIsDisplayed()==true)infoButton.click();}
    public void openAlbumTab() {
        if(infoPanelIsHidden()==true){openInfoPanel();};
        infoPanelAlbumTab.click();
    }
    public void openArtistTab() {
        if(infoPanelIsHidden()==true){openInfoPanel();};
        infoPanelArtistTab.click();
    }
    public void openLyricTab() {
        if(infoPanelIsHidden()==true){openInfoPanel();};
        infoPanelLyricsTab.click();
    }
    public void clickShuffleButtonAlbumTab() {
        openAlbumTab();
        wait.until(ExpectedConditions.elementToBeClickable(shuffleButtonInfoPanelAlbumTab));
        shuffleButtonInfoPanelAlbumTab.click();
    }
    public void clickShuffleButtonArtistTab() {
        openArtistTab();
        wait.until(ExpectedConditions.elementToBeClickable(shuffleButtonInfoPanelArtistTab));
        shuffleButtonInfoPanelArtistTab.click();
    }
    public String getAlbumNameFromInfoPanel() {
        By infoPanelAlbumLocator = By.xpath("//*[@class='album-info sidebar']/h1/span");
        try {
            WebElement infoPanelAlbum = wait.until(ExpectedConditions.visibilityOfElementLocated(infoPanelAlbumLocator));
            return getWebElementText(infoPanelAlbum);
        } catch (TimeoutException err) {
            return "";
        }
    }
    public String getArtistNameFromInfoPanel() {
        By infoPanelArtistLocator = By.xpath("//*[@class='artist-info sidebar']/h1/span");
        try {
            WebElement infoPanelAlbum = wait.until(ExpectedConditions.visibilityOfElementLocated(infoPanelArtistLocator));
            return getWebElementText(infoPanelAlbum);
        } catch (TimeoutException err) {
            return "";
        }
    }
    public String getLyricFromInfoPanel() {
        By infoPanelArtistLocator = By.xpath("//*[@class='lyric-info sidebar']/h1/span");
        try {
            WebElement infoLyrics = wait.until(ExpectedConditions.visibilityOfElementLocated(infoPanelArtistLocator));
            return getWebElementText(infoLyrics);
        } catch (TimeoutException err) {
            return "";
        }
    }
}