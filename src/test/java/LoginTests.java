import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class LoginTests extends BaseTest {

    private String email;
    private String password;
    public WebDriver driver;

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

    @BeforeTest
    public void loginEmptyEmailPassword() throws InterruptedException {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //      Input login credentials
        setEmailPassword("kristofer.juhasz@testpro.io", "Logintest1!");
        inputEmail();
        inputPassword();

        //      Clicks login button
        WebElement login = driver.findElement(By.cssSelector("button[type='submit']"));
        login.click();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
