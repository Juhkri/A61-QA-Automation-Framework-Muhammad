import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    private String email;
    private String password;
    private String song;
    String url = "https://qa.koel.app/";
    WebDriver wait;

    public void verifyPlay() {
        WebElement soundbar = driver.findElement(By.cssSelector("div[data-testid='sound-bar-play']"));
        Assert.assertTrue(soundbar.isDisplayed());
    }

    public void playFirstSong()  {
        WebElement buttonPlay = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        buttonPlay.click();

    }

    public void playNextSong() {
        WebElement skip = this.driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        skip.click();
    }

    public void setEmailPassword(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void inputEmail() {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(this.email);
    }

    public void inputPassword() {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(this.password);
    }

    public void loginButton() {
        //      Clicks login button
        WebElement login = driver.findElement(By.cssSelector("button[type='submit']"));
        login.click();
    }

    public void login() {
        //      Input login credentials
        setEmailPassword("kristofer.juhasz@testpro.io", "Logintest1!");
        inputEmail();
        inputPassword();
        loginButton();
    }

    public void inputSearch() {
        WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
        searchBar.clear();
        searchBar.sendKeys(this.song);
    }

    public void searchSong(String song) {
        this.song = song;
    }

    public void viewAllButton() {
        WebElement viewAll = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAll.click();
    }

    public void firstSongSelect() {
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr:nth-child(1)"));
        firstSong.click();
    }

    public void addToPlaylist() {
        WebElement addTo = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addTo.click();
    }

    public void selectPlaylist() {
        WebElement selectPlaylist = driver.findElement(By.cssSelector("[#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li.playlist]"));
        selectPlaylist.click();
    }


    public void createPlaylist() throws InterruptedException {
        Thread.sleep(2000);
        WebElement createPlaylistButton = driver.findElement(By.cssSelector("[data-testid=\"sidebar-create-playlist-btn\"]"));
        createPlaylistButton.click();
        WebElement newPlaylistButton = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        newPlaylistButton.click();
        WebElement newPlaylistName = driver.findElement(By.cssSelector("#playlists > form > input[type=text]"));
        newPlaylistName.clear();
        newPlaylistName.sendKeys("Homework");
        newPlaylistName.sendKeys(Keys.ENTER);
    }

    public void deleteFirstPlaylist() {
        WebElement firstPlaylist = driver.findElement(By.cssSelector("[class=\"playlist playlist\"]"));
        firstPlaylist.click();
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector("[class=\"del btn-delete-playlist\"]"));
        deletePlaylistButton.click();
    }

    @BeforeMethod
    public void initBrowser() throws InterruptedException {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
}