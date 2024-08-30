import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    private String email;
    private String password;
    String url = "https://qa.koel.app/";

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